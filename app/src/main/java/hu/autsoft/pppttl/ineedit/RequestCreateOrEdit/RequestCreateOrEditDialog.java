package hu.autsoft.pppttl.ineedit.RequestCreateOrEdit;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import hu.autsoft.pppttl.ineedit.Model.Request;
import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.Requests.SaveRequestCallbackListener;

/**
 * Created by pppttl on 2018. 02. 27..
 */

public class RequestCreateOrEditDialog {

    public void show(View view, String title, final SaveRequestCallbackListener listener) {
        boolean wrapInScrollView = true;
        MaterialDialog addDialog = new MaterialDialog.Builder(view.getContext())
                .title(title)
                .customView(R.layout.dialog_request_create, wrapInScrollView)
                .positiveText(R.string.save)
                .negativeText(R.string.cancel)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        View view = dialog.getView();
                        String name = ((TextInputEditText) view.findViewById(R.id.requestName)).getText().toString();
                        String link = ((TextInputEditText) view.findViewById(R.id.requestUrl)).getText().toString();
                        int price = Integer.parseInt(((TextInputEditText) view.findViewById(R.id.requestPrice)).getText().toString());

                        listener.onRequestSave(new Request(name, Request.Status.PENDING, link, price));
                    }
                })
                .show();
    }
}
