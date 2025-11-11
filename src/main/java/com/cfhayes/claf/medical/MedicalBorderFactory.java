package com.cfhayes.claf.medical;

import javax.swing.border.Border;

import com.cfhayes.claf.AbstractBorderFactory;

public class MedicalBorderFactory implements AbstractBorderFactory {

    private static MedicalBorderFactory instance = null;

    private MedicalBorderFactory() {
    }

    public static synchronized MedicalBorderFactory getInstance() {
        if (instance == null) {
            instance = new MedicalBorderFactory();
        }
        return instance;
    }

    public Border getButtonBorder() {
        return MedicalBorders.getButtonBorder();
    }

    public Border getToggleButtonBorder() {
        return MedicalBorders.getToggleButtonBorder();
    }

    public Border getTextBorder() {
        return MedicalBorders.getTextBorder();
    }

    public Border getSpinnerBorder() {
        return MedicalBorders.getSpinnerBorder();
    }

    public Border getTextFieldBorder() {
        return MedicalBorders.getTextFieldBorder();
    }

    public Border getComboBoxBorder() {
        return MedicalBorders.getComboBoxBorder();
    }

    public Border getTableHeaderBorder() {
        return MedicalBorders.getTableHeaderBorder();
    }

    public Border getScrollPaneBorder() {
        return MedicalBorders.getScrollPaneBorder();
    }

    public Border getTabbedPaneBorder() {
        return MedicalBorders.getTabbedPaneBorder();
    }

    public Border getMenuBarBorder() {
        return MedicalBorders.getMenuBarBorder();
    }

    public Border getMenuItemBorder() {
        return MedicalBorders.getMenuItemBorder();
    }

    public Border getPopupMenuBorder() {
        return MedicalBorders.getPopupMenuBorder();
    }

    public Border getInternalFrameBorder() {
        return MedicalBorders.getInternalFrameBorder();
    }

    public Border getPaletteBorder() {
        return MedicalBorders.getPaletteBorder();
    }

    public Border getToolBarBorder() {
        return MedicalBorders.getToolBarBorder();
    }

    public Border getProgressBarBorder() {
        return MedicalBorders.getProgressBarBorder();
    }

    public Border getDesktopIconBorder() {
        return MedicalBorders.getDesktopIconBorder();
    }
}