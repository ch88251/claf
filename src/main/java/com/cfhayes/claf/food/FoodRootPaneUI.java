package com.cfhayes.claf.food;

import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseRootPaneUI;
import com.cfhayes.claf.BaseTitlePane;

public class FoodRootPaneUI extends BaseRootPaneUI {

    public static ComponentUI createUI(JComponent c) {
        return new FoodRootPaneUI();
    }

    public BaseTitlePane createTitlePane(JRootPane root) {
        return new FoodTitlePane(root, this);
    }
}
