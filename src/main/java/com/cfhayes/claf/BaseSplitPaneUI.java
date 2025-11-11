package com.cfhayes.claf;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class BaseSplitPaneUI extends BasicSplitPaneUI {

    public static ComponentUI createUI(JComponent c) {
        return new BaseSplitPaneUI();
    }

    public BasicSplitPaneDivider createDefaultDivider() {
        return new BaseSplitPaneDivider(this);
    }
}
