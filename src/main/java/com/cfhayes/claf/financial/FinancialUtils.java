package com.cfhayes.claf.financial;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Utility class for financial theme rendering operations.
 */
public class FinancialUtils {

    private FinancialUtils() {
        // Utility class - no instances
    }

    /**
     * Creates a financial-themed gradient paint for professional applications.
     */
    public static GradientPaint createFinancialGradient(Rectangle bounds, Color startColor, Color endColor) {
        return new GradientPaint(
            bounds.x, bounds.y, startColor,
            bounds.x, bounds.y + bounds.height, endColor
        );
    }

    /**
     * Fills a rectangle with a financial gradient.
     */
    public static void fillFinancialGradient(Graphics g, Rectangle bounds, Color startColor, Color endColor) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gradient = createFinancialGradient(bounds, startColor, endColor);
        g2.setPaint(gradient);
        g2.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    /**
     * Draws a professional border suitable for financial applications.
     */
    public static void drawFinancialBorder(Graphics g, int x, int y, int width, int height) {
        FinancialDefaultTheme theme = new FinancialDefaultTheme();
        
        // Draw outer border in control shadow
        g.setColor(theme.getControlShadow());
        g.drawRect(x, y, width - 1, height - 1);
        
        // Draw inner highlight
        g.setColor(theme.getControlHighlight());
        g.drawRect(x + 1, y + 1, width - 3, height - 3);
    }

    /**
     * Creates a subtle financial accent color based on the base color.
     */
    public static Color createFinancialAccent(Color baseColor) {
        // Add a subtle gold tint for financial appeal
        int r = Math.min(255, baseColor.getRed() + 20);
        int g = Math.min(255, baseColor.getGreen() + 15);
        int b = Math.max(0, baseColor.getBlue() - 10);
        return new Color(r, g, b);
    }
}