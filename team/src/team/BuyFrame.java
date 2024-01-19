
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
import javax.swing.border.LineBorder;

import javafx.scene.control.ToggleButton;

import java.awt.Color;
import java.awt.Component;

public class BuyFrame extends JFrame {
	private LottoProgram lotto;
	public static ArrayList<JToggleButton> numberToggleButtons;
	public static ArrayList<String> selectedNumbers;
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
	private JButton btnAuto;
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
	private boolean autoSelected = false;
	private JButton btnNumReset;

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
				// 선택한 번호 초기화
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
			}
		});

		btnAuto = new JButton("자동선택");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnAuto, 6, SpringLayout.EAST, btnReset);
		pnl.add(btnAuto);
		// "자동선택" 버튼에 대한 ActionListener를 추가
		btnAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				autoSelected = true;
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
		toggleButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateD, 0, SpringLayout.WEST, lblStateA);
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
		btnPurchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnRetouchA = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchA, -4, SpringLayout.NORTH, lblA);
		pnl.add(btnRetouchA);
		btnRetouchA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        // 선택된 숫자들을 0번 인덱스의 resultBuy에 설정
		        lotto.resultBuy.set(0, selectedNumbers);
		        // 선택된 숫자에 해당하는 토글 버튼을 선택 상태로 설정
		        for (String number : selectedNumbers) {
		            int index = Integer.parseInt(number) - 1; // 토글 버튼은 0부터 시작하므로 1을 빼줍니다.
		            JToggleButton toggleButton = numberToggleButtons.get(index);
		            toggleButton.setSelected(true);
		        }
		    }
		});

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
				lblStateA.setText("");

//				lotto.resultBuy.set(0, new ArrayList<>());
				
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
				lblStateB.setText("");

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
				lblStateC.setText("");

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
				lblStateD.setText("");
				
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
				lblStateE.setText("");

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

		btnNumReset = new JButton("초기화");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNumReset, 0, SpringLayout.NORTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNumReset, -168, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNumReset, 0, SpringLayout.EAST, btnDeleteA);
		pnl.add(btnNumReset);
		btnNumReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckA.setText("");
				lblStateA.setText("");
				lblCheckB.setText("");
				lblStateB.setText("");
				lblCheckC.setText("");
				lblStateC.setText("");
				lblCheckD.setText("");
				lblStateD.setText("");
				lblCheckE.setText("");
				lblStateE.setText("");
			}
		});
		
		// 번호확인 버튼
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedNumbers = new ArrayList<>();
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
					if (lblStateA.getText().equals("") || lblCheckA.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckA.setText(result.toString());
						lblCheckA.setVisible(false);
//						lotto.resultBuy.add(new ArrayList<>());
						lotto.showBuyBall(pnl, sl_pnl, -100, selectedNumbers);
						lotto.resultBuy.set(0, selectedNumbers);
						System.out.println(lotto.resultBuy); // 콘솔확인용
						for (JToggleButton toggleButton : numberToggleButtons) {
			                toggleButton.setSelected(false);
			            }
						if (autoSelected && lblStateA.getText().equals("")) {
							lblStateA.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateA.setText("수동");
						} else {
							lblStateA.setText("반자동");
						}
						
					} else if (lblStateB.getText().equals("") || lblCheckB.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckB.setText(result.toString());
						lblCheckB.setVisible(false);
//						lotto.resultBuy.add(new ArrayList<>());
						lotto.showBuyBall(pnl, sl_pnl, -30, selectedNumbers);
						lotto.resultBuy.set(1, selectedNumbers);
						System.out.println(lotto.resultBuy);
						for (JToggleButton toggleButton : numberToggleButtons) {
			                toggleButton.setSelected(false);
			            }
						if (autoSelected && lblStateB.getText().equals("")) {
							lblStateB.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateB.setText("수동");
						} else {
							lblStateB.setText("반자동");
						}
					} else if (lblStateC.getText().equals("") || lblCheckC.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckC.setText(result.toString());
						lblCheckC.setVisible(false);
//						lotto.resultBuy.add(new ArrayList<>());
						lotto.showBuyBall(pnl, sl_pnl, 40, selectedNumbers);
						lotto.resultBuy.set(2, selectedNumbers);
						System.out.println(lotto.resultBuy);
						for (JToggleButton toggleButton : numberToggleButtons) {
			                toggleButton.setSelected(false);
						}
						
						
						if (autoSelected && lblStateC.getText().equals("")) {
							lblStateC.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateC.setText("수동");
						} else {
							lblStateC.setText("반자동");
						}
					} else if (lblStateD.getText().equals("") || lblCheckD.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckD.setText(result.toString());
						lblCheckD.setVisible(false);
//						lotto.resultBuy.add(ArrayList<>());
						lotto.showBuyBall(pnl, sl_pnl, 110, selectedNumbers);
						lotto.resultBuy.set(3, selectedNumbers);
						System.out.println(lotto.resultBuy);
						for (JToggleButton toggleButton : numberToggleButtons) {
			                toggleButton.setSelected(false);
						}
						if (autoSelected && lblStateD.getText().equals("")) {
							lblStateD.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateD.setText("수동");
						} else {
							lblStateD.setText("반자동");
						}
						
					} else if (lblStateE.getText().equals("") || lblCheckE.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckE.setText(result.toString());
						lblCheckE.setVisible(false);
						lotto.showBuyBall(pnl, sl_pnl, 180, selectedNumbers);
						lotto.resultBuy.set(4, selectedNumbers);
						System.out.println(lotto.resultBuy);
						for (JToggleButton toggleButton : numberToggleButtons) {
			                toggleButton.setSelected(false);
						}
						if (autoSelected && lblStateE.getText().equals("")) {
							lblStateE.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateE.setText("수동");
						} else {
							lblStateE.setText("반자동");
						}
						
					}
				} else {
					// 6개가 선택되지 않은 경우
					lblCheckA.setText("6개를 선택해야 합니다.");
//		            lblCheckB.setText("6개를 선택해야 합니다.");
//		            lblCheckC.setText("6개를 선택해야 합니다.");
//		            lblCheckD.setText("6개를 선택해야 합니다.");
//		            lblCheckE.setText("6개를 선택해야 합니다.");
				}
			}
		});

		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);

	}
}