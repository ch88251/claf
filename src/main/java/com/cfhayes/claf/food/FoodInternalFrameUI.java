package com.cfhayes.claf.food;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseInternalFrameUI;

public class FoodInternalFrameUI extends BaseInternalFrameUI {

    public FoodInternalFrameUI(JInternalFrame b) {
        super(b);
    }

    public static ComponentUI createUI(JComponent c) {
        return new FoodInternalFrameUI((JInternalFrame) c);
    }

    protected JComponent createNorthPane(JInternalFrame w) {
        titlePane = new FoodInternalFrameTitlePane(w);
        return titlePane;
    }
}

