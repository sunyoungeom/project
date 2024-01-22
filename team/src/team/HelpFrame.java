
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import sun.net.www.content.image.jpeg;

//import javafx.scene.control.ToggleButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Font;

public class HelpFrame extends JFrame {
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
	 private static final int DISPLAY_TIME = 3000; // 3초 딜레이 (밀리초 단위)

	public HelpFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		Random random = new Random();
		
		JPanel pnlImage = new JPanel();
		getContentPane().add(pnlImage, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\GGG\\Downloads\\loto-icon.gif"));
		pnlImage.add(lblNewLabel_5);
		
		
		
		
		JPanel pnl = new JPanel();
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		getContentPane().add(pnl);

		JPanel ballApnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballApnl, 216, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballApnl, 90, SpringLayout.WEST, pnl);
		pnl.add(ballApnl);

		JPanel ballBpnl = new JPanel();
		pnl.add(ballBpnl);

		JPanel ballCpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballCpnl, 0, SpringLayout.NORTH, ballBpnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballCpnl, 6, SpringLayout.EAST, ballBpnl);
		pnl.add(ballCpnl);

		JPanel ballDpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, ballDpnl, 0, SpringLayout.NORTH, ballBpnl);
		sl_pnl.putConstraint(SpringLayout.WEST, ballDpnl, 6, SpringLayout.EAST, ballCpnl);
		pnl.add(ballDpnl);

		JPanel ballEpnl = new JPanel();
		sl_pnl.putConstraint(SpringLayout.WEST, ballEpnl, 6, SpringLayout.EAST, ballDpnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, ballEpnl, 0, SpringLayout.SOUTH, ballBpnl);
		pnl.add(ballEpnl);

		btnreturn = new JButton("돌아가기");
		sl_pnl.putConstraint(SpringLayout.NORTH, ballBpnl, 0, SpringLayout.NORTH, btnreturn);
		sl_pnl.putConstraint(SpringLayout.WEST, ballBpnl, 437, SpringLayout.EAST, btnreturn);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 29, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
		pnl.add(btnreturn);
		
		
		
		
		
		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\GGG\\Downloads\\loto-icon.gif"));
				setVisible(false);
				lotto.setVisible(true);
				lotto.setRoundNum(lotto.getRoundNum() + 1);
			}
		});
		
		
//		
//		JLabel[] resultTitleLabels = { titleA, titleB, titleC, titleD, titleE };
//		for (int j = 0; j < resultTitleLabels.length; j++) {
//			if (!lotto.resultBuyTitle.get(j).isEmpty() && j < lotto.resultBuyTitle.size()
//					&& lotto.resultBuyTitle.size() > 0) {
//				StringBuilder resultTitleText = new StringBuilder();
//				System.out.println((char) (ch + j));
//				resultTitleText.append(ch).append(" ").append(lotto.resultBuyTitle.get(j));
//				ch += 1;
//				resultTitleLabels[j].setText(resultTitleText.toString());
//
//			} else {
//				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
//				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
//				resultTitleLabels[j].setText("");
//			}
//		}
//
//		JLabel[] resultLabels = { resultA, resultB, resultC, resultD, resultE };
//		for (int j = 0; j < resultLabels.length; j++) {
//			if (!lotto.resultBuy.isEmpty() && j < lotto.resultBuy.size() && lotto.resultBuy.get(j).size() > 0) {
//				StringBuilder resultText = new StringBuilder();
//				for (int i = 0; i < 6 && i < lotto.resultBuy.get(j).size(); i++) {
//					resultText.append(lotto.resultBuy.get(j).get(i)).append(" ");
//				}
//				resultLabels[j].setText(resultText.toString());
//			} else {
//				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
//				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
//				resultLabels[j].setText("");
//			}
//		}
//		int resultNum = 0;
//		for (int i = 0; i < 5; i++) {
//			if (lotto.resultBuy.get(i).size() != 0) {
//				resultNum++;
//			}
//		}
		
		JButton btnNewButton = new JButton("New button");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				pnl.setVisible(true);
//				pnlImage.setVisible(false);
//			}
//		});
		pnlImage.add(btnNewButton);
		
		
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
		    @Override
		    public void run() {
		    	pnlImage.setVisible(false); // 타이머 동작 후 이미지를 숨김
		        pnl.setVisible(true);
//		        timer.cancel(); // 타이머 중지
		    }
		};

		timer.schedule(task, DISPLAY_TIME);

		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnlImage.setVisible(false);

                 // 버튼을 누르면 이미지를 보이고, 3초 후에 타이머 시작
