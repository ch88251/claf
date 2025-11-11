package com.cfhayes.claf.medical;

import java.awt.Color;

import javax.swing.plaf.ColorUIResource;

import com.cfhayes.claf.AbstractTheme;
import com.cfhayes.claf.ColorHelper;

public class MedicalDefaultTheme extends AbstractTheme {

    public MedicalDefaultTheme() {
        super();
        // Setup theme with defaults
        setUpColor();
        // Overwrite defaults with user props
        loadProperties();
        // Setup the color arrays
        setUpColorArrs();
    }

    public String getPropertyFileName() {
        return "MedicalTheme.properties";
    }

    public void setUpColor() {
        super.setUpColor();
        // Defaults for MedicalLookAndFeel - warm blues and greens
        backgroundColor = new ColorUIResource(235, 245, 240);  // Light mint green background
        backgroundColorLight = new ColorUIResource(245, 250, 248);  // Very light mint
        backgroundColorDark = new ColorUIResource(220, 235, 230);  // Slightly darker mint
        alterBackgroundColor = new ColorUIResource(230, 240, 235);  // Alternate mint

        frameColor = new ColorUIResource(100, 140, 120);  // Medium green-blue frame
        backgroundPattern = true;
        selectionForegroundColor = white;
        selectionBackgroundColor = new ColorUIResource(70, 130, 180);  // Steel blue selection

        focusColor = new ColorUIResource(30, 144, 255);  // Dodger blue focus
        focusCellColor = focusColor;

        rolloverColor = new ColorUIResource(60, 179, 113);  // Medium sea green rollover
        rolloverColorLight = new ColorUIResource(200, 230, 215);  // Light sea green
        rolloverColorDark = new ColorUIResource(120, 200, 150);  // Medium sea green

        buttonBackgroundColor = new ColorUIResource(240, 248, 245);  // Light mint button background
        buttonColorLight = new ColorUIResource(250, 255, 252);  // Very light mint
        buttonColorDark = new ColorUIResource(225, 240, 235);  // Darker mint

        controlBackgroundColor = new ColorUIResource(240, 248, 245);  // Light mint controls
        controlColorLight = new ColorUIResource(248, 252, 250);  // Very light mint
        controlColorDark = new ColorUIResource(220, 235, 230);  // Darker mint
        controlHighlightColor = new ColorUIResource(245, 250, 248);  // Highlight mint
        controlShadowColor = new ColorUIResource(180, 200, 190);  // Shadow green-grey

        windowTitleForegroundColor = new ColorUIResource(25, 25, 112);  // Midnight blue text
        windowTitleBackgroundColor = new ColorUIResource(176, 224, 230);  // Powder blue title
        windowTitleColorLight = new ColorUIResource(200, 230, 235);  // Light blue title
        windowTitleColorDark = new ColorUIResource(135, 206, 235);  // Sky blue title
        windowBorderColor = new ColorUIResource(70, 130, 180);  // Steel blue border
        windowIconColor = new ColorUIResource(25, 25, 112);  // Midnight blue icons
        windowIconShadowColor = new ColorUIResource(200, 230, 235);  // Light blue shadow
        windowIconRolloverColor = new ColorUIResource(220, 20, 60);  // Crimson rollover

        windowInactiveTitleForegroundColor = new ColorUIResource(105, 105, 105);  // Dim grey
        windowInactiveTitleBackgroundColor = new ColorUIResource(230, 240, 235);  // Inactive mint
        windowInactiveTitleColorLight = new ColorUIResource(240, 245, 243);  // Light inactive
        windowInactiveTitleColorDark = new ColorUIResource(220, 235, 230);  // Dark inactive
        windowInactiveBorderColor = new ColorUIResource(150, 170, 160);  // Inactive border

        menuBackgroundColor = new ColorUIResource(240, 248, 245);  // Light mint menu
        menuSelectionForegroundColor = white;
        menuSelectionBackgroundColor = new ColorUIResource(72, 209, 204);  // Medium turquoise
        
        menuColorLight = new ColorUIResource(248, 252, 250);  // Very light mint
        menuColorDark = new ColorUIResource(220, 235, 230);  // Darker mint

        toolbarBackgroundColor = new ColorUIResource(235, 245, 240);  // Mint toolbar
        toolbarColorLight = new ColorUIResource(245, 250, 248);  // Light mint
        toolbarColorDark = new ColorUIResource(220, 235, 230);  // Dark mint

        tabAreaBackgroundColor = backgroundColor;
        desktopColor = backgroundColor;
    }

