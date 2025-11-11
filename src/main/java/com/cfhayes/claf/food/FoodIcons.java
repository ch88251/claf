package com.cfhayes.claf.food;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.plaf.UIResource;

import com.cfhayes.claf.BaseIcons;
import com.cfhayes.claf.CLAFUtilities;
import com.cfhayes.claf.LazyImageIcon;

public class FoodIcons extends BaseIcons {

    private static Icon radioButtonIcon;
    private static Icon checkBoxIcon;
    private static Icon thumbIcon = null;
    private static Icon thumbIconRollover = null;
    private static Icon splitterUpArrowIcon = null;
    private static Icon splitterDownArrowIcon = null;
    private static Icon splitterLeftArrowIcon = null;
    private static Icon splitterRightArrowIcon = null;

    public static Icon getRadioButtonIcon() {
        if (radioButtonIcon == null) {
            radioButtonIcon = new RadioButtonIcon();
        }
        return radioButtonIcon;
    }

    public static Icon getCheckBoxIcon() {
        if (checkBoxIcon == null) {
            checkBoxIcon = new CheckBoxIcon();
        }
        return checkBoxIcon;
    }

    public static Icon getThumbHorIcon() {
        if (thumbIcon == null) {
            thumbIcon = new LazyImageIcon("icons/thumb_hor.gif");
        }
        return thumbIcon;
    }

    public static Icon getThumbVerIcon() {
        if (thumbIcon == null) {
            thumbIcon = new LazyImageIcon("icons/thumb_ver.gif");
        }
        return thumbIcon;
    }

    public static Icon getThumbHorIconRollover() {
        if (thumbIconRollover == null) {
            thumbIconRollover = new LazyImageIcon("icons/thumb_hor_rollover.gif");
        }
        return thumbIconRollover;
    }

    public static Icon getThumbVerIconRollover() {
        if (thumbIconRollover == null) {
            thumbIconRollover = new LazyImageIcon("icons/thumb_ver_rollover.gif");
        }
        return thumbIconRollover;
    }

    public static Icon getSplitterUpArrowIcon() {
        if (splitterUpArrowIcon == null) {
            splitterUpArrowIcon = new LazyImageIcon("icons/SplitterUpArrow.gif");
        }
        return splitterUpArrowIcon;
    }

    public static Icon getSplitterDownArrowIcon() {
        if (splitterDownArrowIcon == null) {
            splitterDownArrowIcon = new LazyImageIcon("icons/SplitterDownArrow.gif");
        }
        return splitterDownArrowIcon;
    }

    public static Icon getSplitterLeftArrowIcon() {
        if (splitterLeftArrowIcon == null) {
            splitterLeftArrowIcon = new LazyImageIcon("icons/SplitterLeftArrow.gif");
        }
        return splitterLeftArrowIcon;
    }

    public static Icon getSplitterRightArrowIcon() {
        if (splitterRightArrowIcon == null) {
            splitterRightArrowIcon = new LazyImageIcon("icons/SplitterRightArrow.gif");
        }
        return splitterRightArrowIcon;
    }

    //--------------------------------------------------------------------------------------------------------
    private static class CheckBoxIcon implements Icon, UIResource {

        private static Icon checkIcon = null;
        private static Icon checkSelectedIcon = null;
        private static Icon checkPressedIcon = null;
        private static Icon checkRolloverIcon = null;
        private static Icon checkRolloverSelectedIcon = null;
        private static Icon checkDisabledIcon = null;
        private static Icon checkDisabledSelectedIcon = null;

