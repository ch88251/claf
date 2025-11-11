package com.cfhayes.claf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.text.View;

public class BaseRadioButtonUI extends BasicRadioButtonUI {

    private static BaseRadioButtonUI radioButtonUI = null;
    private static Dimension size = new Dimension();
    private static Rectangle viewRect = new Rectangle();
    private static Rectangle iconRect = new Rectangle();
    private static Rectangle textRect = new Rectangle();

    public static ComponentUI createUI(JComponent c) {
        if (radioButtonUI == null) {
            radioButtonUI = new BaseRadioButtonUI();
        }
        return radioButtonUI;
    }

    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setRolloverEnabled(true);
        icon = UIManager.getIcon("RadioButton.icon");
    }

    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        Font f = c.getFont();
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();

        Insets i = c.getInsets();
        size = b.getSize(size);
        viewRect.x = i.left;
        viewRect.y = i.top;
        viewRect.width = size.width - (i.right + viewRect.x);
        viewRect.height = size.height - (i.bottom + viewRect.y);
        iconRect.x = iconRect.y = iconRect.width = iconRect.height = 0;
        textRect.x = textRect.y = textRect.width = textRect.height = 0;
        Icon altIcon = b.getIcon();
        int iconTextGap = getDefaultTextIconGap(b);
        if (CLAFUtilities.getJavaVersion() >= 1.4) {
            iconTextGap = b.getIconTextGap();
        }
        String text = SwingUtilities.layoutCompoundLabel(
                c,
                fm,
                b.getText(),
                altIcon != null ? altIcon : getDefaultIcon(),
                b.getVerticalAlignment(),
                b.getHorizontalAlignment(),
                b.getVerticalTextPosition(),
                b.getHorizontalTextPosition(),
                viewRect,
                iconRect,
                textRect,
                iconTextGap);

        // fill background
        if (c.isOpaque()) {
            paintBackground(g, c);
        }

        paintIcon(g, c, iconRect);

        if (text != null) {
            paintText(g, c, text, textRect);
        }

        if (b.hasFocus() && b.isFocusPainted() && (textRect.width > 0) && (textRect.height > 0)) {
            paintFocus(g, textRect, size);
        }
    }

    protected void paintBackground(Graphics g, JComponent c) {
        g.setColor(c.getBackground());
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
    }

    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        Icon ico = null;
        if (!model.isEnabled()) {
            if (b.isSelected()) {
                ico = b.getDisabledSelectedIcon();
            } else {
                ico = b.getDisabledIcon();
            }
        } else {
            if (model.isPressed()) {
                ico = b.getPressedIcon();
            } else {
                if (model.isRollover()) {
                    if (b.isSelected()) {
                        ico = b.getRolloverSelectedIcon();
                    } else {
                        ico = b.getRolloverIcon();
                    }
                } else {
                    if (b.isSelected()) {
                        ico = b.getSelectedIcon();
                    } else {
                        ico = b.getIcon();
                    }
                }
            }
        }

        if (ico != null) {
            ico.paintIcon(c, g, iconRect.x, iconRect.y - 1);
        } else {
            getDefaultIcon().paintIcon(c, g, iconRect.x, iconRect.y - 1);
        }
    }

    protected void paintText(Graphics g, JComponent c, String text, Rectangle textRect) {
        View v = (View) c.getClientProperty(BasicHTML.propertyKey);
        if (v != null) {
            Graphics2D g2D = (Graphics2D) g;
            Object savedRenderingHint = null;
            if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
                savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
                g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, AbstractLookAndFeel.getTheme().getTextAntiAliasingHint());
            }
            v.paint(g, textRect);
            if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
                g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, savedRenderingHint);
            }
        } else {
            AbstractButton b = (AbstractButton) c;
            ButtonModel model = b.getModel();
            Font f = c.getFont();
            g.setFont(f);
            FontMetrics fm = g.getFontMetrics();
            int mnemIndex = -1;
            if (CLAFUtilities.getJavaVersion() >= 1.4) {
                mnemIndex = b.getDisplayedMnemonicIndex();
            } else {
                mnemIndex = CLAFUtilities.findDisplayedMnemonicIndex(b.getText(), model.getMnemonic());
            }
            if (model.isEnabled()) {
                g.setColor(b.getForeground());
                CLAFUtilities.drawStringUnderlineCharAt(c, g, text, mnemIndex, textRect.x, textRect.y + fm.getAscent());
            } else {
                g.setColor(Color.white);
                CLAFUtilities.drawStringUnderlineCharAt(c, g, text, mnemIndex, textRect.x + 1, textRect.y + 1 + fm.getAscent());
                g.setColor(AbstractLookAndFeel.getDisabledForegroundColor());
                CLAFUtilities.drawStringUnderlineCharAt(c, g, text, mnemIndex, textRect.x, textRect.y + fm.getAscent());
            }
        }
    }

    protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
        g.setColor(AbstractLookAndFeel.getFocusColor());
        BasicGraphicsUtils.drawDashedRect(g, t.x, t.y - 1, t.width + 1, t.height + 1);
    }
}
