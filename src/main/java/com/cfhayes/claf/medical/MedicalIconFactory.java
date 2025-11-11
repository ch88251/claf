package com.cfhayes.claf.medical;

import javax.swing.Icon;

import com.cfhayes.claf.AbstractIconFactory;
import com.cfhayes.claf.BaseIcons;

/**
 * Icon factory for Medical Look and Feel.
 * Currently delegates to BaseIcons - can be customized for medical-specific icons.
 */
public class MedicalIconFactory implements AbstractIconFactory {
    
    private static MedicalIconFactory instance = null;
    
    public static MedicalIconFactory getInstance() {
        if (instance == null) {
            instance = new MedicalIconFactory();
        }
        return instance;
    }

    // Delegate all icon methods to BaseIcons for now
    // These can be overridden to provide medical-specific icons
    
    public Icon getOptionPaneErrorIcon() {
        return BaseIcons.getOptionPaneErrorIcon();
    }

    public Icon getOptionPaneWarningIcon() {
        return BaseIcons.getOptionPaneWarningIcon();
    }

    public Icon getOptionPaneInformationIcon() {
        return BaseIcons.getOptionPaneInformationIcon();
    }

    public Icon getOptionPaneQuestionIcon() {
        return BaseIcons.getOptionPaneQuestionIcon();
    }

    public Icon getFileChooserDetailViewIcon() {
        return BaseIcons.getFileChooserDetailViewIcon();
    }

    public Icon getFileChooserHomeFolderIcon() {
        return BaseIcons.getFileChooserHomeFolderIcon();
    }

    public Icon getFileChooserListViewIcon() {
        return BaseIcons.getFileChooserListViewIcon();
    }

    public Icon getFileChooserNewFolderIcon() {
        return BaseIcons.getFileChooserNewFolderIcon();
    }

    public Icon getFileChooserUpFolderIcon() {
        return BaseIcons.getFileChooserUpFolderIcon();
    }

    public Icon getCheckBoxIcon() {
        return BaseIcons.getCheckBoxIcon();
    }

    public Icon getRadioButtonIcon() {
        return BaseIcons.getRadioButtonIcon();
    }

    public Icon getTreeCollapsedIcon() {
        return BaseIcons.getTreeControlIcon(true);
    }

    public Icon getTreeExpandedIcon() {
        return BaseIcons.getTreeControlIcon(false);
    }

    public Icon getTreeLeafIcon() {
        return BaseIcons.getTreeLeafIcon();
    }

    public Icon getTreeFolderIcon() {
        return BaseIcons.getTreeFolderIcon();
    }

    public Icon getTreeComputerIcon() {
        return BaseIcons.getTreeComputerIcon();
    }

    public Icon getTreeFloppyDriveIcon() {
        return BaseIcons.getTreeFloppyDriveIcon();
    }

    public Icon getTreeHardDriveIcon() {
        return BaseIcons.getTreeHardDriveIcon();
    }

    public Icon getMenuArrowIcon() {
        return BaseIcons.getMenuArrowIcon();
    }

    public Icon getMenuCheckBoxIcon() {
        return BaseIcons.getMenuCheckBoxIcon();
    }

    public Icon getMenuRadioButtonIcon() {
        return BaseIcons.getMenuRadioButtonIcon();
    }

    public Icon getUpArrowIcon() {
        return BaseIcons.getUpArrowIcon();
    }

    public Icon getDownArrowIcon() {
        return BaseIcons.getDownArrowIcon();
    }

    public Icon getLeftArrowIcon() {
        return BaseIcons.getLeftArrowIcon();
    }

    public Icon getRightArrowIcon() {
        return BaseIcons.getRightArrowIcon();
    }

    public Icon getSplitterDownArrowIcon() {
        return BaseIcons.getSplitterDownArrowIcon();
    }

    public Icon getSplitterHorBumpIcon() {
        return BaseIcons.getSplitterHorBumpIcon();
    }

    public Icon getSplitterLeftArrowIcon() {
        return BaseIcons.getSplitterLeftArrowIcon();
    }

    public Icon getSplitterRightArrowIcon() {
        return BaseIcons.getSplitterRightArrowIcon();
    }

    public Icon getSplitterUpArrowIcon() {
        return BaseIcons.getSplitterUpArrowIcon();
    }

    public Icon getSplitterVerBumpIcon() {
        return BaseIcons.getSplitterVerBumpIcon();
    }

    public Icon getThumbHorIcon() {
        return BaseIcons.getThumbHorIcon();
    }

    public Icon getThumbVerIcon() {
        return BaseIcons.getThumbVerIcon();
    }

    public Icon getThumbHorIconRollover() {
        return BaseIcons.getThumbHorIconRollover();
    }

    public Icon getThumbVerIconRollover() {
        return BaseIcons.getThumbVerIconRollover();
    }

    public Icon getCloseIcon() {
        return BaseIcons.getCloseIcon();
    }

    public Icon getIconIcon() {
        return BaseIcons.getIconIcon();
    }

    public Icon getMaxIcon() {
        return BaseIcons.getMaxIcon();
    }

    public Icon getMinIcon() {
        return BaseIcons.getMinIcon();
    }

    public Icon getPaletteCloseIcon() {
        return BaseIcons.getPaletteCloseIcon();
    }

    public Icon getMenuIcon() {
        return BaseIcons.getMenuIcon();
    }

    public Icon getComboBoxIcon() {
        return BaseIcons.getComboBoxIcon();
    }
}