package com.cfhayes.claf.financial;

import java.awt.Color;

import javax.swing.plaf.ColorUIResource;

import com.cfhayes.claf.AbstractTheme;
import com.cfhayes.claf.ColorHelper;

public class FinancialDefaultTheme extends AbstractTheme {

    public FinancialDefaultTheme() {
        super();
        // Setup theme with defaults
        setUpColor();
        // Overwrite defaults with user props
        loadProperties();
        // Setup the color arrays
        setUpColorArrs();
    }

    public String getPropertyFileName() {
        return "FinancialTheme.properties";
    }

    public void setUpColor() {
        super.setUpColor();
        // Financial theme colors - professional blues, money greens, and gold accents
        backgroundColor = new ColorUIResource(240, 245, 250);  // Very light blue-gray
        backgroundColorLight = new ColorUIResource(248, 252, 255);  // Almost white blue
        backgroundColorDark = new ColorUIResource(225, 235, 245);  // Light blue-gray
        alterBackgroundColor = new ColorUIResource(235, 240, 248);  // Alternate light blue

        frameColor = new ColorUIResource(72, 88, 120);  // Dark blue-gray frame
        backgroundPattern = true;
        selectionForegroundColor = white;
        selectionBackgroundColor = new ColorUIResource(25, 78, 132);  // Deep corporate blue

        focusColor = new ColorUIResource(255, 193, 7);  // Gold focus color
        focusCellColor = focusColor;

        rolloverColor = new ColorUIResource(34, 139, 34);  // Forest green for money/success
        rolloverColorLight = new ColorUIResource(220, 245, 220);  // Light green
        rolloverColorDark = new ColorUIResource(144, 238, 144);  // Light green

        buttonBackgroundColor = new ColorUIResource(245, 248, 252);  // Light blue button
        buttonColorLight = new ColorUIResource(252, 254, 255);  // Very light blue
        buttonColorDark = new ColorUIResource(235, 242, 250);  // Medium blue

        controlBackgroundColor = new ColorUIResource(245, 248, 252);  // Light blue controls
        controlColorLight = new ColorUIResource(250, 252, 255);  // Very light blue
        controlColorDark = new ColorUIResource(225, 235, 248);  // Medium blue
        controlHighlightColor = new ColorUIResource(248, 250, 253);  // Highlight blue
        controlShadowColor = new ColorUIResource(180, 190, 205);  // Shadow blue-gray

        windowTitleForegroundColor = new ColorUIResource(25, 25, 112);  // Midnight blue text
        windowTitleBackgroundColor = new ColorUIResource(70, 130, 180);  // Steel blue title
        windowTitleColorLight = new ColorUIResource(100, 149, 237);  // Cornflower blue
        windowTitleColorDark = new ColorUIResource(25, 78, 132);  // Deep blue
        windowBorderColor = new ColorUIResource(72, 88, 120);  // Dark blue-gray border
        windowIconColor = new ColorUIResource(255, 193, 7);  // Gold icons
        windowIconShadowColor = new ColorUIResource(100, 149, 237);  // Light blue shadow
        windowIconRolloverColor = new ColorUIResource(255, 140, 0);  // Dark orange rollover

        windowInactiveTitleForegroundColor = new ColorUIResource(105, 105, 105);  // Gray
        windowInactiveTitleBackgroundColor = new ColorUIResource(235, 240, 248);  // Inactive blue
        windowInactiveTitleColorLight = new ColorUIResource(245, 248, 252);  // Light inactive
        windowInactiveTitleColorDark = new ColorUIResource(225, 235, 245);  // Dark inactive
        windowInactiveBorderColor = new ColorUIResource(150, 160, 175);  // Inactive border

        menuBackgroundColor = new ColorUIResource(245, 248, 252);  // Light blue menu
        menuSelectionForegroundColor = white;
        menuSelectionBackgroundColor = new ColorUIResource(25, 78, 132);  // Deep blue selection
        
        menuColorLight = new ColorUIResource(250, 252, 255);  // Very light blue
        menuColorDark = new ColorUIResource(225, 235, 248);  // Medium blue

        toolbarBackgroundColor = new ColorUIResource(240, 245, 250);  // Blue toolbar
        toolbarColorLight = new ColorUIResource(248, 252, 255);  // Light blue
        toolbarColorDark = new ColorUIResource(225, 235, 245);  // Dark blue

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
        INACTIVE_COLORS = ColorHelper.createColorArr(new Color(235, 240, 248), new Color(225, 235, 245), 20);

        PRESSED_COLORS = ColorHelper.createColorArr(ColorHelper.darker(selectionBackgroundColor, 5), ColorHelper.brighter(selectionBackgroundColor, 20), 20);
        DISABLED_COLORS = ColorHelper.createColorArr(Color.white, new Color(200, 210, 225), 20);
        BUTTON_COLORS = new Color[]{
                    new Color(252, 254, 255),  // Very light blue
                    new Color(250, 252, 254),
                    new Color(248, 250, 253),
                    new Color(246, 249, 252),
                    new Color(244, 247, 251),
                    new Color(242, 245, 250),
                    new Color(240, 244, 249),
                    new Color(238, 242, 248),
                    new Color(236, 240, 247),
                    new Color(234, 239, 246),
                    new Color(236, 240, 247),
                    new Color(238, 242, 248),
                    new Color(240, 244, 249),
                    new Color(242, 245, 250),
                    new Color(244, 247, 251),
                    new Color(246, 249, 252),
                    new Color(248, 250, 253),
                    new Color(250, 252, 254),};
        ROLLOVER_COLORS = ColorHelper.createColorArr(rolloverColorLight, rolloverColorDark, 20);
        WINDOW_TITLE_COLORS = ColorHelper.createColorArr(windowTitleColorLight, windowTitleColorDark, 20);
        WINDOW_INACTIVE_TITLE_COLORS = ColorHelper.createColorArr(windowInactiveTitleColorLight, windowInactiveTitleColorDark, 20);
        MENUBAR_COLORS = ColorHelper.createColorArr(menuColorLight, menuColorDark, 20);
        TOOLBAR_COLORS = ColorHelper.createColorArr(toolbarColorLight, toolbarColorDark, 20);
        TAB_COLORS = DEFAULT_COLORS;
        COL_HEADER_COLORS = BUTTON_COLORS;

        SELECTED_COLORS = ColorHelper.createColorArr(ColorHelper.brighter(selectionBackgroundColor, 40), selectionBackgroundColor, 20);

        TRACK_COLORS = ColorHelper.createColorArr(new Color(235, 240, 248), new Color(245, 248, 252), 20);
        THUMB_COLORS = ColorHelper.createColorArr(new Color(25, 78, 132), new Color(70, 130, 180), 20);  // Deep to steel blue
        SLIDER_COLORS = ColorHelper.createColorArr(new Color(100, 149, 237), new Color(70, 130, 180), 10);  // Cornflower to steel blue
        PROGRESSBAR_COLORS = ColorHelper.createColorArr(new Color(34, 139, 34), new Color(0, 128, 0), 10);  // Green for financial progress (money)
    }
}