package hu.autsoft.pppttl.ineedit.useredit;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.model.User;

/**
 * Created by pppttl on 2018. 04. 08..
 */
public class UserEditDialog {
    public void show(String title, View view, final User user, final SaveUserCallbackListener listener) {
        boolean wrapInScrollView = true;
        final MaterialDialog addDialog = new MaterialDialog.Builder(view.getContext())
                .title(title)
                .customView(R.layout.dialog_user_edit, wrapInScrollView)
                .positiveText(R.string.edit)
                .negativeText(R.string.cancel)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        View view = dialog.getView();
                        String fullName = ((EditText) view.findViewById(R.id.userFullName)).getText().toString();
                        Boolean useLoginAddressForWorkEmail = ((CheckBox) view.findViewById(R.id.user_work_email_prompt)).isChecked();
                        String workEmail = !useLoginAddressForWorkEmail ? user.getEmail() : ((EditText) view.findViewById(R.id.userWorkEmail)).getText().toString();
                        String phoneNumber = ((EditText) view.findViewById(R.id.userPhoneNumber)).getText().toString();
                        String workAddress = ((EditText) view.findViewById(R.id.userWorkAddress)).getText().toString();

                        user.setFullName(fullName);
                        user.setPhoneNumber(phoneNumber);
                        user.setWorkAddress(workAddress);
                        user.setWorkEmail(useLoginAddressForWorkEmail ? user.getEmail() : workEmail);
                        if (listener != null) listener.onSaveUser(user);
                    }
                })
                .show();

        final View dialogView = addDialog.getView();
        dialogView.findViewById(R.id.user_work_email_prompt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb = (CheckBox) view;
                dialogView.findViewById(R.id.userWorkEmailTextInput).setVisibility(cb.isChecked() ? View.GONE : View.VISIBLE);
            }
        });
    }
}
