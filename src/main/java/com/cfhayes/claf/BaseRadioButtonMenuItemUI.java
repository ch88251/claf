package com.cfhayes.claf;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

public class BaseRadioButtonMenuItemUI extends BaseMenuItemUI {

    public static ComponentUI createUI(JComponent b) {
        return new BaseRadioButtonMenuItemUI();
    }

    protected void installDefaults() {
        super.installDefaults();
        checkIcon = UIManager.getIcon("RadioButtonMenuItem.checkIcon");
    }

}
