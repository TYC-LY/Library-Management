package utils;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author huang(jy)
 * @Date 2019/3/12 14:04
 */
public class FontImage {
	
    /**
     * 根据str,font的样式以及输出文件目录
     * @param str	字符串
     * @param font	字体
     * @param outFile	输出文件位置
     * @param width	宽度
     * @param height	高度
     * @throws Exception
     */
    public static void createImage(String str, Font font, File outFile,
                                   Integer width, Integer height) throws Exception {
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        // 先用黑色填充整张图片,也就是背景
        g.fillRect(0, 0, width, height);
        // 在换成红色
        g.setColor(Color.black);
        // 设置画笔字体
        g.setFont(font);
        /** 用于获得垂直居中y */
        Rectangle clip = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics(font);
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int y = (clip.height - (ascent + descent)) / 2 + ascent;	
        for (int i = 0; i < str.length(); i++) {
            // 画出字符串
            g.drawString(str, i * str.length() * 40, y);
        }
        g.dispose();
        // 输出png图片
        ImageIO.write(image, "png", outFile);
    }
}

