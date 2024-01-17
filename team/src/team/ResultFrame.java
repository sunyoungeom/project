
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultFrame extends JFrame {
	private LottoProgram lotto;
	public ResultFrame(LottoProgram lottoProgram) {
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
		setSize(800,600);
		setVisible(false);
		
    }
}