package com.cfhayes.claf.food;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JRootPane;

import com.cfhayes.claf.AbstractLookAndFeel;
import com.cfhayes.claf.BaseRootPaneUI;
import com.cfhayes.claf.BaseTitlePane;
import com.cfhayes.claf.CLAFUtilities;

public class FoodTitlePane extends BaseTitlePane {

    public FoodTitlePane(JRootPane root, BaseRootPaneUI ui) {
        super(root, ui);
    }

    public void paintBackground(Graphics g) {
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, null);
        } else {
            FoodUtils.fillComponent(g, this);
        }
        Graphics2D g2D = (Graphics2D) g;
        Composite composite = g2D.getComposite();
        AlphaComposite alpha = null;
        if (backgroundImage != null) {
            alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue);
        } else {
            alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
        }
        g2D.setComposite(alpha);
        CLAFUtilities.fillHorGradient(g, FoodLookAndFeel.getTheme().getDefaultColors(), 0, 0, getWidth(), getHeight());
        g2D.setComposite(composite);
    }

    public void paintBorder(Graphics g) {
        if (isActive()) {
            g.setColor(AbstractLookAndFeel.getTheme().getWindowBorderColor());
        } else {
            g.setColor(AbstractLookAndFeel.getTheme().getWindowInactiveBorderColor());
        }
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}
