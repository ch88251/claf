package com.cfhayes.claf.food;

import javax.swing.Icon;

import com.cfhayes.claf.AbstractIconFactory;

public class FoodIconFactory implements AbstractIconFactory {

    private static FoodIconFactory instance = null;

    private FoodIconFactory() {
    }

    public static synchronized FoodIconFactory getInstance() {
        if (instance == null) {
            instance = new FoodIconFactory();
        }
        return instance;
    }

    public Icon getOptionPaneErrorIcon() {
        return FoodIcons.getOptionPaneErrorIcon();
    }

    public Icon getOptionPaneWarningIcon() {
        return FoodIcons.getOptionPaneWarningIcon();
    }

    public Icon getOptionPaneInformationIcon() {
        return FoodIcons.getOptionPaneInformationIcon();
    }

    public Icon getOptionPaneQuestionIcon() {
        return FoodIcons.getOptionPaneQuestionIcon();
    }

    public Icon getFileChooserDetailViewIcon() {
        return FoodIcons.getFileChooserDetailViewIcon();
    }

    public Icon getFileChooserHomeFolderIcon() {
        return FoodIcons.getFileChooserHomeFolderIcon();
    }

    public Icon getFileChooserListViewIcon() {
        return FoodIcons.getFileChooserListViewIcon();
    }

    public Icon getFileChooserNewFolderIcon() {
        return FoodIcons.getFileChooserNewFolderIcon();
    }

    public Icon getFileChooserUpFolderIcon() {
        return FoodIcons.getFileChooserUpFolderIcon();
    }

    public Icon getMenuIcon() {
        return FoodIcons.getMenuIcon();
    }

    public Icon getIconIcon() {
        return FoodIcons.getIconIcon();
    }

    public Icon getMaxIcon() {
        return FoodIcons.getMaxIcon();
    }

    public Icon getMinIcon() {
        return FoodIcons.getMinIcon();
    }

    public Icon getCloseIcon() {
        return FoodIcons.getCloseIcon();
    }

    public Icon getPaletteCloseIcon() {
        return FoodIcons.getPaletteCloseIcon();
    }

    public Icon getRadioButtonIcon() {
        return FoodIcons.getRadioButtonIcon();
    }

    public Icon getCheckBoxIcon() {
        return FoodIcons.getCheckBoxIcon();
    }

    public Icon getComboBoxIcon() {
        return FoodIcons.getComboBoxIcon();
    }

    public Icon getTreeComputerIcon() {
        return FoodIcons.getTreeComputerIcon();
    }

    public Icon getTreeFloppyDriveIcon() {
        return FoodIcons.getTreeFloppyDriveIcon();
    }

    public Icon getTreeHardDriveIcon() {
        return FoodIcons.getTreeHardDriveIcon();
    }

    public Icon getTreeFolderIcon() {
        return FoodIcons.getTreeFolderIcon();
    }

    public Icon getTreeLeafIcon() {
        return FoodIcons.getTreeLeafIcon();
    }

    public Icon getTreeCollapsedIcon() {
        return FoodIcons.getTreeControlIcon(true);
    }

    public Icon getTreeExpandedIcon() {
        return FoodIcons.getTreeControlIcon(false);
    }

    public Icon getMenuArrowIcon() {
        return FoodIcons.getMenuArrowIcon();
    }

    public Icon getMenuCheckBoxIcon() {
        return FoodIcons.getMenuCheckBoxIcon();
    }

    public Icon getMenuRadioButtonIcon() {
        return FoodIcons.getMenuRadioButtonIcon();
    }

    public Icon getUpArrowIcon() {
        return FoodIcons.getUpArrowIcon();
    }

    public Icon getDownArrowIcon() {
        return FoodIcons.getDownArrowIcon();
    }

    public Icon getLeftArrowIcon() {
        return FoodIcons.getLeftArrowIcon();
    }

    public Icon getRightArrowIcon() {
        return FoodIcons.getRightArrowIcon();
    }

    public Icon getSplitterDownArrowIcon() {
        return FoodIcons.getSplitterDownArrowIcon();
    }

    public Icon getSplitterHorBumpIcon() {
        return FoodIcons.getSplitterHorBumpIcon();
    }

    public Icon getSplitterLeftArrowIcon() {
        return FoodIcons.getSplitterLeftArrowIcon();
    }

    public Icon getSplitterRightArrowIcon() {
        return FoodIcons.getSplitterRightArrowIcon();
    }

    public Icon getSplitterUpArrowIcon() {
        return FoodIcons.getSplitterUpArrowIcon();
    }

    public Icon getSplitterVerBumpIcon() {
        return FoodIcons.getSplitterVerBumpIcon();
    }

    public Icon getThumbHorIcon() {
        return FoodIcons.getThumbHorIcon();
    }

    public Icon getThumbVerIcon() {
        return FoodIcons.getThumbVerIcon();
    }

    public Icon getThumbHorIconRollover() {
        return FoodIcons.getThumbHorIconRollover();
    }

    public Icon getThumbVerIconRollover() {
        return FoodIcons.getThumbVerIconRollover();
    }
}
