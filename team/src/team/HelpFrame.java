
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import javax.swing.border.MatteBorder;

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
	private JButton btnreturn;
	public int countNum = 0; // 배열의 대한 숫자 0~4까지
	public int numSelect = 0; // 직접 내가 누르는 번호의 개수
	private static final int DISPLAY_TIME = 3000; // 3초 딜레이 (밀리초 단위)

	public HelpFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		System.out.println("이거느?"+lotto.buyNumberCollection.get(lotto.roundNum));

		Random random = new Random();

		JPanel pnlImage = new JPanel();
		getContentPane().add(pnlImage, BorderLayout.NORTH);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\GGG\\Downloads\\loto-icon.gif"));
		pnlImage.add(lblNewLabel_5);

		JPanel pnl = new JPanel();
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		  pnl.setBackground(Color.WHITE);
		getContentPane().add(pnl);

		JPanel ballApnl = new JPanel();
		   sl_pnl.putConstraint(SpringLayout.WEST, ballApnl, 190, SpringLayout.WEST, pnl);
	        sl_pnl.putConstraint(SpringLayout.SOUTH, ballApnl, -312, SpringLayout.SOUTH, pnl);
	        ballApnl.setBackground(Color.WHITE);

		pnl.add(ballApnl);

//		JPanel ballBpnl = new JPanel();
//		pnl.add(ballBpnl);
//
//		JPanel ballCpnl = new JPanel();
//		sl_pnl.putConstraint(SpringLayout.NORTH, ballCpnl, 0, SpringLayout.NORTH, ballBpnl);
//		sl_pnl.putConstraint(SpringLayout.WEST, ballCpnl, 6, SpringLayout.EAST, ballBpnl);
//		pnl.add(ballCpnl);
//
//		JPanel ballDpnl = new JPanel();
//		sl_pnl.putConstraint(SpringLayout.NORTH, ballDpnl, 0, SpringLayout.NORTH, ballBpnl);
//		sl_pnl.putConstraint(SpringLayout.WEST, ballDpnl, 6, SpringLayout.EAST, ballCpnl);
//		pnl.add(ballDpnl);
//
//		JPanel ballEpnl = new JPanel();
//		sl_pnl.putConstraint(SpringLayout.WEST, ballEpnl, 6, SpringLayout.EAST, ballDpnl);
//		sl_pnl.putConstraint(SpringLayout.SOUTH, ballEpnl, 0, SpringLayout.SOUTH, ballBpnl);
//		pnl.add(ballEpnl);

		btnreturn = new JButton("돌아가기");
		   sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 10, SpringLayout.WEST, pnl);
		pnl.add(btnreturn);

		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\GGG\\Downloads\\loto-icon.gif"));
				setVisible(false);
				lotto.setVisible(true);
//				lotto.setRoundNum(lotto.getRoundNum() + 1);
			}
		});
int totalNum;
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				pnlImage.setVisible(false); // 타이머 동작 후 이미지를 숨김
				pnl.setVisible(true);

				System.out.println("대화 상자를 생성합니다.");
				JDialog dialog = new RecordDialog(lottoProgram);
				dialog.setVisible(true);
				dialog.setTitle("결과확인");
//		        timer.cancel(); // 타이머 중지

				for (int i = 0; i < 5; i++) {
					lotto.resultBuy.set(i, new ArrayList<>());
				}
			}
		};

		timer.schedule(task, DISPLAY_TIME);

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

			lotto.winningNumberCollection.put(lotto.roundNum, lotto.resultBuy.get(index));
			ArrayList<String> ll = new ArrayList<>();
			ll = lotto.winningNumberCollection.get(lotto.roundNum);
			System.out.println("dd" + ll);

			for (Integer numKey : lotto.winningNumberCollection.keySet()) {
				System.out.println("제" + (numKey) + "회" + ": " + lotto.winningNumberCollection.get(numKey));
			}
		}

		showRBall(lotto.winningNumberCollection.get(lotto.roundNum), ballApnl, sl_pnl, 10, 10);

		ballApnl.setBounds(500, 300, 200, 50);

		int buyLottoCount = 0; // 구매한 로또 갯수
//		for (ArrayList<String> elem : lotto.resultBuy) {
			for (int i = 0; i < lotto.resultBuy.size(); i++) {
				if (!lotto.resultBuy.get(i).isEmpty()) {
					buyLottoCount++;
				}

			}
