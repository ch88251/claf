/**
 * Custom Look and Feel (CLAF) module for Java Swing applications.
 * 
 * Provides a collection of modern, customizable look and feel implementations
 * including the Food theme with additional Industrial components.
 * 
 * @since 2.0
 */
module com.cfhayes.claf {
    
    // Required modules
    requires transitive java.desktop;
    requires java.base;
    
    // Exports main packages
    exports com.cfhayes.claf;
    exports com.cfhayes.claf.food;
    exports com.cfhayes.claf.industrial;
    exports com.cfhayes.claf.demo;
    
    // Services for Look and Feel discovery
    provides javax.swing.LookAndFeel 
        with com.cfhayes.claf.food.FoodLookAndFeel,
             com.cfhayes.claf.industrial.IndustrialLookAndFeel;
}