package com.cfhayes.claf.medical;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class MedicalGradientPaint implements Paint {

    private Dimension size = null;
    private Point offset = null;

    public MedicalGradientPaint(Point offset, Dimension size) {
        this.offset = offset;
        this.size = size;
    }

    public PaintContext createContext(ColorModel cm,
            Rectangle deviceBounds,
            Rectangle2D userBounds,
            AffineTransform xform,
            RenderingHints hints) {
        return new MedicalGradientPaintContext(cm, deviceBounds, offset, size);
    }

    /**
     * Returns the transparency mode for this <code>MedicalGradientPaint</code>.
     * @return an integer value representing this <code>MedicalGradientPaint</code>
     * object's transparency mode.
     * @see Transparency
     */
    public int getTransparency() {
        return OPAQUE;
    }

//---------------------------------------------------------------------------------------------------------------
    private static final class MedicalGradientPaintContext implements PaintContext {
        // Medical-themed pattern with soft blue-green tones

        private static final int PATTERN_WIDTH = 32;
        private static final int PATTERN_HEIGHT = 32;
        private static final int[] PATTERN = createMedicalPattern();
        
        private ColorModel colorModel = null;
        private Rectangle rect = null;
        private Point offset = null;
        private Dimension size = null;
        private int[] gradientSample = null;
        private Hashtable<Integer, Raster> rasterCache = new Hashtable<>();

        // Create a soft medical pattern with subtle variations
        private static int[] createMedicalPattern() {
            int[] pattern = new int[PATTERN_WIDTH * PATTERN_HEIGHT];
            for (int i = 0; i < pattern.length; i++) {
                // Create subtle variations in the mint/blue range (245-250)
                double angle = (i % PATTERN_WIDTH) * Math.PI / 16.0;
                double wave = Math.sin(angle) * 2.0;
                pattern[i] = (int) (247 + wave); // Range: 245-249
            }
            return pattern;
        }

        public MedicalGradientPaintContext(ColorModel cm, Rectangle r, Point o, Dimension s) {
            colorModel = cm;
            rect = r;
            offset = o;
            size = s;
            createSample();
        }

        public void dispose() {
            // rasterCache.clear();
        }

        public ColorModel getColorModel() {
            return colorModel;
        }

        public Raster getRaster(int x, int y, int w, int h) {
            // If gradientSample is not created, return a solid mint green raster
            if (gradientSample == null) {
                WritableRaster raster = colorModel.createCompatibleWritableRaster(w, h);
                // Light mint green RGB(240,248,245)
                int color = (240 << 16) | (248 << 8) | (245);
                for (int j = 0; j < h; j++) {
                    for (int i = 0; i < w; i++) {
                        raster.setDataElements(i, j, colorModel.getDataElements(color, null));
                    }
                }
                return raster;
            } else {
                // Check cache first
                Raster o = rasterCache.get(Integer.valueOf(x));
                if (o != null) {
                    return o;
                } else {
                    WritableRaster raster = colorModel.createCompatibleWritableRaster(w, h);
                    int offs = x - (int) rect.x + offset.x;
                    
                    for (int j = 0; j < h; j++) {
                        for (int i = 0; i < w; i++) {
                            // Calculate pattern coordinates
                            int xi = Math.abs(offset.x + x + i) % PATTERN_WIDTH;
                            int yi = Math.abs(offset.y + y + j) % PATTERN_HEIGHT;
                            int c1 = gradientSample[Math.abs(offs + i) % gradientSample.length];
                            int c2 = PATTERN[(yi * PATTERN_WIDTH) + xi];
                            
                            // Combine for medical-themed color
                            int c = Math.max(0, Math.min(255, c1 - (c2 - 247))); // Adjust based on pattern
                            
                            // Create blue-green tint for medical theme
                            int red = (int) (c * 0.94);   // Slightly reduce red
                            int green = (int) (c * 0.98); // Keep green strong
                            int blue = (int) (c * 0.96);  // Slight blue tint
                            
                            int color = (red << 16) | (green << 8) | blue;
                            raster.setDataElements(i, j, colorModel.getDataElements(color, null));
                        }
                    }
                    rasterCache.put(Integer.valueOf(x), raster);
                    return raster;
                }
            }
        }

        private void createSample() {
            if ((size.width > 8) && (size.width < 4096)) {
                int w = (size.width + 1) / 2;
                gradientSample = new int[w * 2];

                // Create medical gradient from light mint to white with blue-green tint
                float c1 = 235.0f; // Light mint base
                float c2 = 250.0f; // Very light mint top
                float dc = (c2 - c1) / w;
                float c = c1;
                gradientSample[0] = (int) c1;
                for (int i = 1; i < w - 1; i++) {
                    c += dc;
                    gradientSample[i] = (int) c;
                }
                gradientSample[w - 1] = (int) c2;

                // Mirror the gradient
                for (int i = w, j = w - 1; i < size.width; i++, j--) {
                    gradientSample[i] = gradientSample[j];
                }
            }
        }
    } // class MedicalGradientPaintContext
} // class MedicalGradientPaint