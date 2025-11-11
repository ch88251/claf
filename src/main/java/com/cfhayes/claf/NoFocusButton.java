package com.cfhayes.claf;

import javax.swing.Icon;
import javax.swing.JButton;

public class NoFocusButton extends JButton {

    public NoFocusButton() {
        super();
        init();
    }

    public NoFocusButton(Icon ico) {
        super(ico);
        init();
    }

    private void init() {
        setFocusPainted(false);
        setRolloverEnabled(true);
        if (CLAFUtilities.getJavaVersion() >= 1.4) {
            setFocusable(false);
        }
    }

    public boolean isFocusTraversable() {
        return false;
    }

    public void requestFocus() {
    }
}
