# CLAF - Custom Look and Feel

A modern Java Swing Look and Feel library

## Overview

CLAF provides custom Look and Feel implementations for Java Swing applications, offering several themes:

- **Food Theme**: A colorful and user-friendly look and feel
- **Industrial Components**: Additional UI components with an industrial design aesthetic

## Features

- ✅ **Modern Java Support**: Updated to work with Java 17 and newer versions
- ✅ **Module System**: Full Java 9+ module system compatibility
- ✅ **Anti-aliased Text**: Support for modern text rendering
- ✅ **Customizable Themes**: Properties-based theme configuration
- ✅ **Window Decoration**: Custom window title bars and borders
- ✅ **High DPI Support**: Optimized for high-resolution displays

## Requirements

- **Java 17+** (originally required Java 1.4)
- **Maven 3.6+** for building

## Installation

### Using Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.cfhayes.claf</groupId>
    <artifactId>claf</artifactId>
    <version>2.0.0</version>
</dependency>
```

### Building from Source

```bash
git clone https://github.com/yourusername/claf.git
cd claf
./mvnw clean install
```

## Usage

### Quick Demo

Try the interactive demo application to see both themes in action:

```bash
# On Linux/Mac (Interactive Menu)
./run-demo.sh

# On Windows (Interactive Menu)
run-demo.bat

# Or using Maven directly
./mvnw exec:java
```

**New Interactive Menu!** The launcher scripts now provide a menu with options to:
- **Food Theme** - Launch directly with colorful Food theme
- **Industrial Theme** - Launch directly with professional Industrial theme  
- **System Default** - Launch with your OS native theme
- **Interactive Mode** - Launch with theme switcher (recommended)
- **About CLAF** - View project information

The demo showcases various Swing components including forms, buttons, lists, progress bars, 
and sliders with the ability to switch between themes dynamically.

### Basic Usage

```java
import com.cfhayes.claf.food.FoodLookAndFeel;
import com.cfhayes.claf.industrial.IndustrialLookAndFeel;
import javax.swing.UIManager;

public class MyApp {
    public static void main(String[] args) {
        try {
            // Choose your theme
            UIManager.setLookAndFeel(new FoodLookAndFeel());
            // or
            // UIManager.setLookAndFeel(new IndustrialLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create your Swing application
        SwingUtilities.invokeLater(() -> {
            new MyFrame().setVisible(true);
        });
    }
}
```

### Module System (Java 9+)

If you're using modules, add this to your `module-info.java`:

```java
module your.module {
    requires com.cfhayes.claf;
    // ... other requirements
}
```

### Theme Configuration

You can customize themes using properties:

```java
import com.cfhayes.claf.food.FoodLookAndFeel;
import java.util.Properties;

Properties props = new Properties();
props.setProperty("controlTextFont", "Dialog 14");
props.setProperty("windowDecoration", "on");
props.setProperty("textAntiAliasing", "on");

FoodLookAndFeel.setTheme(props);
```

### Available Themes

```java
// Get list of available themes
List<String> themes = FoodLookAndFeel.getThemes();

// Set a specific theme
FoodLookAndFeel.setTheme("Large-Font");
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Make your changes
4. Add tests for new functionality
5. Commit your changes (`git commit -m 'Add amazing feature'`)
6. Push to the branch (`git push origin feature/amazing-feature`)
7. Open a Pull Request

## Testing

Run tests with:

```bash
./mvnw test
```

## License

