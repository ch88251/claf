package com.cfhayes.claf.industrial;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Properties;

import javax.swing.UIDefaults;

import com.cfhayes.claf.AbstractBorderFactory;
import com.cfhayes.claf.AbstractIconFactory;
import com.cfhayes.claf.AbstractLookAndFeel;
import com.cfhayes.claf.AbstractTheme;
import com.cfhayes.claf.BaseCheckBoxMenuItemUI;
import com.cfhayes.claf.BaseComboBoxUI;
import com.cfhayes.claf.BaseEditorPaneUI;
import com.cfhayes.claf.BaseFileChooserUI;
import com.cfhayes.claf.BaseLabelUI;
import com.cfhayes.claf.BaseMenuBarUI;
import com.cfhayes.claf.BaseMenuItemUI;
import com.cfhayes.claf.BaseMenuUI;
import com.cfhayes.claf.BasePopupMenuUI;
import com.cfhayes.claf.BaseProgressBarUI;
import com.cfhayes.claf.BaseRadioButtonMenuItemUI;
import com.cfhayes.claf.BaseScrollBarUI;
import com.cfhayes.claf.BaseSeparatorUI;
import com.cfhayes.claf.BaseSpinnerUI;
import com.cfhayes.claf.BaseTableHeaderUI;
import com.cfhayes.claf.BaseTableUI;
import com.cfhayes.claf.BaseTextAreaUI;
import com.cfhayes.claf.BaseTextFieldUI;
import com.cfhayes.claf.BaseToggleButtonUI;
import com.cfhayes.claf.BaseToolTipUI;
import com.cfhayes.claf.BaseTreeUI;

public class IndustrialLookAndFeel extends AbstractLookAndFeel {

    private static IndustrialDefaultTheme myTheme = null;

    private static final ArrayList<String> themesList = new ArrayList<>();
    private static final HashMap<String, Properties> themesMap = new HashMap<>();
    private static final Properties defaultProps = new Properties();
    private static final Properties smallFontProps = new Properties();
    private static final Properties largeFontProps = new Properties();
    private static final Properties giantFontProps = new Properties();

    static {
        smallFontProps.setProperty("controlTextFont", "Dialog 10");
        smallFontProps.setProperty("systemTextFont", "Dialog 10");
        smallFontProps.setProperty("userTextFont", "Dialog 10");
        smallFontProps.setProperty("menuTextFont", "Dialog 10");
        smallFontProps.setProperty("windowTitleFont", "Dialog bold 10");
        smallFontProps.setProperty("subTextFont", "Dialog 8");

        largeFontProps.setProperty("controlTextFont", "Dialog 14");
        largeFontProps.setProperty("systemTextFont", "Dialog 14");
        largeFontProps.setProperty("userTextFont", "Dialog 14");
        largeFontProps.setProperty("menuTextFont", "Dialog 14");
        largeFontProps.setProperty("windowTitleFont", "Dialog bold 14");
        largeFontProps.setProperty("subTextFont", "Dialog 12");

        giantFontProps.setProperty("controlTextFont", "Dialog 18");
        giantFontProps.setProperty("systemTextFont", "Dialog 18");
        giantFontProps.setProperty("userTextFont", "Dialog 18");
        giantFontProps.setProperty("menuTextFont", "Dialog 18");
        giantFontProps.setProperty("windowTitleFont", "Dialog 18");
        giantFontProps.setProperty("subTextFont", "Dialog 16");

        themesList.add("Default");
        themesList.add("Small-Font");
        themesList.add("Large-Font");
        themesList.add("Giant-Font");

        themesMap.put("Default", defaultProps);
        themesMap.put("Small-Font", smallFontProps);
        themesMap.put("Large-Font", largeFontProps);
        themesMap.put("Giant-Font", giantFontProps);
    }

    public static java.util.List<String> getThemes() {
        return themesList;
    }

    public static Properties getThemeProperties(String name) {
        return themesMap.get(name);
    }

