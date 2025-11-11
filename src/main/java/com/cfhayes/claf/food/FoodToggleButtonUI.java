package com.cfhayes.claf.food;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;

import com.cfhayes.claf.BaseToggleButtonUI;
import com.cfhayes.claf.ColorHelper;
import com.cfhayes.claf.CLAFUtilities;

public class FoodToggleButtonUI extends BaseToggleButtonUI {

    public static ComponentUI createUI(JComponent c) {
        return new FoodToggleButtonUI();
    }

    protected void paintBackground(Graphics g, AbstractButton b) {
        if (!b.isContentAreaFilled() || (b.getParent() instanceof JMenuBar)) {
            return;
        }

        int width = b.getWidth();
        int height = b.getHeight();
        Color colors[] = null;
        ButtonModel model = b.getModel();
        if (b.isEnabled()) {
            if (b.getBackground() instanceof ColorUIResource) {
                if ((model.isPressed() && model.isArmed()) || model.isSelected()) {
                    colors = FoodLookAndFeel.getTheme().getPressedColors();
                } else {
                    if (model.isRollover()) {
                        colors = FoodLookAndFeel.getTheme().getRolloverColors();
                    } else if (CLAFUtilities.isFrameActive(b)) {
                        colors = FoodLookAndFeel.getTheme().getButtonColors();
                    } else {
                        colors = FoodLookAndFeel.getTheme().getInActiveColors();
                    }

                }
            } else {
                if ((model.isPressed() && model.isArmed()) || model.isSelected()) {
                    colors = ColorHelper.createColorArr(b.getBackground(), ColorHelper.darker(b.getBackground(), 50), 20);
                } else {
                    if (model.isRollover()) {
                        colors = ColorHelper.createColorArr(ColorHelper.brighter(b.getBackground(), 80), ColorHelper.brighter(b.getBackground(), 20), 20);
                    } else {
                        colors = ColorHelper.createColorArr(ColorHelper.brighter(b.getBackground(), 40), ColorHelper.darker(b.getBackground(), 20), 20);
                    }
                }
            }
        } else {
            colors = FoodLookAndFeel.getTheme().getDisabledColors();
        }
        CLAFUtilities.fillHorGradient(g, colors, 0, 0, width, height);
    }
}


