import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GeneratePlayStoreAssets {

    public static void main(String[] args) throws Exception {
        File outDir = new File("play_store_assets");
        outDir.mkdirs();

        generateAppIcon(new File(outDir, "app_icon_512.png"));
        generateFeatureGraphic(new File(outDir, "feature_graphic_1024x500.png"));

        System.out.println("Assets successfully generated in " + outDir.getAbsolutePath());
    }

    private static void generateAppIcon(File outputFile) throws Exception {
        int width = 512;
        int height = 512;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();

        // High quality rendering hints
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        // 1. Rich Deep Sacred Background Gradient
        GradientPaint bgPaint = new GradientPaint(
            0, 0, new Color(0x13, 0x0C, 0x24),
            width, height, new Color(0x2B, 0x11, 0x36)
        );
        g.setPaint(bgPaint);
        g.fill(new RoundRectangle2D.Float(0, 0, width, height, 110, 110));

        // 2. Central Radiant Aura Glow
        Point2D center = new Point2D.Float(256, 255);
        float radius = 230;
        float[] distAura = {0.0f, 0.35f, 0.70f, 1.0f};
        Color[] colorsAura = {
            new Color(0xFF, 0x98, 0x00, 110),
            new Color(0xE9, 0x1E, 0x63, 45),
            new Color(0x7B, 0x1F, 0xA2, 20),
            new Color(0x13, 0x0C, 0x24, 0)
        };
        RadialGradientPaint auraPaint = new RadialGradientPaint(center, radius, distAura, colorsAura);
        g.setPaint(auraPaint);
        g.fill(new Ellipse2D.Float(256 - radius, 255 - radius, radius * 2, radius * 2));

        // 3. Sacred Mandala Geometry Rings
        g.setColor(new Color(0xFF, 0xE0, 0x82, 38));
        g.setStroke(new BasicStroke(1.5f));
        g.draw(new Ellipse2D.Float(256 - 195, 255 - 195, 390, 390));

        g.setColor(new Color(0xFF, 0xD5, 0x4F, 50));
        float[] dashPattern = {8, 6};
        g.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashPattern, 0));
        g.draw(new Ellipse2D.Float(256 - 155, 255 - 155, 310, 310));

        g.setColor(new Color(0xFF, 0xE0, 0x82, 35));
        g.setStroke(new BasicStroke(1.2f));
        g.draw(new Ellipse2D.Float(256 - 115, 255 - 115, 230, 230));

        // 4. Glowing Radiant Rays Behind Flame
        g.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(new Color(0xFF, 0xE0, 0x82, 55));
        g.drawLine(256, 120, 256, 75);
        g.drawLine(335, 150, 370, 115);
        g.drawLine(177, 150, 142, 115);
        g.drawLine(370, 225, 410, 215);
        g.drawLine(142, 225, 102, 215);

        // 5. Lotus Petals Foundation Under Diya
        drawLotusPetals(g, 256, 360, 1.0f);

        // 6. Shadow under Diya
        g.setColor(new Color(0x06, 0x02, 0x0C, 160));
        g.fill(new Ellipse2D.Float(256 - 120, 370, 240, 32));

        // 7. Brass Diya Bowl
        GradientPaint bowlPaint = new GradientPaint(
            150, 320, new Color(0xFF, 0xF9, 0xC4),
            360, 390, new Color(0xBF, 0x36, 0x0C)
        );
        g.setPaint(bowlPaint);
        Path2D.Float bowl = new Path2D.Float();
        bowl.moveTo(136, 330);
        bowl.curveTo(155, 400, 357, 400, 376, 330);
        bowl.curveTo(382, 312, 368, 305, 348, 312);
        bowl.curveTo(295, 330, 217, 330, 164, 312);
        bowl.curveTo(144, 305, 130, 312, 136, 330);
        bowl.closePath();
        g.fill(bowl);

        // Diya Golden Rim Highlight
        g.setColor(new Color(0xFF, 0xFF, 0xE0, 220));
        g.setStroke(new BasicStroke(2.5f));
        Path2D.Float rim = new Path2D.Float();
        rim.moveTo(140, 315);
        rim.curveTo(200, 332, 312, 332, 372, 315);
        g.draw(rim);

        // Diya Oil Center Bed
        g.setColor(new Color(0xD8, 0x43, 0x15, 200));
        g.fill(new Ellipse2D.Float(256 - 65, 322, 130, 14));

        // 8. Sacred Flame
        // Outer Flame Glow
        float[] distFlame = {0.0f, 0.45f, 0.85f, 1.0f};
        Color[] colorsFlame = {
            new Color(0xFF, 0xFF, 0xFF, 255),
            new Color(0xFF, 0xD5, 0x4F, 240),
            new Color(0xFF, 0x57, 0x22, 200),
            new Color(0xBF, 0x36, 0x0C, 0)
        };
        RadialGradientPaint flamePaint = new RadialGradientPaint(
            new Point2D.Float(256, 260), 85, distFlame, colorsFlame
        );
        g.setPaint(flamePaint);

        Path2D.Float flame = new Path2D.Float();
        flame.moveTo(256, 125);
        flame.curveTo(285, 180, 318, 230, 304, 275);
        flame.curveTo(290, 312, 222, 312, 208, 275);
        flame.curveTo(194, 230, 227, 180, 256, 125);
        flame.closePath();
        g.fill(flame);

        // Inner Golden Core of Flame
        GradientPaint corePaint = new GradientPaint(
            256, 160, Color.WHITE,
            256, 280, new Color(0xFF, 0xCA, 0x28)
        );
        g.setPaint(corePaint);
        Path2D.Float core = new Path2D.Float();
        core.moveTo(256, 165);
        core.curveTo(274, 202, 292, 238, 284, 268);
        core.curveTo(275, 292, 237, 292, 228, 268);
        core.curveTo(220, 238, 238, 202, 256, 165);
        core.closePath();
        g.fill(core);

        // Brilliant White Spark Center
        g.setColor(Color.WHITE);
        Path2D.Float spark = new Path2D.Float();
        spark.moveTo(256, 205);
        spark.curveTo(266, 228, 274, 248, 269, 265);
        spark.curveTo(265, 276, 247, 276, 243, 265);
        spark.curveTo(238, 248, 246, 228, 256, 205);
        spark.closePath();
        g.fill(spark);

        // Divine Sparks
        g.setColor(new Color(0xFF, 0xF9, 0xC4));
        g.fill(new Ellipse2D.Float(256 - 3, 110, 6, 6));
        g.setColor(new Color(0xFF, 0xE0, 0x82));
        g.fill(new Ellipse2D.Float(282 - 2, 135, 4, 4));
        g.fill(new Ellipse2D.Float(232 - 2, 142, 4, 4));

        g.dispose();
        ImageIO.write(img, "PNG", outputFile);
    }

    private static void drawLotusPetals(Graphics2D g, float cx, float cy, float scale) {
        // Gradient for petals
        GradientPaint petalGrad = new GradientPaint(
            cx - 100 * scale, cy - 50 * scale, new Color(0xFF, 0xE0, 0x82, 210),
            cx + 100 * scale, cy + 30 * scale, new Color(0xFF, 0x70, 0x43, 170)
        );
        g.setPaint(petalGrad);

        // Left Wing Petal
        Path2D.Float p1 = new Path2D.Float();
        p1.moveTo(cx, cy);
        p1.curveTo(cx - 50 * scale, cy - 5 * scale, cx - 110 * scale, cy - 40 * scale, cx - 140 * scale, cy - 80 * scale);
        p1.curveTo(cx - 110 * scale, cy - 90 * scale, cx - 50 * scale, cy - 65 * scale, cx, cy);
        g.fill(p1);

        // Right Wing Petal
        Path2D.Float p2 = new Path2D.Float();
        p2.moveTo(cx, cy);
        p2.curveTo(cx + 50 * scale, cy - 5 * scale, cx + 110 * scale, cy - 40 * scale, cx + 140 * scale, cy - 80 * scale);
        p2.curveTo(cx + 110 * scale, cy - 90 * scale, cx + 50 * scale, cy - 65 * scale, cx, cy);
        g.fill(p2);

        // Outer Left Low Petal
        Path2D.Float p3 = new Path2D.Float();
        p3.moveTo(cx, cy + 5 * scale);
        p3.curveTo(cx - 65 * scale, cy + 10 * scale, cx - 125 * scale, cy - 10 * scale, cx - 165 * scale, cy - 45 * scale);
        p3.curveTo(cx - 130 * scale, cy - 55 * scale, cx - 65 * scale, cy - 35 * scale, cx, cy + 5 * scale);
        g.fill(p3);

        // Outer Right Low Petal
        Path2D.Float p4 = new Path2D.Float();
        p4.moveTo(cx, cy + 5 * scale);
        p4.curveTo(cx + 65 * scale, cy + 10 * scale, cx + 125 * scale, cy - 10 * scale, cx + 165 * scale, cy - 45 * scale);
        p4.curveTo(cx + 130 * scale, cy - 55 * scale, cx + 65 * scale, cy - 35 * scale, cx, cy + 5 * scale);
        g.fill(p4);
    }

    private static void generateFeatureGraphic(File outputFile) throws Exception {
        int width = 1024;
        int height = 500;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // 1. Background Gradient
        GradientPaint bgPaint = new GradientPaint(
            0, 0, new Color(0x0E, 0x08, 0x1E),
            width, height, new Color(0x27, 0x0E, 0x33)
        );
        g.setPaint(bgPaint);
        g.fillRect(0, 0, width, height);

        // 2. Right Side Warm Aura Glow
        Point2D rightCenter = new Point2D.Float(780, 250);
        float rightRadius = 380;
        float[] distAura = {0.0f, 0.40f, 0.75f, 1.0f};
        Color[] colorsAura = {
            new Color(0xFF, 0x98, 0x00, 80),
            new Color(0xE9, 0x1E, 0x63, 35),
            new Color(0x7B, 0x1F, 0xA2, 15),
            new Color(0x0E, 0x08, 0x1E, 0)
        };
        RadialGradientPaint rightAura = new RadialGradientPaint(rightCenter, rightRadius, distAura, colorsAura);
        g.setPaint(rightAura);
        g.fill(new Ellipse2D.Float(780 - rightRadius, 250 - rightRadius, rightRadius * 2, rightRadius * 2));

        // 3. Left Ambient Subtle Purple Glow
        Point2D leftCenter = new Point2D.Float(150, 150);
        RadialGradientPaint leftAura = new RadialGradientPaint(
            leftCenter, 300, new float[]{0.0f, 1.0f},
            new Color[]{new Color(0x67, 0x3A, 0xB7, 40), new Color(0x0E, 0x08, 0x1E, 0)}
        );
        g.setPaint(leftAura);
        g.fill(new Ellipse2D.Float(-150, -150, 600, 600));

        // 4. Mandala Geometry around Right Center
        g.setColor(new Color(0xFF, 0xE0, 0x82, 30));
        g.setStroke(new BasicStroke(1.5f));
        g.draw(new Ellipse2D.Float(780 - 180, 250 - 180, 360, 360));
        float[] dash = {8, 6};
        g.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dash, 0));
        g.draw(new Ellipse2D.Float(780 - 140, 250 - 140, 280, 280));
        g.setStroke(new BasicStroke(1.2f));
        g.draw(new Ellipse2D.Float(780 - 100, 250 - 100, 200, 200));

        // 5. Draw Sacred Diya on the Right (scaled to 0.78)
        drawSacredDiyaSmall(g, 780, 260);

        // 6. LEFT TEXT CONTENT
        // Sanskrit Shloka Watermark
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.setColor(new Color(0xFF, 0xE0, 0x82, 110));
        g.drawString("कर्मण्येवाधिकारस्ते मा फलेषु कदाचन ।", 80, 110);

        // Main App Title
        g.setFont(new Font("SansSerif", Font.BOLD, 62));
        GradientPaint titlePaint = new GradientPaint(
            80, 140, new Color(0xFF, 0xF9, 0xC4),
            500, 200, new Color(0xFF, 0xB3, 0x00)
        );
        g.setPaint(titlePaint);
        g.drawString("Gita Wisdom", 80, 195);

        // Subtitle / Tagline
        g.setFont(new Font("SansSerif", Font.PLAIN, 24));
        g.setColor(new Color(0xFA, 0xFA, 0xFA, 230));
        g.drawString("Spiritual Companion & Daily Reflections", 82, 242);

        // Mission line
        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.setColor(new Color(0xD1, 0xC4, 0xE9, 200));
        g.drawString("Overcome modern life dilemmas with timeless Bhagavad Gita guidance", 82, 280);

        // 7. BADGES ROW
        drawBadge(g, 80, 335, 195, 38, "🌐 12 Indian Languages", new Color(0xFF, 0xB3, 0x00));
        drawBadge(g, 290, 335, 215, 38, "📿 Daily Streaks & Journal", new Color(0xBA, 0x68, 0xC8));
        drawBadge(g, 520, 335, 145, 38, "💾 Offline-First", new Color(0x26, 0xA6, 0x9A));

        // 8. Footer Credo
        g.setFont(new Font("SansSerif", Font.PLAIN, 13));
        g.setColor(new Color(0xB3, 0x9D, 0xDB, 150));
        g.drawString("Authentic Shlokas • Sanskrit Audio Recitation • No Paywalls • 100% Private", 82, 435);

        g.dispose();
        ImageIO.write(img, "PNG", outputFile);
    }

    private static void drawBadge(Graphics2D g, int x, int y, int w, int h, String text, Color accent) {
        g.setColor(new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), 38));
        g.fillRoundRect(x, y, w, h, h, h);

        g.setColor(new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), 160));
        g.setStroke(new BasicStroke(1.2f));
        g.drawRoundRect(x, y, w, h, h, h);

        g.setFont(new Font("SansSerif", Font.BOLD, 13));
        g.setColor(new Color(0xFF, 0xF9, 0xC4));
        FontMetrics fm = g.getFontMetrics();
        int textX = x + (w - fm.stringWidth(text)) / 2;
        int textY = y + (h - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(text, textX, textY);
    }

    private static void drawSacredDiyaSmall(Graphics2D g, float cx, float cy) {
        // Lotus petals
        drawLotusPetals(g, cx, cy + 50, 0.7f);

        // Diya Brass Bowl
        GradientPaint bowlPaint = new GradientPaint(
            cx - 80, cy, new Color(0xFF, 0xF9, 0xC4),
            cx + 80, cy + 50, new Color(0xBF, 0x36, 0x0C)
        );
        g.setPaint(bowlPaint);
        Path2D.Float bowl = new Path2D.Float();
        bowl.moveTo(cx - 80, cy + 15);
        bowl.curveTo(cx - 60, cy + 65, cx + 60, cy + 65, cx + 80, cy + 15);
        bowl.curveTo(cx + 85, cy + 2, cx + 70, cy - 2, cx + 55, cy + 3);
        bowl.curveTo(cx + 20, cy + 15, cx - 20, cy + 15, cx - 55, cy + 3);
        bowl.curveTo(cx - 70, cy - 2, cx - 85, cy + 2, cx - 80, cy + 15);
        bowl.closePath();
        g.fill(bowl);

        // Flame
        float[] distFlame = {0.0f, 0.5f, 1.0f};
        Color[] colorsFlame = {
            new Color(0xFF, 0xFF, 0xFF, 255),
            new Color(0xFF, 0xB3, 0x00, 230),
            new Color(0xBF, 0x36, 0x0C, 0)
        };
        RadialGradientPaint flamePaint = new RadialGradientPaint(
            new Point2D.Float(cx, cy - 40), 65, distFlame, colorsFlame
        );
        g.setPaint(flamePaint);

        Path2D.Float flame = new Path2D.Float();
        flame.moveTo(cx, cy - 100);
        flame.curveTo(cx + 22, cy - 65, cx + 45, cy - 25, cx + 35, cy + 5);
        flame.curveTo(cx + 25, cy + 22, cx - 25, cy + 22, cx - 35, cy + 5);
        flame.curveTo(cx - 45, cy - 25, cx - 22, cy - 65, cx, cy - 100);
        flame.closePath();
        g.fill(flame);

        // Core flame
        g.setColor(Color.WHITE);
        Path2D.Float spark = new Path2D.Float();
        spark.moveTo(cx, cy - 45);
        spark.curveTo(cx + 8, cy - 25, cx + 14, cy - 10, cx + 10, cy + 2);
        spark.curveTo(cx + 6, cy + 8, cx - 6, cy + 8, cx - 10, cy + 2);
        spark.curveTo(cx - 14, cy - 10, cx - 8, cy - 25, cx, cy - 45);
        spark.closePath();
        g.fill(spark);
    }
}
