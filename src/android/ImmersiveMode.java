package com.toluhta.immersify;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.view.View;
import android.view.WindowManager;

public class ImmersiveMode extends CordovaPlugin {
    public static final String ACTION_ENABLE_IMMERSIVE = "enableImmersive";
    public static final String ACTION_ENABLE_IMMERSIVE_STICKY = "enableSticky";
    public static final String ACTION_IMMERSIVE_DISABLE = "disable";

    public boolean execute(final String action, JSONArray args,
            CallbackContext callbackContext) throws JSONException {
        if (action.equals(ACTION_ENABLE_IMMERSIVE)
                || action.equals(ACTION_ENABLE_IMMERSIVE_STICKY)) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Override Cordova's own full screen setting
                    cordova.getActivity()
                            .getWindow()
                            .clearFlags(
                                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                    
                    // Non-Sticky immersion
                    cordova.getActivity()
                            .getWindow()
                            .getDecorView()
                            .setSystemUiVisibility(
                                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                                            | View.INVISIBLE);

                    if (action.equals(ACTION_ENABLE_IMMERSIVE_STICKY)) {
                        cordova.getActivity()
                        .getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                        | View.INVISIBLE);
                    }
                }
            });

            callbackContext.success();
            return true;
        }else if (action.equals(ACTION_IMMERSIVE_DISABLE)) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    cordova.getActivity().getWindow().getDecorView()
                            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                }
            });
            callbackContext.success();
            return true;
        } else {
            callbackContext.error("Invalid action");
            return false;
        }
    }
}
