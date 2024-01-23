
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

//import javafx.beans.binding.StringBinding;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

// 기표
public class ResultFrame extends JFrame {
	private LottoProgram lotto;
	private BuyFrame buy;
	private int winningCount = 0;
//	public static Map<Integer, ArrayList<String>> winningNumberCollection = new TreeMap<>();

	public ResultFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		Random random = new Random();

		setTitle("로또 결과 확인");

		JLabel backgroundImage = new JLabel(new ImageIcon("images/lottoResult.png"));
		SpringLayout springLayout = new SpringLayout();
		backgroundImage.setLayout(springLayout);

		JLabel lblTitle = new JLabel("구매내역/결과확인");
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 33, SpringLayout.WEST, getContentPane());
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		backgroundImage.add(lblTitle);

//		// 결과 공 표시  
//		JPanel pnlResultBall = new JPanel();
//		springLayout.putConstraint(SpringLayout.NORTH, pnlResultBall, 90, SpringLayout.NORTH, backgroundImage);
//		springLayout.putConstraint(SpringLayout.WEST, pnlResultBall, 440, SpringLayout.WEST, backgroundImage);
//		backgroundImage.add(pnlResultBall);

		JLabel firstLine = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, lblTitle, -6, SpringLayout.NORTH, firstLine);
		springLayout.putConstraint(SpringLayout.NORTH, firstLine, 48, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, firstLine, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, firstLine, 375, SpringLayout.WEST, getContentPane());
//		firstLine.setIcon(new ImageIcon("images/lottoResult_2.png"));
		backgroundImage.add(firstLine);

		JLabel lottoIcon = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lottoIcon, 9, SpringLayout.SOUTH, firstLine);
		springLayout.putConstraint(SpringLayout.WEST, lottoIcon, 0, SpringLayout.WEST, lblTitle);
		lottoIcon.setIcon(new ImageIcon("images/lottoResult_1.png"));
		backgroundImage.add(lottoIcon);

		JLabel lottoDate = new JLabel("발 행 일: ");
		springLayout.putConstraint(SpringLayout.NORTH, lottoDate, 17, SpringLayout.SOUTH, lottoIcon);
		springLayout.putConstraint(SpringLayout.WEST, lottoDate, 0, SpringLayout.WEST, lblTitle);
		lottoDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		backgroundImage.add(lottoDate);

		JLabel lblNewLabel_1 = new JLabel("제 1회");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 19, SpringLayout.SOUTH, firstLine);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 67, SpringLayout.EAST, lottoIcon);
		lblNewLabel_1.setText("제 " + lotto.roundNum + "회");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		backgroundImage.add(lblNewLabel_1);

		JLabel secondLine = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, secondLine, 6, SpringLayout.SOUTH, lottoDate);
		springLayout.putConstraint(SpringLayout.WEST, secondLine, 0, SpringLayout.WEST, firstLine);
		backgroundImage.add(secondLine);

		JLabel titleA = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, titleA, 110, SpringLayout.SOUTH, secondLine);
		springLayout.putConstraint(SpringLayout.WEST, titleA, 0, SpringLayout.WEST, lblTitle);
		backgroundImage.add(titleA);

		JLabel titleB = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, titleB, 22, SpringLayout.SOUTH, titleA);
		springLayout.putConstraint(SpringLayout.WEST, titleB, 0, SpringLayout.WEST, lblTitle);
		backgroundImage.add(titleB);

		JLabel titleC = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, titleC, 26, SpringLayout.SOUTH, titleB);
		springLayout.putConstraint(SpringLayout.WEST, titleC, 0, SpringLayout.WEST, lblTitle);
		backgroundImage.add(titleC);

		JLabel titleD = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, titleD, 30, SpringLayout.SOUTH, titleC);
		springLayout.putConstraint(SpringLayout.EAST, titleD, 0, SpringLayout.EAST, titleA);
		backgroundImage.add(titleD);

		JLabel titleE = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, titleE, 25, SpringLayout.SOUTH, titleD);
		springLayout.putConstraint(SpringLayout.WEST, titleE, 0, SpringLayout.WEST, lblTitle);
		backgroundImage.add(titleE);

		JLabel resultA = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, resultA, 110, SpringLayout.SOUTH, secondLine);
		springLayout.putConstraint(SpringLayout.WEST, resultA, 34, SpringLayout.EAST, titleA);
		backgroundImage.add(resultA);

		JLabel resultB = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, resultB, 0, SpringLayout.NORTH, titleB);
		springLayout.putConstraint(SpringLayout.WEST, resultB, 0, SpringLayout.WEST, resultA);
		backgroundImage.add(resultB);

		JLabel resultC = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, resultC, 0, SpringLayout.NORTH, titleC);
		springLayout.putConstraint(SpringLayout.WEST, resultC, 0, SpringLayout.WEST, resultA);
		backgroundImage.add(resultC);

		JLabel resultD = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, resultD, 0, SpringLayout.NORTH, titleD);
		springLayout.putConstraint(SpringLayout.WEST, resultD, 0, SpringLayout.WEST, resultA);
		backgroundImage.add(resultD);

		JLabel resultE = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, resultE, 0, SpringLayout.NORTH, titleE);
		springLayout.putConstraint(SpringLayout.WEST, resultE, 0, SpringLayout.WEST, resultA);
		backgroundImage.add(resultE);

		JLabel thirdLine = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, thirdLine, 6, SpringLayout.SOUTH, titleE);
		springLayout.putConstraint(SpringLayout.WEST, thirdLine, 0, SpringLayout.WEST, firstLine);
		thirdLine.setIcon(new ImageIcon("images/lottoResult_3.png"));
		backgroundImage.add(thirdLine);

		JLabel total = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, total, 6, SpringLayout.SOUTH, thirdLine);
		springLayout.putConstraint(SpringLayout.WEST, total, 0, SpringLayout.WEST, lblNewLabel_1);
		backgroundImage.add(total);
		JLabel WinningresultA = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		springLayout.putConstraint(SpringLayout.NORTH, WinningresultA, 110, SpringLayout.SOUTH, secondLine);
		springLayout.putConstraint(SpringLayout.WEST, WinningresultA, 200, SpringLayout.WEST, lblTitle);
		backgroundImage.add(WinningresultA);

		JButton btnNewButton = new JButton("확인");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 35, SpringLayout.SOUTH, thirdLine);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 158, SpringLayout.WEST, getContentPane());
		backgroundImage.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);
				for (int i = 0; i < 5; i++) {
					lotto.resultBuy.set(i, new ArrayList<>());
				}
			}
		});
		System.out.println(lotto.resultBuy.get(0));

		char ch = 'A';
