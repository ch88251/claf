package com.cfhayes.claf.food;

import javax.swing.border.Border;

import com.cfhayes.claf.AbstractBorderFactory;

public class FoodBorderFactory implements AbstractBorderFactory {

    private static FoodBorderFactory instance = null;

    private FoodBorderFactory() {
    }

    public static synchronized FoodBorderFactory getInstance() {
        if (instance == null) {
            instance = new FoodBorderFactory();
        }
        return instance;
    }

    public Border getButtonBorder() {
        return FoodBorders.getButtonBorder();
    }

    public Border getToggleButtonBorder() {
        return FoodBorders.getToggleButtonBorder();
    }

    public Border getTextBorder() {
        return FoodBorders.getTextBorder();
    }

    public Border getSpinnerBorder() {
        return FoodBorders.getSpinnerBorder();
    }

    public Border getTextFieldBorder() {
        return FoodBorders.getTextFieldBorder();
    }

    public Border getComboBoxBorder() {
        return FoodBorders.getComboBoxBorder();
    }

    public Border getTableHeaderBorder() {
        return FoodBorders.getTableHeaderBorder();
    }

    public Border getScrollPaneBorder() {
        return FoodBorders.getScrollPaneBorder();
    }

    public Border getTabbedPaneBorder() {
        return FoodBorders.getTabbedPaneBorder();
    }

    public Border getMenuBarBorder() {
        return FoodBorders.getMenuBarBorder();
    }

    public Border getMenuItemBorder() {
        return FoodBorders.getMenuItemBorder();
    }

    public Border getPopupMenuBorder() {
        return FoodBorders.getPopupMenuBorder();
    }

    public Border getInternalFrameBorder() {
        return FoodBorders.getInternalFrameBorder();
    }

    public Border getPaletteBorder() {
        return FoodBorders.getPaletteBorder();
    }

    public Border getToolBarBorder() {
        return FoodBorders.getToolBarBorder();
    }

    public Border getProgressBarBorder() {
        return FoodBorders.getProgressBarBorder();
    }

    public Border getDesktopIconBorder() {
        return FoodBorders.getDesktopIconBorder();
    }
}