        public CheckBoxIcon() {
            checkIcon = new LazyImageIcon("icons/CheckSymbol.gif");
            checkSelectedIcon = new LazyImageIcon("icons/CheckPressedSymbol.gif");
            checkPressedIcon = new LazyImageIcon("icons/CheckPressedSymbol.gif");
            checkRolloverIcon = new LazyImageIcon("icons/CheckSymbol.gif");
            checkRolloverSelectedIcon = new LazyImageIcon("icons/CheckPressedSymbol.gif");
            checkDisabledIcon = new LazyImageIcon("icons/CheckSymbolDisabled.gif");
            checkDisabledSelectedIcon = new LazyImageIcon("icons/CheckSymbolDisabled.gif");
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            if (!CLAFUtilities.isLeftToRight(c)) {
                x += 2;
            }
            JCheckBox cb = (JCheckBox) c;
            ButtonModel model = cb.getModel();
            if (cb.isEnabled()) {
                if (model.isPressed() && model.isArmed()) {
                    checkPressedIcon.paintIcon(c, g, x, y);
                } else if (model.isSelected()) {
                    if (cb.isRolloverEnabled() && model.isRollover() && !model.isArmed()) {
                        checkRolloverSelectedIcon.paintIcon(c, g, x, y);
                    } else {
                        checkSelectedIcon.paintIcon(c, g, x, y);
                    }
                } else {
                    if (cb.isRolloverEnabled() && model.isRollover() && !model.isArmed()) {
                        checkRolloverIcon.paintIcon(c, g, x, y);
                    } else {
                        checkIcon.paintIcon(c, g, x, y);
                    }
                }
            } else {
                if (model.isPressed() && model.isArmed()) {
                    checkPressedIcon.paintIcon(c, g, x, y);
                } else if (model.isSelected()) {
                    checkDisabledSelectedIcon.paintIcon(c, g, x, y);
                } else {
                    checkDisabledIcon.paintIcon(c, g, x, y);
                }
            }
        }

        public int getIconWidth() {
            return checkIcon.getIconWidth() + 2;
        }

        public int getIconHeight() {
            return checkIcon.getIconHeight();
        }
    }

    private static class RadioButtonIcon implements Icon, UIResource {

        private Icon radioIcon = null;
        private Icon radioSelectedIcon = null;
        private Icon radioRolloverIcon = null;
        private Icon radioRolloverSelectedIcon = null;
        private Icon radioDisabledIcon = null;
        private Icon radioDisabledSelectedIcon = null;

        public RadioButtonIcon() {
            radioIcon = new LazyImageIcon("icons/RadioSymbol.gif");
            radioSelectedIcon = new LazyImageIcon("icons/RadioSymbol.gif");
            radioRolloverIcon = new LazyImageIcon("icons/RadioSymbol.gif");
            radioRolloverSelectedIcon = new LazyImageIcon("icons/RadioSymbol.gif");
            radioDisabledIcon = new LazyImageIcon("icons/RadioSymbolDisabled.gif");
            radioDisabledSelectedIcon = new LazyImageIcon("icons/RadioSymbolDisabled.gif");
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            if (!CLAFUtilities.isLeftToRight(c)) {
                x += 2;
            }
            JRadioButton rb = (JRadioButton) c;
            ButtonModel model = rb.getModel();
            if (rb.isEnabled()) {
                if (model.isSelected()) {
                    if (rb.isRolloverEnabled() && model.isRollover()) {
                        radioRolloverSelectedIcon.paintIcon(c, g, x, y);
                    } else {
                        radioSelectedIcon.paintIcon(c, g, x, y);
                    }
                } else {
                    if (rb.isRolloverEnabled() && model.isRollover()) {
                        radioRolloverIcon.paintIcon(c, g, x, y);
                    } else {
                        radioIcon.paintIcon(c, g, x, y);
                    }
                }
            } else {
                if (model.isSelected()) {
                    radioDisabledSelectedIcon.paintIcon(c, g, x, y);
                } else {
                    radioDisabledIcon.paintIcon(c, g, x, y);
                }
            }
        }

        public int getIconWidth() {
            return radioIcon.getIconWidth() + 2;
        }

        public int getIconHeight() {
            return radioIcon.getIconHeight();
        }
    }
}