    public void setUpColorArrs() {
        super.setUpColorArrs();
        DEFAULT_COLORS = ColorHelper.createColorArr(controlColorLight, controlColorDark, 20);
        HIDEFAULT_COLORS = new Color[DEFAULT_COLORS.length];
        for (int i = 0; i < DEFAULT_COLORS.length; i++) {
            HIDEFAULT_COLORS[i] = ColorHelper.brighter(DEFAULT_COLORS[i], 20);
        }

        ACTIVE_COLORS = DEFAULT_COLORS;
        INACTIVE_COLORS = ColorHelper.createColorArr(new Color(230, 240, 235), new Color(220, 235, 230), 20);

        PRESSED_COLORS = ColorHelper.createColorArr(ColorHelper.darker(selectionBackgroundColor, 5), ColorHelper.brighter(selectionBackgroundColor, 20), 20);
        DISABLED_COLORS = ColorHelper.createColorArr(Color.white, new Color(200, 220, 210), 20);
        BUTTON_COLORS = new Color[]{
                    new Color(250, 255, 252),  // Very light mint
                    new Color(248, 252, 250),
                    new Color(246, 250, 248),
                    new Color(244, 248, 246),
                    new Color(242, 246, 244),
                    new Color(240, 244, 242),
                    new Color(238, 242, 240),
                    new Color(236, 240, 238),
                    new Color(234, 238, 236),
                    new Color(232, 236, 234),
                    new Color(234, 238, 236),
                    new Color(236, 240, 238),
                    new Color(238, 242, 240),
                    new Color(240, 244, 242),
                    new Color(242, 246, 244),
                    new Color(244, 248, 246),
                    new Color(246, 250, 248),
                    new Color(248, 252, 250),};
        ROLLOVER_COLORS = ColorHelper.createColorArr(rolloverColorLight, rolloverColorDark, 20);
        WINDOW_TITLE_COLORS = ColorHelper.createColorArr(windowTitleColorLight, windowTitleColorDark, 20);
        WINDOW_INACTIVE_TITLE_COLORS = ColorHelper.createColorArr(windowInactiveTitleColorLight, windowInactiveTitleColorDark, 20);
        MENUBAR_COLORS = ColorHelper.createColorArr(menuColorLight, menuColorDark, 20);
        TOOLBAR_COLORS = ColorHelper.createColorArr(toolbarColorLight, toolbarColorDark, 20);
        TAB_COLORS = DEFAULT_COLORS;
        COL_HEADER_COLORS = BUTTON_COLORS;

        SELECTED_COLORS = ColorHelper.createColorArr(ColorHelper.brighter(selectionBackgroundColor, 40), selectionBackgroundColor, 20);

        TRACK_COLORS = ColorHelper.createColorArr(new Color(230, 240, 235), new Color(240, 248, 245), 20);
        THUMB_COLORS = ColorHelper.createColorArr(new Color(100, 149, 237), new Color(70, 130, 180), 20);  // Cornflower to steel blue
        SLIDER_COLORS = ColorHelper.createColorArr(new Color(135, 206, 235), new Color(100, 149, 237), 10);  // Sky to cornflower blue
        PROGRESSBAR_COLORS = SLIDER_COLORS;
    }
}