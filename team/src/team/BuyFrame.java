
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
import java.awt.Font;

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
		pnl.setBackground(Color.WHITE);
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);

		JPanel ballEpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballEpnl, 411, SpringLayout.NORTH, pnl);
		ballEpnl.setBackground(Color.WHITE);
		pnl.add(ballEpnl);
		
		JPanel ballBpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballBpnl, 196, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballBpnl, 50, SpringLayout.EAST, ballEpnl); // Adjust the offset value
		ballBpnl.setBackground(Color.WHITE);
		pnl.add(ballBpnl);

		JPanel ballApnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.WEST, ballApnl, 0, SpringLayout.WEST, ballEpnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, ballApnl, -22, SpringLayout.NORTH, ballBpnl);
		ballApnl.setBackground(Color.WHITE);
		pnl.add(ballApnl);

		JPanel ballCpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.SOUTH, ballCpnl, -244, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballCpnl, 0, SpringLayout.WEST, ballEpnl);
		ballCpnl.setBackground(Color.WHITE);
		pnl.add(ballCpnl);

		JPanel ballDpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballDpnl, 21, SpringLayout.SOUTH, ballCpnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballDpnl, 0, SpringLayout.WEST, ballEpnl);
		ballDpnl.setBackground(Color.WHITE);
		pnl.add(ballDpnl);

		btnreturn = new JButton("돌아가기");
		btnreturn.setBackground(Color.WHITE);
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
		btnReset.setBackground(Color.WHITE);
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
		btnAuto.setBackground(Color.WHITE);
		btnAuto.setForeground(Color.BLACK);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnAuto, 6, SpringLayout.EAST, btnReset);
		pnl.add(btnAuto);
		// "자동선택" 버튼에 대한 ActionListener를 추가
		btnAuto.addActionListener(new ActionListener() {
			private Random random;
			private int numSelect;

			@Override
			public void actionPerformed(ActionEvent e) {
				autoSelected = true;
				int autoSelectCount = SELECTED_NUMBER;
				numSelect = 0;
				for (JToggleButton toggleButton : numberToggleButtons) {
					if (toggleButton.isSelected()) {
						numSelect++; // 내가 누르는 번호의 개수
					}
				}
				// 나머지 번호를 자동으로 선택 (반자동)
				if (numSelect < autoSelectCount) {
					random = new Random();
					while (numSelect < autoSelectCount) {
						int randomNumber = random.nextInt(45) + 1;
						if (!numberToggleButtons.get(randomNumber - 1).isSelected()) {
							numberToggleButtons.get(randomNumber - 1).setSelected(true);
							numSelect++;
						}
					}
				} // 자동
				else if (numSelect == 0 || autoSelectCount == 6) {
					random = new Random();
					for (JToggleButton toggleButton : numberToggleButtons) {
						toggleButton.setSelected(false);
					}
					numSelect = 0; // 버튼 초기화
					while (numSelect < autoSelectCount) {
						int randomNumber = random.nextInt(45) + 1;
						if (!numberToggleButtons.get(randomNumber - 1).isSelected()) {
							numberToggleButtons.get(randomNumber - 1).setSelected(true);
							numSelect++;
						}
					}
				}
			}
		});

		btnCheck = new JButton("번호확인");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnCheck, 0, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnCheck, 6, SpringLayout.EAST, btnAuto);
		pnl.add(btnCheck);
		btnCheck.setOpaque(false);
		btnCheck.setContentAreaFilled(false);

		toggleButtonPanel = new JPanel();
		toggleButtonPanel.setBackground(Color.WHITE);
		toggleButtonPanel.setBorder(new LineBorder(Color.DARK_GRAY));
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
			toggleButton.setOpaque(false);
			toggleButton.setContentAreaFilled(false);
			toggleButton.setForeground(Color.darkGray);
			toggleButton.setBackground(Color.white);
			toggleButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int selectedCount = 0;
					// 토글 버튼을 누를 때마다 선택된 토글 버튼의 개수를 세기
					for (Component component : toggleButtonPanel.getComponents()) {
						if (component instanceof JToggleButton) {
							JToggleButton btn = (JToggleButton) component;
							if (btn.isSelected()) {
								selectedCount++;
							}
						}
						if (selectedCount > SELECTED_NUMBER) {
							toggleButton.setSelected(false);
						}
					}
					// 여기서 numSelect 값을 업데이트
					numSelect = selectedCount;
				}
			});
			toggleButton.setOpaque(true);
			toggleButton.setContentAreaFilled(true);
			toggleButtonPanel.add(toggleButton);
		}

		lblA = new JLabel("A");
		sl_pnl.putConstraint(SpringLayout.EAST, lblA, -596, SpringLayout.EAST, pnl);
		lblA.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pnl.add(lblA);

		lblB = new JLabel("B");
		sl_pnl.putConstraint(SpringLayout.EAST, lblB, -596, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblA, -51, SpringLayout.NORTH, lblB);
		lblB.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pnl.add(lblB);

		lblC = new JLabel("C");
		sl_pnl.putConstraint(SpringLayout.NORTH, ballCpnl, 0, SpringLayout.NORTH, lblC);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblB, -46, SpringLayout.NORTH, lblC);
		sl_pnl.putConstraint(SpringLayout.WEST, lblC, 0, SpringLayout.WEST, lblA);
		lblC.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pnl.add(lblC);

		lblD = new JLabel("D");
		sl_pnl.putConstraint(SpringLayout.WEST, ballDpnl, 93, SpringLayout.EAST, lblD);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblD, -188, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblC, -51, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.WEST, lblD, 0, SpringLayout.WEST, lblA);
		lblD.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pnl.add(lblD);

		lblE = new JLabel("E");
		sl_pnl.putConstraint(SpringLayout.WEST, ballEpnl, 97, SpringLayout.EAST, lblE);
		sl_pnl.putConstraint(SpringLayout.NORTH, lblE, 43, SpringLayout.SOUTH, lblD);
		sl_pnl.putConstraint(SpringLayout.WEST, lblE, 0, SpringLayout.WEST, lblA);
		lblE.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pnl.add(lblE);

		lblStateA = new JLabel("미지정");
		lblStateA.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pnl.add(lblStateA);

		lblStateB = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblStateA, -36, SpringLayout.NORTH, lblStateB);
		sl_pnl.putConstraint(SpringLayout.EAST, lblStateA, 0, SpringLayout.EAST, lblStateB);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateB, 408, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballBpnl, 29, SpringLayout.EAST, lblStateB);
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateB, 5, SpringLayout.NORTH, lblB);
		lblStateB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pnl.add(lblStateB);

		lblStateC = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateC, 20, SpringLayout.EAST, lblC);
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateC, 5, SpringLayout.NORTH, lblC);
		lblStateC.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pnl.add(lblStateC);

		lblStateD = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateD, 5, SpringLayout.NORTH, lblD);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateD, 19, SpringLayout.EAST, lblD);
		lblStateD.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pnl.add(lblStateD);

		lblStateE = new JLabel("미지정");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblStateE, 5, SpringLayout.NORTH, lblE);
		sl_pnl.putConstraint(SpringLayout.WEST, lblStateE, 23, SpringLayout.EAST, lblE);
		lblStateE.setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnRetouchA, 0, SpringLayout.SOUTH, ballApnl);
		btnRetouchA.setBackground(Color.WHITE);
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
				lblStateA.setText("미지정");
				lotto.resultBuy.set(0, new ArrayList<>());

			}
		});

		btnRetouchB = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchB, 6, SpringLayout.NORTH, lblB);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchB, 0, SpringLayout.EAST, btnRetouchA);
		btnRetouchB.setBackground(Color.WHITE);
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
				lblStateB.setText("미지정");
				lotto.resultBuy.set(1, new ArrayList<>());

			}
		});
		pnl.add(btnRetouchB);

		btnRetouchC = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchC, 1, SpringLayout.NORTH, lblC);
		btnRetouchC.setBackground(Color.WHITE);
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
				lblStateC.setText("미지정");
				lotto.resultBuy.set(2, new ArrayList<>());

			}
		});
		pnl.add(btnRetouchC);

		btnRetouchD = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchD, 6, SpringLayout.NORTH, lblD);
		btnRetouchD.setBackground(Color.WHITE);
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
				lblStateD.setText("미지정");
				lotto.resultBuy.set(3, new ArrayList<>());
			}
		});
		pnl.add(btnRetouchD);

		btnRetouchE = new JButton("수정");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnRetouchE, 6, SpringLayout.NORTH, lblE);
		btnRetouchE.setBackground(Color.WHITE);
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
				lblStateE.setText("미지정");
				lotto.resultBuy.set(4, new ArrayList<>());
