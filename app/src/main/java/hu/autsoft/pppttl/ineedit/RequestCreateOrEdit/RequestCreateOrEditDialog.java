package hu.autsoft.pppttl.ineedit.RequestCreateOrEdit;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import hu.autsoft.pppttl.ineedit.Model.Request;
import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.Requests.RequestsView;

/**
 * Created by pppttl on 2018. 02. 27..
 */

public class RequestCreateOrEditDialog {

    public void show(View view, String title, final RequestsView.SaveRequestCallbackListener listener, final Request request) {
        boolean wrapInScrollView = true;
        final MaterialDialog addDialog = new MaterialDialog.Builder(view.getContext())
                .title(title)
                .customView(R.layout.dialog_request_create, wrapInScrollView)
                .positiveText(R.string.save)
                .negativeText(R.string.cancel)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        View view = dialog.getView();
                        String name = ((TextInputEditText) view.findViewById(R.id.requestName)).getText().toString() + "";
                        String link = ((TextInputEditText) view.findViewById(R.id.requestUrl)).getText().toString() + "";

                        String priceString = ((TextInputEditText) view.findViewById(R.id.requestPrice)).getText().toString();
                        int price = priceString.length() > 0 ? Integer.parseInt(priceString) : 0;

                        if (request == null) {
                            Request newRequest = new Request(name, Request.Status.PENDING, link, price);
                            listener.onRequestSave(newRequest);
                        } else {
                            request.setName(name);
                            request.setLink(link);
                            request.setPrice(price);
                            listener.onRequestSave(request);
                        }


                    }
                })
                .show();

        addDialog.getActionButton(DialogAction.POSITIVE).setEnabled(false);
        final TextInputEditText nameEditText = addDialog.getView().findViewById(R.id.requestName);
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 && s.toString().replace(" ", "").length() > 0) {
                    addDialog.getActionButton(DialogAction.POSITIVE).setEnabled(true);
                } else {
                    addDialog.getActionButton(DialogAction.POSITIVE).setEnabled(false);
                }
            }
        });

        if (request != null) {
            View dialogView = addDialog.getView();
            TextInputEditText urlEditText = dialogView.findViewById(R.id.requestUrl);
            TextInputEditText priceEditText = dialogView.findViewById(R.id.requestPrice);

            nameEditText.setText(request.getName());
            urlEditText.setText(request.getLink());
            priceEditText.setText(Integer.toString(request.getPrice()));
        }
    }
}
