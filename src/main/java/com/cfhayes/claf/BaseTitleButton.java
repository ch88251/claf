package com.cfhayes.claf;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Action;
import javax.swing.Icon;

public class BaseTitleButton extends NoFocusButton {

    private float alpha = 1.0f;

    public BaseTitleButton(Action action, String accessibleName, Icon icon, float alpha) {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setAction(action);
        setText(null);
        setIcon(icon);
        putClientProperty("paintActive", Boolean.TRUE);
        getAccessibleContext().setAccessibleName(accessibleName);
        this.alpha = Math.max(0.2f, alpha);
    }

    public void paint(Graphics g) {
        if (CLAFUtilities.isActive(this) || (alpha >= 1.0)) {
            super.paint(g);
        } else {
            Graphics2D g2D = (Graphics2D) g;
            Composite composite = g2D.getComposite();
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2D.setComposite(alphaComposite);
            super.paint(g);
            g2D.setComposite(composite);
        }
    }
}
