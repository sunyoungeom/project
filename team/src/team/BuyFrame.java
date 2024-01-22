
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import sun.net.www.content.image.jpeg;

//import javafx.scene.control.ToggleButton;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;

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
	private JToggleButton toggleButton;
	private int autoSelectCount;
	public int countNum = 0; // 배열의 대한 숫자 0~4까지 
	public int numSelect = 0; // 직접 내가 누르는 번호의 개수
	private JComboBox comboBox;
	private JLabel lblBuyCount;
	private Map<Integer, JLabel[]> ballLabels;

	public BuyFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;

		if (lotto.resultBuy.get(0).size() != 0) {
			System.out.println("이미 구매한회차");
			 JOptionPane.showMessageDialog(null, "이미 구매한 회차 입니다.", "해당 회차 종료", JOptionPane.WARNING_MESSAGE);

		}
		JPanel pnl = new JPanel();
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);

		JPanel ballApnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballApnl, 90, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballApnl, 440, SpringLayout.WEST, pnl);
		pnl.add(ballApnl);

		JPanel ballBpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballBpnl, 160, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballBpnl, 440, SpringLayout.WEST, pnl);
		pnl.add(ballBpnl);

		JPanel ballCpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballCpnl, 230, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballCpnl, 440, SpringLayout.WEST, pnl);
		pnl.add(ballCpnl);

		JPanel ballDpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballDpnl, 300, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballDpnl, 440, SpringLayout.WEST, pnl);
		pnl.add(ballDpnl);

		JPanel ballEpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballEpnl, 370, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballEpnl, 440, SpringLayout.WEST, pnl);
		pnl.add(ballEpnl);

		btnreturn = new JButton("돌아가기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 29, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
		pnl.add(btnreturn);
		
		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);
				lotto.setRoundNum(lotto.getRoundNum() + 1);
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
		    	int selectedCount = 0;
		    	for (JToggleButton toggleButton : numberToggleButtons) {
		    		if (toggleButton.isSelected()) {
		    			selectedCount++;
		    		}
		    	}
		    	
		    	
		    	// 나머지 번호를 자동으로 선택
		    	if (selectedCount < autoSelectCount) {
		    		Random random = new Random();
		    		while (selectedCount < autoSelectCount) {
		    			int randomNumber = random.nextInt(45) + 1;
		    			if (!numberToggleButtons.get(randomNumber - 1).isSelected()) {
		    				numberToggleButtons.get(randomNumber - 1).setSelected(true);
		    				selectedCount++;
		    			}
		    		}
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

		lblStateA = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateA, 0, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateA, 25, SpringLayout.EAST, lblA);
		pnl.add(lblStateA);

		lblStateB = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateB, 0, SpringLayout.NORTH, lblB);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateB, 25, SpringLayout.EAST, lblB);
		pnl.add(lblStateB);

		lblStateC = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateC, 0, SpringLayout.NORTH, lblC);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateC, 24, SpringLayout.EAST, lblC);
		pnl.add(lblStateC);

		lblStateD = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateD, 0, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateD, 0, SpringLayout.WEST, lblStateA);
		pnl.add(lblStateD);

		lblStateE = new JLabel("미지정");
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
				System.out.println("대화 상자를 생성합니다.");
				JDialog dialog = new ResultDialog(lottoProgram);
				dialog.setVisible(true);

				System.out.println("출력 확인!!");
			}
		});

		btnRetouchA = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchA, -4, SpringLayout.NORTH, lblA);
		pnl.add(btnRetouchA);
		btnRetouchA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				countNum = 0;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
				lblCheckA.setText("");
				// 선택된 숫자들을 0번 인덱스의 resultBuy에 설정
//              lotto.resultBuy.set(0, selectedNumbers);
				ArrayList<String> selectAnumbers = lotto.resultBuy.get(0);
				// 선택된 숫자에 해당하는 토글 버튼을 선택 상태로 설정
				for (String number : selectAnumbers) {
					int index = Integer.parseInt(number) - 1; // 토글 버튼은 0부터 시작하므로 1을 빼줍니다.
					toggleButton = numberToggleButtons.get(index);
					toggleButton.setSelected(true);
				}

//              lblStateA.getText().equals("");
//              lotto.resultBuy.set(0, new ArrayList<>());

			}
		});

		btnRetouchB = new JButton("수정");
		btnRetouchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 1;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
				lblCheckB.setText("");
				// 선택된 숫자들을 0번 인덱스의 resultBuy에 설정
