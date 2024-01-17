package team;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeforeFrame extends JFrame { // 이전회차
	public BeforeFrame() {
		JPanel pnl = new JPanel();
		pnl.add(new JLabel("Carddfs Content"));
		add(pnl);
	}
}