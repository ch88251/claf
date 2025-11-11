package com.cfhayes.claf;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class BaseMenuBarUI extends BasicMenuBarUI {

    public static ComponentUI createUI(JComponent c) {
        return new BaseMenuBarUI();
    }

    public void paint(Graphics g, JComponent c) {
        int w = c.getWidth();
        int h = c.getHeight();
        CLAFUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getMenuBarColors(), 0, 0, w, h);
    }
}