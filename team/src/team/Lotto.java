//package team;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JToggleButton;
//import javax.swing.border.EmptyBorder;
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Component;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.SpringLayout;
//import javax.swing.JCheckBox;
//import javax.swing.SwingConstants;
//import java.awt.Rectangle;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//import net.miginfocom.swing.MigLayout;
//
//public class Lotto extends JFrame {
//	
//	private JPanel contentPane;
//	private ArrayList<JToggleButton> numberToggleButtons;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Lotto frame = new Lotto();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Lotto() {
//
//		JPanel panel = new JPanel();
//		CardLayout card = new CardLayout();
//		getContentPane().add(panel, BorderLayout.CENTER);
//		panel.setLayout(card);
//		JButton btn2 = new JButton("결과확인");
//		JButton btn3 = new JButton("이전회차");
//		JButton btn4 = new JButton("도움말");
//
//		JPanel main = new JPanel();
//		SpringLayout sl_main = new SpringLayout();
//		sl_main.putConstraint(SpringLayout.SOUTH, btn3, -92, SpringLayout.NORTH, btn4);
//		sl_main.putConstraint(SpringLayout.SOUTH, btn4, -36, SpringLayout.SOUTH, main);
//		main.setLayout(sl_main);
//		
//		JPanel buy = new JPanel();
//		buy.setBackground(Color.WHITE);
//		
//		JPanel result = new JPanel();
//		
//		JPanel before = new JPanel();
//		
//		JPanel help = new JPanel();
//		
//
//		JButton btn1 = new JButton("구매하기");
//		sl_main.putConstraint(SpringLayout.NORTH, btn2, 102, SpringLayout.SOUTH, btn1);
//		sl_main.putConstraint(SpringLayout.EAST, btn2, 0, SpringLayout.EAST, btn1);
//		sl_main.putConstraint(SpringLayout.WEST, btn3, 0, SpringLayout.WEST, btn1);
//		sl_main.putConstraint(SpringLayout.WEST, btn4, 0, SpringLayout.WEST, btn1);
//		sl_main.putConstraint(SpringLayout.EAST, btn4, 0, SpringLayout.EAST, btn1);
//		sl_main.putConstraint(SpringLayout.NORTH, btn1, 30, SpringLayout.NORTH, main);
//		sl_main.putConstraint(SpringLayout.EAST, btn1, -55, SpringLayout.EAST, main);
//	
//		btn1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				card.show(panel, "구매화면");
//			}
//		});
//		btn2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				card.show(panel, "결과화면");
//			}
//		});
//		btn3.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				card.show(panel, "이전회차");
//			}
//		});
//		btn4.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				card.show(panel, "도움말");
//			}
//		});
//		
//		main.add(btn1);
//		main.add(btn2);
//		main.add(btn3);
//		main.add(btn4);
//
//		
//		
//		panel.add(main, "초기화면");
//		panel.add(buy, "구매화면");
//		
//		
//		
//		
//		
//		numberToggleButtons = new ArrayList<>();
//		SpringLayout sl_buy = new SpringLayout();
//		buy.setLayout(sl_buy);
//		
//		JPanel toggleButtonPanel = new JPanel(); // 6개의 번호 고르는 화면
//		toggleButtonPanel.setBackground(Color.WHITE);
//		sl_buy.putConstraint(SpringLayout.NORTH, toggleButtonPanel, 130, SpringLayout.NORTH, buy);
//		sl_buy.putConstraint(SpringLayout.WEST, toggleButtonPanel, 0, SpringLayout.WEST, buy);
//		sl_buy.putConstraint(SpringLayout.SOUTH, toggleButtonPanel, 519, SpringLayout.NORTH, buy);
//		sl_buy.putConstraint(SpringLayout.EAST, toggleButtonPanel, 248, SpringLayout.WEST, buy);
//		buy.add(toggleButtonPanel);
//		toggleButtonPanel.setLayout(new GridLayout(9, 5));
//		
//		for (int i = 1; i <= 45; i++) {
//			JToggleButton toggleButton = new JToggleButton();
//			toggleButton.setText(String.valueOf(i)); // 
//			numberToggleButtons.add(toggleButton);
//			toggleButton.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					//
//				}
//			});
//			toggleButtonPanel.add(toggleButton);
//		}
//		
//		
//		JPanel panel_2 = new JPanel(); // 고른번호를 출력화면
//		panel_2.setBackground(Color.WHITE);
//		sl_buy.putConstraint(SpringLayout.NORTH, panel_2, 63, SpringLayout.NORTH, buy);
//		sl_buy.putConstraint(SpringLayout.WEST, panel_2, 774, SpringLayout.WEST, buy);
//		sl_buy.putConstraint(SpringLayout.SOUTH, panel_2, 519, SpringLayout.NORTH, buy);
//		buy.add(panel_2);
//		
//		JPanel panel_3 = new JPanel(); // 위에세팅 
//		panel_3.setBackground(Color.WHITE);
//		sl_buy.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, buy);
//		sl_buy.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, buy);
//		sl_buy.putConstraint(SpringLayout.EAST, panel_3, 784, SpringLayout.WEST, buy);
//		buy.add(panel_3);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.WHITE);
//		sl_buy.putConstraint(SpringLayout.NORTH, panel_1, 519, SpringLayout.NORTH, buy);
//		sl_buy.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, buy);
//		sl_buy.putConstraint(SpringLayout.EAST, panel_1, 784, SpringLayout.WEST, buy);
//		buy.add(panel_1);
//		panel_1.setLayout(new MigLayout("", "[69px][81px][81px]", "[23px]"));
//		panel_1.setLayout(new MigLayout("", "[1px][1px]", "[1px][1px]"));
//		
//		JButton btnNewButton_2 = new JButton("초기화");
//		btnNewButton_2.setBounds(new Rectangle(100, 10, 0, 0));
//		panel_1.add(btnNewButton_2, "flowx,cell 0 0,grow");
//		
//		JButton btnNewButton_1 = new JButton("자동선택");
//		btnNewButton_1.setToolTipText("");
//		panel_1.add(btnNewButton_1, "cell 0 0,grow");
//		
//		JButton btnNewButton = new JButton("구매하기");
//		panel_1.add(btnNewButton, "cell 0 0,grow");
//		panel.add(result, "결과화면");
//		panel.add(before, "이전회차");
//		panel.add(help, "도움말");
//
//		JLabel lbl = new JLabel(new ImageIcon(Lotto.class.getResource("/images/lotto.jpg")));
//		panel_3.add(lbl, BorderLayout.NORTH);
//		
//		showGUI();
//	}
//
//	private void showGUI() {
//		setSize(800, 600);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//	}
//}