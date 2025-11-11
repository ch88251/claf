package com.cfhayes.claf.food;

import java.awt.Graphics;

import com.cfhayes.claf.BaseSplitPaneDivider;

public class FoodSplitPaneDivider extends BaseSplitPaneDivider {

    public FoodSplitPaneDivider(FoodSplitPaneUI ui) {
        super(ui);
    }

    public void paint(Graphics g) {
        FoodUtils.fillComponent(g, this);
        paintComponents(g);
    }
}
