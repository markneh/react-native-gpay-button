package com.reactnativegpaybutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class RNGooglePayButtonWrapper extends LinearLayout  {

    public RNGooglePayButtonWrapper(Context context) {
        super(context);

         updateButtonAppearance();
    }

    public void setCurrentButtonType(ButtonType currentButtonType) {
        this.currentButtonType = currentButtonType;
        updateButtonAppearance();
    }

    public void setShadowEnabled(boolean shadowEnabled) {
        this.isShadowEnabled = shadowEnabled;
        updateButtonAppearance();
    }

    public enum ButtonType {
        Basic,
        Buy
    }

    private View currentButtonView;
    private ButtonType currentButtonType;
    private boolean isShadowEnabled;

    private void updateButtonAppearance() {
        ButtonType type = currentButtonType != null ? currentButtonType : ButtonType.Basic;
        int layout = layoutByButtonType(type, isShadowEnabled);

        View buttonView = LayoutInflater.from(getContext()).inflate(layout, null);

        if (currentButtonView != null) {
            buttonView.setLayoutParams(currentButtonView.getLayoutParams());
        }

        addView(buttonView);

        if (currentButtonView != null) {
            removeView(currentButtonView);
            currentButtonView = null;
        }

        currentButtonView = buttonView;
    }

    private int layoutByButtonType(ButtonType buttonType, Boolean shadow) {
        switch (buttonType) {
            case Buy: return shadow ? R.layout.buy_with_googlepay_button : R.layout.buy_with_googlepay_button_no_shadow;
            case Basic:
            default:
                return shadow ? R.layout.googlepay_button : R.layout.googlepay_button_no_shadow;
        }
    }
}
