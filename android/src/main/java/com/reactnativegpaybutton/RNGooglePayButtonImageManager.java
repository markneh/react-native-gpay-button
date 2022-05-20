package com.reactnativegpaybutton;

import android.view.View;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGooglePayButtonImageManager extends SimpleViewManager<View> {

    public static final String REACT_CLASS = "GooglePayButtonImageView";
    ReactApplicationContext mCallerContext;

    public RNGooglePayButtonImageManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RNGooglePayButtonWrapper createViewInstance(ThemedReactContext reactContext) {
        return new RNGooglePayButtonWrapper(reactContext);
    }

    @ReactProp(name = "buttonType")
    public void setButtonType(RNGooglePayButtonWrapper view, String buttonType) {
        RNGooglePayButtonWrapper.ButtonType type = buttonTypeFromString(buttonType);
        view.setCurrentButtonType(type);
    }

    @ReactProp(name = "shadow", defaultBoolean = false)
    public void setShadow(RNGooglePayButtonWrapper view, boolean shadow) {
        view.setShadowEnabled(shadow);
    }

    private RNGooglePayButtonWrapper.ButtonType buttonTypeFromString(String string) {
        if (string.equals("buy")) {
            return RNGooglePayButtonWrapper.ButtonType.Buy;
        }
        return RNGooglePayButtonWrapper.ButtonType.Basic;
    }

}
