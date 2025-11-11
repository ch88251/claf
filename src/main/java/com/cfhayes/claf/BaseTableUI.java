package com.cfhayes.claf;

import java.awt.FontMetrics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;

public class BaseTableUI extends BasicTableUI {

    public static ComponentUI createUI(JComponent c) {
        return new BaseTableUI();
    }

    public void installDefaults() {
        super.installDefaults();
        FontMetrics fm = table.getFontMetrics(table.getFont());
        table.setRowHeight(fm.getHeight() + (fm.getHeight() / 4));
    }

}