//              lotto.resultBuy.set(1, selectedNumbers);

				ArrayList<String> selectBnumbers = lotto.resultBuy.get(1);
				// 선택된 숫자에 해당하는 토글 버튼을 선택 상태로 설정
				for (String number : selectBnumbers) {
					int index = Integer.parseInt(number) - 1; // 토글 버튼은 0부터 시작하므로 1을 빼줍니다.
					toggleButton = numberToggleButtons.get(index);
					toggleButton.setSelected(true);
				}

//              lblStateA.getText().equals("");
//              lotto.resultBuy.set(1, new ArrayList<>());
			}
		});
		sl_pnl.putConstraint(SpringLayout.WEST, btnRetouchA, 0, SpringLayout.WEST, btnRetouchB);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchB, -132, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnRetouchB, 0, SpringLayout.SOUTH, lblB);
		pnl.add(btnRetouchB);

		btnRetouchC = new JButton("수정");
		btnRetouchC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 2;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
				lblCheckC.setText("");
				// 선택된 숫자들을 0번 인덱스의 resultBuy에 설정
//              lotto.resultBuy.set(2, selectedNumbers);
				ArrayList<String> selectCnumbers = lotto.resultBuy.get(2);
				// 선택된 숫자에 해당하는 토글 버튼을 선택 상태로 설정
				for (String number : selectCnumbers) {
					int index = Integer.parseInt(number) - 1; // 토글 버튼은 0부터 시작하므로 1을 빼줍니다.
					toggleButton = numberToggleButtons.get(index);
					toggleButton.setSelected(true);
				}
//              lblStateA.getText().equals("");
//              lotto.resultBuy.set(2, new ArrayList<>());
			}
		});
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnRetouchC, 0, SpringLayout.SOUTH, lblC);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchC, -132, SpringLayout.EAST, pnl);
		pnl.add(btnRetouchC);

		btnRetouchD = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchD, -4, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.WEST, btnRetouchD, 0, SpringLayout.WEST, btnRetouchA);
		btnRetouchD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 3;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
				lblCheckD.setText("");
				// 선택된 숫자들을 0번 인덱스의 resultBuy에 설정
				ArrayList<String> selectDnumbers = lotto.resultBuy.get(3);
				// 선택된 숫자에 해당하는 토글 버튼을 선택 상태로 설정
				for (String number : selectDnumbers) {
					int index = Integer.parseInt(number) - 1; // 토글 버튼은 0부터 시작하므로 1을 빼줍니다.
					toggleButton = numberToggleButtons.get(index);
					toggleButton.setSelected(true);
				}
//              lblStateA.getText().equals("");
//              lotto.resultBuy.set(3, new ArrayList<>());
			}

		});

		pnl.add(btnRetouchD);

		btnRetouchE = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchE, -4, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchE, 0, SpringLayout.EAST, btnRetouchA);
		btnRetouchE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 4;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
				lblCheckE.setText("");
				// 선택된 숫자들을 0번 인덱스의 resultBuy에 설정
				ArrayList<String> selectEnumbers = lotto.resultBuy.get(4);
				// 선택된 숫자에 해당하는 토글 버튼을 선택 상태로 설정
				for (String number : selectEnumbers) {
					int index = Integer.parseInt(number) - 1; // 토글 버튼은 0부터 시작하므로 1을 빼줍니다.
					toggleButton = numberToggleButtons.get(index);
					toggleButton.setSelected(true);
				}
