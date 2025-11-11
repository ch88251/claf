package com.cfhayes.claf;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;

public class BaseLabelUI extends BasicLabelUI {

    private static BaseLabelUI baseLabelUI = null;

    public static ComponentUI createUI(JComponent c) {
        if (baseLabelUI == null) {
            baseLabelUI = new BaseLabelUI();
        }
        return baseLabelUI;
    }

    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int mnemIndex = -1;
        if (CLAFUtilities.getJavaVersion() >= 1.4) {
            mnemIndex = l.getDisplayedMnemonicIndex();
        } else {
            mnemIndex = CLAFUtilities.findDisplayedMnemonicIndex(l.getText(), l.getDisplayedMnemonic());
        }
        g.setColor(l.getForeground());
        CLAFUtilities.drawStringUnderlineCharAt(l, g, s, mnemIndex, textX, textY);
    }

    protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int mnemIndex = -1;
        if (CLAFUtilities.getJavaVersion() >= 1.4) {
            mnemIndex = l.getDisplayedMnemonicIndex();
        } else {
            mnemIndex = CLAFUtilities.findDisplayedMnemonicIndex(l.getText(), l.getDisplayedMnemonic());
        }
        g.setColor(Color.white);
        CLAFUtilities.drawStringUnderlineCharAt(l, g, s, mnemIndex, textX + 1, textY + 1);
        g.setColor(AbstractLookAndFeel.getDisabledForegroundColor());
        CLAFUtilities.drawStringUnderlineCharAt(l, g, s, mnemIndex, textX, textY);
    }
}

