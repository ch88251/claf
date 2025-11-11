package com.cfhayes.claf.food;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.UIResource;

import com.cfhayes.claf.AbstractLookAndFeel;
import com.cfhayes.claf.BaseBorders;
import com.cfhayes.claf.ColorHelper;
import com.cfhayes.claf.CLAFUtilities;
import com.cfhayes.claf.BaseBorders.BaseInternalFrameBorder;
import com.cfhayes.claf.industrial.IndustrialLookAndFeel;

public class FoodBorders extends BaseBorders {

    private static Border buttonBorder = null;
    private static Border rolloverToolButtonBorder = null;
    private static Border internalFrameBorder = null;

    ///////////////////////////////////////////////////////////////////
    // Lazy access methods

    public static Border getButtonBorder() {
        if (buttonBorder == null) {
            buttonBorder = new ButtonBorder();
        }
        return buttonBorder;
    }

    public static Border getToggleButtonBorder() {
        return getButtonBorder();
    }

    public static Border getRolloverToolButtonBorder() {
        if (rolloverToolButtonBorder == null) {
            rolloverToolButtonBorder = new RolloverToolButtonBorder();
        }
        return rolloverToolButtonBorder;
    }

    public static Border getInternalFrameBorder() {
        if (internalFrameBorder == null) {
            internalFrameBorder = new InternalFrameBorder();
        }
        return internalFrameBorder;
    }

    /////////////////////////////////////////////////////////////////////
    // Implementation of border classes

    public static class ButtonBorder implements Border, UIResource {

        private static final Insets insets = new Insets(4, 8, 4, 8);

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Color cHi = FoodLookAndFeel.getControlDarkShadow();
            Color cLo = ColorHelper.darker(cHi, 8);
            CLAFUtilities.draw3DBorder(g, cHi, cLo, x, y, w, h);
        }

        public Insets getBorderInsets(Component c) {
            return insets;
        }

        public boolean isBorderOpaque() {
            return true;
        }
    }

    public static class RolloverToolButtonBorder implements Border, UIResource {

        private static final Color frameHiColor = ColorHelper.brighter(FoodLookAndFeel.getFrameColor(), 60);
        private static final Color frameLoColor = FoodLookAndFeel.getFrameColor();
        private static final Insets insets = new Insets(2, 2, 2, 2);

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            AbstractButton button = (AbstractButton) c;
            ButtonModel model = button.getModel();
            if (model.isEnabled()) {
                if (model.isRollover()) {
                    CLAFUtilities.draw3DBorder(g, frameHiColor, frameLoColor, x, y, w - 1, h);
                    CLAFUtilities.draw3DBorder(g, Color.white, frameHiColor, x + 1, y + 1, w - 2, h - 2);
                } else if ((model.isPressed() && model.isArmed()) || model.isSelected()) {
                    g.setColor(frameHiColor);
                    g.drawRect(x, y, w - 2, h - 1);
                } else {
                    g.setColor(FoodLookAndFeel.getFrameColor());
                    g.drawRect(x, y, w - 2, h - 1);
                }
            } else {
                g.setColor(frameHiColor);
                g.drawRect(x, y, w - 2, h - 1);
            }
            g.setColor(Color.white);
            g.drawLine(w - 1, 0, w - 1, h - 1);
        }

        public Insets getBorderInsets(Component c) {
            return insets;
        }

        public boolean isBorderOpaque() {
            return true;
        }
    }

    public static class InternalFrameBorder extends BaseInternalFrameBorder {

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Graphics2D g2D = (Graphics2D) g;
            Color titleColor = FoodLookAndFeel.getWindowInactiveTitleBackgroundColor();
            if (isActive(c)) {
                titleColor = FoodLookAndFeel.getWindowTitleBackgroundColor();
            }
            int th = getTitleHeight(c);

            g.setColor(titleColor);
            g.fillRect(6, 6, w, dw);
            g.fillRect(6, h - dw, w, dw - 4);

            if (isActive(c)) {
                CLAFUtilities.fillHorGradient(g, IndustrialLookAndFeel.getTheme().getWindowTitleColors(), 1, dw, dw, th + 1);
                CLAFUtilities.fillHorGradient(g, IndustrialLookAndFeel.getTheme().getWindowTitleColors(), w - dw, dw, dw, th + 1);
                Color c1 = AbstractLookAndFeel.getTheme().getWindowTitleColorDark();
                Color c2 = AbstractLookAndFeel.getTheme().getWindowTitleColorLight();
                g2D.setPaint(new GradientPaint(0, dw + th + 1, c1, 0, h - th - (2 * dw), c2));
                g.fillRect(1, dw + th + 1, dw - 1, h - th - (2 * dw));
                g.fillRect(w - dw, dw + th + 1, dw - 1, h - th - (2 * dw));
                g2D.setPaint(null);
            } else {
                //CLAFUtilities.fillHorGradient(g, FoodLookAndFeel.getTheme().getWindowInactiveTitleColors(), 1, dw, dw, th + 1);
                //CLAFUtilities.fillHorGradient(g, FoodLookAndFeel.getTheme().getWindowInactiveTitleColors(), w - dw, dw, dw, th + 1);
                //Color c1 = AbstractLookAndFeel.getTheme().getWindowInactiveTitleColorDark();
                //Color c2 = AbstractLookAndFeel.getTheme().getWindowInactiveTitleColorLight();
                //g2D.setPaint(new GradientPaint(0, dw + th + 1, c1, 0, h - th - (2 * dw), c2));
                //g.fillRect(1, dw + th + 1, dw - 1, h - th - (2 * dw));
                //g.fillRect(w - dw, dw + th + 1, dw - 1, h - th - (2 * dw));
                //g2D.setPaint(null);
            }


            Color borderColor = FoodLookAndFeel.getWindowInactiveBorderColor();
            if (isActive(c)) {
                borderColor = FoodLookAndFeel.getWindowBorderColor();
            }
            g.setColor(borderColor);
            
            //Outer border
            g.drawRect(0, 0, w - 1, h - 1);
            
            //Inner border left side
            g.drawLine(x + dw - 1, y + insets.top + th, x + dw - 1, y + h - dw);
            
            //Inner border right side
            g.drawLine(x + w - dw, y + insets.top + th, x + w - dw, y + h - dw);
            
            //Fix bottom left inner corner
            g.drawLine(x + dw - 1, y + h - dw, x + w - dw, y + h - dw);

            g.setColor(new Color(26, 26, 26));
            g.drawLine(1, 1, w - 2, 1);
        }
    }
}

