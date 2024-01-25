import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;

// 내가 산기록
public class RecordDialog extends JDialog {
	private LottoProgram lotto;
	private int tempNum;
	private int winningCount = 0;
	private HelpFrame help;

	public RecordDialog(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		Random random = new Random();

		JLabel backgroundImage = new JLabel(new ImageIcon("images/lottoResult.png"));
		SpringLayout springLayout = new SpringLayout();
		backgroundImage.setLayout(null);

		setTitle("결과확인");

		setModal(true);
		setSize(380, 522);
		setLocation(lotto.getX() + lotto.getWidth(), lotto.getY());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JLabel lblTitle = new JLabel("결과확인");

		lblTitle.setBounds(33, 10, 110, 19);
//			lblTitle.setBounds(33, 32, 110, 19);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		JLabel lottoDate = new JLabel("0000-00-00");
		lottoDate.setBounds(115, 120, 138, 17);
		LocalDateTime nowDT = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = nowDT.format(formatter);

        lottoDate.setText(formattedDate);
		lottoDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("제 1회");
		lblNewLabel_1.setBounds(235, 81, 59, 27);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setText("제 " + lotto.roundNum + "회");

		JLabel titleA = new JLabel("");
		titleA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleA.setBounds(51, 200, 69, 15);

		JLabel titleB = new JLabel("");
		titleB.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleB.setBounds(51, 240, 69, 15);

		JLabel titleC = new JLabel("");
		titleC.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleC.setBounds(51, 280, 69, 15);

		JLabel titleD = new JLabel("");
		titleD.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleD.setBounds(51, 320, 69, 15);

		JLabel titleE = new JLabel("");
		titleE.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleE.setBounds(51, 360, 69, 15);

		JLabel resultA = new JLabel("");
		resultA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultA.setBounds(140, 200, 177, 15);

		JLabel resultB = new JLabel("");
		resultB.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultB.setBounds(140, 240, 177, 15);

		JLabel resultC = new JLabel("");
		resultC.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultC.setBounds(140, 280, 177, 15);

		JLabel resultD = new JLabel("");
		resultD.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultD.setBounds(140, 320, 177, 15);

		JLabel resultE = new JLabel("");
		resultE.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultE.setBounds(140, 360, 177, 15);

		JLabel total = new JLabel("당첨금");
		total.setBounds(240, 422, 200, 15);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(147, 422, 69, 34);
		btnNewButton.setBackground(Color.WHITE);
		System.out.println(lotto.resultBuy.get(0));

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
//			JComboBox comboBox = new JComboBox();
//			springLayout.putConstraint(SpringLayout.WEST, comboBox, 26, SpringLayout.EAST, thirdLine);
//			springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, lblNewLabel_1);
//			getContentPane().add(comboBox);
//			

		JButton btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tempNum = lotto.roundNum;
				tempNum--;
				JLabel[] resultLabels = { resultA, resultB, resultC, resultD, resultE };
				for (int j = 0; j < resultLabels.length; j++) {
					if (!lotto.buyNumberCollection.get(tempNum).isEmpty()
							&& j < lotto.buyNumberCollection.get(tempNum).size()
							&& lotto.buyNumberCollection.get(tempNum).get(j).size() > 0) {
						StringBuilder resultText = new StringBuilder();
						for (int i = 0; i < 6 && i < lotto.buyNumberCollection.get(tempNum).get(j).size(); i++) {
							resultText.append(lotto.buyNumberCollection.get(tempNum).get(j).get(i)).append(" ");
						}
						resultLabels[j].setText(resultText.toString());
					} else {
						// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
						// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
						resultLabels[j].setText("");
					}
				}

			}
		});

		JLabel WinningresultA = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultA.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultA.setBounds(300, 200, 70, 15);
		backgroundImage.add(WinningresultA);

		JLabel WinningresultB = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultB.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultB.setBounds(300, 240, 70, 15);
		backgroundImage.add(WinningresultB);

		JLabel WinningresultC = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultC.setBounds(300, 280, 70, 15);
		backgroundImage.add(WinningresultC);

		JLabel WinningresultD = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultD.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultD.setBounds(300, 320, 70, 15);
		backgroundImage.add(WinningresultD);

		JLabel WinningresultE = new JLabel(""); // 당첨결과를 알려주기 위한 라벨
		WinningresultE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		WinningresultE.setBounds(300, 360, 70, 15);
		backgroundImage.add(WinningresultE);