//                 lblNewLabel_5.setVisible(true);
//                 timer.schedule(task, DISPLAY_TIME);
            	timer.schedule(task, DISPLAY_TIME);
                 pnl.setVisible(true);
//                 timer.cancel(); // 타이머 중지
            }
        });
		
		
		
		
		
		
		
		int resultNum = 0;
		for (int i = 0; i < lotto.resultBuy.size(); i++) {
			if (!lotto.resultBuy.get(i).isEmpty()) {
				resultNum++;
			}
		}

		System.out.println(lotto.roundNum);
		System.out.println("ghkr");

		JLabel winningNumber = new JLabel();
		sl_pnl.putConstraint(SpringLayout.NORTH, winningNumber, 100, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, winningNumber, 60, SpringLayout.WEST, getContentPane());

		int index = 0;
		if (resultNum != 0) {
			index = random.nextInt(resultNum);
			winningNumber.setText("당첨 번호 : " + lotto.resultBuy.get(index)); // 당첨 번호 출력하는 라벨

//		winningNumberCollection = new TreeMap<>();
			lotto.winningNumberCollection.put(lotto.roundNum, lotto.resultBuy.get(index));
			ArrayList<String> ll = new ArrayList<>();
			ll = lotto.winningNumberCollection.get(lotto.roundNum);
			System.out.println("dd" + ll);

			for (Integer numKey : lotto.winningNumberCollection.keySet()) {
				System.out.println("제" + (numKey) + "회" + ": " + lotto.winningNumberCollection.get(numKey));
			}
//			showBall(1, lotto.resultBuy.get(index),  pnl,sl_pnl, 10,10);

		}
//		if (lotto.winningNumberCollection.get(lotto.roundNum-1) != null) {
					showRBall(lotto.winningNumberCollection.get(lotto.roundNum), ballApnl, sl_pnl, 10, 10);
			
//		}

		
		
		
		
		ballApnl.setBounds(500, 300, 200, 50);
		
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
		
		JPanel panel = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, panel, 167, SpringLayout.SOUTH, lblNewLabel_2);
		sl_pnl.putConstraint(SpringLayout.WEST, panel, 242, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, panel, -25, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, panel, 614, SpringLayout.WEST, pnl);
		pnl.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("축하합니다!");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 123, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("총 100원 당첨");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 48, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_3);
		panel.add(lblNewLabel_4);
		
	
		setSize(800, 600);
		pnl.setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
			sl_pnl.putConstraint(SpringLayout.NORTH, label, x, SpringLayout.NORTH, lblA);
			sl_pnl.putConstraint(SpringLayout.WEST, label, y + (i * 50), SpringLayout.EAST, lblStateA);
			pnl.add(label);
			
		}

		
	}
//	public Map<Integer, JLabel[]> showBall(int countNum, ArrayList<String> selectedNumbers, JPanel pnl, SpringLayout sl_pnl, int x, int y) {
//		ballLabels = new HashMap<>();
//		JLabel[] labels = ballLabels.get(countNum);
//		
//		if (labels == null) {
//			labels = new JLabel[selectedNumbers.size()];
//		}
//		
//		for (int i = 0; i < selectedNumbers.size(); i++) {
//			String num = selectedNumbers.get(i);
//			String path = "images/ball/ball_";
//			String imagePath = "images/ball/ball_" + num + ".PNG";
//			
//			ImageIcon icon = new ImageIcon(imagePath);
//			Image image = icon.getImage(); // Image 객체로 변환
//			Image resizedImage = image.getScaledInstance(54, 40, Image.SCALE_SMOOTH); // 크기 조정
//			ImageIcon resizedIcon = new ImageIcon(resizedImage); // 조정된 이미지로 새로운 아이콘 생성
//			
//			JLabel label = new JLabel(resizedIcon);
//			sl_pnl.putConstraint(SpringLayout.NORTH, label, x, SpringLayout.NORTH, lblA);
//			sl_pnl.putConstraint(SpringLayout.WEST, label, y + (i * 50), SpringLayout.EAST, lblStateA);
//			pnl.add(label);
//			labels[i] = label;
//		}
//		
//		ballLabels.put(countNum, labels);
//		return ballLabels;
//	}

	public void removeBalls(int key, JPanel pnl, Map<Integer, JLabel[]> ballLabels) {
		JLabel[] labelsArray = ballLabels.get(key);
		pnl.removeAll();
		pnl.revalidate();
		pnl.repaint();
	}
}
