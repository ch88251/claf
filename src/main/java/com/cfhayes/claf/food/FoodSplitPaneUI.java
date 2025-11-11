package com.cfhayes.claf.food;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;

import com.cfhayes.claf.BaseSplitPaneUI;

public class FoodSplitPaneUI extends BaseSplitPaneUI {

    public static ComponentUI createUI(JComponent c) {
        return new FoodSplitPaneUI();
    }

    public BasicSplitPaneDivider createDefaultDivider() {
        return new FoodSplitPaneDivider(this);
    }
}
