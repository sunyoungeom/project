import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BeforeFrame extends JFrame {
    private LottoProgram lotto;

    public BeforeFrame(LottoProgram lottoProgram) {
        this.lotto = lottoProgram;

        JPanel pnl = new JPanel();
        pnl.setBackground(Color.WHITE);
        SpringLayout sl_pnl = new SpringLayout();
        pnl.setLayout(sl_pnl);
        JButton btnreturn = new JButton("돌아가기");
        sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 1, SpringLayout.NORTH, pnl);
        sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
        pnl.add(btnreturn);
//        ResultFrame.winningNumberCollection.get(1); 
        
        // 여러 개의 이미지와 텍스트를 가지는 데이터
        ImageTextPair[] imageTextPairs = {
        		
// ImageTextPair[i]
            new ImageTextPair("images/ball_1.png", "1"),
            new ImageTextPair("images/ball_2.png", "2"),
            new ImageTextPair("images/basicCircle.png", "3"),
            new ImageTextPair("images/basicCircle.png", "4"),
            new ImageTextPair("images/basicCircle.png", "5"),
            new ImageTextPair("images/basicCircle.png", "6"),
            new ImageTextPair("", "+"),
            new ImageTextPair("images/basicCircle.png", "7"),
            // 추가적인 이미지와 텍스트를 원하는 만큼 추가
        };
      

        int horizontalGap = -15; // 이미지 사이의 가로 간격 조정
        int xPosition = horizontalGap + 80; // 이미지의 초기 x 좌표

        for (ImageTextPair pair : imageTextPairs) {
            CircleImagePanel circleImagePanel = new CircleImagePanel(pair);
            sl_pnl.putConstraint(SpringLayout.NORTH, circleImagePanel, 203, SpringLayout.NORTH, pnl);
            sl_pnl.putConstraint(SpringLayout.WEST, circleImagePanel, xPosition, SpringLayout.WEST, pnl);
            sl_pnl.putConstraint(SpringLayout.SOUTH, circleImagePanel, 289, SpringLayout.NORTH, pnl);
            sl_pnl.putConstraint(SpringLayout.EAST, circleImagePanel, xPosition + 95, SpringLayout.WEST, pnl);
            pnl.add(circleImagePanel);
            circleImagePanel.setBackground(Color.WHITE);
            xPosition += 95 + horizontalGap; // 이미지와 간격만큼 x 좌표 이동
        }
       
        btnreturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                lotto.setVisible(true);
            }
        });

        getContentPane().add(pnl);
        
        JButton btnNewButton = new JButton("<");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton, 203, SpringLayout.SOUTH, btnreturn);
        sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, pnl);
        pnl.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton(">");
        sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
        sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, pnl);
        pnl.add(btnNewButton_1);
        setSize(800, 600);
        setVisible(false);
    }

   
}
