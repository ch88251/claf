package com.cfhayes.claf.industrial;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseRadioButtonUI;
import com.cfhayes.claf.BaseIcons;

public class IndustrialRadioButtonUI extends BaseRadioButtonUI {

    private static IndustrialRadioButtonUI radioButtonUI = null;

    public static ComponentUI createUI(JComponent c) {
        if (radioButtonUI == null) {
            radioButtonUI = new IndustrialRadioButtonUI();
        }
        return radioButtonUI;
    }

    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        // Use the base radio button icon for now
        icon = BaseIcons.getRadioButtonIcon();
    }
}