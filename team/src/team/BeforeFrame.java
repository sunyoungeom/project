import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class BeforeFrame extends JFrame {
	private LottoProgram lotto;
	private JTextField textField;
	private int tempNum = 0; // 비교를 위한 변수 

	public BeforeFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		tempNum = lotto.roundNum;
		JPanel pnl = new JPanel();
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);

		JPanel ballApnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballApnl, 216, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballApnl, 90, SpringLayout.WEST, pnl);
		pnl.add(ballApnl);
		
		JLabel label = new JLabel("로또 6/45");
		sl_pnl.putConstraint(SpringLayout.NORTH, label, 67, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, label, 313, SpringLayout.WEST, pnl);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl.add(label);
		
		JLabel lblNewLabel = new JLabel("회차 출력");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, label);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, label);
		lblNewLabel.setText("제" + lotto.roundNum + "회");
		pnl.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("0000-00-00 추첨");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 20, SpringLayout.SOUTH, label);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_1, 359, SpringLayout.WEST, pnl);
		pnl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("당첨번호");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 27, SpringLayout.SOUTH, lblNewLabel_1);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		pnl.add(lblNewLabel_2);
		
		
		JButton btnMyLotto = new JButton("나의 기록?");
		btnMyLotto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new RecordDialog(lottoProgram);
				dialog.setVisible(true);
				dialog.setTitle("결과확인");
				
			}
		});
		sl_pnl.putConstraint(SpringLayout.NORTH, btnMyLotto, 10, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnMyLotto, 300, SpringLayout.WEST, pnl);
		pnl.add(btnMyLotto);
		
		
		
		JButton btnreturn = new JButton("돌아가기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 1, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
		pnl.add(btnreturn);
//       
		showRBall(lotto.winningNumberCollection.get(lotto.roundNum), ballApnl, sl_pnl, 10, 10);

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				int tempNum = lotto.roundNum;
				tempNum--;
				
			if (tempNum <= 0) {
				JOptionPane.showMessageDialog(null, "이전 회차가 없습니다.", "알림", JOptionPane.WARNING_MESSAGE);
			} else {
				removeBalls(ballApnl);
				
				showRBall(lotto.winningNumberCollection.get(tempNum), ballApnl, sl_pnl, 10, 10);
				textField.setText(String.valueOf(tempNum));
			}
			}
		});
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton, 203, SpringLayout.SOUTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, pnl);
		pnl.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(">");
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
					textField.setText(String.valueOf(tempNum));
				}
				
				
					
			}
		});
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, pnl);
		pnl.add(btnNewButton_1);

		textField = new JTextField();
		sl_pnl.putConstraint(SpringLayout.NORTH, textField, 94, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, textField, 310, SpringLayout.WEST, pnl);
		pnl.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(lotto.roundNum));

		JLabel lblNewLabel_ = new JLabel("당첨 회차");
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, textField);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, textField);
		pnl.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("확인");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(lotto.winningNumberCollection.get(lotto.roundNum));
//				String roundInfo = textField.getText();
//				int round = Integer.parseInt(roundInfo);
//				System.out.println(lotto.winningNumberCollection.get(round));
			}
		});
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, textField);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton_2, 7, SpringLayout.EAST, textField);
		pnl.add(btnNewButton_2);
		setSize(800, 600);
		setVisible(false);
	}
	public void showRBall(ArrayList<String> selectedNumbers, JPanel pnl, SpringLayout sl_pnl, int x, int y) {

		for (int i = 0; i < selectedNumbers.size(); i++) {
			String num = selectedNumbers.get(i);
			String path = "images/ball/ball_";
			String imagePath = "images/ball/ball_" + num + ".PNG";

			ImageIcon icon = new ImageIcon(imagePath);
			Image image = icon.getImage(); // Image 객체로 변환
			Image resizedImage = image.getScaledInstance(86, 64, Image.SCALE_SMOOTH); // 크기 조정
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
