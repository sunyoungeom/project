package team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeforeFrame extends JFrame { // 이전회차
	private LottoProgram lotto;
	public BeforeFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		
		JPanel pnl = new JPanel();
		JButton btnreturn = new JButton("돌아가기");
		pnl.add(btnreturn);
		add(pnl);
		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);
				
			}
		});
		setSize(500,500);
		setVisible(false);
		
	}
}