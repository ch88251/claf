package com.cfhayes.claf.food;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseTabbedPaneUI;

public class FoodTabbedPaneUI extends BaseTabbedPaneUI {

    private static Color SEP_COLORS[] = {
        new Color(229, 187, 0),
        new Color(254, 240, 0),
        new Color(251, 232, 0),
        new Color(247, 225, 0),
        new Color(243, 216, 0),
        new Color(229, 187, 0),};

    public static ComponentUI createUI(JComponent c) {
        return new FoodTabbedPaneUI();
    }

    public void installDefaults() {
        super.installDefaults();
        tabAreaInsets.bottom = 6;
    }

    protected Color[] getContentBorderColors(int tabPlacement) {
        return SEP_COLORS;
    }

    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        FoodUtils.fillComponent(g, tabPane);
        super.paintContentBorder(g, tabPlacement, selectedIndex, x, y, w, h);
    }
}