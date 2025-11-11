#!/bin/bash

# CLAF Demo Launcher
# Runs the CLAF Demo application to showcase Look and Feel themes

show_banner() {
    echo "🎨 ═══════════════════════════════════════════════════════════════"
    echo "   CLAF - Custom Look and Feel Demo"
    echo "   Choose your Look & Feel experience!"
    echo "═══════════════════════════════════════════════════════════════"
    echo ""
}

check_prerequisites() {
    # Check if Java is available
    if ! command -v java &> /dev/null; then
        echo "❌ Error: Java is not installed or not in PATH"
        exit 1
    fi

    # Check Java version
    JAVA_VERSION=$(java -version 2>&1 | grep "version" | awk '{print $3}' | tr -d '"' | cut -d'.' -f1)
    if [ "$JAVA_VERSION" -lt 17 ]; then
        echo "⚠️  Warning: Java 17 or higher is recommended"
        echo "   Current Java version: $JAVA_VERSION"
        echo ""
    fi

    # Build the project if needed
    if [ ! -d "target/classes" ]; then
        echo "🔨 Building project..."
        ./mvnw compile -q
        if [ $? -ne 0 ]; then
            echo "❌ Build failed. Please check the error messages above."
            exit 1
        fi
        echo "✅ Build complete"
        echo ""
    fi
}

show_menu() {
    echo "📋 Select a Look & Feel to demo:"
    echo ""
    echo "   1) 🍎 Food Theme      - Colorful, vibrant interface"
    echo "   2) 🏭 Industrial      - Professional gray theme" 
    echo "   3) 🖥️  System Default  - Your OS native theme"
    echo "   4) 🎛️  Interactive     - Demo with theme switcher (recommended)"
    echo "   5) ❓ About CLAF      - Show project information"
    echo "   6) 🚪 Exit"
    echo ""
    echo -n "Enter your choice (1-6): "
}

launch_demo() {
    local theme=$1
    local theme_name=$2
    
    echo ""
    echo "🚀 Launching CLAF Demo with $theme_name..."
    echo "   Close the window or press Ctrl+C to return to menu"
    echo ""
    
    java -cp target/classes com.cfhayes.claf.demo.CLAFDemo "$theme"
}

show_about() {
    echo ""
    echo "ℹ️  About CLAF (Custom Look and Feel)"
    echo "──────────────────────────────────────"
    echo "Version: 2.0.0-SNAPSHOT"
    echo "Java: 17+ (modernized from 1.4)"
    echo "Themes: Food, Industrial"
    echo "Features: Swing components, theme switching, modern Java support"
    echo ""
    echo "Original concept modernized for contemporary Java applications."
    echo "Perfect for adding custom themes to your Swing applications!"
    echo ""
    echo "Press Enter to continue..."
    read
}

main_loop() {
    while true; do
        clear
        show_banner
        show_menu
        
        read choice
        
        case $choice in
            1)
                launch_demo "food" "Food Theme"
                ;;
            2)
                launch_demo "industrial" "Industrial Theme"
                ;;
            3)
                launch_demo "system" "System Default Theme"
                ;;
            4)
                launch_demo "interactive" "Interactive Theme Switcher"
                ;;
            5)
                show_about
                ;;
            6)
                echo ""
                echo "👋 Thanks for trying CLAF!"
                echo ""
                exit 0
                ;;
            *)
                echo ""
                echo "❌ Invalid choice. Please enter a number between 1-6."
                echo "Press Enter to continue..."
                read
                ;;
        esac
    done
}

# Main execution
show_banner
check_prerequisites
main_loop