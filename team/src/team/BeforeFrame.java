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
	private JTextField textField;
	private int tempNum; // 비교를 위한 변수 
	private JLabel lblNewLabel_;
	private JLabel lblNewLabel;

	public BeforeFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
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
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_1, -350, SpringLayout.EAST, pnl);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		LocalDateTime nowDT = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = nowDT.format(formatter);

        lblNewLabel_1.setText(formattedDate);
		pnl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("당첨번호");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_2, -363, SpringLayout.EAST, pnl);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		pnl.add(lblNewLabel_2);
		
		
		JButton btnMyLotto = new JButton("구매내역");
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
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
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
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, pnl);
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
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_1);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, pnl);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				tempNum = lotto.roundNum;
				tempNum++;
				
				if (tempNum > lotto.roundNum) {
					JOptionPane.showMessageDialog(null, "다음 회차가 없습니다.", "알림", JOptionPane.WARNING_MESSAGE);
				}else {
					removeBalls(ballApnl);
					showRBall(lotto.winningNumberCollection.get(tempNum), ballApnl, sl_pnl, 10, 10);
					lblNewLabel.setText("제" + String.valueOf(tempNum) + "회");
				}
				
				
					
			}
		});
		pnl.add(btnNewButton_1);

		textField = new JTextField();
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, -1, SpringLayout.NORTH, textField);
		sl_pnl.putConstraint(SpringLayout.NORTH, textField, 7, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnMyLotto, 6, SpringLayout.SOUTH, textField);
		sl_pnl.putConstraint(SpringLayout.EAST, textField, -44, SpringLayout.EAST, pnl);
		pnl.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(lotto.roundNum));

		lblNewLabel_ = new JLabel("당첨 회차");

		JButton btnNewButton_2 = new JButton("확인");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_1, 92, SpringLayout.SOUTH, btnNewButton_2);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_2, 16, SpringLayout.SOUTH, btnMyLotto);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_2, -28, SpringLayout.EAST, pnl);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(lotto.winningNumberCollection.get(lotto.roundNum));
//				String roundInfo = textField.getText();
//				int round = Integer.parseInt(roundInfo);
//				System.out.println(lotto.winningNumberCollection.get(round));
			}
		});
		pnl.add(btnNewButton_2);
		
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
		sl_pnl.putConstraint(SpringLayout.EAST, label, -234, SpringLayout.WEST, btnNewButton_2);
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
		lblNewLabel_3.setBounds(50, 30, 85, 15);
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 66, SpringLayout.NORTH, panel_2);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_3, 68, SpringLayout.WEST, panel_2);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 289, SpringLayout.NORTH, panel_2);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_3, 701, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("2등 당첨금");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_4.setBounds(50, 55, 85, 15);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("3등 당첨금");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_5.setBounds(50, 86, 85, 15);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("4등 당첨금");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_6.setBounds(50, 111, 85, 15);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("5등 당첨금");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_7.setBounds(50, 147, 85, 15);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("500,000,000");
		lblNewLabel_8.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(409, 32, 353, 15);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("3,000,000");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(419, 55, 353, 15);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("100,000");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(429, 86, 353, 15);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("50,000");
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(147, 124, 353, 15);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("5,000");
		lblNewLabel_12.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(147, 147, 353, 15);
		panel_2.add(lblNewLabel_12);
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
