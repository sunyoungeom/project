import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SpringLayout;

public class LottoProgram extends JFrame {
    private BeforeFrame beforeFrame = new BeforeFrame(this);
    private HelpFrame helpFrame = new HelpFrame(this);
    public ArrayList<ArrayList<String>> resultBuy = new ArrayList<>(5);
//    public ArrayList<ArrayList<String>> resultBuyTitles = new ArrayList<>();
    public ArrayList<String> resultBuyTitle = new ArrayList<>(5);

//    public ArrayList<ArrayList<String>> getResultBuy() {
//        return resultBuy;
//    }
//
//    public void setResultBuy(ArrayList<ArrayList<String>> resultBuy) {
//        this.resultBuy = resultBuy;
//    }

    public LottoProgram() {
        for (int i = 0; i < 5; i++) {
            resultBuy.add(new ArrayList<>());
        }
        
        for (int i = 0; i < 5; i++) {
            resultBuyTitle.add("");
        }

        setTitle("메인 창");
        JPanel main = new JPanel();

        JButton btnBuy = new JButton("구매하기");
        JButton btnResult = new JButton("결과확인");
        JButton btnBefore = new JButton("이전회차");
        JButton btnHelp = new JButton("도움말");
        SpringLayout sl_main = new SpringLayout();
        sl_main.putConstraint(SpringLayout.WEST, btnBuy, 547, SpringLayout.WEST, main);
        sl_main.putConstraint(SpringLayout.EAST, btnBuy, -55, SpringLayout.EAST, main);
        sl_main.putConstraint(SpringLayout.NORTH, btnHelp, 6, SpringLayout.SOUTH, btnBefore);
        sl_main.putConstraint(SpringLayout.WEST, btnHelp, 0, SpringLayout.WEST, btnBuy);
        sl_main.putConstraint(SpringLayout.SOUTH, btnHelp, 279, SpringLayout.SOUTH, btnBuy);
        sl_main.putConstraint(SpringLayout.EAST, btnHelp, 0, SpringLayout.EAST, btnBuy);
        sl_main.putConstraint(SpringLayout.NORTH, btnBefore, 6, SpringLayout.SOUTH, btnResult);
        sl_main.putConstraint(SpringLayout.WEST, btnBefore, 0, SpringLayout.WEST, btnBuy);
        sl_main.putConstraint(SpringLayout.SOUTH, btnBefore, -200, SpringLayout.SOUTH, main);
        sl_main.putConstraint(SpringLayout.EAST, btnBefore, 0, SpringLayout.EAST, btnBuy);
        sl_main.putConstraint(SpringLayout.NORTH, btnResult, 6, SpringLayout.SOUTH, btnBuy);
        sl_main.putConstraint(SpringLayout.WEST, btnResult, 0, SpringLayout.WEST, btnBuy);
        sl_main.putConstraint(SpringLayout.SOUTH, btnResult, 93, SpringLayout.SOUTH, btnBuy);
        sl_main.putConstraint(SpringLayout.EAST, btnResult, 182, SpringLayout.WEST, btnBuy);
        sl_main.putConstraint(SpringLayout.NORTH, btnBuy, 88, SpringLayout.NORTH, main);
        sl_main.putConstraint(SpringLayout.SOUTH, btnBuy, -386, SpringLayout.SOUTH, main);
        main.setLayout(sl_main);

        main.add(btnBuy);
        main.add(btnResult);
        main.add(btnBefore);
        main.add(btnHelp);

        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                BuyFrame buyFrame = new BuyFrame(LottoProgram.this);
                buyFrame.setVisible(true);
            }
        });

        btnResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ResultFrame resultFrame = new ResultFrame(LottoProgram.this);
                resultFrame.setVisible(true);
            }
        });

        btnBefore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                beforeFrame.setVisible(true);
            }
        });

        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                helpFrame.setVisible(true);
            }
        });
        getContentPane().add(main);

        JPanel panel = new JPanel();
        sl_main.putConstraint(SpringLayout.NORTH, panel, 8, SpringLayout.NORTH, btnBuy);
        sl_main.putConstraint(SpringLayout.WEST, panel, 302, SpringLayout.WEST, main);
        sl_main.putConstraint(SpringLayout.SOUTH, panel, -90, SpringLayout.SOUTH, main);
        sl_main.putConstraint(SpringLayout.EAST, panel, -9, SpringLayout.WEST, btnBuy);
        main.add(panel);

       

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void showBuyBall(JPanel pnl, SpringLayout sl_pnl, int y, ArrayList<String> selectedNumbers) {
        ImageTextPair[] imageTextPairs = new ImageTextPair[6];

        for (int i = 0; i < selectedNumbers.size(); i++) {
            for (int j = 0; j < selectedNumbers.size(); j++) {
                if (Integer.valueOf(selectedNumbers.get(i)) >= j * 10 + 1
                        && Integer.valueOf(selectedNumbers.get(i)) <= (j + 1) * 10) {
                    String imagePath = "images/ball_" + (j + 1) + ".png";
                    imageTextPairs[i] = new ImageTextPair(imagePath, selectedNumbers.get(i));
                }
            }
        }

        int horizontalGap = -25;
        int xPosition = horizontalGap + 490;
        int yPosition = horizontalGap + 215 + y;

        for (ImageTextPair pair : imageTextPairs) {
            CircleImagePanel circleImagePanel = new CircleImagePanel(pair);
            sl_pnl.putConstraint(SpringLayout.NORTH, circleImagePanel, yPosition, SpringLayout.NORTH, pnl);
            sl_pnl.putConstraint(SpringLayout.WEST, circleImagePanel, xPosition, SpringLayout.WEST, pnl);
            sl_pnl.putConstraint(SpringLayout.SOUTH, circleImagePanel, yPosition + 50, SpringLayout.NORTH, pnl);
            sl_pnl.putConstraint(SpringLayout.EAST, circleImagePanel, xPosition + 50, SpringLayout.WEST, pnl);
            pnl.add(circleImagePanel);
            xPosition += 75 + horizontalGap;
        }
    }

   
}
