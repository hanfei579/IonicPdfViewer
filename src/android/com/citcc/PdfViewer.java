package com.citcc.PdfViewPlugin.PdfViewer;

import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class PdfViewer extends CordovaPlugin {

    public static final String VIEW_DOCUMENT_ANDROID = "viewDocumentAndroid";
    public static final String URL = "url";
    public static final String PDF = "application/pdf";
    public static final String CONTENT_TYPE = "contentType";

    public static final String FILE_URL_TYPE= "fileUrlType";

    @Override
    public boolean execute(String action, JSONArray argsArray, CallbackContext callbackContext) throws JSONException {
        if (action.equals(VIEW_DOCUMENT_ANDROID)) {

            JSONObject args;
            if (argsArray.length() > 0) {
                args = argsArray.getJSONObject(0);

            } else {
                args = new JSONObject();
            }

            String url = args.getString(URL);
            String contentType = args.getString(CONTENT_TYPE);
            int urlType = args.getInt(FILE_URL_TYPE);
            final JSONObject successObj = new JSONObject();
            if (PDF.equals(contentType.toLowerCase())) {
                Intent intent = new Intent(this.cordova.getActivity(), com.citcc.PdfViewPlugin.PdfViewer.PdfActivity.class);
                intent.putExtra("FileUrl", url);
                intent.putExtra("UrlType",urlType);
                this.cordova.getActivity().startActivity(intent);
                callbackContext.success("");
            } else {
                String message =
                        "Content type '" + contentType + "' is not supported";
                successObj.put("message", message);
                callbackContext.success(successObj);
            }
            return true;
        }
        return false;
    }

    private void documentView(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
