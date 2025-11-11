package com.cfhayes.claf.industrial;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicGraphicsUtils;

import com.cfhayes.claf.AbstractLookAndFeel;
import com.cfhayes.claf.BaseButtonUI;
import com.cfhayes.claf.ColorHelper;
import com.cfhayes.claf.CLAFUtilities;

public class IndustrialButtonUI extends BaseButtonUI {

    public static ComponentUI createUI(JComponent c) {
        return new IndustrialButtonUI();
    }

    protected void paintBackground(Graphics g, AbstractButton b) {
        if (!b.isContentAreaFilled() || (b.getParent() instanceof JMenuBar)) {
            return;
        }

        if (!(b.isBorderPainted() && (b.getBorder() instanceof UIResource))) {
            super.paintBackground(g, b);
            return;
        }

        int width = b.getWidth();
        int height = b.getHeight();
        ButtonModel model = b.getModel();
        Graphics2D g2D = (Graphics2D) g;
        Composite composite = g2D.getComposite();
        Object savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (((width < 64) || (height < 16)) && ((b.getText() == null) || b.getText().equals(""))) {
            Color[] colors = null;
            if (b.getBackground() instanceof ColorUIResource) {
                if (!model.isEnabled()) {
                    colors = IndustrialLookAndFeel.getTheme().getDisabledColors();
                } else if (model.isRollover()) {
                    colors = IndustrialLookAndFeel.getTheme().getRolloverColors();
                } else {
                    colors = IndustrialLookAndFeel.getTheme().getButtonColors();
                }
            } else {
                colors = ColorHelper.createColorArr(ColorHelper.brighter(b.getBackground(), 20), ColorHelper.darker(b.getBackground(), 20), 20);
            }
            CLAFUtilities.fillHorGradient(g, colors, 0, 0, width - 1, height - 1);
            if (model.isEnabled()) {
                g2D.setColor(IndustrialLookAndFeel.getFrameColor());
            } else {
                g2D.setColor(ColorHelper.brighter(IndustrialLookAndFeel.getFrameColor(), 20));
            }
            g2D.drawRect(0, 0, width - 1, height - 1);
            AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);
            g2D.setComposite(alpha);
            g2D.setColor(Color.white);
            g2D.drawRect(1, 1, width - 3, height - 3);
        } else if (model.isPressed() && model.isArmed()) {
            int d = height - 2;
            Color color = IndustrialLookAndFeel.getTheme().getSelectionBackgroundColor();
            g2D.setColor(color);
            g2D.fillRoundRect(0, 0, width - 1, height - 1, d, d);

            g2D.setColor(ColorHelper.darker(color, 40));
            g2D.drawRoundRect(0, 0, width - 1, height - 1, d, d);
        } else {
            int d = height - 2;
            Color[] colors = null;
            if (b.getBackground() instanceof ColorUIResource) {
                if (!model.isEnabled()) {
                    colors = IndustrialLookAndFeel.getTheme().getDisabledColors();
                } else if (model.isRollover()) {
                    colors = IndustrialLookAndFeel.getTheme().getRolloverColors();
                } else {
                    colors = IndustrialLookAndFeel.getTheme().getButtonColors();
                }
            } else {
                colors = ColorHelper.createColorArr(ColorHelper.brighter(b.getBackground(), 20), ColorHelper.darker(b.getBackground(), 20), 20);
            }

            Shape savedClip = g.getClip();
            Area clipArea = new Area(savedClip);
            Area rectArea = new Area(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, d, d));
            rectArea.intersect(clipArea);
            g2D.setClip(rectArea);
            CLAFUtilities.fillHorGradient(g, colors, 0, 0, width - 1, height - 1);
            g2D.setClip(savedClip);

            if (model.isEnabled()) {
                g2D.setColor(IndustrialLookAndFeel.getFrameColor());
            } else {
                g2D.setColor(ColorHelper.brighter(IndustrialLookAndFeel.getFrameColor(), 20));
            }
            g2D.drawRoundRect(0, 0, width - 1, height - 1, d, d);

            AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);
            g2D.setComposite(alpha);
            g2D.setColor(Color.white);
            g2D.drawRoundRect(1, 1, width - 3, height - 3, d - 2, d - 2);

        }
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, savedRenderingHint);
        g2D.setComposite(composite);
    }

    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        Graphics2D g2D = (Graphics2D) g;
        int width = b.getWidth();
        int height = b.getHeight();
        if (!b.isContentAreaFilled()
                || ((width < 64) || (height < 16)) && ((b.getText() == null) || b.getText().equals(""))) {
            g.setColor(AbstractLookAndFeel.getFocusColor());
            BasicGraphicsUtils.drawDashedRect(g, 4, 3, width - 8, height - 6);
        } else {
            Object savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2D.setColor(AbstractLookAndFeel.getFocusColor());
            int d = b.getHeight() - 4;
            g2D.drawRoundRect(2, 2, b.getWidth() - 5, b.getHeight() - 5, d, d);
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, savedRenderingHint);
        }
    }
}



