
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.SpringLayout;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

public class LottoProgram extends JFrame {
//	private HelpFrame helpFrame = new HelpFrame(this);
	public ArrayList<ArrayList<String>> resultBuy = new ArrayList<>(5);
public ArrayList<ArrayList<String>> resultBuyTemp = new ArrayList<>(5);
//    public ArrayList<ArrayList<String>> resultBuyTitles = new ArrayList<>();
	public ArrayList<String> resultBuyTitle = new ArrayList<>(5);
	public ArrayList<String> resultBuyTitleTemp = new ArrayList<>(5);
	public int roundNum = 0;
	public static Map<Integer, ArrayList<String>> winningNumberCollection = new TreeMap<>();
	public static Map<Integer, ArrayList<ArrayList<String>>> buyNumberCollection = new TreeMap<>();
	public static Map<Integer, ArrayList<String>> buyNumberCollectionTitle = new TreeMap<>();

	public static CircleImagePanel circleImagePanel;
	public static ImageTextPair[] imageTextPairs = new ImageTextPair[6];
	private BufferedImage scratchLayer;
	private boolean isScratching = false;

	public int getRoundNum() {
		return roundNum;
	}

	public void setRoundNum(int roundNum) {
		this.roundNum = roundNum;
	}

	public LottoProgram() {
		for (int i = 0; i < 5; i++) {
			resultBuy.add(new ArrayList<>());
		}

		for (int i = 0; i < 5; i++) {
			resultBuyTitle.add("");
		}
		
		setTitle("메인 창");

		JPanel main = new JPanel();
		JLabel backgroundImage = new JLabel(new ImageIcon("images/나눔로또.png"));
		//images/lottoMain.jpeg
		SpringLayout sl_main = new SpringLayout();
		backgroundImage.setLayout(null);

		JButton btnBuy = new JButton("구매하기");
		JButton btnResult = new JButton("결과확인");
		JButton btnBefore = new JButton("이전회차");
		JButton btnHelp = new JButton("결과확인");
		btnBuy.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnResult.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnBefore.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnHelp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnBuy.setBounds(33, 10, 110, 19);
		btnResult.setBounds(33, 10, 110, 19);
		btnBefore.setBounds(33, 10, 110, 19);
		btnHelp.setBounds(33, 10, 110, 19);
		backgroundImage.add(btnBuy);
//		backgroundImage.add(btnResult);
		backgroundImage.add(btnBefore);
		backgroundImage.add(btnHelp);
		btnBuy.setBounds(100, 400, 150, 70);
		btnBuy.setBackground(Color.white);
		btnBefore.setBounds(300, 400, 150, 70);
		btnBefore.setBackground(Color.white);
		btnHelp.setBounds(500, 400, 150, 70);
		btnHelp.setBackground(Color.white);

		main.add(backgroundImage);
		
		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (resultBuy.get(0).size() == 0
						&& resultBuy.get(1).size() == 0
						&& resultBuy.get(2).size() == 0
						&& resultBuy.get(3).size() == 0
						&& resultBuy.get(4).size() == 0) {
					setVisible(false);
					BuyFrame buyFrame = new BuyFrame(LottoProgram.this);
					buyFrame.setVisible(true);
					buyFrame.returnCount = 0;
				} else {
					System.out.println("이미 구매한회차");
					JOptionPane.showMessageDialog(null, "이미 구매한 회차 입니다.", "해당 회차 종료", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});

		btnResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (resultBuy.get(0).size() != 0) {
					setVisible(false);
					ResultFrame resultFrame = new ResultFrame(LottoProgram.this);
					resultFrame.setVisible(true);
					System.out.println(buyNumberCollection.get(roundNum));
				} else {
					JOptionPane.showMessageDialog(LottoProgram.this, "구매하기를 먼저 진행해 주세요", "해당 회차 종료",
							JOptionPane.WARNING_MESSAGE);
					System.out.println("구매하기 먼저");
				}

			}
			
		});

		btnBefore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (winningNumberCollection.get(roundNum) != null) {
					System.out.println("여기"+buyNumberCollection.get(roundNum));
					setVisible(false);
					BeforeFrame beforeFrame = new BeforeFrame(LottoProgram.this);
					beforeFrame.setVisible(true);
//					showRBall(lotto.winningNumberCollection.get(roundNum), pnl, sl_pnl, 10, 10);
					System.out.println(winningNumberCollection.get(roundNum));
				} else {
					JOptionPane.showMessageDialog(LottoProgram.this, "이전 회차가 없습니다.", "누적회차 부족", JOptionPane.WARNING_MESSAGE);

				}
			}
		});

		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (resultBuy.get(0).size() != 0) {
					setVisible(false);
					HelpFrame helpFrame = new HelpFrame(LottoProgram.this);
					helpFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(LottoProgram.this, "구매하기를 먼저 진행해 주세요", "회차 결과 없음",
					JOptionPane.WARNING_MESSAGE);
					System.out.println("구매하기 먼저");
				}
			}
		});

		getContentPane().add(main);

		setSize(800, 600);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
