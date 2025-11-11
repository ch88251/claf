package com.cfhayes.claf.food;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.Icon;

import com.cfhayes.claf.AbstractLookAndFeel;
import com.cfhayes.claf.CLAFUtilities;
import com.cfhayes.claf.LazyImageIcon;

public class FoodUtils {

    private static final Icon BG_IMAGE = new LazyImageIcon("food/icons/background.jpg");
    // Use safe defaults in case the background image fails to load
    private static final int IMAGE_WIDTH = BG_IMAGE.getIconWidth() > 0 ? BG_IMAGE.getIconWidth() : 64;
    private static final int IMAGE_HEIGHT = BG_IMAGE.getIconHeight() > 0 ? BG_IMAGE.getIconHeight() : 64;

    private FoodUtils() {
    }

    public static void fillComponent(Graphics g, Component c) {
        if (AbstractLookAndFeel.getTheme().isBackgroundPatternOn() && BG_IMAGE.getIconWidth() > 0) {
            // Only use pattern if background image loaded successfully
            int w = c.getWidth();
            int h = c.getHeight();
            Point p = CLAFUtilities.getRelLocation(c);
            int y = -p.y;
            while (y < h) {
                int x = -p.x;
                while (x < w) {
                    BG_IMAGE.paintIcon(c, g, x, y);
                    x += IMAGE_WIDTH;
                }
                y += IMAGE_HEIGHT;
            }
        } else {
            // Fall back to solid color if pattern is off or image failed to load
            g.setColor(AbstractLookAndFeel.getBackgroundColor());
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }

    }
}
