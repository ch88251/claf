package com.cfhayes.claf.medical;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseIcons;

public class MedicalCheckBoxUI extends MedicalRadioButtonUI {

    private static MedicalCheckBoxUI checkBoxUI = null;

    public static ComponentUI createUI(JComponent b) {
        if (checkBoxUI == null) {
            checkBoxUI = new MedicalCheckBoxUI();
        }
        return checkBoxUI;
    }

    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        icon = BaseIcons.getCheckBoxIcon();
    }
}