package com.cfhayes.claf;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

public class BaseCheckBoxMenuItemUI extends BaseMenuItemUI {

    public static ComponentUI createUI(JComponent c) {
        return new BaseCheckBoxMenuItemUI();
    }

    protected void installDefaults() {
        super.installDefaults();
        checkIcon = UIManager.getIcon("CheckBoxMenuItem.checkIcon");
    }

}
