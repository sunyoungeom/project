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
	private BuyFrame buyFrame = new BuyFrame();
	private ResultFrame resultFrame = new ResultFrame();
	private BeforeFrame beforeFrame = new BeforeFrame();
	private HelpFrame helpFrame = new HelpFrame();

	public LottoProgram() {
		setTitle("메인 창");
		JPanel main = new JPanel();
		
		JButton btnBuy = new JButton("구매하기");
		JButton btnResult = new JButton("결과확인");
		JButton btnBefore = new JButton("이전회차");
		JButton btnHelp = new JButton("도움말");
		
		main.add(btnBuy);
		main.add(btnResult);
		main.add(btnBefore);
		main.add(btnHelp);
		
		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				buyFrame.setVisible(true);
			}
		});
		
		btnResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				resultFrame.setVisible(true);
			}
		});
		
		btnBefore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				beforeFrame.setVisible(true);
			}
		});
		
		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				helpFrame.setVisible(true);
			}
		});
		add(main);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