//			springLayout.putConstraint(SpringLayout.NORTH, btnLeft, 10, SpringLayout.SOUTH, thirdLine);
//			springLayout.putConstraint(SpringLayout.WEST, btnLeft, 250, SpringLayout.WEST, getContentPane());
//			getContentPane().add(btnLeft);
//
//			JButton btnNewButton = new JButton("확인");
//			springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 35, SpringLayout.SOUTH, thirdLine);
//			springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 158, SpringLayout.WEST, getContentPane());
//			getContentPane().add(btnNewButton);
//			System.out.println(lotto.resultBuy.get(0));

		char ch = 'A';
		JLabel[] resultTitleLabels = { titleA, titleB, titleC, titleD, titleE };
		for (int j = 0; j < resultTitleLabels.length; j++) {
			if (!lotto.resultBuyTitle.get(j).isEmpty() && j < lotto.resultBuyTitle.size()
					&& lotto.resultBuyTitle.size() > 0) {
				StringBuilder resultTitleText = new StringBuilder();
				System.out.println((char) (ch + j));
				resultTitleText.append(ch).append(" ").append(lotto.resultBuyTitle.get(j)).append(" ");
				ch += 1;
				resultTitleLabels[j].setText(resultTitleText.toString());

			} else if (lotto.resultBuyTitle.get(j).equals("미지정")) {
				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
				resultTitleLabels[j].setText("");
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
		winningNumber.setBounds(120, 35, 220, 20);

//		int index = 0;
		if (resultNum != 0) {
//			index = random.nextInt(resultNum);
//			winningNumber.setText("당첨 번호 : " + lotto.resultBuy.get(index)); // 당첨 번호 출력하는 라벨
			winningNumber.setFont(new Font("맑은 고딕", Font.BOLD, 13));

//			lotto.winningNumberCollection.put(lotto.roundNum, lotto.resultBuy.get(index));
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

		JLabel[] winningresults = { WinningresultA, WinningresultB, WinningresultC, WinningresultD, WinningresultE };
		JLabel[] resultLabels = { resultA, resultB, resultC, resultD, resultE };
		for (int j = 0; j < resultLabels.length; j++) {
			if (!lotto.resultBuy.isEmpty() && j < lotto.resultBuy.size() && lotto.resultBuy.get(j).size() > 0) {
				StringBuilder resultText = new StringBuilder();
				for (int i = 0; i < 6 && i < lotto.resultBuy.get(j).size(); i++) {
					resultText.append(lotto.resultBuy.get(j).get(i)).append("  ");
				}
				resultLabels[j].setText(resultText.toString());

			} else {

				if (resultLabels[j].getText().isEmpty()) {
					resultTitleLabels[j].setText("");
					winningresults[j].setText("");
				}
				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
				resultLabels[j].setText("");
			}
		}

		int totalNum = 0;
		if (WinningresultA.getText().equals("5등")) {
			totalNum += 5000;
		} 
		if (WinningresultA.getText().equals("4등")) {
			totalNum += 50000;
		} 
		if (WinningresultA.getText().equals("3등")) {
			totalNum += 100000;
		}
		if (WinningresultA.getText().equals("2등")) {
			totalNum += 3000000;
		}
		if (WinningresultA.getText().equals("1등")) {
			totalNum += 500000000;
		}
		
		if (WinningresultB.getText().equals("5등")) {
			totalNum += 5000;
		} 
		if (WinningresultB.getText().equals("4등")) {
			totalNum += 50000;
		} 
		if (WinningresultB.getText().equals("3등")) {
			totalNum += 100000;
		}
		if (WinningresultB.getText().equals("2등")) {
			totalNum += 3000000;
		}
		if (WinningresultB.getText().equals("1등")) {
			totalNum += 500000000;
		}
		
		if (WinningresultC.getText().equals("5등")) {
			totalNum += 5000;
		} 
		if (WinningresultC.getText().equals("4등")) {
			totalNum += 50000;
		} 
		if (WinningresultC.getText().equals("3등")) {
			totalNum += 100000;
		}
		if (WinningresultC.getText().equals("2등")) {
			totalNum += 3000000;
		}
		if (WinningresultC.getText().equals("1등")) {
			totalNum += 500000000;
		}
		
		if (WinningresultD.getText().equals("5등")) {
			totalNum += 5000;
		} 
		if (WinningresultD.getText().equals("4등")) {
			totalNum += 50000;
		} 
		if (WinningresultD.getText().equals("3등")) {
			totalNum += 100000;
		}
		if (WinningresultD.getText().equals("2등")) {
			totalNum += 3000000;
		}
		if (WinningresultD.getText().equals("1등")) {
			totalNum += 500000000;
		}
		
		if (WinningresultE.getText().equals("5등")) {
			totalNum += 5000;
		} 
		if (WinningresultE.getText().equals("4등")) {
			totalNum += 50000;
		} 
		if (WinningresultE.getText().equals("3등")) {
			totalNum += 100000;
		}
		if (WinningresultE.getText().equals("2등")) {
			totalNum += 3000000;
		}
		if (WinningresultE.getText().equals("1등")) {
			totalNum += 500000000;
		}
		
		
		
		
		total.setText("합계: " + totalNum);
//			backgroundImage.add(winningNumber);

		// 윈도우 빌더 사용가능
//			getContentPane().setLayout(null);
//			getContentPane().add(lblTitle);
//			getContentPane().add(lottoIcon);
//			getContentPane().add(lottoDate);
//			getContentPane().add(lblNewLabel_1);
//			getContentPane().add(secondLine);
//			getContentPane().add(titleA);
//			getContentPane().add(titleB);
//			getContentPane().add(titleC);
//			getContentPane().add(titleD);
//			getContentPane().add(titleE);
//			getContentPane().add(resultA);
//			getContentPane().add(resultB);
//			getContentPane().add(resultC);
//			getContentPane().add(resultD);
//			getContentPane().add(resultE);
//			getContentPane().add(thirdLine);
//			getContentPane().add(total);
//			getContentPane().add(btnNewButton);
//			

		backgroundImage.add(lblTitle);
		backgroundImage.add(lottoDate);
		backgroundImage.add(lblNewLabel_1);
		backgroundImage.add(titleA);
		backgroundImage.add(titleB);
		backgroundImage.add(titleC);
		backgroundImage.add(titleD);
		backgroundImage.add(titleE);
		backgroundImage.add(resultA);
		backgroundImage.add(resultB);
		backgroundImage.add(resultC);
		backgroundImage.add(resultD);
		backgroundImage.add(resultE);
		backgroundImage.add(total);
		backgroundImage.add(btnNewButton);

		getContentPane().add(backgroundImage);

	}
}