//              lblStateA.getText().equals("");
//              lotto.resultBuy.set(4, new ArrayList<>());
			}
		});
		pnl.add(btnRetouchE);

		btnDeleteA = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteA, -4, SpringLayout.NORTH, lblA);
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteA, 6, SpringLayout.EAST, btnRetouchA);
		pnl.add(btnDeleteA);

		btnDeleteA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckA.setText("");
				lblStateA.setText("미지정");
				lotto.resultBuy.set(0, new ArrayList<>());
				countNum = 0;
				removeBalls(0, ballApnl, ballLabels);
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
				lblStateB.setText("미지정");
				lotto.resultBuy.set(1, new ArrayList<>());
				countNum = 1;
				removeBalls(1, ballBpnl, ballLabels);
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
				lblStateC.setText("미지정");
				lotto.resultBuy.set(2, new ArrayList<>());
				countNum = 2;
				removeBalls(2, ballCpnl, ballLabels);
			}
		});
		btnDeleteD = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteD, -4, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.EAST, btnDeleteD, 0, SpringLayout.EAST, btnDeleteA);
		pnl.add(btnDeleteD);
		btnDeleteD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckD.setText("");
				lblStateD.setText("미지정");
				lotto.resultBuy.set(3, new ArrayList<>());
				countNum = 3;
				removeBalls(3, ballDpnl, ballLabels);
			}
		});
		btnDeleteE = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteE, -4, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.EAST, btnDeleteE, 0, SpringLayout.EAST, btnDeleteA);
		pnl.add(btnDeleteE);
		btnDeleteE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCheckE.setText("");
				lblStateE.setText("미지정");
				lotto.resultBuy.set(4, new ArrayList<>());
				countNum = 4;
				removeBalls(4, ballEpnl, ballLabels);
			}
		});
		lblCheckA = new JLabel("ㅣㅏㅓㅣㅏ");
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
				lblStateA.setText("미지정");
				lotto.resultBuy.set(0, new ArrayList<>());

				lblCheckB.setText("");
				lblStateB.setText("미지정");
				lotto.resultBuy.set(1, new ArrayList<>());

				lblCheckC.setText("");
				lblStateC.setText("미지정");
				lotto.resultBuy.set(2, new ArrayList<>());

				lblCheckD.setText("");
				lblStateD.setText("미지정");
				lotto.resultBuy.set(3, new ArrayList<>());

				lblCheckE.setText("");
				lblStateE.setText("미지정");
				lotto.resultBuy.set(4, new ArrayList<>());

				// countNum을 -1로 재설정
				countNum = 0;
			}
		});
		
		comboBox = new JComboBox();
		sl_pnl.putConstraint(SpringLayout.WEST, comboBox, 26, SpringLayout.EAST, btnCheck);
		sl_pnl.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, lblStateA);
		pnl.add(comboBox);
		
		lblBuyCount = new JLabel("구매수량");
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblBuyCount, -50, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, lblBuyCount);
		sl_pnl.putConstraint(SpringLayout.EAST, lblBuyCount, 0, SpringLayout.EAST, lblStateA);
		pnl.add(lblBuyCount);
		

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
					for (JToggleButton toggleButton : numberToggleButtons) {
						toggleButton.setSelected(false);
					}

					if (btnDeleteA.isSelected() || btnDeleteB.isSelected() || btnDeleteC.isSelected()
							|| btnDeleteD.isSelected() || btnDeleteE.isSelected()) {
						if (lotto.resultBuy.get(0).size() == 0) {
							countNum = 0;
						} else if (lotto.resultBuy.get(1).size() == 0) {
							countNum = 1;
						} else if (lotto.resultBuy.get(2).size() == 0) {
							countNum = 2;
						} else if (lotto.resultBuy.get(3).size() == 0) {
							countNum = 3;
						} else if (lotto.resultBuy.get(4).size() == 0) {
							countNum = 4;
						}
					}

//               if (lblStateA.getText().equals("미지정") || lblCheckA.getText().equals("6개를 선택해야 합니다.")) {
					if (countNum == 0 || lblCheckA.getText().equals("6개를 선택해야 합니다.")) {
//                  if (lotto.resultBuy.get(0) == null || lblCheckA.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckA.setText(result.toString());
						lblCheckA.setVisible(false);
//                  lotto.showBuyBall(pnl, sl_pnl, -100, selectedNumbers);
						lotto.resultBuy.set(0, selectedNumbers);
						System.out.println(lotto.resultBuy);
						System.out.println(selectedNumbers.get(0));
						showBall(0, selectedNumbers, ballApnl, sl_pnl, -10, 50);
						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}

						if (autoSelected && lblStateA.getText().equals("미지정")) {
							lblStateA.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateA.setText("수동");
						} else {
							lblStateA.setText("반자동");
						}

						lotto.resultBuyTitle.set(0, lblStateA.getText());
//                  countNum++;
					} else if (countNum == 1 || lblCheckB.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckB.setText(result.toString());
						lblCheckB.setVisible(false);
//						lotto.showBuyBall(pnl, sl_pnl, -30, selectedNumbers);
						lotto.resultBuy.set(1, selectedNumbers);
						System.out.println(lotto.resultBuy);
						showBall(1, selectedNumbers, ballBpnl, sl_pnl, 60, 50);

						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}

						if (autoSelected && lblStateB.getText().equals("미지정")) {
							lblStateB.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateB.setText("수동");
						} else {
							lblStateB.setText("반자동");
						}

						lotto.resultBuyTitle.set(1, lblStateB.getText());