//				countNum = 0;
			}
		});
		pnl.add(btnRetouchE);

		btnDeleteA = new JButton("삭제");
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchA, -6, SpringLayout.WEST, btnDeleteA);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnDeleteA, 0, SpringLayout.SOUTH, ballApnl);
		btnDeleteA.setBackground(Color.WHITE);
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
		sl_pnl.putConstraint(SpringLayout.EAST, btnDeleteA, 0, SpringLayout.EAST, btnDeleteB);
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteB, 858, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteB, 6, SpringLayout.NORTH, lblB);
		btnDeleteB.setBackground(Color.WHITE);
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
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteC, 858, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchC, -6, SpringLayout.WEST, btnDeleteC);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteC, 6, SpringLayout.NORTH, lblC);
		btnDeleteC.setBackground(Color.WHITE);
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
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteD, 858, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchD, -6, SpringLayout.WEST, btnDeleteD);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteD, 6, SpringLayout.NORTH, lblD);
		btnDeleteD.setBackground(Color.WHITE);
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
		sl_pnl.putConstraint(SpringLayout.WEST, btnDeleteE, 858, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnRetouchE, -6, SpringLayout.WEST, btnDeleteE);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnDeleteE, 6, SpringLayout.NORTH, lblE);
		btnDeleteE.setBackground(Color.WHITE);
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
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckA, 107, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckA, 186, SpringLayout.EAST, lblA);
		pnl.add(lblCheckA);

		lblCheckB = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckB, 188, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckB, 0, SpringLayout.WEST, lblCheckA);
		pnl.add(lblCheckB);

		lblCheckC = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckC, 271, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckC, 0, SpringLayout.WEST, lblCheckA);
		pnl.add(lblCheckC);

		lblCheckD = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckD, 0, SpringLayout.WEST, lblCheckA);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblCheckD, -197, SpringLayout.NORTH, btnPurchase);
		pnl.add(lblCheckD);

		lblCheckE = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblCheckE, 389, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblCheckE, 0, SpringLayout.WEST, lblCheckA);
		pnl.add(lblCheckE);

		btnNumReset = new JButton("초기화");
		btnNumReset.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNumReset, 0, SpringLayout.NORTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNumReset, 725, SpringLayout.EAST, btnreturn);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNumReset, -69, SpringLayout.EAST, pnl);
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
		sl_pnl.putConstraint(SpringLayout.EAST, comboBox, -122, SpringLayout.WEST, btnPurchase);
		pnl.add(comboBox);

		lblBuyCount = new JLabel("구매수량");
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblBuyCount, -50, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, lblBuyCount, -122, SpringLayout.WEST, btnPurchase);
		sl_pnl.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, lblBuyCount);
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
					}
					if (lotto.resultBuy.get(4).size() == 0) {
						countNum = 4;
					}
					if (lotto.resultBuy.get(3).size() == 0) {
						countNum = 3;
					}
					if (lotto.resultBuy.get(2).size() == 0) {
						countNum = 2;
					}
					if (lotto.resultBuy.get(1).size() == 0) {
						countNum = 1;
					}
					if (lotto.resultBuy.get(0).size() == 0) {
						countNum = 0;

					}
					if (countNum == 5) {
						JOptionPane.showMessageDialog(BuyFrame.this, "구매횟수를 초과했습니다", "구매횟수 초과",
								JOptionPane.WARNING_MESSAGE);
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
						if (numSelect == 0) {
							lblStateA.setText("자동");
							autoSelected = false;
						} else if (numSelect == 6) { // () = true
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
						if (numSelect == 0 || autoSelectCount == 6) {
							lblStateB.setText("자동");
							autoSelected = false;
						} else if (numSelect == 6) { // () = true
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
						if (numSelect == 0) {
							lblStateC.setText("자동");
							autoSelected = false;
						} else if (numSelect == 6) { // () = true
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
						if (numSelect == 0) {
							lblStateD.setText("자동");
							autoSelected = false;
						} else if (numSelect == 6) { // () = true
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

							if (numSelect == 0) {
								lblStateE.setText("자동");
								autoSelected = false;
							} else if (numSelect == 6) { // () = true
								lblStateE.setText("수동");
							} else {
								lblStateE.setText("반자동");
							}
							lotto.resultBuyTitle.set(4, lblStateE.getText());
							countNum = 5;
						}

					} else {
						// 6개가 선택되지 않은 경우
						lblCheckA.setText("6개를 선택해야 합니다.");
					}
					for (int j = 0; j < 5; j++) {
						if (lotto.resultBuy.get(j).size() == 0) {
							countNum = j;
							break;
						}
					}

					numSelect = 0;
				}
			}
		});
		ballApnl.setBounds(500, 300, 200, 50);

		JLabel lblNewLabel = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel, -19, SpringLayout.NORTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblBuyCount);
		lblNewLabel.setIcon(new ImageIcon("images/img.jpg"));
		pnl.add(lblNewLabel);

