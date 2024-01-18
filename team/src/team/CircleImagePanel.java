import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CircleImagePanel extends JPanel {
    private ImageTextPair imageTextPair;

    public CircleImagePanel(ImageTextPair imageTextPair) {
        this.imageTextPair = imageTextPair;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 이미지 그리기
        ImageIcon imageIcon = new ImageIcon(imageTextPair.getImagePath());
        int imageWidth = imageIcon.getIconWidth();
        int imageHeight = imageIcon.getIconHeight();
        imageIcon.paintIcon(this, g, getWidth() / 2 - imageWidth / 2, getHeight() / 2 - imageHeight / 2);

        // 텍스트 그리기
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(imageTextPair.getText());
        int textHeight = fontMetrics.getHeight();
        g.drawString(imageTextPair.getText(), getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 4);
    }
}
