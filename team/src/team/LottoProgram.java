
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.net.www.content.image.jpeg;
import javax.swing.SpringLayout;

public class LottoProgram extends JFrame {
//	private BuyFrame buyFrame = new BuyFrame(this);
//	private ResultFrame resultFrame = new ResultFrame(this);
	private BeforeFrame beforeFrame = new BeforeFrame(this);
	private HelpFrame helpFrame = new HelpFrame(this);
	public ArrayList<ArrayList<String>> resultBuy = new ArrayList<>(5);

	public ArrayList<ArrayList<String>> getResultBuy() {
		return resultBuy;
	}

	public void setResultBuy(ArrayList<ArrayList<String>> resultBuy) {
		this.resultBuy = resultBuy;
	}

	public LottoProgram() {
		for (int i = 0; i < 5; i++) {
			resultBuy.add(new ArrayList<>());
		}
		
		setTitle("메인 창");
		JPanel main = new JPanel();

		JButton btnBuy = new JButton("구매하기");
		JButton btnResult = new JButton("결과확인");
		JButton btnBefore = new JButton("이전회차");
		JButton btnHelp = new JButton("도움말");

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
		add(main);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

//	public void showBuyBall(JPanel pnl, SpringLayout sl_pnl, int y, ArrayList<String> selectedNumbers, Boolean b) {
		public void showBuyBall(JPanel pnl, SpringLayout sl_pnl, int y, ArrayList<String> selectedNumbers) {

		ImageTextPair[] imageTextPairs = new ImageTextPair[6];
//		if (b) {
			for (int i = 0; i < selectedNumbers.size(); i++) {
				for (int j = 0; j < selectedNumbers.size(); j++) {
					if (Integer.valueOf(selectedNumbers.get(i)) >= j * 10 + 1
							&& Integer.valueOf(selectedNumbers.get(i)) <= (j + 1) * 10) {
//					String imagePath = "images/ball_" + (j + 1) + ".png";
						String imagePath = "";
						imageTextPairs[i] = new ImageTextPair(imagePath, selectedNumbers.get(i));
					}

//				}
			}
		} 
//		else { for (int i = 0; i < selectedNumbers.size(); i++) {
//			for (int j = 0; j < selectedNumbers.size(); j++) {
//				if (Integer.valueOf(selectedNumbers.get(i)) >= j * 10 + 1
//						&& Integer.valueOf(selectedNumbers.get(i)) <= (j + 1) * 10) {
////				String imagePath = "images/ball_" + (j + 1) + ".png";
//					String imagePath = "";
//					imageTextPairs[i] = new ImageTextPair(imagePath, selectedNumbers.get(i));
//				}
//
//			}
//		}

		int horizontalGap = -25; // 이미지 사이의 가로 간격 조정
		int xPosition = horizontalGap + 490; // 이미지의 초기 x 좌표
		int yPosition = horizontalGap + 215 + y; // 이미지의 초기 x 좌표

		for (ImageTextPair pair : imageTextPairs) {
			CircleImagePanel circleImagePanel = new CircleImagePanel(pair);
			sl_pnl.putConstraint(SpringLayout.NORTH, circleImagePanel, yPosition, SpringLayout.NORTH, pnl);
			sl_pnl.putConstraint(SpringLayout.WEST, circleImagePanel, xPosition, SpringLayout.WEST, pnl);
			sl_pnl.putConstraint(SpringLayout.SOUTH, circleImagePanel, yPosition + 50, SpringLayout.NORTH, pnl);
			sl_pnl.putConstraint(SpringLayout.EAST, circleImagePanel, xPosition + 50, SpringLayout.WEST, pnl);
			pnl.add(circleImagePanel);
//			circleImagePanel.setBackground(Color.WHITE);
			xPosition += 75 + horizontalGap; // 이미지와 간격만큼 x 좌표 이동
		}
	}
}
