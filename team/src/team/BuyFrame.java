
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
import java.awt.Container;
import java.awt.Font;

import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BuyFrame extends JFrame {
	private LottoProgram lotto;
	public static ArrayList<JToggleButton> numberToggleButtons;
	public static ArrayList<String> selectedNumbers;
	private int SELECTED_NUMBER = 6;
	private JButton btnAuto;
	private JButton btnReset;
	private JButton btnreturn;
	private JButton btnPurchase;
	private JButton btnCheck;
	private JPanel toggleButtonPanel;
	private boolean autoSelected = false;
	private JButton btnNumReset;
	private JToggleButton toggleButton;
	private int autoSelectCount;
	public int countNum = 0; // 배열의 대한 숫자 0~4까지
	public int numSelect = 0; // 직접 내가 누르는 번호의 개수
	private Map<Integer, JLabel[]> ballLabels;
	private JLabel lblLineA;
	private JLabel lblLineB;
	private JLabel lblLineC;
	private JLabel lblLineD;
	private JLabel lblLineE;
	private JLabel lblStateA;
	private JLabel lblStateB;
	private JLabel lblStateC;
	private JLabel lblStateD;
	private JLabel lblStateE;
	private JButton btnRetouchB;
	private JButton btnRetouchC;
	private JButton btnRetouchD;
	private JButton btnRetouchE;
	private JButton btnDeleteA;
	private JButton btnDeleteB;
	private JButton btnDeleteC;
	private JButton btnDeleteD;
	private JButton btnDeleteE;
	private JPanel ballApnl;
	private JPanel ballBpnl;
	private JPanel ballCpnl;
	private JPanel ballDpnl;
	private JPanel ballEpnl;
	private JButton btnRetouchA;
	public static int returnCount;
	public int mapTempNum = 1;

	public BuyFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		
		setTitle("구매 화면");

		
		if (lotto.roundNum==2) {
			System.out.println("1값"+lotto.buyNumberCollection.get(1));

		}
		JPanel pnl = new JPanel();
		pnl.setBackground(Color.WHITE);
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);

		btnreturn = new JButton("돌아가기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 10, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
		btnreturn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnreturn.setBackground(Color.WHITE);
		pnl.add(btnreturn);
		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (returnCount == 0) {
					
					int answer = JOptionPane.showConfirmDialog(BuyFrame.this, "구매하시지 않고 뒤로 가시겠습니까?", "경고",
							JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) {
						setVisible(false);
						lotto.setVisible(true);
						for (int i = 0; i < 5; i++) {
							lotto.resultBuy.set(i, new ArrayList<>());
						}
					}
				} else {
					
					setVisible(false);
					lotto.setVisible(true);
				}
			}
		});

		btnReset = new JButton("초기화");
		btnReset.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		sl_pnl.putConstraint(SpringLayout.WEST, btnReset, 10, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnReset, -893, SpringLayout.EAST, pnl);
		btnReset.setBackground(Color.WHITE);
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
		sl_pnl.putConstraint(SpringLayout.WEST, btnAuto, 27, SpringLayout.EAST, btnReset);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnAuto, 0, SpringLayout.SOUTH, btnReset);
		btnAuto.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnAuto.setBackground(Color.WHITE);
		btnAuto.setForeground(Color.BLACK);
		pnl.add(btnAuto);
		// "자 동선택" 버튼에 대한 ActionListener를 추가
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
				// 나머지 번호를 자 동으로 선택 (반자동)
				if (numSelect < autoSelectCount) {
					random = new Random();
					while (numSelect < autoSelectCount) {
						int randomNumber = random.nextInt(45) + 1;
						if (!numberToggleButtons.get(randomNumber - 1).isSelected()) {
							numberToggleButtons.get(randomNumber - 1).setSelected(true);
							numSelect++;
						}
					}
				} // 자 동
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
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnCheck, 0, SpringLayout.SOUTH, btnReset);
		btnCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pnl.add(btnCheck);
		btnCheck.setOpaque(false);
		btnCheck.setContentAreaFilled(false);

		toggleButtonPanel = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, btnCheck, 21, SpringLayout.SOUTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnAuto, 21, SpringLayout.SOUTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.NORTH, toggleButtonPanel, 65, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnreturn, -20, SpringLayout.NORTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.SOUTH, toggleButtonPanel, -66, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnCheck, 0, SpringLayout.EAST, toggleButtonPanel);
		toggleButtonPanel.setBackground(Color.WHITE);
		toggleButtonPanel.setBorder(new LineBorder(Color.DARK_GRAY));
		sl_pnl.putConstraint(SpringLayout.NORTH, btnReset, 21, SpringLayout.SOUTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.EAST, toggleButtonPanel, -667, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, toggleButtonPanel, 10, SpringLayout.WEST, pnl);
		pnl.add(toggleButtonPanel);
		toggleButtonPanel.setLayout(new GridLayout(9, 5, 15, 15));

		// 버튼 45개 생성
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

		btnPurchase = new JButton("구매하기");
		sl_pnl.putConstraint(SpringLayout.WEST, btnPurchase, 242, SpringLayout.EAST, btnCheck);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnPurchase, -16, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnPurchase, -312, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnReset, 0, SpringLayout.SOUTH, btnPurchase);
		btnPurchase.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPurchase.setBackground(Color.WHITE);
		pnl.add(btnPurchase);
		
		
		btnPurchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (lotto.resultBuy.get(0).size() == 0 
						&& lotto.resultBuy.get(1).size() == 0
								&& lotto.resultBuy.get(2).size() == 0
										&& lotto.resultBuy.get(3).size() == 0 
												&& lotto.resultBuy.get(4).size() == 0) {
					JOptionPane.showMessageDialog(BuyFrame.this, "구매 수량이 없습니다");
				} else {
					btnPurchase.setEnabled(false); // 한번 구매시 구매버튼 비활성화
					
						disableAllButtons(getContentPane()); // 돌아가기 제외 모든 버튼 비활성화
						btnreturn.setEnabled(true);
					returnCount++;
					lotto.roundNum++;
					
//					lotto.buyNumberCollection.put(lotto.roundNum, lotto.resultBuy);
//					lotto.resultBuyTemp = lotto.buyNumberCollection.get(lotto.roundNum);
//					lotto.resultBuyTemp.get(lotto.roundNum);
//					mapTempNum++;
					
					// resultBuyTemp에 resultBuy 값 복사 (깊은 복사)
					lotto.resultBuyTemp = deepCopyResultBuy(lotto.resultBuy);
					 // buyNumberCollection에 resultBuy 넣기 (깊은 복사)
			        lotto.buyNumberCollection.put(lotto.roundNum, deepCopyResultBuy(lotto.resultBuyTemp));

			        lotto.resultBuyTitleTemp = deepCopyResultBuyTitle(lotto.resultBuyTitle);
			        lotto.buyNumberCollectionTitle.put(lotto.roundNum, deepCopyResultBuyTitle(lotto.resultBuyTitleTemp));
					
					System.out.println("jj"+lotto.buyNumberCollection.get(lotto.roundNum));
					JDialog dialog = new ResultDialog(lottoProgram);
					dialog.setTitle("구매내역");
					dialog.setVisible(true);
					
					// 구매시 기본공 출력
					removeBalls(ballApnl);
					removeBalls(ballBpnl);
					removeBalls(ballCpnl);
					removeBalls(ballDpnl);
					removeBalls(ballEpnl);
					
					showDefaultBall(sl_pnl, ballApnl);
					showDefaultBall(sl_pnl, ballBpnl);
					showDefaultBall(sl_pnl, ballCpnl);
					showDefaultBall(sl_pnl, ballDpnl);
					showDefaultBall(sl_pnl, ballEpnl);
					
					
					
					
				}
			}
		});
		

		btnNumReset = new JButton("초기화");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNumReset, 10, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnreturn, -794, SpringLayout.WEST, btnNumReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNumReset, 893, SpringLayout.WEST, pnl);
		btnNumReset.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNumReset.setBackground(Color.WHITE);
		pnl.add(btnNumReset);
		btnNumReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStateA.setText("미지정");
				lotto.resultBuy.set(0, new ArrayList<>());
				removeBalls(ballApnl);
				showDefaultBall(sl_pnl, ballApnl);
				lblStateB.setText("미지정");
				lotto.resultBuy.set(1, new ArrayList<>());
				removeBalls(ballBpnl);
				showDefaultBall(sl_pnl, ballBpnl);
				lblStateC.setText("미지정");
				lotto.resultBuy.set(2, new ArrayList<>());
				removeBalls(ballCpnl);
				showDefaultBall(sl_pnl, ballCpnl);
				lblStateD.setText("미지정");
				lotto.resultBuy.set(3, new ArrayList<>());
				removeBalls(ballDpnl);
				showDefaultBall(sl_pnl, ballDpnl);
				lblStateE.setText("미지정");
				lotto.resultBuy.set(4, new ArrayList<>());
				removeBalls(ballEpnl);
				showDefaultBall(sl_pnl, ballEpnl);
				countNum = 0;
			}
		});

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
					if (countNum == 0) {
						lotto.resultBuy.set(0, selectedNumbers);
						System.out.println(lotto.resultBuy);
						System.out.println(selectedNumbers.get(0));
						removeBalls(ballApnl);
						showBall(0, selectedNumbers, ballApnl, sl_pnl, -10, 50);
						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}
						if (numSelect == 0) {
							lblStateA.setText("자 동");
							autoSelected = false;
						} else if (numSelect >= 1 && numSelect <= 5) { // () = true
							lblStateA.setText("반자동");
						} else {
							lblStateA.setText("수 동");
						}
						lotto.resultBuyTitle.set(0, lblStateA.getText());
					} else if (countNum == 1) {
						lotto.resultBuy.set(1, selectedNumbers);
						System.out.println(lotto.resultBuy);
						removeBalls(ballBpnl);
						showBall(1, selectedNumbers, ballBpnl, sl_pnl, 60, 50);
						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}
						if (numSelect == 0 || autoSelectCount == 6) {
							lblStateB.setText("자 동");
							autoSelected = false;
						} else if (numSelect == 6) { // () = true
							lblStateB.setText("수 동");
						} else {
							lblStateB.setText("반자동");
						}
						lotto.resultBuyTitle.set(1, lblStateB.getText());
					} else if (countNum == 2) {
						lotto.resultBuy.set(2, selectedNumbers);
						System.out.println(lotto.resultBuy);
						removeBalls(ballCpnl);
						showBall(2, selectedNumbers, ballCpnl, sl_pnl, 130, 50);

						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}
						if (numSelect == 0) {
							lblStateC.setText("자 동");
							autoSelected = false;
						} else if (numSelect == 6) { // () = true
							lblStateC.setText("수 동");
						} else {
							lblStateC.setText("반자동");
						}
						lotto.resultBuyTitle.set(2, lblStateC.getText());
					} else if (countNum == 3) {
						lotto.resultBuy.set(3, selectedNumbers);
						System.out.println(lotto.resultBuy);
						removeBalls(ballDpnl);
						showBall(3, selectedNumbers, ballDpnl, sl_pnl, 200, 50);

						for (JToggleButton toggleButton : numberToggleButtons) {
							toggleButton.setSelected(false);
						}
						if (numSelect == 0) {
							lblStateD.setText("자 동");
							autoSelected = false;
						} else if (numSelect == 6) { // () = true
							lblStateD.setText("수 동");
						} else {
							lblStateD.setText("반자동");
						}
						lotto.resultBuyTitle.set(3, lblStateD.getText());
					} else if (countNum == 4) {
						if (lotto.resultBuy.get(4).size() == 0 || lotto.resultBuy.get(4).size() == 6) {
//							lotto.showBuyBall(pnl, sl_pnl, 180, selectedNumbers);
							lotto.resultBuy.set(4, selectedNumbers);
							System.out.println(lotto.resultBuy);
							removeBalls(ballEpnl);
							showBall(4, selectedNumbers, ballEpnl, sl_pnl, 270, 50);
							for (JToggleButton toggleButton : numberToggleButtons) {
								toggleButton.setSelected(false);
							}
							if (numSelect == 0) {
								lblStateE.setText("자 동");
								autoSelected = false;
							} else if (numSelect == 6) { // () = true
								lblStateE.setText("수 동");
							} else {
								lblStateE.setText("반자동");
							}
							lotto.resultBuyTitle.set(4, lblStateE.getText());
							countNum = 5;
						}
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

		JLabel lblNewLabel = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 389, SpringLayout.WEST, pnl);
		lblNewLabel.setIcon(new ImageIcon("images/img.jpg"));
		pnl.add(lblNewLabel);

		JPanel panel = new JPanel();
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnNumReset, -20, SpringLayout.NORTH, panel);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnPurchase, 15, SpringLayout.SOUTH, panel);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNumReset, 0, SpringLayout.EAST, panel);
		sl_pnl.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, pnl);
		panel.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.WEST, panel, 22, SpringLayout.EAST, toggleButtonPanel);
		pnl.add(panel);
		panel.setLayout(null);

		lblLineA = new JLabel("A");
		lblLineA.setBounds(45, 55, 20, 35);
		lblLineA.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineA);

		lblStateA = new JLabel("미지정");
		lblStateA.setBounds(70, 65, 45, 21);
		lblStateA.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateA);

		ballApnl = new JPanel();
		ballApnl.setBackground(Color.WHITE);
		ballApnl.setBounds(130, 50, 310, 50);
		panel.add(ballApnl);

		btnRetouchA = new JButton("수정");
		btnRetouchA.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnRetouchA.setBackground(Color.WHITE);
		btnRetouchA.setBounds(450, 60, 60, 30);
		panel.add(btnRetouchA);
		btnRetouchA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				countNum = 0;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
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

		btnDeleteA = new JButton("삭제");
		btnDeleteA.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDeleteA.setBackground(Color.WHITE);
		btnDeleteA.setBounds(520, 60, 60, 30);
		panel.add(btnDeleteA);
		btnDeleteA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStateA.setText("미지정");
				lotto.resultBuy.set(0, new ArrayList<>());
				countNum = 0;
				removeBalls(ballApnl);
				showDefaultBall(sl_pnl, ballApnl);
			}
		});

		ballBpnl = new JPanel();
		ballBpnl.setBackground(Color.WHITE);
		ballBpnl.setBounds(130, 125, 310, 50);
		panel.add(ballBpnl);

		lblLineB = new JLabel("B");
		lblLineB.setBounds(45, 130, 20, 35);
		lblLineB.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineB);

		lblStateB = new JLabel("미지정");
		lblStateB.setBounds(70, 140, 45, 21);
		lblStateB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateB);

		btnRetouchB = new JButton("수정");
		btnRetouchB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnRetouchB.setBackground(Color.WHITE);
		btnRetouchB.setBounds(450, 135, 60, 30);
		panel.add(btnRetouchB);
		btnRetouchB.setBackground(Color.WHITE);
		btnRetouchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 1;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
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

		btnDeleteB = new JButton("삭제");
		btnDeleteB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDeleteB.setBackground(Color.WHITE);
		btnDeleteB.setBounds(520, 135, 60, 30);
		panel.add(btnDeleteB);
		btnDeleteB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStateB.setText("미지정");
				lotto.resultBuy.set(1, new ArrayList<>());
				countNum = 1;
				removeBalls(ballBpnl);
				showDefaultBall(sl_pnl, ballBpnl);
			}
		});

		lblLineC = new JLabel("C");
		lblLineC.setBounds(45, 205, 20, 35);
		lblLineC.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineC);

		lblStateC = new JLabel("미지정");
		lblStateC.setBounds(70, 215, 45, 21);
		lblStateC.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateC);

		ballCpnl = new JPanel();
		ballCpnl.setBackground(Color.WHITE);
		ballCpnl.setBounds(130, 200, 310, 50);
		panel.add(ballCpnl);

		btnRetouchC = new JButton("수정");
		btnRetouchC.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnRetouchC.setBackground(Color.WHITE);
		btnRetouchC.setBounds(450, 210, 60, 30);
		panel.add(btnRetouchC);
		btnRetouchC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 2;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
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

		btnDeleteC = new JButton("삭제");
		btnDeleteC.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDeleteC.setBackground(Color.WHITE);
		btnDeleteC.setBounds(520, 210, 60, 30);
		panel.add(btnDeleteC);
		btnDeleteC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStateC.setText("미지정");
				lotto.resultBuy.set(2, new ArrayList<>());
				countNum = 2;
				removeBalls(ballCpnl);
				showDefaultBall(sl_pnl, ballCpnl);
			}
		});

		lblLineD = new JLabel("D");
		lblLineD.setBounds(45, 280, 20, 35);
		lblLineD.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineD);

		lblStateD = new JLabel("미지정");
		lblStateD.setBounds(70, 290, 45, 21);
		lblStateD.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateD);

		ballDpnl = new JPanel();
		ballDpnl.setBackground(Color.WHITE);
		ballDpnl.setBounds(130, 275, 310, 50);
		panel.add(ballDpnl);

		btnRetouchD = new JButton("수정");
		btnRetouchD.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnRetouchD.setBackground(Color.WHITE);
		btnRetouchD.setBounds(450, 285, 60, 30);
		panel.add(btnRetouchD);
		btnRetouchD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 3;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
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

		btnDeleteD = new JButton("삭제");
		btnDeleteD.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDeleteD.setBackground(Color.WHITE);
		btnDeleteD.setBounds(520, 285, 60, 30);
		panel.add(btnDeleteD);
		btnDeleteD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStateD.setText("미지정");
				lotto.resultBuy.set(3, new ArrayList<>());
				countNum = 3;
				removeBalls(ballDpnl);
				showDefaultBall(sl_pnl, ballDpnl);
			}
		});

		lblLineE = new JLabel("E");
		lblLineE.setBounds(45, 355, 20, 35);
		lblLineE.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineE);

		lblStateE = new JLabel("미지정");
		lblStateE.setBounds(70, 365, 45, 21);
		lblStateE.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateE);

		ballEpnl = new JPanel();
		ballEpnl.setBackground(Color.WHITE);
		ballEpnl.setBounds(130, 350, 310, 50);
		panel.add(ballEpnl);

		btnRetouchE = new JButton("수정");
		btnRetouchE.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnRetouchE.setBackground(Color.WHITE);
		btnRetouchE.setBounds(450, 360, 60, 30);
		panel.add(btnRetouchE);
		btnRetouchE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countNum = 4;
				for (JToggleButton toggleButton : numberToggleButtons) {
					toggleButton.setSelected(false);
				}
				ArrayList<String> selectEnumbers = lotto.resultBuy.get(4);
				// 선택된 숫자에 해당하는 토글 버튼을 선택 상태로 설정
				for (String number : selectEnumbers) {
					int index = Integer.parseInt(number) - 1; // 토글 버튼은 0부터 시작하므로 1을 빼줍니다.
					toggleButton = numberToggleButtons.get(index);
					toggleButton.setSelected(true);
				}
				lblStateE.setText("미지정");
				lotto.resultBuy.set(4, new ArrayList<>());
			}
		});

		btnDeleteE = new JButton("삭제");
		btnDeleteE.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDeleteE.setBackground(Color.WHITE);
		btnDeleteE.setBounds(520, 360, 60, 30);
		panel.add(btnDeleteE);
		btnDeleteE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStateE.setText("미지정");
				lotto.resultBuy.set(4, new ArrayList<>());
				countNum = 4;
				removeBalls(ballEpnl);
				showDefaultBall(sl_pnl, ballEpnl);
			}
		});
		

		// 기본 공 출력
		showDefaultBall(sl_pnl, ballApnl);
		showDefaultBall(sl_pnl, ballBpnl);
		showDefaultBall(sl_pnl, ballCpnl);
		showDefaultBall(sl_pnl, ballDpnl);
		showDefaultBall(sl_pnl, ballEpnl);

		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);

	}
	 // resultBuy의 각 내부 리스트에 대해 깊은 복사 수행
    private static ArrayList<String> deepCopyResultBuyTitle(ArrayList<String> original) {
    	 ArrayList<String> copy = new ArrayList<>();
    	    for (String element : original) {
    	        copy.add(new String(element)); // 문자열은 불변 객체이므로 새로운 문자열 생성
    	    }
    	    return copy;
    	}
	
	 // resultBuy의 각 내부 리스트에 대해 깊은 복사 수행
    private static ArrayList<ArrayList<String>> deepCopyResultBuy(ArrayList<ArrayList<String>> original) {
        ArrayList<ArrayList<String>> copy = new ArrayList<>();
        for (ArrayList<String> innerList : original) {
            copy.add(new ArrayList<>(innerList));
        }
        return copy;
    }

	// 모든 버튼을 비활성화하는 메서드
    private static void disableAllButtons(Container container) {
        Component[] components = container.getComponents();

        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(false);
            } else if (component instanceof Container) {
                // 재귀적으로 컨테이너 내의 모든 하위 컴포넌트 검사
                disableAllButtons((Container) component);
            }
        }
    }
	
	

	public void showDefaultBall(SpringLayout springLayout, JPanel pnl) {
		for (int i = 0; i < 6; i++) {
			String imagePath = "images/ball/ball_s_0.PNG";
			ImageIcon icon = new ImageIcon(imagePath);
			JLabel label = new JLabel(icon);
			springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, pnl);
			springLayout.putConstraint(SpringLayout.WEST, label, 0 + (i * 50), SpringLayout.EAST, pnl);
			pnl.add(label);
		}
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
			String imagePath = "images/ball/ball_s_" + num + ".PNG";
			ImageIcon icon = new ImageIcon(imagePath);
			JLabel label = new JLabel(icon);
			sl_pnl.putConstraint(SpringLayout.NORTH, label, x, SpringLayout.NORTH, lblLineA);
			sl_pnl.putConstraint(SpringLayout.WEST, label, y + (i * 80), SpringLayout.EAST, lblStateA);
			pnl.add(label);
			labels[i] = label;
		}

		ballLabels.put(countNum, labels);
		return ballLabels;
	}

	public void removeBalls(JPanel pnl) {
		pnl.removeAll();
		pnl.revalidate();
		pnl.repaint();
	}
}
