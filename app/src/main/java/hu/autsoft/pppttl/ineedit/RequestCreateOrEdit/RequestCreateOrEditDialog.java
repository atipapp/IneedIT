package hu.autsoft.pppttl.ineedit.RequestCreateOrEdit;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import hu.autsoft.pppttl.ineedit.R;

/**
 * Created by pppttl on 2018. 02. 27..
 */

public class RequestCreateOrEditDialog {

    public void show(View view, String title){
        boolean wrapInScrollView = true;
        MaterialDialog addDialog = new MaterialDialog.Builder(view.getContext())
                .title(title)
                .customView(R.layout.dialog_request_create, wrapInScrollView)
                .positiveText(R.string.save)
                .negativeText(R.string.cancel)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        //TODO
                    }
                })
                .show();
    }
}
