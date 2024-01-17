
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

// 기표
public class ResultFrame extends JFrame {
	private LottoProgram lotto;

	public ResultFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;

		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		JButton btnreturn = new JButton("돌아가기");
		btnreturn.setBounds(12, 10, 81, 23);
		pnl.add(btnreturn);
		getContentPane().add(pnl);

		JPanel panel = new JPanel();
		panel.setBounds(68, 55, 556, 77);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		pnl.add(panel);

		JLabel A = new JLabel("A");
		A.setBounds(70, 240, 16, 15);
		pnl.add(A);

		JLabel AText = new JLabel("");
		AText.setBounds(100, 240, 57, 15);
		pnl.add(AText);

		JLabel AResult = new JLabel("");
		AResult.setBounds(560, 240, 57, 15);
		pnl.add(AResult);

		JLabel B = new JLabel("B");
		B.setBounds(70, 300, 16, 15);
		pnl.add(B);

		JLabel BText = new JLabel("");
		BText.setBounds(100, 300, 57, 15);
		pnl.add(BText);

		JLabel BResult = new JLabel("");
		BResult.setBounds(560, 300, 57, 15);
		pnl.add(BResult);

		JLabel C = new JLabel("C");
		C.setBounds(70, 360, 16, 15);
		pnl.add(C);

		JLabel CText = new JLabel("");
		CText.setBounds(100, 360, 57, 15);
		pnl.add(CText);

		JLabel CResult = new JLabel("");
		CResult.setBounds(560, 360, 57, 15);
		pnl.add(CResult);

		JLabel D = new JLabel("D");
		D.setBounds(70, 420, 16, 15);
		pnl.add(D);

		JLabel DText = new JLabel("");
		DText.setBounds(100, 420, 57, 15);
		pnl.add(DText);

		JLabel DResult = new JLabel("");
		DResult.setBounds(560, 420, 57, 15);
		pnl.add(DResult);

		JLabel E = new JLabel("E");
		E.setBounds(70, 480, 16, 15);
		pnl.add(E);

		JLabel EText = new JLabel("");
		EText.setBounds(100, 480, 57, 15);
		pnl.add(EText);

		JLabel EResult = new JLabel("");
		EResult.setBounds(560, 480, 57, 15);
		pnl.add(EResult);

		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);

			}
		});
		setSize(700, 600);
		setVisible(false);

	}
}