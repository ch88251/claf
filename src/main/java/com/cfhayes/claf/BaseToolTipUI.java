package com.cfhayes.claf;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalToolTipUI;

public class BaseToolTipUI extends MetalToolTipUI {

    public static ComponentUI createUI(JComponent c) {
        return new BaseToolTipUI();
    }
}
