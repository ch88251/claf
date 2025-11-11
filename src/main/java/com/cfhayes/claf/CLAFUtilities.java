package com.cfhayes.claf;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.lang.reflect.Method;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicGraphicsUtils;

public class CLAFUtilities {

    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().indexOf("windows") != -1;
    private static final boolean isOS2 = System.getProperty("os.name").toLowerCase().indexOf("os/2") != -1;
    private static final boolean isMac = System.getProperty("os.name").toLowerCase().indexOf("mac") != -1;
    private static final boolean isLinux = System.getProperty("os.name").toLowerCase().indexOf("linux") != -1;
    private static final boolean isSunOS = System.getProperty("os.name").toLowerCase().indexOf("sunos") != -1;
    private static final boolean isAIX = System.getProperty("os.name").toLowerCase().indexOf("aix") != -1;
    private static final boolean isHPUX = System.getProperty("os.name").toLowerCase().indexOf("hpux") != -1;
    private static final boolean isFreeBSD = System.getProperty("os.name").toLowerCase().indexOf("freebsd") != -1;
    private static final boolean isHiresScreen = Toolkit.getDefaultToolkit().getScreenSize().width > 1280;
    private static Integer javaMajorVersion = null;
    private static final String ELLIPSIS = "...";

    /**
     * Gets the Java major version (e.g., 8, 11, 17, 21).
     * @return The Java major version
     */
    public static int getJavaMajorVersion() {
        if (javaMajorVersion == null) {
            try {
                String version = System.getProperty("java.version");
                if (version.startsWith("1.")) {
                    // Java 8 and earlier (1.8.0_xx format)
                    javaMajorVersion = Integer.parseInt(version.substring(2, 3));
                } else {
                    // Java 9+ (9.x.x, 11.x.x, 17.x.x format)
                    int dotIndex = version.indexOf('.');
                    if (dotIndex > 0) {
                        javaMajorVersion = Integer.parseInt(version.substring(0, dotIndex));
                    } else {
                        javaMajorVersion = Integer.parseInt(version);
                    }
                }
            } catch (Exception ex) {
                javaMajorVersion = 17; // Default to Java 17 for modern usage
            }
        }
        return javaMajorVersion;
    }

