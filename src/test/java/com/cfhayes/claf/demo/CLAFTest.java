package com.cfhayes.claf.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.UIManager;

import com.cfhayes.claf.food.FoodLookAndFeel;
import com.cfhayes.claf.industrial.IndustrialLookAndFeel;

/**
 * Test class to verify CLAF Look and Feel implementations work correctly.
 */
public class CLAFTest {
    
    @BeforeEach
    void setUp() {
        // Reset to system default before each test
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Ignore setup failures
        }
    }
    
    @Test
    void testFoodLookAndFeelInstantiation() {
        assertDoesNotThrow(() -> {
            FoodLookAndFeel laf = new FoodLookAndFeel();
            assertNotNull(laf);
            assertEquals("Food", laf.getName());
            assertEquals("Food", laf.getID());
            assertFalse(laf.isNativeLookAndFeel());
            assertTrue(laf.isSupportedLookAndFeel());
        });
    }
    
    @Test
    void testIndustrialLookAndFeelInstantiation() {
        assertDoesNotThrow(() -> {
            IndustrialLookAndFeel laf = new IndustrialLookAndFeel();
            assertNotNull(laf);
            assertEquals("Industrial", laf.getName());
            assertEquals("Industrial", laf.getID());
            assertFalse(laf.isNativeLookAndFeel());
            assertTrue(laf.isSupportedLookAndFeel());
        });
    }
    
    @Test
    void testFoodLookAndFeelActivation() {
        assertDoesNotThrow(() -> {
            UIManager.setLookAndFeel(new FoodLookAndFeel());
            assertEquals(FoodLookAndFeel.class, UIManager.getLookAndFeel().getClass());
        });
    }
    
    @Test
    void testIndustrialLookAndFeelActivation() {
        assertDoesNotThrow(() -> {
            UIManager.setLookAndFeel(new IndustrialLookAndFeel());
            assertEquals(IndustrialLookAndFeel.class, UIManager.getLookAndFeel().getClass());
        });
    }
    
    @Test
    void testFoodThemes() {
        assertDoesNotThrow(() -> {
            var themes = FoodLookAndFeel.getThemes();
            assertNotNull(themes);
            assertTrue(themes.size() > 0);
            assertTrue(themes.contains("Default"));
        });
    }
    
    @Test
    void testIndustrialThemes() {
        assertDoesNotThrow(() -> {
            var themes = IndustrialLookAndFeel.getThemes();
            assertNotNull(themes);
            assertTrue(themes.size() > 0);
            assertTrue(themes.contains("Default"));
        });
    }
    
    @Test
    void testBorderFactories() {
        assertDoesNotThrow(() -> {
            FoodLookAndFeel foodLaf = new FoodLookAndFeel();
            assertNotNull(foodLaf.getBorderFactory());
            
            IndustrialLookAndFeel industrialLaf = new IndustrialLookAndFeel();
            assertNotNull(industrialLaf.getBorderFactory());
        });
    }
    
    @Test
    void testIconFactories() {
        assertDoesNotThrow(() -> {
            FoodLookAndFeel foodLaf = new FoodLookAndFeel();
            assertNotNull(foodLaf.getIconFactory());
            
            IndustrialLookAndFeel industrialLaf = new IndustrialLookAndFeel();
            assertNotNull(industrialLaf.getIconFactory());
        });
    }
    
    @Test
    void testDemoApplicationInstantiation() {
        // Test that the demo class can be instantiated without GUI
        assertDoesNotThrow(() -> {
            // Set headless mode for testing
            System.setProperty("java.awt.headless", "true");
            
            // This should not throw an exception during class loading
            Class.forName("com.cfhayes.claf.demo.CLAFDemo");
        });
    }
}