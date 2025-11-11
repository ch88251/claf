package com.cfhayes.claf.industrial;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicDesktopPaneUI;

public class IndustrialDesktopPaneUI extends BasicDesktopPaneUI {

    private static IndustrialDesktopPaneUI desktopPaneUI = null;

    public static ComponentUI createUI(JComponent c) {
        if (desktopPaneUI == null) {
            desktopPaneUI = new IndustrialDesktopPaneUI();
        }
        return desktopPaneUI;
    }

    public void update(Graphics g, JComponent c) {
        IndustrialUtils.fillComponent(g, c);
    }
}
