package com.cfhayes.claf.medical;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

import com.cfhayes.claf.AbstractLookAndFeel;
import com.cfhayes.claf.CLAFUtilities;

/**
 * Utility class for Medical Look and Feel rendering operations.
 */
public class MedicalUtils {

    /**
     * Fills a component with the default medical gradient background.
     * @param g Graphics context
     * @param c Component to fill
     */
    public static void fillComponent(Graphics g, Component c) {
        if (g != null && c != null) {
            fillComponent(g, c, 0, 0, c.getWidth(), c.getHeight());
        }
    }

    /**
     * Fills a rectangular area with the medical gradient background.
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
     * Gets the default gradient colors for the medical theme.
     * @return Array of colors for gradient painting
     */
    public static Color[] getDefaultGradientColors() {
        try {
            return AbstractLookAndFeel.getTheme().getDefaultColors();
        } catch (Exception e) {
            // Fallback to simple medical-themed gradient (mint green)
            return new Color[] {
                new Color(250, 255, 252),  // Very light mint
                new Color(240, 248, 245),  // Light mint
                new Color(235, 245, 240)   // Medium mint
            };
        }
    }

    /**
     * Creates a medical-style gradient paint using soothing blue/green colors.
     * @param x1 Start X coordinate
     * @param y1 Start Y coordinate  
     * @param x2 End X coordinate
     * @param y2 End Y coordinate
     * @param lightColor Light color for gradient
     * @param darkColor Dark color for gradient
     * @return GradientPaint object
     */
    public static GradientPaint createMedicalGradient(float x1, float y1, float x2, float y2, 
                                                     Color lightColor, Color darkColor) {
        return new GradientPaint(x1, y1, lightColor, x2, y2, darkColor);
    }

    /**
     * Paints a medical-themed button background with soothing colors.
     * @param g Graphics context
     * @param x X coordinate
     * @param y Y coordinate
     * @param w Width
     * @param h Height
     * @param pressed Whether button is pressed
     * @param rollover Whether button has rollover state
     */
    public static void paintMedicalButton(Graphics g, int x, int y, int w, int h, 
                                         boolean pressed, boolean rollover) {
        Graphics2D g2d = (Graphics2D) g;
        
        Color lightColor = AbstractLookAndFeel.getTheme().getControlHighlightColor();
        Color darkColor = AbstractLookAndFeel.getTheme().getControlShadowColor();
        
        if (pressed) {
            // Use steel blue for pressed effect
            lightColor = new Color(70, 130, 180);
            darkColor = new Color(100, 149, 237);
        } else if (rollover) {
            // Use light sea green for rollover
            lightColor = new Color(200, 230, 215);
            darkColor = new Color(120, 200, 150);
        }
        
        GradientPaint gradient = createMedicalGradient(x, y, x, y + h, lightColor, darkColor);
        g2d.setPaint(gradient);
        g2d.fillRect(x, y, w, h);
    }
}