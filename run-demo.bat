@echo off
REM CLAF Demo Launcher for Windows
REM Runs the CLAF Demo application to showcase Look and Feel themes

:banner
cls
echo 🎨 ═══════════════════════════════════════════════════════════════
echo    CLAF - Custom Look and Feel Demo
echo    Choose your Look ^& Feel experience!
echo ═══════════════════════════════════════════════════════════════
echo.

REM Check prerequisites once
if not defined CHECKED_PREREQ (
    REM Check if Java is available
    java -version >nul 2>&1
    if %errorlevel% neq 0 (
        echo ❌ Error: Java is not installed or not in PATH
        pause
        exit /b 1
    )

    REM Build the project if needed
    if not exist "target\classes" (
        echo 🔨 Building project...
        call mvnw.cmd compile -q
        if %errorlevel% neq 0 (
            echo ❌ Build failed. Please check the error messages above.
            pause
            exit /b 1
        )
        echo ✅ Build complete
        echo.
    )
    set CHECKED_PREREQ=1
)

:menu
echo 📋 Select a Look ^& Feel to demo:
echo.
echo    1^) 🍎 Food Theme      - Colorful, vibrant interface
echo    2^) 🏭 Industrial      - Professional gray theme
echo    3^) �️  System Default  - Your OS native theme
echo    4^) 🎛️  Interactive     - Demo with theme switcher ^(recommended^)
echo    5^) ❓ About CLAF      - Show project information
echo    6^) 🚪 Exit
echo.
set /p choice="Enter your choice (1-6): "

if "%choice%"=="1" (
    call :launch_demo food "Food Theme"
    goto menu
)
if "%choice%"=="2" (
    call :launch_demo industrial "Industrial Theme"  
    goto menu
)
if "%choice%"=="3" (
    call :launch_demo system "System Default Theme"
    goto menu
)
if "%choice%"=="4" (
    call :launch_demo interactive "Interactive Theme Switcher"
    goto menu
)
if "%choice%"=="5" (
    call :show_about
    goto banner
)
if "%choice%"=="6" (
    echo.
    echo 👋 Thanks for trying CLAF!
    echo.
    exit /b 0
)

echo.
echo ❌ Invalid choice. Please enter a number between 1-6.
pause
goto banner

:launch_demo
echo.
echo 🚀 Launching CLAF Demo with %~2...
echo    Close the window to return to menu
echo.
java -cp target\classes com.cfhayes.claf.demo.CLAFDemo %1
goto :eof

:show_about
echo.
echo ℹ️  About CLAF ^(Custom Look and Feel^)
echo ──────────────────────────────────────
echo Version: 2.0.0-SNAPSHOT
echo Java: 17+ ^(modernized from 1.4^)
echo Themes: Food, Industrial
echo Features: Swing components, theme switching, modern Java support
echo.
echo Original concept modernized for contemporary Java applications.
echo Perfect for adding custom themes to your Swing applications!
echo.
pause
goto :eof