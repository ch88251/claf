package com.cfhayes.claf.financial;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseIcons;

public class FinancialCheckBoxUI extends FinancialRadioButtonUI {

    private static FinancialCheckBoxUI checkBoxUI = null;

    public static ComponentUI createUI(JComponent b) {
        if (checkBoxUI == null) {
            checkBoxUI = new FinancialCheckBoxUI();
        }
        return checkBoxUI;
    }

    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        icon = BaseIcons.getCheckBoxIcon();
    }
}