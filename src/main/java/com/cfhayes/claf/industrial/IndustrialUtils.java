package com.cfhayes.claf.industrial;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

import com.cfhayes.claf.AbstractLookAndFeel;
import com.cfhayes.claf.CLAFUtilities;

/**
 * Utility class for Industrial Look and Feel rendering operations.
 */
public class IndustrialUtils {

    /**
     * Fills a component with the default industrial gradient background.
     * @param g Graphics context
     * @param c Component to fill
     */
    public static void fillComponent(Graphics g, Component c) {
        if (g != null && c != null) {
            fillComponent(g, c, 0, 0, c.getWidth(), c.getHeight());
        }
    }

    /**
     * Fills a rectangular area with the industrial gradient background.
     * @param g Graphics context
     * @param c Component (for color reference)
     * @param x X coordinate
     * @param y Y coordinate
     * @param w Width
     * @param h Height
     */
    public static void fillComponent(Graphics g, Component c, int x, int y, int w, int h) {
        if (g != null && w > 0 && h > 0) {
            Color[] colors = getDefaultGradientColors();
            CLAFUtilities.fillHorGradient(g, colors, x, y, w, h);
        }
    }

    /**
     * Gets the default gradient colors for the industrial theme.
     * @return Array of colors for gradient painting
     */
    public static Color[] getDefaultGradientColors() {
        try {
            return AbstractLookAndFeel.getTheme().getDefaultColors();
        } catch (Exception e) {
            // Fallback to simple gradient
            return new Color[] {
                new Color(240, 240, 240),
                new Color(220, 220, 220),
                new Color(200, 200, 200)
            };
        }
    }

    /**
     * Creates a metallic-style gradient paint.
     * @param x1 Start X coordinate
     * @param y1 Start Y coordinate  
     * @param x2 End X coordinate
     * @param y2 End Y coordinate
     * @param lightColor Light color for gradient
     * @param darkColor Dark color for gradient
     * @return GradientPaint object
     */
    public static GradientPaint createMetallicGradient(float x1, float y1, float x2, float y2, 
                                                       Color lightColor, Color darkColor) {
        return new GradientPaint(x1, y1, lightColor, x2, y2, darkColor);
    }

    /**
     * Paints a metallic button background.
     * @param g Graphics context
     * @param x X coordinate
     * @param y Y coordinate
     * @param w Width
     * @param h Height
     * @param pressed Whether button is pressed
     * @param rollover Whether button has rollover state
     */
    public static void paintMetallicButton(Graphics g, int x, int y, int w, int h, 
                                          boolean pressed, boolean rollover) {
        Graphics2D g2d = (Graphics2D) g;
        
        Color lightColor = AbstractLookAndFeel.getTheme().getControlHighlightColor();
        Color darkColor = AbstractLookAndFeel.getTheme().getControlShadowColor();
        
        if (pressed) {
            // Swap colors for pressed effect
            Color temp = lightColor;
            lightColor = darkColor;
            darkColor = temp;
        } else if (rollover) {
            lightColor = AbstractLookAndFeel.getControlColorLight();
            darkColor = AbstractLookAndFeel.getControlColorDark();
        }
        
        GradientPaint gradient = createMetallicGradient(x, y, x, y + h, lightColor, darkColor);
        g2d.setPaint(gradient);
        g2d.fillRect(x, y, w, h);
    }
}