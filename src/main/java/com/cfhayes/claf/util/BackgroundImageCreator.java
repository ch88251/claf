package com.cfhayes.claf.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Utility to create background images for CLAF themes
 */
public class BackgroundImageCreator {
    
    public static void main(String[] args) {
        try {
            createFoodBackground();
            System.out.println("Successfully created background images!");
        } catch (Exception e) {
            System.err.println("Error creating background images: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void createFoodBackground() throws Exception {
        int size = 64;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        // Enable antialiasing for smoother patterns
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dark orange base color
        Color darkOrange = new Color(204, 102, 0); // #CC6600
        Color lighterOrange = new Color(221, 119, 17); // Slightly lighter for pattern
        Color darkerOrange = new Color(170, 85, 0); // Slightly darker for depth
        
        // Fill with base dark orange
        g2d.setColor(darkOrange);
        g2d.fillRect(0, 0, size, size);
        
        // Add subtle texture pattern
        g2d.setColor(lighterOrange);
        
        // Create a subtle diagonal weave pattern
        BasicStroke thinStroke = new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(thinStroke);
        
        // Diagonal lines going one way
        for (int i = -size; i < size * 2; i += 8) {
            g2d.drawLine(i, 0, i + size, size);
        }
        
        // Add some subtle dots for texture
        g2d.setColor(darkerOrange);
        for (int x = 4; x < size; x += 16) {
            for (int y = 4; y < size; y += 16) {
                g2d.fillOval(x - 1, y - 1, 2, 2);
            }
        }
        
        // Add lighter dots offset
        g2d.setColor(lighterOrange);
        for (int x = 12; x < size; x += 16) {
            for (int y = 12; y < size; y += 16) {
                g2d.fillOval(x - 1, y - 1, 2, 2);
            }
        }
        
        g2d.dispose();
        
        // Save as JPG
        File outputFile = new File("src/main/java/com/cfhayes/claf/food/icons/background.jpg");
        outputFile.getParentFile().mkdirs();
        ImageIO.write(image, "JPEG", outputFile);
        
        System.out.println("Created food background: " + outputFile.getAbsolutePath());
    }
}