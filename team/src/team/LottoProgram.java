package team;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.net.www.content.image.jpeg;
import javax.swing.SpringLayout;

public class LottoProgram extends JFrame {
	private BuyFrame buyFrame;
	private ResultFrame resultFrame = new ResultFrame();
	private BeforeFrame beforeFrame = new BeforeFrame();
	private HelpFrame helpFrame = new HelpFrame();

	public LottoProgram() {
		buyFrame = new BuyFrame();
		
		JPanel main = new JPanel();
		CardLayout cardlayout = new CardLayout();
		main.setLayout(cardlayout);

		JPanel start = new JPanel();
		JButton btnBuy = new JButton("구매하기");
		JButton btnResult = new JButton("결과확인");
		JButton btnBefore = new JButton("이전회차");
		JButton btnHelp = new JButton("도움말");
		SpringLayout sl_start = new SpringLayout();
		sl_start.putConstraint(SpringLayout.NORTH, btnResult, 187, SpringLayout.NORTH, start);
		sl_start.putConstraint(SpringLayout.SOUTH, btnResult, -47, SpringLayout.NORTH, btnBefore);
		sl_start.putConstraint(SpringLayout.NORTH, btnBefore, 292, SpringLayout.NORTH, start);
		sl_start.putConstraint(SpringLayout.WEST, btnBefore, 0, SpringLayout.WEST, btnBuy);
		sl_start.putConstraint(SpringLayout.SOUTH, btnBefore, -37, SpringLayout.NORTH, btnHelp);
		sl_start.putConstraint(SpringLayout.EAST, btnBefore, -113, SpringLayout.EAST, start);
		sl_start.putConstraint(SpringLayout.NORTH, btnHelp, 387, SpringLayout.NORTH, start);
		sl_start.putConstraint(SpringLayout.NORTH, btnBuy, 84, SpringLayout.NORTH, start);
		sl_start.putConstraint(SpringLayout.WEST, btnBuy, 524, SpringLayout.WEST, start);
		sl_start.putConstraint(SpringLayout.SOUTH, btnBuy, -45, SpringLayout.NORTH, btnResult);
		sl_start.putConstraint(SpringLayout.EAST, btnBuy, -113, SpringLayout.EAST, start);
		sl_start.putConstraint(SpringLayout.WEST, btnResult, 524, SpringLayout.WEST, start);
		sl_start.putConstraint(SpringLayout.EAST, btnResult, 0, SpringLayout.EAST, btnBuy);
		sl_start.putConstraint(SpringLayout.WEST, btnHelp, 524, SpringLayout.WEST, start);
		sl_start.putConstraint(SpringLayout.EAST, btnHelp, -113, SpringLayout.EAST, start);
		sl_start.putConstraint(SpringLayout.SOUTH, btnHelp, -116, SpringLayout.SOUTH, start);
		start.setLayout(sl_start);
		start.add(btnBuy);
		start.add(btnResult);
		start.add(btnBefore);
		start.add(btnHelp);

		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(main, "구매하기");
			}
		});
		btnResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(main, "결과확인");
			}
		});
		btnBefore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(main, "이전회차");
			}
		});
		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(main, "도움말");
			}
		});
		main.add(start, "시작화면");
		main.add(buyFrame, "구매하기");
		main.add(resultFrame, "결과확인");
		main.add(beforeFrame, "이전회차");
		main.add(helpFrame, "도움말");
		getContentPane().add(main);

		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
}
