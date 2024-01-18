
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
	private JLabel lblCheckA;
	private JLabel lblCheckB;
	private JLabel lblCheckC;
	private JLabel lblCheckD;
	private JLabel lblCheckE;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblD;
	private JLabel lblE;
	private JLabel lblStateA;
	private JLabel lblStateB;
	private JLabel lblStateC;
	private JLabel lblStateD;
	private JLabel lblStateE;
	private JToggleButton btnAuto;
	private JButton btnReset;
	private JButton btnreturn;
	private JButton btnDeleteA;
	private JButton btnRetouchD;
	private JButton btnRetouchE;
	private JButton btnRetouchC;
	private JButton btnRetouchB;
	private JButton btnRetouchA;
	private JButton btnPurchase;
	private JButton btnDeleteB;
	private JButton btnDeleteC;
	private JButton btnDeleteD;
	private JButton btnDeleteE;
	private JButton btnCheck;
	private JPanel toggleButtonPanel;
	public BuyFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;

		JPanel pnl = new JPanel();
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);
		
		btnreturn = new JButton("돌아가기");
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
		
		
		btnReset = new JButton("초기화");
		sl_pnl.putConstraint(SpringLayout.WEST, btnReset, 0, SpringLayout.WEST, btnreturn);
		sl_pnl.putConstraint(SpringLayout.EAST, btnReset, 0, SpringLayout.EAST, btnreturn);
		pnl.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		

		btnAuto = new JToggleButton("자동선택");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnAuto, 6, SpringLayout.EAST, btnReset);
		pnl.add(btnAuto);
		// "자동선택" 버튼에 대한 ActionListener를 추가
		btnAuto.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // 자동으로 선택할 번호 개수
		        int autoSelectCount = SELECTED_NUMBER;
		        // 선택된 번호 초기화
		        for (JToggleButton toggleButton : numberToggleButtons) {
		            toggleButton.setSelected(false);
		        }
		        // Random 객체 생성
		        Random random = new Random();
		        // 중복을 피하기 위해 HashSet을 사용하여 선택된 번호를 저장
		        Set<Integer> selectedNumbers = new HashSet<>();
		        // 자동으로 선택할 번호를 무작위로 선택
		        while (selectedNumbers.size() < autoSelectCount) {
		            int randomNumber = random.nextInt(45) + 1;
		            selectedNumbers.add(randomNumber);
		        }
		        // 선택된 번호를 토글 버튼에 반영
		        for (Integer number : selectedNumbers) {
		            numberToggleButtons.get(number - 1).setSelected(true);
		        }
		        }
		    
		});

		btnCheck = new JButton("번호확인");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnCheck, 0, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnCheck, 6, SpringLayout.EAST, btnAuto);
		pnl.add(btnCheck);
		
		
		toggleButtonPanel = new JPanel();
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
		
		lblA = new JLabel("A");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblA, 107, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblA, 37, SpringLayout.EAST, toggleButtonPanel);
		pnl.add(lblA);
		
		lblB = new JLabel("B");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblB, 54, SpringLayout.SOUTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, lblB, 0, SpringLayout.WEST, lblA);
		pnl.add(lblB);
		
		lblC = new JLabel("C");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblC, 56, SpringLayout.SOUTH, lblB);
		sl_pnl.putConstraint(SpringLayout.WEST, lblC, 0, SpringLayout.WEST, lblA);
		pnl.add(lblC);
		
		lblD = new JLabel("D");
		sl_pnl.putConstraint(SpringLayout.WEST, lblD, 0, SpringLayout.WEST, lblA);
		pnl.add(lblD);
		
		lblE = new JLabel("E");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblE, 389, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblD, -55, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.WEST, lblE, 0, SpringLayout.WEST, lblA);
		pnl.add(lblE);
		
		lblStateA = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateA, 0, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateA, 25, SpringLayout.EAST, lblA);
		pnl.add(lblStateA);
		
		lblStateB = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateB, 0, SpringLayout.NORTH, lblB);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateB, 25, SpringLayout.EAST, lblB);
		pnl.add(lblStateB);
		
		lblStateC = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateC, 0, SpringLayout.NORTH, lblC);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateC, 24, SpringLayout.EAST, lblC);
		pnl.add(lblStateC);
		
		lblStateD = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateD, 0, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.EAST, lblStateD, 0, SpringLayout.EAST, lblStateA);
		pnl.add(lblStateD);
		
		lblStateE = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateE, 0, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateE, 0, SpringLayout.WEST, lblStateA);
		pnl.add(lblStateE);
		
		btnPurchase = new JButton("구매하기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnPurchase, -12, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnPurchase, -425, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnPurchase, 23, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.EAST, btnPurchase, -312, SpringLayout.EAST, pnl);
		btnPurchase.setBackground(Color.WHITE);
		pnl.add(btnPurchase);
		
		btnRetouchA = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchA, -4, SpringLayout.NORTH, lblA);
		pnl.add(btnRetouchA);
		
		btnRetouchB = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.WEST, btnRetouchA, 0, SpringLayout.WEST, btnRetouchB);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchB, -132, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnRetouchB, 0, SpringLayout.SOUTH, lblB);
		pnl.add(btnRetouchB);
		
		btnRetouchC = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnRetouchC, 0, SpringLayout.SOUTH, lblC);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchC, -132, SpringLayout.EAST, pnl);
		pnl.add(btnRetouchC);
		
		btnRetouchD = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnRetouchD, 0, SpringLayout.SOUTH, lblE);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchD, -132, SpringLayout.EAST, pnl);
		pnl.add(btnRetouchD);
		
		btnRetouchE = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnRetouchE, 0, SpringLayout.SOUTH, lblD);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchE, -132, SpringLayout.EAST, pnl);
		pnl.add(btnRetouchE);
		
		btnDeleteA = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteA, -4, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteA, 6, SpringLayout.EAST, btnRetouchA);
		pnl.add(btnDeleteA);
		
		btnDeleteA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckA.setText("");
			}
		});
		
		btnDeleteB = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteB, 6, SpringLayout.EAST, btnRetouchB);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnDeleteB, 0, SpringLayout.SOUTH, lblB);
		pnl.add(btnDeleteB);
		btnDeleteB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckB.setText("");
			}
		});
		
		btnDeleteC = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteC, 6, SpringLayout.EAST, btnRetouchC);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnDeleteC, 0, SpringLayout.SOUTH, lblC);
		pnl.add(btnDeleteC);
		btnDeleteC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckC.setText("");
			}
		});
		btnDeleteD = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteD, 0, SpringLayout.NORTH, btnRetouchE);
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteD, 6, SpringLayout.EAST, btnRetouchE);
		pnl.add(btnDeleteD);
		btnDeleteD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckD.setText("");
			}
		});
		btnDeleteE = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnDeleteE, 0, SpringLayout.SOUTH, lblE);
		sl_pnl.putConstraint(SpringLayout.EAST, btnDeleteE, 0, SpringLayout.EAST, btnDeleteA);
		pnl.add(btnDeleteE);
		btnDeleteE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckE.setText("");
			}
		});
		lblCheckA = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckA, 0, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckA, 137, SpringLayout.EAST, lblStateA);
		pnl.add(lblCheckA);
		
		lblCheckB = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckB, 0, SpringLayout.NORTH, lblB);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckB, 0, SpringLayout.WEST, lblCheckA);
		pnl.add(lblCheckB);
		
		lblCheckC = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckC, 0, SpringLayout.NORTH, lblC);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckC, 0, SpringLayout.WEST, lblCheckA);
		pnl.add(lblCheckC);
		
		lblCheckD = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckD, 0, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckD, 0, SpringLayout.WEST, lblCheckA);
		pnl.add(lblCheckD);
		
		lblCheckE = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckE, 0, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckE, 0, SpringLayout.WEST, lblCheckA);
		pnl.add(lblCheckE);
		
		btnCheck.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ArrayList<String> selectedNumbers = new ArrayList<>();
		        boolean isAutoSelected = false;

		        for (JToggleButton toggleButton : numberToggleButtons) {
		            if (toggleButton.isSelected()) {
		                selectedNumbers.add(toggleButton.getText());
		            }
		        }

		        // Check if numbers were selected automatically
		        for (JToggleButton toggleButton : numberToggleButtons) {
		            if (toggleButton.isSelected() && toggleButton.getBackground() != Color.WHITE) {
		                isAutoSelected = true;
		                break;
		            }
		        }

		        if (selectedNumbers.size() == SELECTED_NUMBER) {
		            // 6개가 선택된 경우
		            StringBuilder result = new StringBuilder();
		            for (String number : selectedNumbers) {
		                result.append(number).append(" ");
		            }
		            if (isAutoSelected) {
		                lblStateA.setText("자동");
		            }
		            if (lblCheckA.getText().equals("")) {
		                lblCheckA.setText(result.toString());
		            } else if (lblCheckB.getText().equals("")) {
		                lblCheckB.setText(result.toString());
		            } else if (lblCheckC.getText().equals("")) {
		                lblCheckC.setText(result.toString());
		            } else if (lblCheckD.getText().equals("")) {
		                lblCheckD.setText(result.toString());
		            } else if (lblCheckE.getText().equals("")) {
		                lblCheckE.setText(result.toString());
		            }
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