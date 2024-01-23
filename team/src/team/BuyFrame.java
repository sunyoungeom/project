
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

		btnPurchase = new JButton("구매하기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnPurchase, -6, SpringLayout.NORTH, btnReset);
		sl_pnl.putConstraint(SpringLayout.WEST, btnPurchase, 294, SpringLayout.EAST, btnCheck);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnPurchase, 29, SpringLayout.NORTH, btnReset);
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

		btnNumReset = new JButton("초기화");
		btnNumReset.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNumReset, 0, SpringLayout.NORTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNumReset, 725, SpringLayout.EAST, btnreturn);
		sl_pnl.putConstraint(SpringLayout.EAST, btnNumReset, -69, SpringLayout.EAST, pnl);
		pnl.add(btnNumReset);
		btnNumReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStateA.setText("미지정");
				lotto.resultBuy.set(0, new ArrayList<>());

				lblStateB.setText("미지정");
				lotto.resultBuy.set(1, new ArrayList<>());

				lblStateC.setText("미지정");
				lotto.resultBuy.set(2, new ArrayList<>());

				lblStateD.setText("미지정");
				lotto.resultBuy.set(3, new ArrayList<>());

				lblStateE.setText("미지정");
				lotto.resultBuy.set(4, new ArrayList<>());
				// countNum을 -1로 재설정
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
					} else if (countNum == 1) {
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
					} else if (countNum == 2) {
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
					} else if (countNum == 3) {
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
					} else if (countNum == 4) {
						if (lotto.resultBuy.get(4).size() == 0 || lotto.resultBuy.get(4).size() == 6) {
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
		sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel, -19, SpringLayout.NORTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 389, SpringLayout.WEST, pnl);
		lblNewLabel.setIcon(new ImageIcon("images/img.jpg"));
		pnl.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		sl_pnl.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, pnl);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		sl_pnl.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, toggleButtonPanel);
		sl_pnl.putConstraint(SpringLayout.WEST, panel, 22, SpringLayout.EAST, toggleButtonPanel);
		pnl.add(panel);
		panel.setLayout(null);
		
		lblLineA = new JLabel("A");
		lblLineA.setBounds(25, 10, 20, 35);
		lblLineA.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineA);
		
		lblStateA = new JLabel("미지정");
		lblStateA.setBounds(80, 20, 45, 21);
		lblStateA.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateA);
		
		ballApnl = new JPanel();
		ballApnl.setBackground(Color.WHITE);
		ballApnl.setBounds(160, 5, 330, 50);
		panel.add(ballApnl);
		
		JButton btnRetouchA = new JButton("수정");
		btnRetouchA.setBackground(Color.WHITE);
		btnRetouchA.setBounds(507, 15, 60, 25);
		panel.add(btnRetouchA);
		
		btnDeleteA = new JButton("삭제");
		btnDeleteA.setBackground(Color.WHITE);
		btnDeleteA.setBounds(575, 15, 60, 25);
		panel.add(btnDeleteA);
		
		ballBpnl = new JPanel();
		ballBpnl.setBackground(Color.WHITE);
		ballBpnl.setBounds(160, 95, 330, 50);
		panel.add(ballBpnl);
		
		lblLineB = new JLabel("B");
		lblLineB.setBounds(25, 100, 20, 35);
		lblLineB.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineB);
		
		lblStateB = new JLabel("미지정");
		lblStateB.setBounds(80, 110, 45, 21);
		lblStateB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateB);
		
		btnRetouchB = new JButton("수정");
		btnRetouchB.setBackground(Color.WHITE);
		btnRetouchB.setBounds(507, 105, 60, 25);
		panel.add(btnRetouchB);
		
		btnDeleteB = new JButton("삭제");
		btnDeleteB.setBackground(Color.WHITE);
		btnDeleteB.setBounds(575, 105, 60, 25);
		panel.add(btnDeleteB);
		
		lblLineC = new JLabel("C");
		lblLineC.setBounds(30, 190, 20, 35);
		lblLineC.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineC);
		
		lblStateC = new JLabel("미지정");
		lblStateC.setBounds(83, 200, 45, 21);
		lblStateC.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateC);
		
		ballCpnl = new JPanel();
		ballCpnl.setBackground(Color.WHITE);
		ballCpnl.setBounds(160, 185, 330, 50);
		panel.add(ballCpnl);
		
		btnRetouchC = new JButton("수정");
		btnRetouchC.setBackground(Color.WHITE);
		btnRetouchC.setBounds(507, 195, 60, 25);
		panel.add(btnRetouchC);
		
		btnDeleteC = new JButton("삭제");
		btnDeleteC.setBackground(Color.WHITE);
		btnDeleteC.setBounds(575, 195, 60, 25);
		panel.add(btnDeleteC);
		
		lblLineD = new JLabel("D");
		lblLineD.setBounds(30, 280, 20, 35);
		lblLineD.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineD);
		
		lblStateD = new JLabel("미지정");
		lblStateD.setBounds(83, 290, 45, 21);
		lblStateD.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateD);
		
		ballDpnl = new JPanel();
		ballDpnl.setBackground(Color.WHITE);
		ballDpnl.setBounds(160, 275, 330, 50);
		panel.add(ballDpnl);
		
		btnRetouchD = new JButton("수정");
		btnRetouchD.setBackground(Color.WHITE);
		btnRetouchD.setBounds(507, 285, 60, 25);
		panel.add(btnRetouchD);
		
		btnDeleteD = new JButton("삭제");
		btnDeleteD.setBackground(Color.WHITE);
		btnDeleteD.setBounds(575, 285, 60, 25);
		panel.add(btnDeleteD);
		
		lblLineE = new JLabel("E");
		lblLineE.setBounds(32, 370, 20, 35);
		lblLineE.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel.add(lblLineE);
		
		lblStateE = new JLabel("미지정");
		lblStateE.setBounds(83, 380, 45, 21);
		lblStateE.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblStateE);
		
		btnRetouchE = new JButton("수정");
		btnRetouchE.setBackground(Color.WHITE);
		btnRetouchE.setBounds(507, 375, 60, 25);
		panel.add(btnRetouchE);
		
		ballEpnl = new JPanel();
		ballEpnl.setBackground(Color.WHITE);
		ballEpnl.setBounds(160, 365, 330, 50);
		panel.add(ballEpnl);
		
		btnDeleteE = new JButton("삭제");
		btnDeleteE.setBackground(Color.WHITE);
		btnDeleteE.setBounds(575, 375, 60, 25);
		panel.add(btnDeleteE);

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
			sl_pnl.putConstraint(SpringLayout.NORTH, label, x, SpringLayout.NORTH, lblLineA);
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
