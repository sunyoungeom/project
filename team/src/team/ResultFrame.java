
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
		backgroundImage.setLayout(null);

		JLabel lblTitle = new JLabel("구매내역/결과확인");
		lblTitle.setBounds(33, 15, 110, 19);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		backgroundImage.add(lblTitle);


		JLabel lottoDate = new JLabel("0000-00-00");
		lottoDate.setBounds(120, 146, 138, 17);
		lottoDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		backgroundImage.add(lottoDate);

		JLabel lblNewLabel_1 = new JLabel("제 1회");
		lblNewLabel_1.setBounds(235, 81, 59, 27);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setText("제 " + lotto.roundNum + "회");
		backgroundImage.add(lblNewLabel_1);

		JLabel titleA = new JLabel("New label");
		titleA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		titleA.setBounds(51, 205, 69, 15);
		backgroundImage.add(titleA);

		JLabel titleB = new JLabel("New label");
		titleB.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		titleB.setBounds(51, 245, 69, 15);
		backgroundImage.add(titleB);

		JLabel titleC = new JLabel("New label");
		titleC.setFont(new Font("맑은 고딕",Font.BOLD, 13));
		titleC.setBounds(51, 285, 69, 15);
		backgroundImage.add(titleC);

		JLabel titleD = new JLabel("New label");
		titleD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		titleD.setBounds(51, 325, 69, 15);
		backgroundImage.add(titleD);

		JLabel titleE = new JLabel("New label");
		titleE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		titleE.setBounds(51, 365, 69, 15);
		backgroundImage.add(titleE);

		JLabel resultA = new JLabel("New label");
		resultA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		resultA.setBounds(140, 205, 177, 15);
		backgroundImage.add(resultA);

		JLabel resultB = new JLabel("New label");
		resultB.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		resultB.setBounds(140, 245, 177, 15);
		backgroundImage.add(resultB);

		JLabel resultC = new JLabel("New label");
		resultC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		resultC.setBounds(140, 285, 177, 15);
		backgroundImage.add(resultC);

		JLabel resultD = new JLabel("New label");
		resultD.setFont(new Font("맑은 고딕",Font.BOLD, 13));
		resultD.setBounds(140, 325, 177, 15);
		backgroundImage.add(resultD);

		JLabel resultE = new JLabel("New label");
		resultE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		resultE.setBounds(140, 365, 177, 15);
		backgroundImage.add(resultE);

		JLabel total = new JLabel("New label"); // 당첨금의 합을 알려주는 라벨
		total.setBounds(270, 422, 57, 15);
		backgroundImage.add(total);

		JLabel WinningresultA = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultA.setBounds(300, 205, 70, 15);
		backgroundImage.add(WinningresultA);

		JLabel WinningresultB = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultB.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultB.setBounds(300, 245, 70, 15);
		backgroundImage.add(WinningresultB);

		JLabel WinningresultC = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultC.setBounds(300, 285, 70, 15);
		backgroundImage.add(WinningresultC);

		JLabel WinningresultD = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultD.setBounds(300, 325, 70, 15);
		backgroundImage.add(WinningresultD);

		JLabel WinningresultE = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultE.setBounds(300, 365, 70, 15);
		backgroundImage.add(WinningresultE);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(147, 440, 69, 34);
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
		int resultNum = 0;
		for (int i = 0; i < lotto.resultBuy.size(); i++) {
			if (!lotto.resultBuy.get(i).isEmpty()) {
				resultNum++;
			}
		}

		System.out.println(lotto.roundNum);
		System.out.println("ghkr");

		JLabel winningNumber = new JLabel(); // 당첨번호 출력해주는라벨
		winningNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		winningNumber.setBounds(80, 170, 220, 20);

		int index = 0;
		if (resultNum != 0) {
			index = random.nextInt(resultNum);
			winningNumber.setText("당첨 번호 : " + lotto.resultBuy.get(index)); // 당첨 번호 출력하는 라벨
			winningNumber.setFont(new Font("맑은 고딕", Font.BOLD, 13));

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
				winningCount = 0;
				WinningresultA.setForeground(Color.BLACK);
			} else if (winningCount == 3) {
				WinningresultA.setText("4등");
				winningCount = 0;
				WinningresultA.setForeground(Color.BLUE);
			} else if (winningCount == 4) {
				WinningresultA.setText("3등");
				winningCount = 0;
				WinningresultA.setForeground(Color.GREEN);
			} else if (winningCount == 5) {
				WinningresultA.setText("2등");
				winningCount = 0;
				WinningresultA.setForeground(Color.YELLOW);
			} else if (winningCount == 6) {
				WinningresultA.setText("1등");
				winningCount = 0;
				WinningresultA.setForeground(Color.RED);
			}

			// B번호 매칭하여 1,2,3,4,5,낙첨 출력
			for (int i = 0; i < 6; i++) {
				if (lotto.resultBuy.size() > 1 && lotto.resultBuy.get(1).size() > i) {
					for (int j = 0; j < 6; j++) {
						if (lotto.resultBuy.get(1).get(i)
								.equals(lotto.winningNumberCollection.get(lotto.roundNum).get(j))) {
							winningCount++;
							break;
						}
					}
				}
			}
			if (winningCount == 0 || winningCount < 3) {
				WinningresultB.setText("낙첨");
				WinningresultB.setForeground(Color.BLACK);
				winningCount = 0;
			} else if (winningCount == 3) {
				WinningresultB.setText("4등");
				WinningresultB.setForeground(Color.BLUE);
				winningCount = 0;
			} else if (winningCount == 4) {
				WinningresultB.setText("3등");
				WinningresultB.setForeground(Color.GREEN);
				winningCount = 0;
			} else if (winningCount == 5) {
				WinningresultB.setText("2등");
				WinningresultA.setForeground(Color.YELLOW);
				winningCount = 0;
			} else if (winningCount == 6) {
				WinningresultB.setText("1등");
				WinningresultA.setForeground(Color.RED);
				winningCount = 0;
			}

			// C번호 매칭하여 1,2,3,4,5,낙첨 출력
			for (int i = 0; i < 6; i++) {
				if (lotto.resultBuy.size() > 1 && lotto.resultBuy.get(2).size() > i) {
					for (int j = 0; j < 6; j++) {
						if (lotto.resultBuy.get(2).get(i)
								.equals(lotto.winningNumberCollection.get(lotto.roundNum).get(j))) {
							winningCount++;
							break;
						}
					}
				}
			}
			if (winningCount == 0 || winningCount < 3) {
				WinningresultC.setText("낙첨");
				WinningresultC.setForeground(Color.BLACK);
				winningCount = 0;
			} else if (winningCount == 3) {
				WinningresultC.setText("4등");
				WinningresultC.setForeground(Color.BLUE);
				winningCount = 0;
			} else if (winningCount == 4) {
				WinningresultC.setText("3등");
				WinningresultC.setForeground(Color.GREEN);
				winningCount = 0;
			} else if (winningCount == 5) {
				WinningresultC.setText("2등");
				WinningresultC.setForeground(Color.YELLOW);
				winningCount = 0;
			} else if (winningCount == 6) {
				WinningresultC.setText("1등");
				WinningresultC.setForeground(Color.RED);
				winningCount = 0;
			}
			winningCount = 0;
			// D번호 매칭하여 1,2,3,4,5,낙첨 출력
			for (int i = 0; i < 6; i++) {
				if (lotto.resultBuy.size() > 1 && lotto.resultBuy.get(3).size() > i) {
					for (int j = 0; j < 6; j++) {
						if (lotto.resultBuy.get(3).get(i)
								.equals(lotto.winningNumberCollection.get(lotto.roundNum).get(j))) {
							winningCount++;
							break;
						}
					}
				}
			}
			if (winningCount == 0 || winningCount < 3) {
				WinningresultD.setText("낙첨");
				WinningresultD.setForeground(Color.BLACK);
				winningCount = 0;
			} else if (winningCount == 3) {
				WinningresultD.setText("4등");
				WinningresultD.setForeground(Color.BLUE);
				winningCount = 0;
			} else if (winningCount == 4) {
				WinningresultD.setText("3등");
				WinningresultD.setForeground(Color.GREEN);
				winningCount = 0;
			} else if (winningCount == 5) {
				WinningresultD.setText("2등");
				WinningresultD.setForeground(Color.YELLOW);
				winningCount = 0;
			} else if (winningCount == 6) {
				WinningresultD.setText("1등");
				WinningresultD.setForeground(Color.RED);
				winningCount = 0;
			}
			// E번호 매칭하여 1,2,3,4,5,낙첨 출력
			for (int i = 0; i < 6; i++) {
				if (lotto.resultBuy.size() > 1 && lotto.resultBuy.get(4).size() > i) {
					for (int j = 0; j < 6; j++) {
						if (lotto.resultBuy.get(4).get(i)
								.equals(lotto.winningNumberCollection.get(lotto.roundNum).get(j))) {
							winningCount++;
							break;
						}
					}
				}
			}
			if (winningCount == 0 || winningCount < 3) {
				WinningresultE.setText("낙첨");
				WinningresultE.setForeground(Color.BLACK);
				winningCount = 0;
			} else if (winningCount == 3) {
				WinningresultE.setText("4등");
				WinningresultE.setForeground(Color.BLUE);
				winningCount = 0;
			} else if (winningCount == 4) {
				WinningresultE.setText("3등");
				WinningresultE.setForeground(Color.GREEN);
				winningCount = 0;
			} else if (winningCount == 5) {
				WinningresultE.setText("2등");
				WinningresultE.setForeground(Color.YELLOW);
				winningCount = 0;
			} else if (winningCount == 6) {
				WinningresultE.setText("1등");
				WinningresultE.setForeground(Color.RED);
				winningCount = 0;
			}

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