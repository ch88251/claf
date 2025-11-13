package com.cfhayes.claf.financial;

import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicDesktopPaneUI;

public class FinancialDesktopPaneUI extends BasicDesktopPaneUI {

    private static FinancialDesktopPaneUI desktopPaneUI;

    public static ComponentUI createUI(JComponent c) {
        if (desktopPaneUI == null) {
            desktopPaneUI = new FinancialDesktopPaneUI();
        }
        return desktopPaneUI;
    }

    public void update(Graphics g, JComponent c) {
        if (c.isOpaque()) {
            // Create professional financial gradient background
            Graphics2D g2 = (Graphics2D) g;
            Dimension d = c.getSize();
            FinancialDefaultTheme theme = new FinancialDefaultTheme();

            // Financial gradient: light navy to darker steel blue
            GradientPaint gradient = new GradientPaint(
                0, 0, theme.getDesktopColor(),
                0, d.height, theme.getMenuBackground()
            );
            
            g2.setPaint(gradient);
            g2.fillRect(0, 0, d.width, d.height);
        }
        paint(g, c);
    }
}