//                  countNum++;
					} else if (countNum == 2 || lblCheckC.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckC.setText(result.toString());
						lblCheckC.setVisible(false);
//						lotto.showBuyBall(pnl, sl_pnl, 40, selectedNumbers);
						lotto.resultBuy.set(2, selectedNumbers);
						System.out.println(lotto.resultBuy);
						showBall(2, selectedNumbers, ballCpnl, sl_pnl, 130, 50);

						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}
						if (autoSelected && lblStateC.getText().equals("미지정")) {
							lblStateC.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateC.setText("수동");
						} else {
							lblStateC.setText("반자동");
						}
						lotto.resultBuyTitle.set(2, lblStateC.getText());
//                  countNum++;
					} else if (countNum == 3 || lblCheckD.getText().equals("6개를 선택해야 합니다.")) {
						lblCheckD.setText(result.toString());
						lblCheckD.setVisible(false);
//						lotto.showBuyBall(pnl, sl_pnl, 110, selectedNumbers);
						lotto.resultBuy.set(3, selectedNumbers);
						System.out.println(lotto.resultBuy);
						showBall(3, selectedNumbers, ballDpnl, sl_pnl, 200, 50);

						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}
						if (autoSelected && lblStateD.getText().equals("미지정")) {
							lblStateD.setText("자동");
							autoSelected = false;
						} else if (!autoSelected) { // () = true
							lblStateD.setText("수동");
						} else {
							lblStateD.setText("반자동");
						}
						lotto.resultBuyTitle.set(3, lblStateD.getText());
//                  countNum++;
					} else if (countNum == 4 || lblCheckE.getText().equals("6개를 선택해야 합니다.")) {
						if (lotto.resultBuy.get(4).size() == 0 || lotto.resultBuy.get(4).size() == 6) {
							lblCheckE.setText(selectedNumbers.toString());
							lblCheckE.setVisible(false);
//							lotto.showBuyBall(pnl, sl_pnl, 180, selectedNumbers);
							lotto.resultBuy.set(4, selectedNumbers);
							System.out.println(lotto.resultBuy);
							showBall(4, selectedNumbers, ballEpnl, sl_pnl, 270, 50);
							
							for (JToggleButton toggleButton : numberToggleButtons) {
								toggleButton.setSelected(false);
							}

							if (autoSelected && lblStateE.getText().equals("미지정")) {
								lblStateE.setText("자동");
								autoSelected = false;
							} else if (!autoSelected) { // () = true
								lblStateE.setText("수동");
							} else {
								lblStateE.setText("반자동");
							}

							lotto.resultBuyTitle.set(4, lblStateE.getText());

						}
					} else {
						// 6개가 선택되지 않은 경우
						lblCheckA.setText("6개를 선택해야 합니다.");
					}

					for (int j = 0; j < 4; j++) {
						if (lotto.resultBuy.get(j + 1).size() == 0) {
							countNum = j + 1;
							break;
						}
					}
				}
			}
		});
		ballApnl.setBounds(500, 300, 200, 50);
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);

	}
	public Map<Integer, JLabel[]> showBall(int countNum, ArrayList<String> selectedNumbers, JPanel pnl, SpringLayout sl_pnl, int x, int y) {
		ballLabels = new HashMap<>();
		JLabel[] labels = ballLabels.get(countNum);

		if (labels == null) {
			labels = new JLabel[selectedNumbers.size()];
		}

		for (int i = 0; i < selectedNumbers.size(); i++) {
			String num = selectedNumbers.get(i);
			String path = "images/ball/ball_";
			String imagePath = "images/ball/ball_" + num + ".PNG";

			ImageIcon icon = new ImageIcon(imagePath);
			Image image = icon.getImage(); // Image 객체로 변환
			Image resizedImage = image.getScaledInstance(54, 40, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon resizedIcon = new ImageIcon(resizedImage); // 조정된 이미지로 새로운 아이콘 생성

			JLabel label = new JLabel(resizedIcon);
			sl_pnl.putConstraint(SpringLayout.NORTH, label, x, SpringLayout.NORTH, lblA);
			sl_pnl.putConstraint(SpringLayout.WEST, label, y + (i * 50), SpringLayout.EAST, lblStateA);
			pnl.add(label);
			labels[i] = label;
		}

		ballLabels.put(countNum, labels);
		return ballLabels;
	}

	public void removeBalls(int key, JPanel pnl, Map<Integer, JLabel[]> ballLabels) {
		JLabel[] labelsArray = ballLabels.get(key);
		pnl.removeAll();
		pnl.revalidate();
		pnl.repaint();
	}
}