    /**
     * @deprecated Use getJavaMajorVersion() instead. This method remains for backward compatibility.
     * @return The Java version as a double (legacy format)
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public static double getJavaVersion() {
        int majorVersion = getJavaMajorVersion();
        if (majorVersion <= 8) {
            return 1.0 + (majorVersion / 10.0); // Convert 8 to 1.8, etc.
        }
        return majorVersion; // For Java 9+, return the major version directly
    }

    public static boolean isWindows() {
        return isWindows;
    }

    public static boolean isOS2() {
        return isOS2;
    }

    public static boolean isMac() {
        return isMac;
    }

    public static boolean isLinux() {
        return isLinux;
    }

    public static boolean isSunOS() {
        return isSunOS;
    }

    public static boolean isAIX() {
        return isAIX;
    }

    public static boolean isHPUX() {
        return isHPUX;
    }

    public static boolean isFreeBSD() {
        return isFreeBSD;
    }

    public static boolean isHiresScreen() {
        return isHiresScreen;
    }

    public static boolean isLeftToRight(Component c) {
        return c.getComponentOrientation().isLeftToRight();
    }

    public static boolean isActive(JComponent c) {
        if (c == null) {
            return false;
        }

        boolean active = true;
        if (c instanceof JInternalFrame) {
            active = ((JInternalFrame) c).isSelected();
        }
        if (active) {
            Container parent = c.getParent();
            while (parent != null) {
                if (parent instanceof JInternalFrame) {
                    active = ((JInternalFrame) parent).isSelected();
                    break;
                }
                parent = parent.getParent();
            }
        }
        if (active) {
            active = isFrameActive(c);
        }
        return active;
    }

    public static boolean isFrameActive(JComponent c) {
        if (c == null) {
            return false;
        }

        if (c.getTopLevelAncestor() instanceof Window) {
            return isWindowActive((Window) c.getTopLevelAncestor());
        }

        return true;
    }

    public static boolean isWindowActive(Window window) {
        // Java 4+ feature - all modern Java versions support this
        try {
            Method m = window.getClass().getMethod("isActive");
            Boolean b = (Boolean) m.invoke(window);
            return b;
        } catch (Exception ex) {
            // Fallback for any reflection issues
            return true;
        }
    }

    public static Container getRootContainer(Component c) {
        if (c != null) {
            Container parent = c.getParent();
            while ((parent != null) && !(parent instanceof JPopupMenu) && !(parent instanceof JInternalFrame) && !(parent instanceof Window) && (parent.getParent() != null)) {
                parent = parent.getParent();
            }
            return parent;
        }
        return null;
    }

    public static Dimension getFrameSize(Component c) {
        Container parent = getRootContainer(c);
        if (parent != null) {
            return parent.getSize();
        }
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static Point getRelLocation(Component c) {
        if (c == null || !c.isShowing()) {
            return new Point(0, 0);
        }

        Container parent = getRootContainer(c);
        if ((parent != null) && parent.isShowing()) {
            Point p1 = c.getLocationOnScreen();
            Point p2 = parent.getLocationOnScreen();
            return new Point(p1.x - p2.x, p1.y - p2.y);
        }

        return new Point(0, 0);
    }

    public static String getClippedText(String text, FontMetrics fm, int maxWidth) {
        if ((text == null) || (text.length() == 0)) {
            return "";
        }
        int width = SwingUtilities.computeStringWidth(fm, text);
        if (width > maxWidth) {
            int totalWidth = SwingUtilities.computeStringWidth(fm, ELLIPSIS);
            for (int i = 0; i < text.length(); i++) {
                totalWidth += fm.charWidth(text.charAt(i));
                if (totalWidth > maxWidth) {
                    return text.substring(0, i) + ELLIPSIS;
                }
            }
        }
        return text;
    }

    public static int findDisplayedMnemonicIndex(String text, int mnemonic) {
        if (text == null || mnemonic == '\0') {
            return -1;
        }

        char uc = Character.toUpperCase((char)mnemonic);
        char lc = Character.toLowerCase((char)mnemonic);

        int uci = text.indexOf(uc);
        int lci = text.indexOf(lc);

        if (uci == -1) {
            return lci;
        } else if(lci == -1) {
            return uci;
        } else {
            return (lci < uci) ? lci : uci;
        }
    }

    public static void drawString(JComponent c, Graphics g, String text, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        Object savedRenderingHint = null;
        if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
            savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
            g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, AbstractLookAndFeel.getTheme().getTextAntiAliasingHint());
        }
        
        // All modern Java versions support SwingUtilities2
        try {
            Class<?> swingUtilities2Class = Class.forName("sun.swing.SwingUtilities2");
            Class<?>[] classParams = {JComponent.class, Graphics.class, String.class, Integer.TYPE, Integer.TYPE};
            Method m = swingUtilities2Class.getMethod("drawString", classParams);
            Object[] methodParams = {c, g, text, x, y};
            m.invoke(null, methodParams);
        } catch (Exception ex) {
            // Fallback to standard Graphics.drawString
            g.drawString(text, x, y);
        }
        
        if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
            g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, savedRenderingHint);
        }
    }

    public static void drawStringUnderlineCharAt(JComponent c, Graphics g, String text, int underlinedIndex, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        Object savedRenderingHint = null;
        if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
            savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
            g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, AbstractLookAndFeel.getTheme().getTextAntiAliasingHint());
        }
        
        // Try SwingUtilities2 first (available since Java 1.6)
        try {
            Class<?> swingUtilities2Class = Class.forName("sun.swing.SwingUtilities2");
            Class<?>[] classParams = {JComponent.class, Graphics.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
            Method m = swingUtilities2Class.getMethod("drawStringUnderlineCharAt", classParams);
            Object[] methodParams = {c, g, text, underlinedIndex, x, y};
            m.invoke(null, methodParams);
        } catch (Exception ex) {
            // Fallback to BasicGraphicsUtils (available since Java 1.4)
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, underlinedIndex, x, y);
        }
        
        if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
            g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, savedRenderingHint);
        }
    }

    public static void fillHorGradient(Graphics g, Color[] colors, int x, int y, int w, int h) {
        int steps = colors.length;
        double dy = (double) h / (double) (steps);
        if (dy <= 3.001) {
            int y1 = y;
            for (int i = 0; i < steps; i++) {
                int y2 = y + (int) Math.round((double) i * dy);
                g.setColor(colors[i]);
                if (i == (steps - 1)) {
                    g.fillRect(x, y1, w, y + h - y1);
                } else {
                    g.fillRect(x, y1, w, y2 - y1);
                }
                y1 = y2;
            }
        } else {
            smoothFillHorGradient(g, colors, x, y, w, h);
        }
    }

    public static void smoothFillHorGradient(Graphics g, Color[] colors, int x, int y, int w, int h) {
        Graphics2D g2D = (Graphics2D) g;
        int steps = colors.length;
        double dy = (double) h / (double) (steps - 1);
        int y1 = y;
        for (int i = 0; i < steps; i++) {
            int y2 = y + (int) Math.round((double) i * dy);
            if (i == (steps - 1)) {
                g2D.setPaint(null);
                g2D.setColor(colors[i]);
                g.fillRect(x, y1, w, y + h - y1);
            } else {
                g2D.setPaint(new GradientPaint(0, y1, colors[i], 0, y2, colors[i + 1]));
                g.fillRect(x, y1, w, y2 - y1);
            }
            y1 = y2;
        }
    }

    public static void fillInverseHorGradient(Graphics g, Color[] colors, int x, int y, int w, int h) {
        int steps = colors.length;
        double dy = (double) h / (double) steps;
        if (dy <= 3.001) {
            int y1 = y;
            for (int i = 0; i < steps; i++) {
                int y2 = y + (int) Math.round((double) i * dy);
                g.setColor(colors[colors.length - i - 1]);
                if (i == (steps - 1)) {
                    g.fillRect(x, y1, w, y + h - y1);
                } else {
                    g.fillRect(x, y1, w, y2 - y1);
                }
                y1 = y2;
            }
        } else {
            smoothFillInverseHorGradient(g, colors, x, y, w, h);
        }

    }

    public static void smoothFillInverseHorGradient(Graphics g, Color[] colors, int x, int y, int w, int h) {
        Graphics2D g2D = (Graphics2D) g;
        int steps = colors.length;
        double dy = (double) h / (double) steps;
        int y1 = y;
        for (int i = 0; i < steps; i++) {
            int y2 = y + (int) Math.round((double) i * dy);
            g.setColor(colors[colors.length - i - 1]);
            if (i == (steps - 1)) {
                g2D.setPaint(null);
                g2D.setColor(colors[colors.length - i - 1]);
                g.fillRect(x, y1, w, y + h - y1);
            } else {
                g2D.setPaint(new GradientPaint(0, y1, colors[colors.length - i - 1], 0, y2, colors[colors.length - i - 2]));
                g.fillRect(x, y1, w, y2 - y1);
            }
            y1 = y2;
        }
    }

    public static void fillVerGradient(Graphics g, Color[] colors, int x, int y, int w, int h) {
        int steps = colors.length;
        double dx = (double) w / (double) steps;
        int x1 = x;
        for (int i = 0; i < steps; i++) {
            int x2 = x + (int) Math.round((double) i * dx);
            g.setColor(colors[i]);
            if (i == (steps - 1)) {
                g.fillRect(x1, y, x + w - x1, h);
            } else {
                g.fillRect(x1, y, x2 - x1, h);
            }
            x1 = x2;
        }
    }

    public static void fillInverseVerGradient(Graphics g, Color[] colors, int x, int y, int w, int h) {
        int steps = colors.length;
        double dx = (double) w / (double) steps;
        int x1 = x;
        for (int i = 0; i < steps; i++) {
            int x2 = x + (int) Math.round((double) i * dx);
            g.setColor(colors[colors.length - i - 1]);
            if (i == (steps - 1)) {
                g.fillRect(x1, y, x + w - x1, h);
            } else {
                g.fillRect(x1, y, x2 - x1, h);
            }
            x1 = x2;
        }
    }
    //-------------------------------------------------------------------------------------------

    public static void drawBorder(Graphics g, Color c, int x, int y, int w, int h) {
        g.setColor(c);
        g.drawRect(x, y, w - 1, h - 1);
    }

    public static void draw3DBorder(Graphics g, Color c1, Color c2, int x, int y, int w, int h) {
        int x2 = x + w - 1;
        int y2 = y + h - 1;
        g.setColor(c1);
        g.drawLine(x, y, x2 - 1, y);
        g.drawLine(x, y + 1, x, y2);
        g.setColor(c2);
        g.drawLine(x + 1, y2, x2 - 1, y2);
        g.drawLine(x2, y, x2, y2);
    }

    public static void drawRoundBorder(Graphics g, Color c, int x, int y, int w, int h, int r) {
        Graphics2D g2D = (Graphics2D) g;
        Object savedRederingHint = g2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setColor(c);
        g2D.drawRoundRect(x, y, w - 1, h - 1, r, r);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, savedRederingHint);
    }

    public static void drawRound3DBorder(Graphics g, Color c1, Color c2, int x, int y, int w, int h) {
        Graphics2D g2D = (Graphics2D) g;
        int x2 = x + w;
        int y2 = y + h;
        int d = h;
        int r = h / 2;
        Color cm = ColorHelper.median(c1, c2);
        Color c1m = ColorHelper.median(c1, cm);
        Color c2m = ColorHelper.median(c2, cm);

        Object savedRederingHint = g2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // oben
        g2D.setColor(c1);
        g2D.drawLine(x + r, y, x2 - r, y);
        // rechts
        g2D.drawLine(x, y + r, x, y2 - r);
        // unten
        g2D.setColor(c2);
        g2D.drawLine(x + r, y2, x2 - r, y2);
        // links
        g2D.drawLine(x2, y + r, x2, y2 - r);

        // links
        g2D.setColor(c1);
        g2D.drawArc(x, y, d, d, 90, 45);
        g2D.setColor(c1m);
        g2D.drawArc(x, y, d, d, 135, 45);
        g2D.setColor(cm);
        g2D.drawArc(x, y, d, d, 180, 45);
        g2D.setColor(c2m);
        g2D.drawArc(x, y, d, d, 225, 45);
        // rechts
        g2D.setColor(c1m);
        g2D.drawArc(x2 - d, y, d, d, 45, 45);
        g2D.setColor(cm);
        g2D.drawArc(x2 - d, y, d, d, 0, 45);
        g2D.setColor(c2m);
        g2D.drawArc(x2 - d, y, d, d, -45, 45);
        g2D.setColor(c2);
        g2D.drawArc(x2 - d, y, d, d, -90, 45);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, savedRederingHint);
    }
}