//		for (int i = 0; i < array.length; i++) {
//			System.out.println((char)(ch + j));
//			lotto.resultBuyTitle.
//		}
//		
		JLabel[] resultTitleLabels = { titleA, titleB, titleC, titleD, titleE };
		for (int j = 0; j < resultTitleLabels.length; j++) {
			if (!lotto.resultBuyTitle.get(j).isEmpty() && j < lotto.resultBuyTitle.size()
					&& lotto.resultBuyTitle.size() > 0) {
				StringBuilder resultTitleText = new StringBuilder();
				System.out.println((char) (ch + j));
				resultTitleText.append(ch).append(" ").append(lotto.resultBuyTitle.get(j));
				ch += 1;
				resultTitleLabels[j].setText(resultTitleText.toString());

			} else {
				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
				resultTitleLabels[j].setText("");
			}
		}

		JLabel[] resultLabels = { resultA, resultB, resultC, resultD, resultE };
		for (int j = 0; j < resultLabels.length; j++) {
			if (!lotto.resultBuy.isEmpty() && j < lotto.resultBuy.size() && lotto.resultBuy.get(j).size() > 0) {
				StringBuilder resultText = new StringBuilder();
				for (int i = 0; i < 6 && i < lotto.resultBuy.get(j).size(); i++) {
					resultText.append(lotto.resultBuy.get(j).get(i)).append(" ");
				}
				resultLabels[j].setText(resultText.toString());
			} else {
				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
				resultLabels[j].setText("");
			}
		}
//		int resultNum = 0;
//		for (int i = 0; i < 5; i++) {
//			if (lotto.resultBuy.get(i).size() != 0) {
//				resultNum++;
//			}
//		}
		int resultNum = 0;
		for (int i = 0; i < lotto.resultBuy.size(); i++) {
			if (!lotto.resultBuy.get(i).isEmpty()) {
				resultNum++;
			}
		}

		System.out.println(lotto.roundNum);
		System.out.println("ghkr");

		JLabel winningNumber = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 100, SpringLayout.SOUTH, thirdLine);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 60, SpringLayout.WEST, getContentPane());

		int index = 0;
		if (resultNum != 0) {
			index = random.nextInt(resultNum);
			winningNumber.setText("당첨 번호 : " + lotto.resultBuy.get(index)); // 당첨 번호 출력하는 라벨

//		winningNumberCollection = new TreeMap<>();
			lotto.winningNumberCollection.put(lotto.roundNum, lotto.resultBuy.get(index));
			ArrayList<String> ll = new ArrayList<>();
			ll = lotto.winningNumberCollection.get(lotto.roundNum);
			System.out.println("dd" + ll);
			System.out.println(lotto.winningNumberCollection.get(lotto.roundNum).get(0));

			for (Integer numKey : lotto.winningNumberCollection.keySet()) {
				System.out.println("제" + (numKey) + "회" + ": " + lotto.winningNumberCollection.get(numKey));
			}
			// A번호 매칭하여 1,2,3,4,5,낙첨 출력
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (lotto.resultBuy.get(0).get(i)
							.equals(lotto.winningNumberCollection.get(lotto.roundNum).get(j))) {
						winningCount++;
						break;
					}
				}
			}
			if (winningCount == 0 || winningCount < 3) {
				WinningresultA.setText("낙첨");
			} else if (winningCount == 3) {
				WinningresultA.setText("4등");
			} else if (winningCount == 4) {
				WinningresultA.setText("3등");
			} else if (winningCount == 5) {
				WinningresultA.setText("2등");
			} else if (winningCount == 6) {
				WinningresultA.setText("1등");
			}
			winningCount = 0;
			
			showResultBall(lotto.resultBuy.get(index), springLayout, backgroundImage);

		}
		backgroundImage.add(winningNumber);

		getContentPane().add(backgroundImage);
		pack();
		setResizable(false);
		setVisible(false);

	}

	public void showResultBall(ArrayList<String> selectedNumbers, SpringLayout springLayout, JLabel backgroundImage) {
		for (int i = 0; i < selectedNumbers.size(); i++) {
			String num = selectedNumbers.get(i);
			String path = "images/ball/ball_";
			String imagePath = "images/ball/ball_" + num + ".PNG";

			ImageIcon icon = new ImageIcon(imagePath);
			Image image = icon.getImage(); // Image 객체로 변환
			Image resizedImage = image.getScaledInstance(54, 40, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon resizedIcon = new ImageIcon(resizedImage); // 조정된 이미지로 새로운 아이콘 생성

			JLabel label = new JLabel(resizedIcon);
			springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, backgroundImage);
			springLayout.putConstraint(SpringLayout.WEST, label, 0 + (i * 50), SpringLayout.EAST, backgroundImage);
			backgroundImage.add(label);
		}
	}
}