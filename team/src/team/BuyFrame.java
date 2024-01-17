
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Component;

public class BuyFrame extends JFrame {
	private LottoProgram lotto;
	private ArrayList<JToggleButton> numberToggleButtons;
	private int SELECTED_NUMBER = 6;
	public BuyFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;

		JPanel pnl = new JPanel();
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);
		
		JButton btnreturn = new JButton("돌아가기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 29, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
		pnl.add(btnreturn);
		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);
			}
		});
		
		
		JButton btnReset = new JButton("초기화");
		sl_pnl.putConstraint(SpringLayout.WEST, btnReset, 0, SpringLayout.WEST, btnreturn);
		sl_pnl.putConstraint(SpringLayout.EAST, btnReset, 0, SpringLayout.EAST, btnreturn);
		pnl.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		

		JButton btnNewButton_1 = new JButton("자동선택");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnReset);
		pnl.add(btnNewButton_1);

		JButton btnCheck = new JButton("번호확인");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnCheck, 0, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnCheck, 6, SpringLayout.EAST, btnNewButton_1);
		pnl.add(btnCheck);
		
		
		JPanel toggleButtonPanel = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, btnReset, 21, SpringLayout.SOUTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.NORTH, toggleButtonPanel, 11, SpringLayout.SOUTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.SOUTH, toggleButtonPanel, -66, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, toggleButtonPanel, -667, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, toggleButtonPanel, 10, SpringLayout.WEST, pnl);
		pnl.add(toggleButtonPanel);
		toggleButtonPanel.setLayout(new GridLayout(9, 5, 15, 15));
		
		numberToggleButtons = new ArrayList<>();
		
		for (int i = 1; i <= 45; i++) {
			JToggleButton toggleButton = new JToggleButton();
			toggleButton.setText(String.valueOf(i));
			toggleButton.setBackground(Color.white);
			numberToggleButtons.add(toggleButton);
			toggleButton.addActionListener(new ActionListener() {
				 @Override
			        public void actionPerformed(ActionEvent e) {
			            int selectedCount = 0;
			            for (Component component : toggleButtonPanel.getComponents()) {
			                if (component instanceof JToggleButton) {
			                    JToggleButton btn = (JToggleButton) component;
			                    if (btn.isSelected()) {
			                        selectedCount++;
			                    }
			                }
			            }
			            if (selectedCount > SELECTED_NUMBER) {
			                toggleButton.setSelected(false);
			            }
			        }
			});
			toggleButtonPanel.add(toggleButton);
		}
		
		JLabel lblA = new JLabel("A");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblA, 107, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblA, 37, SpringLayout.EAST, toggleButtonPanel);
		pnl.add(lblA);
		
		JLabel lblB = new JLabel("B");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblB, 54, SpringLayout.SOUTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, lblB, 0, SpringLayout.WEST, lblA);
		pnl.add(lblB);
		
		JLabel lblC = new JLabel("C");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblC, 56, SpringLayout.SOUTH, lblB);
		sl_pnl.putConstraint(SpringLayout.WEST, lblC, 0, SpringLayout.WEST, lblA);
		pnl.add(lblC);
		
		JLabel lblD = new JLabel("D");
		sl_pnl.putConstraint(SpringLayout.WEST, lblD, 0, SpringLayout.WEST, lblA);
		pnl.add(lblD);
		
		JLabel lblE = new JLabel("E");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblE, 389, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblD, -55, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.WEST, lblE, 0, SpringLayout.WEST, lblA);
		pnl.add(lblE);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_1, 25, SpringLayout.EAST, lblA);
		pnl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 0, SpringLayout.NORTH, lblB);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 25, SpringLayout.EAST, lblB);
		pnl.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 0, SpringLayout.NORTH, lblC);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 24, SpringLayout.EAST, lblC);
		pnl.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3, 0, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_1_3, 0, SpringLayout.EAST, lblNewLabel_1);
		pnl.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1_4, 0, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_1_4, 0, SpringLayout.WEST, lblNewLabel_1);
		pnl.add(lblNewLabel_1_4);
		
		JButton btnPurchase = new JButton("구매하기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnPurchase, -12, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnPurchase, -425, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnPurchase, 23, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.EAST, btnPurchase, -312, SpringLayout.EAST, pnl);
		btnPurchase.setBackground(Color.WHITE);
		pnl.add(btnPurchase);
		
		JButton btnNewButton_4 = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_4, -4, SpringLayout.NORTH, lblA);
		pnl.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btnNewButton_4_1);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_4_1, -132, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_4_1, 0, SpringLayout.SOUTH, lblB);
		pnl.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_4_2, 0, SpringLayout.SOUTH, lblC);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_4_2, -132, SpringLayout.EAST, pnl);
		pnl.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_4 = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_4_4, 0, SpringLayout.SOUTH, lblE);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_4_4, -132, SpringLayout.EAST, pnl);
		pnl.add(btnNewButton_4_4);
		
		JButton btnNewButton_4_3 = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_4_3, 0, SpringLayout.SOUTH, lblD);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_4_3, -132, SpringLayout.EAST, pnl);
		pnl.add(btnNewButton_4_3);
		
		JButton btnNewButton_4_5 = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_4_5, -4, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton_4_5, 6, SpringLayout.EAST, btnNewButton_4);
		pnl.add(btnNewButton_4_5);
		
		JButton btnNewButton_4_6 = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton_4_6, 6, SpringLayout.EAST, btnNewButton_4_1);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_4_6, 0, SpringLayout.SOUTH, lblB);
		pnl.add(btnNewButton_4_6);
		
		JButton btnNewButton_4_7 = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton_4_7, 6, SpringLayout.EAST, btnNewButton_4_2);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_4_7, 0, SpringLayout.SOUTH, lblC);
		pnl.add(btnNewButton_4_7);
		
		JButton btnNewButton_4_8 = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton_4_8, 0, SpringLayout.NORTH, btnNewButton_4_3);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton_4_8, 6, SpringLayout.EAST, btnNewButton_4_3);
		pnl.add(btnNewButton_4_8);
		
		JButton btnNewButton_4_9 = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNewButton_4_9, 0, SpringLayout.SOUTH, lblE);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNewButton_4_9, 0, SpringLayout.EAST, btnNewButton_4_5);
		pnl.add(btnNewButton_4_9);
		
		JLabel lblCheckA = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckA, 0, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckA, 137, SpringLayout.EAST, lblNewLabel_1);
		pnl.add(lblCheckA);
		
		btnCheck.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ArrayList<String> selectedNumbers = new ArrayList<>();
		        for (JToggleButton toggleButton : numberToggleButtons) {
		            if (toggleButton.isSelected()) {
		                selectedNumbers.add(toggleButton.getText());
		            }
		        }
		        if (selectedNumbers.size() == SELECTED_NUMBER) {
		            // 6개가 선택된 경우
		            StringBuilder result = new StringBuilder();
		            for (String number : selectedNumbers) {
		                result.append(number).append(" ");
		            }
		            lblCheckA.setText(result.toString());
		        } else {
		            // 6개가 선택되지 않은 경우
		            lblCheckA.setText("6개를 선택해야 합니다.");
		        }
		    }
		});


		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);

	}
}