//		JLabel lblNewLabel_1 = new JLabel("");
//		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, ballApnl);
//		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_1, 28, SpringLayout.EAST, ballApnl);
//		lblNewLabel_1.setIcon(new ImageIcon("D:\\young\\ball\\ball_s_1.png"));
//		pnl.add(lblNewLabel_1);
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);

	}

	public Map<Integer, JLabel[]> showBall(int countNum, ArrayList<String> selectedNumbers, JPanel pnl,
			SpringLayout sl_pnl, int x, int y) {
		ballLabels = new HashMap<>();
		JLabel[] labels = ballLabels.get(countNum);

		if (labels == null) {
			labels = new JLabel[selectedNumbers.size()];
		}

		for (int i = 0; i < selectedNumbers.size(); i++) {
			String num = selectedNumbers.get(i);
//			String path = "images/ball/ball_";
			String imagePath = "images/ball/ball_s_" + num + ".PNG";

			ImageIcon icon = new ImageIcon(imagePath);
//			Image image = icon.getImage(); // Image 객체로 변환
//			Image resizedImage = image.getScaledInstance(54, 40, Image.SCALE_SMOOTH); // 크기 조정
//			ImageIcon resizedIcon = new ImageIcon(resizedImage); // 조정된 이미지로 새로운 아이콘 생성

//			JLabel label = new JLabel(resizedIcon);
			JLabel label = new JLabel(icon);
			sl_pnl.putConstraint(SpringLayout.NORTH, label, x, SpringLayout.NORTH, lblA);
			sl_pnl.putConstraint(SpringLayout.WEST, label, y + (i * 80), SpringLayout.EAST, lblStateA);
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
