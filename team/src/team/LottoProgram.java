package team;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoProgram{
	private JPanel cards;
    private CardLayout cardLayout;

    public LottoProgram() {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        // 카드 1
        BuyFrame card1 = new BuyFrame();
        cards.add(card1, "BuyFrame");

        // 카드 2
        ResultFrame card2 = new ResultFrame();
        cards.add(card2, "ResultFrame");

        // 카드 3
        BeforeFrame card3 = new BeforeFrame();
        cards.add(card3, "BeforeFrame");

        // 버튼 추가
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cards);
            }
        });

        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cards);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        frame.add(cards, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}







