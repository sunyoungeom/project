import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class BeforeFrame extends JFrame {
	private LottoProgram lotto;
	private int tempNum; // 비교를 위한 변수
	private JLabel lblNewLabel_;
	private JLabel lblNewLabel;

	public BeforeFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		setTitle("이전 회차");
		 BeforeFrame.this.setLocation(400, 250);
		tempNum = lotto.roundNum;
		JPanel pnl = new JPanel();
		pnl.setBackground(Color.WHITE);
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);

		JPanel ballApnl = new JPanel();
		ballApnl.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.WEST, ballApnl, 190, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, ballApnl, -312, SpringLayout.SOUTH, pnl);
		pnl.add(ballApnl);

		JLabel lblNewLabel_1 = new JLabel("0000-00-00 추첨");
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_1, -345, SpringLayout.EAST, pnl);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		LocalDateTime nowDT = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = nowDT.format(formatter);

		lblNewLabel_1.setText(formattedDate);
		pnl.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("당첨번호");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_2, -348, SpringLayout.EAST, pnl);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		pnl.add(lblNewLabel_2);

		JButton btnMyLotto = new JButton("구매내역");
		btnMyLotto.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnMyLotto.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnMyLotto, 35, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnMyLotto, -10, SpringLayout.EAST, pnl);
		btnMyLotto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new MyResultDialog(lottoProgram);
				System.out.println(lotto.buyNumberCollection.get(lotto.roundNum));
				dialog.setVisible(true);
				dialog.setTitle("결과확인");

			}
		});
		pnl.add(btnMyLotto);

		JButton btnreturn = new JButton("돌아가기");
		btnreturn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnreturn.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnMyLotto, 0, SpringLayout.NORTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 6, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnreturn, 35, SpringLayout.NORTH, pnl);
		pnl.add(btnreturn);
//       
		showRBall(lotto.winningNumberCollection.get(lotto.roundNum), ballApnl, sl_pnl, 10, 10);
		System.out.println("dsfd");
		System.out.println(lotto.winningNumberCollection.get(lotto.roundNum));

//		showRBall(lotto.winningNumberCollection.get(lotto.roundNum), pnl, sl_pnl, 10, 10);
		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);
			}
		});

		getContentPane().add(pnl);

		JButton btnNewButton = new JButton("<");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton, 153, SpringLayout.SOUTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton, -336, SpringLayout.SOUTH, pnl);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				int tempNum = lotto.roundNum;
				tempNum--;

				if (tempNum <= 0) {
					JOptionPane.showMessageDialog(null, "이전 회차가 없습니다.", "알림", JOptionPane.WARNING_MESSAGE);
				} else {
					removeBalls(ballApnl);

					showRBall(lotto.winningNumberCollection.get(tempNum), ballApnl, sl_pnl, 10, 10);
					lblNewLabel.setText("제" + String.valueOf(tempNum) + "회");

				}
			}
		});
		pnl.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(">");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_1, 153, SpringLayout.SOUTH, btnMyLotto);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, pnl);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				tempNum = lotto.roundNum;
				tempNum++;

				if (tempNum > lotto.roundNum) {
					JOptionPane.showMessageDialog(null, "다음 회차가 없습니다.", "알림", JOptionPane.WARNING_MESSAGE);
				} else {
					removeBalls(ballApnl);
					showRBall(lotto.winningNumberCollection.get(tempNum), ballApnl, sl_pnl, 10, 10);
					lblNewLabel.setText("제" + String.valueOf(tempNum) + "회");
				}

			}
		});
		pnl.add(btnNewButton_1);

		lblNewLabel_ = new JLabel("당첨 회차");

		JPanel panel = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, panel, 42, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, panel, 71, SpringLayout.WEST, pnl);
		pnl.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, panel_1);
		sl_pnl.putConstraint(SpringLayout.SOUTH, panel_1, -465, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, panel_1, 328, SpringLayout.WEST, pnl);
		pnl.add(panel_1);

		lblNewLabel = new JLabel("회차 출력");
		panel_1.add(lblNewLabel);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 335, SpringLayout.WEST, pnl);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setText("제" + lotto.roundNum + "회");

		JLabel label = new JLabel("로또 6/45");
		panel_1.add(label);
		sl_pnl.putConstraint(SpringLayout.NORTH, label, 67, SpringLayout.NORTH, pnl);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, label);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel, -8, SpringLayout.WEST, label);

		JPanel panel_2 = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, panel_2, 39, SpringLayout.SOUTH, ballApnl);
		sl_pnl.putConstraint(SpringLayout.WEST, panel_2, 102, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, panel_2, -78, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, panel_2, -101, SpringLayout.EAST, pnl);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnl.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("1등 당첨금");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(112, 55, 85, 15);
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 66, SpringLayout.NORTH, panel_2);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_3, 68, SpringLayout.WEST, panel_2);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 289, SpringLayout.NORTH, panel_2);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_3, 701, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("2등 당첨금");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_4.setBounds(112, 80, 85, 15);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("3등 당첨금");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_5.setBounds(112, 105, 85, 15);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("4등 당첨금");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_6.setBounds(112, 130, 85, 15);
		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("500,000,000");
		lblNewLabel_8.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(311, 57, 353, 15);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("3,000,000");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(338, 80, 353, 15);
		panel_2.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("100,000");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(349, 105, 353, 15);
		panel_2.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("50,000");
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(355, 130, 353, 15);
		panel_2.add(lblNewLabel_11);
		setSize(800, 600);
		setVisible(false);
	}

	public void showRBall(ArrayList<String> selectedNumbers, JPanel pnl, SpringLayout sl_pnl, int x, int y) {

		for (int i = 0; i < selectedNumbers.size(); i++) {
			String num = selectedNumbers.get(i);
			String path = "images/ball/ball_";
			String imagePath = "images/ball/ball_s_" + num + ".PNG";

			ImageIcon icon = new ImageIcon(imagePath);
			Image image = icon.getImage(); // Image 객체로 변환
			Image resizedImage = image.getScaledInstance(65, 64, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon resizedIcon = new ImageIcon(resizedImage); // 조정된 이미지로 새로운 아이콘 생성

			JLabel label = new JLabel(resizedIcon);
			sl_pnl.putConstraint(SpringLayout.NORTH, label, x, SpringLayout.NORTH, pnl);
			sl_pnl.putConstraint(SpringLayout.WEST, label, y + (i * 50), SpringLayout.EAST, pnl);
			pnl.add(label);

		}

	}

	public void removeBalls(JPanel pnl) {
		pnl.removeAll();
		pnl.revalidate();
		pnl.repaint();
	}
}
