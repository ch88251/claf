package com.cfhayes.claf.industrial;

import javax.swing.border.Border;

import com.cfhayes.claf.AbstractBorderFactory;

public class IndustrialBorderFactory implements AbstractBorderFactory {

    private static IndustrialBorderFactory instance = null;

    private IndustrialBorderFactory() {
    }

    public static synchronized IndustrialBorderFactory getInstance() {
        if (instance == null) {
            instance = new IndustrialBorderFactory();
        }
        return instance;
    }

    public Border getButtonBorder() {
        return IndustrialBorders.getButtonBorder();
    }

    public Border getToggleButtonBorder() {
        return IndustrialBorders.getToggleButtonBorder();
    }

    public Border getTextBorder() {
        return IndustrialBorders.getTextBorder();
    }

    public Border getSpinnerBorder() {
        return IndustrialBorders.getSpinnerBorder();
    }

    public Border getTextFieldBorder() {
        return IndustrialBorders.getTextFieldBorder();
    }

    public Border getComboBoxBorder() {
        return IndustrialBorders.getComboBoxBorder();
    }

    public Border getTableHeaderBorder() {
        return IndustrialBorders.getTableHeaderBorder();
    }

    public Border getScrollPaneBorder() {
        return IndustrialBorders.getScrollPaneBorder();
    }

    public Border getTabbedPaneBorder() {
        return IndustrialBorders.getTabbedPaneBorder();
    }

    public Border getMenuBarBorder() {
        return IndustrialBorders.getMenuBarBorder();
    }

    public Border getMenuItemBorder() {
        return IndustrialBorders.getMenuItemBorder();
    }

    public Border getPopupMenuBorder() {
        return IndustrialBorders.getPopupMenuBorder();
    }

    public Border getInternalFrameBorder() {
        return IndustrialBorders.getInternalFrameBorder();
    }

    public Border getPaletteBorder() {
        return IndustrialBorders.getPaletteBorder();
    }

    public Border getToolBarBorder() {
        return IndustrialBorders.getToolBarBorder();
    }

    public Border getProgressBarBorder() {
        return IndustrialBorders.getProgressBarBorder();
    }

    public Border getDesktopIconBorder() {
        return IndustrialBorders.getDesktopIconBorder();
    }
}

