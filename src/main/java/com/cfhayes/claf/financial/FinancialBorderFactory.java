package com.cfhayes.claf.financial;

import javax.swing.border.Border;

import com.cfhayes.claf.AbstractBorderFactory;

public class FinancialBorderFactory implements AbstractBorderFactory {

    private static FinancialBorderFactory instance = null;

    private FinancialBorderFactory() {
    }

    public static synchronized FinancialBorderFactory getInstance() {
        if (instance == null) {
            instance = new FinancialBorderFactory();
        }
        return instance;
    }

    public Border getButtonBorder() {
        return FinancialBorders.getButtonBorder();
    }

    public Border getToggleButtonBorder() {
        return FinancialBorders.getToggleButtonBorder();
    }

    public Border getTextBorder() {
        return FinancialBorders.getTextBorder();
    }

    public Border getSpinnerBorder() {
        return FinancialBorders.getSpinnerBorder();
    }

    public Border getTextFieldBorder() {
        return FinancialBorders.getTextFieldBorder();
    }

    public Border getComboBoxBorder() {
        return FinancialBorders.getComboBoxBorder();
    }

    public Border getTableHeaderBorder() {
        return FinancialBorders.getTableHeaderBorder();
    }

    public Border getScrollPaneBorder() {
        return FinancialBorders.getScrollPaneBorder();
    }

    public Border getTabbedPaneBorder() {
        return FinancialBorders.getTabbedPaneBorder();
    }

    public Border getMenuBarBorder() {
        return FinancialBorders.getMenuBarBorder();
    }

    public Border getMenuItemBorder() {
        return FinancialBorders.getMenuItemBorder();
    }

    public Border getPopupMenuBorder() {
        return FinancialBorders.getPopupMenuBorder();
    }

    public Border getInternalFrameBorder() {
        return FinancialBorders.getInternalFrameBorder();
    }

    public Border getPaletteBorder() {
        return FinancialBorders.getPaletteBorder();
    }

    public Border getToolBarBorder() {
        return FinancialBorders.getToolBarBorder();
    }

    public Border getProgressBarBorder() {
        return FinancialBorders.getProgressBarBorder();
    }

    public Border getDesktopIconBorder() {
        return FinancialBorders.getDesktopIconBorder();
    }
}