    public static void setTheme(String name) {
        if (myTheme != null) {
            AbstractTheme.setInternalName(name);
        }
        setTheme(themesMap.get(name));
    }

    public static void setTheme(String name, String licenseKey, String logoString) {
        Properties props = themesMap.get(name);
        props.put("logoString", logoString);
        if (myTheme != null) {
            AbstractTheme.setInternalName(name);
        }
        setTheme(props);
    }

    public static void setTheme(Properties themesProps) {
        if (myTheme == null) {
            myTheme = new IndustrialDefaultTheme();
        }
        if ((myTheme != null) && (themesProps != null)) {
            myTheme.setUpColor();
            myTheme.setProperties(themesProps);
            myTheme.setUpColorArrs();
            AbstractLookAndFeel.setTheme(myTheme);
        }
    }

    public static void setCurrentTheme(Properties themesProps) {
        setTheme(themesProps);
    }

    public String getName() {
        return "Industrial";
    }

    public String getID() {
        return "Industrial";
    }

    public String getDescription() {
        return "The Industrial Look and Feel";
    }

    public boolean isNativeLookAndFeel() {
        return false;
    }

    public boolean isSupportedLookAndFeel() {
        return true;
    }

    public AbstractBorderFactory getBorderFactory() {
        return IndustrialBorderFactory.getInstance();
    }

    public AbstractIconFactory getIconFactory() {
        return IndustrialIconFactory.getInstance();
    }

    protected void createDefaultTheme() {
        if (myTheme == null) {
            myTheme = new IndustrialDefaultTheme();
        }
        setTheme(myTheme);
    }

    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        Object[] uiDefaults = {
            // BaseLookAndFeel classes
            "ToggleButtonUI", BaseToggleButtonUI.class.getName(),
            "LabelUI", BaseLabelUI.class.getName(),
            "SeparatorUI", BaseSeparatorUI.class.getName(),
            "TextFieldUI", BaseTextFieldUI.class.getName(),
            "TextAreaUI", BaseTextAreaUI.class.getName(),
            "EditorPaneUI", BaseEditorPaneUI.class.getName(),
            "ComboBoxUI", BaseComboBoxUI.class.getName(),
            "ToolTipUI", BaseToolTipUI.class.getName(),
            "TreeUI", BaseTreeUI.class.getName(),
            "TableUI", BaseTableUI.class.getName(),
            "TableHeaderUI", BaseTableHeaderUI.class.getName(),
            "ScrollBarUI", BaseScrollBarUI.class.getName(),
            "ProgressBarUI", BaseProgressBarUI.class.getName(),
            "FileChooserUI", BaseFileChooserUI.class.getName(),
            "MenuUI", BaseMenuUI.class.getName(),
            "MenuBarUI", BaseMenuBarUI.class.getName(),
            "PopupMenuUI", BasePopupMenuUI.class.getName(),
            "MenuItemUI", BaseMenuItemUI.class.getName(),
            "CheckBoxMenuItemUI", BaseCheckBoxMenuItemUI.class.getName(),
            "RadioButtonMenuItemUI", BaseRadioButtonMenuItemUI.class.getName(),
            "PopupMenuSeparatorUI", BaseSeparatorUI.class.getName(),
            
            // IndustrialLookAndFeel classes
            "CheckBoxUI", IndustrialCheckBoxUI.class.getName(),
            "RadioButtonUI", IndustrialRadioButtonUI.class.getName(),
            "ButtonUI", IndustrialButtonUI.class.getName(),
            "DesktopPaneUI", IndustrialDesktopPaneUI.class.getName(),};
        table.putDefaults(uiDefaults);
        
        // Spinner is available in all modern Java versions (5+)
        table.put("SpinnerUI", BaseSpinnerUI.class.getName());
    }
    
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);
        table.put("SplitPane.centerOneTouchButtons", Boolean.FALSE);
    }
}