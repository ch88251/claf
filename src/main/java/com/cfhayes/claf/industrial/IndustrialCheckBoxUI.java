package com.cfhayes.claf.industrial;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseIcons;

public class IndustrialCheckBoxUI extends IndustrialRadioButtonUI {

    private static IndustrialCheckBoxUI checkBoxUI = null;

    public static ComponentUI createUI(JComponent b) {
        if (checkBoxUI == null) {
            checkBoxUI = new IndustrialCheckBoxUI();
        }
        return checkBoxUI;
    }

    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        icon = BaseIcons.getCheckBoxIcon();
    }
}