//		}
		System.out.println("구매 로또 갯수" + buyLottoCount);
		
//		int ballCount = 0;
//		ArrayList<Integer> ballCountNum = new ArrayList<Integer>();
//		ArrayList<ArrayList<Integer>> ballCounts = new ArrayList<ArrayList<Integer>>();
////		int[] ballCounts = null;
//		// 사용자의 로또와 당첨 번호 비교
//		if (!lotto.winningNumberCollection.get(lotto.roundNum).isEmpty()) {
//			for (String elem : lotto.winningNumberCollection.get(lotto.roundNum)) {
//				for (int i = 0; i < buyLottoCount; i++) {
//					for (int j = 0; j < 6; j++) {
//						if (lotto.resultBuy.get(i).get(j) == elem) {
//							
//							ballCountNum.set(j, Integer.valueOf(elem));
//
//						}
//					}
//					ballCounts.set(i, ballCountNum);
//				}
//
//			}
//		}
		

//		System.out.println(ballCounts.toString());
		JPanel panel_1 = new JPanel();
		 JLabel lblNewLabel = new JLabel("회차 출력");
	        panel_1.add(lblNewLabel);
	        sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 335, SpringLayout.WEST, pnl);
	        lblNewLabel.setForeground(Color.BLUE);
	        lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	        lblNewLabel.setText("제" + lotto.roundNum + "회");
	        JLabel lblNewLabel_1 = new JLabel("0000-00-00 추첨");
//	        sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_1, -330, SpringLayout.EAST, pnl);
//	        lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	        sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_1, -350, SpringLayout.EAST, pnl);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			LocalDateTime nowDT = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDate = nowDT.format(formatter);

	        lblNewLabel_1.setText(formattedDate);

			pnl.add(lblNewLabel_1);

		JLabel label = new JLabel("로또 6/45");
        panel_1.add(label);
//        sl_pnl.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, pnl);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 360, SpringLayout.WEST, pnl);
        sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, label);
        sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel, -8, SpringLayout.WEST, label);
//		pnl.add(label);
		
        panel_1.setBackground(Color.WHITE);
        sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, panel_1);
        sl_pnl.putConstraint(SpringLayout.SOUTH, panel_1, -465, SpringLayout.SOUTH, pnl);
        sl_pnl.putConstraint(SpringLayout.WEST, panel_1, 328, SpringLayout.WEST, pnl);
        pnl.add(panel_1);

       
		

		
		JLabel lblNewLabel_2 = new JLabel("당첨번호");
		  sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
	        sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_2, -363, SpringLayout.EAST, pnl);
	        lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 17));

	        pnl.add(lblNewLabel_2);


		
		 JPanel panel_2 = new JPanel();
	        sl_pnl.putConstraint(SpringLayout.NORTH, panel_2, 39, SpringLayout.SOUTH, ballApnl);
	        sl_pnl.putConstraint(SpringLayout.WEST, panel_2, 102, SpringLayout.WEST, pnl);
	        sl_pnl.putConstraint(SpringLayout.SOUTH, panel_2, -78, SpringLayout.SOUTH, pnl);
	        sl_pnl.putConstraint(SpringLayout.EAST, panel_2, -101, SpringLayout.EAST, pnl);
	        panel_2.setBackground(Color.WHITE);
	        panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	        pnl.add(panel_2);
	        panel_2.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("축하합니다!");
	    lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lblNewLabel_3.setBounds(50, 30, 100, 25);
		 sl_pnl.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 66, SpringLayout.NORTH, panel_2);
	        sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel_3, 68, SpringLayout.WEST, panel_2);
	        sl_pnl.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 289, SpringLayout.NORTH, panel_2);
	        sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel_3, 701, SpringLayout.WEST, panel_2);
	        		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("1등 당첨");
		 lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	        lblNewLabel_4.setBounds(50, 55, 353, 25);
	        panel_2.add(lblNewLabel_4);
	        
			System.out.println(lotto.buyNumberCollection.get(lotto.roundNum));

		setSize(800, 600);
		pnl.setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	public void removeBalls(JPanel pnl) {
		pnl.removeAll();
		pnl.revalidate();
		pnl.repaint();
	}
}
