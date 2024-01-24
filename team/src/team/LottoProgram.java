
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
//    public ArrayList<ArrayList<String>> resultBuyTitles = new ArrayList<>();
	public ArrayList<String> resultBuyTitle = new ArrayList<>(5);
	public int roundNum = 0;
	public static Map<Integer, ArrayList<String>> winningNumberCollection = new TreeMap<>();
	public static Map<Integer, ArrayList<ArrayList<String>>> buyNumberCollection = new TreeMap<>();

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
		JLabel backgroundImage = new JLabel(new ImageIcon("images/lottoMainimage.png"));
		SpringLayout sl_main = new SpringLayout();
		backgroundImage.setLayout(sl_main);

		JButton btnBuy = new JButton("구매하기");
		JButton btnResult = new JButton("결과확인");
		JButton btnBefore = new JButton("이전회차");
		JButton btnHelp = new JButton("도움말");

		backgroundImage.add(btnBuy);
		backgroundImage.add(btnResult);
		backgroundImage.add(btnBefore);
		backgroundImage.add(btnHelp);
		sl_main.putConstraint(SpringLayout.WEST, btnBuy, 347, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, btnBuy, -155, SpringLayout.EAST, main);
		sl_main.putConstraint(SpringLayout.NORTH, btnBuy, 108, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.SOUTH, btnBuy, -420, SpringLayout.SOUTH, main);
		sl_main.putConstraint(SpringLayout.NORTH, btnResult, 0, SpringLayout.SOUTH, btnBuy);
		sl_main.putConstraint(SpringLayout.SOUTH, btnResult, 85, SpringLayout.SOUTH, btnBuy);
		sl_main.putConstraint(SpringLayout.WEST, btnResult, 0, SpringLayout.WEST, btnBuy);
		sl_main.putConstraint(SpringLayout.EAST, btnResult, 308, SpringLayout.WEST, btnBuy);
		sl_main.putConstraint(SpringLayout.NORTH, btnBefore, 0, SpringLayout.SOUTH, btnResult);
		sl_main.putConstraint(SpringLayout.SOUTH, btnBefore, 83, SpringLayout.SOUTH, btnResult);
		sl_main.putConstraint(SpringLayout.WEST, btnBefore, 0, SpringLayout.WEST, btnResult);
		sl_main.putConstraint(SpringLayout.EAST, btnBefore, 0, SpringLayout.EAST, btnResult);
		sl_main.putConstraint(SpringLayout.NORTH, btnHelp, 0, SpringLayout.SOUTH, btnBefore);
		sl_main.putConstraint(SpringLayout.SOUTH, btnHelp, 80, SpringLayout.SOUTH, btnBefore);
		sl_main.putConstraint(SpringLayout.WEST, btnHelp, 0, SpringLayout.WEST, btnBefore);
		sl_main.putConstraint(SpringLayout.EAST, btnHelp, 0, SpringLayout.EAST, btnBefore);

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
					setVisible(false);
					BeforeFrame beforeFrame = new BeforeFrame(LottoProgram.this);
					beforeFrame.setVisible(true);
//					showRBall(lotto.winningNumberCollection.get(roundNum), pnl, sl_pnl, 10, 10);
					System.out.println(winningNumberCollection.get(roundNum));
				} else {
					JOptionPane.showMessageDialog(null, "이전 회차가 없습니다.", "누적회차 부족", JOptionPane.WARNING_MESSAGE);

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
