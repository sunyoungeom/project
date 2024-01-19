
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javafx.beans.binding.StringBinding;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

// 기표
public class ResultFrame extends JFrame {
	private LottoProgram lotto;

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
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		backgroundImage.add(lblNewLabel_1);

		JLabel secondLine = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, secondLine, 6, SpringLayout.SOUTH, lottoDate);
		springLayout.putConstraint(SpringLayout.WEST, secondLine, 0, SpringLayout.WEST, firstLine);
//		secondLine.setIcon(new ImageIcon("images/lottoResult_3.png"));
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

		JButton btnNewButton = new JButton("확인");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 35, SpringLayout.SOUTH, thirdLine);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 158, SpringLayout.WEST, getContentPane());
		backgroundImage.add(btnNewButton);
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
		int index = random.nextInt(5);
		JLabel winningNumber = new JLabel();
		winningNumber.setText(lotto.resultBuy.get(index).toString()); // 당첨 번호 출력하는 라벨

		Map<Integer, String> winningNumberCollection = new TreeMap<>();
		for (int i = 1; i < 10; i++) {
			winningNumberCollection.put(i, winningNumber.getText());
		}
		JLabel round = new JLabel();
//		winningNumberCollection.round.setText(text);
//		btnreturn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				lotto.setVisible(true);
//
//			}
//		});
		getContentPane().add(backgroundImage);
		pack();
		setVisible(false);

	}

//	public void updateResultLabels() {
//		if (lotto.resultBuy != null && lotto.resultBuy.size() <= 5) {
//			aResult.setText(lotto.resultBuy.get(0).toString());
//			bResult.setText(lotto.resultBuy.get(1).toString());
//			cResult.setText(lotto.resultBuy.get(2).toString());
//			dResult.setText(lotto.resultBuy.get(3).toString());
//			eResult.setText(lotto.resultBuy.get(4).toString());
//		}
//	}
}
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.LineBorder;
//import java.awt.Color;
//import java.awt.Font;
//
//// 기표
//public class ResultFrame extends JFrame {
//	private LottoProgram lotto;
//	private JLabel aResult;
//	private JLabel bResult;
//	private JLabel cResult;
//	private JLabel dResult;
//	private JLabel eResult;
//
//	public ResultFrame(LottoProgram lottoProgram) {
//		this.lotto = lottoProgram;
//		setTitle("로또 결과 확인");
//		JPanel pnl = new JPanel();
//		pnl.setLayout(null);
//		JButton btnreturn = new JButton("돌아가기");
//		btnreturn.setBounds(12, 10, 90, 25);
//		pnl.add(btnreturn);
//		getContentPane().add(pnl);
//
//		JPanel panel = new JPanel();
//		panel.setBounds(70, 80, 550, 80); // 결과 창이 나오는 패널
//		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		pnl.add(panel);
//
//		JLabel A = new JLabel("A");
//		A.setFont(new Font("SansSerif", Font.BOLD, 20));
//		A.setBounds(70, 240, 20, 20);
//		pnl.add(A);
//
//		JLabel AText = new JLabel("");
//		AText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
//		AText.setBounds(100, 240, 60, 20);
//		pnl.add(AText);
//
//		aResult = new JLabel("");
//		aResult.setBounds(560, 240, 57, 15);
//		pnl.add(aResult);
//
//		JLabel aNumber = new JLabel("New label");
//		aNumber.setBounds(291, 240, 57, 15);
//		pnl.add(aNumber);
//		if (lotto.resultBuy != null && lotto.resultBuy.size() >= 5) {
//			StringBuilder indexNumber = new StringBuilder();
//			aNumber.setText(lotto.resultBuy.get(0).toString());
//		}
//
//		JLabel B = new JLabel("B");
//		B.setFont(new Font("SansSerif", Font.BOLD, 20));
//		B.setBounds(70, 300, 20, 20);
//		pnl.add(B);
//
//		JLabel BText = new JLabel("");
//		BText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
//		BText.setBounds(100, 300, 60, 20);
//		pnl.add(BText);
//
//		bResult = new JLabel("");
//		bResult.setBounds(560, 300, 57, 15);
//		pnl.add(bResult);
//
//		JLabel C = new JLabel("C");
//		C.setFont(new Font("SansSerif", Font.BOLD, 20));
//		C.setBounds(70, 360, 20, 20);
//		pnl.add(C);
//
//		JLabel CText = new JLabel("");
//		CText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
//		CText.setBounds(100, 360, 60, 20);
//		pnl.add(CText);
//
//		cResult = new JLabel("");
//		cResult.setBounds(560, 360, 57, 15);
//		pnl.add(cResult);
//
//		JLabel D = new JLabel("D");
//		D.setFont(new Font("SansSerif", Font.BOLD, 20));
//		D.setBounds(70, 420, 20, 20);
//		pnl.add(D);
//
//		JLabel DText = new JLabel("");
//		DText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
//		DText.setBounds(100, 420, 60, 20);
//		pnl.add(DText);
//
//		dResult = new JLabel("");
//		dResult.setBounds(560, 420, 57, 15);
//		pnl.add(dResult);
//
//		JLabel E = new JLabel("E");
//		E.setFont(new Font("SansSerif", Font.BOLD, 20));
//		E.setBounds(70, 480, 20, 20);
//		pnl.add(E);
//
//		JLabel EText = new JLabel("");
//		EText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
//		EText.setBounds(100, 480, 60, 20);
//		pnl.add(EText);
//
//		eResult = new JLabel("");
//		eResult.setBounds(560, 480, 57, 15);
//		pnl.add(eResult);
//
//		btnreturn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				lotto.setVisible(true);
//
//			}
//		});
//
//////		pnl2.setBounds(0, 0, 684, 561);
////		if (lotto.resultBuy != null) {
////				
////				System.out.println(lotto.resultBuy.get(0));
////				lotto.showBuyBall(pnl, sl_pnl, -200, lotto.resultBuy.get(0));
////				
////		}
////
////		
//
//		setSize(700, 600);
//		setVisible(false);
//
//	}
//
//	public void updateResultLabels() {
//		if (lotto.resultBuy != null && lotto.resultBuy.size() <= 5) {
//			aResult.setText(lotto.resultBuy.get(0).toString());
//			bResult.setText(lotto.resultBuy.get(1).toString());
//			cResult.setText(lotto.resultBuy.get(2).toString());
//			dResult.setText(lotto.resultBuy.get(3).toString());
//			eResult.setText(lotto.resultBuy.get(4).toString());
//		}
//	}
//
//}