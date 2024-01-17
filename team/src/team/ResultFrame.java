
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Font;

// 기표
public class ResultFrame extends JFrame {
	private LottoProgram lotto;

	public ResultFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		setTitle("로또 결과 확인");
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		JButton btnreturn = new JButton("돌아가기");
		btnreturn.setBounds(12, 10, 90, 25);
		pnl.add(btnreturn);
		getContentPane().add(pnl);

		JPanel panel = new JPanel();
		panel.setBounds(70, 80, 550, 80); // 결과 창이 나오는 패널
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnl.add(panel);

		JLabel A = new JLabel("A");
		A.setFont(new Font("SansSerif", Font.BOLD, 20));
		A.setBounds(70, 240, 20, 20);
		pnl.add(A);

		JLabel AText = new JLabel("");
		AText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		AText.setBounds(100, 240, 60, 20);
		pnl.add(AText);

		JLabel AResult = new JLabel("");
		AResult.setBounds(560, 240, 57, 15);
		pnl.add(AResult);

		JLabel B = new JLabel("B");
		B.setFont(new Font("SansSerif", Font.BOLD, 20));
		B.setBounds(70, 300, 20, 20);
		pnl.add(B);

		JLabel BText = new JLabel("");
		BText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		BText.setBounds(100, 300, 60, 20);
		pnl.add(BText);

		JLabel BResult = new JLabel("");
		BResult.setBounds(560, 300, 57, 15);
		pnl.add(BResult);

		JLabel C = new JLabel("C");
		C.setFont(new Font("SansSerif", Font.BOLD, 20));
		C.setBounds(70, 360, 20, 20);
		pnl.add(C);

		JLabel CText = new JLabel("");
		CText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		CText.setBounds(100, 360, 60, 20);
		pnl.add(CText);

		JLabel CResult = new JLabel("");
		CResult.setBounds(560, 360, 57, 15);
		pnl.add(CResult);

		JLabel D = new JLabel("D");
		D.setFont(new Font("SansSerif", Font.BOLD, 20));
		D.setBounds(70, 420, 20, 20);
		pnl.add(D);

		JLabel DText = new JLabel("");
		DText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		DText.setBounds(100, 420, 60, 20);
		pnl.add(DText);

		JLabel DResult = new JLabel("");
		DResult.setBounds(560, 420, 57, 15);
		pnl.add(DResult);

		JLabel E = new JLabel("E");
		E.setFont(new Font("SansSerif", Font.BOLD, 20));
		E.setBounds(70, 480, 20, 20);
		pnl.add(E);

		JLabel EText = new JLabel("");
		EText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		EText.setBounds(100, 480, 60, 20);
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