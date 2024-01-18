
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
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


		
		SpringLayout sl_pnl = new SpringLayout();
		pnl.setLayout(sl_pnl);
		JButton btnreturn = new JButton("돌아가기");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnreturn, 10, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnreturn, 12, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnreturn, 35, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnreturn, 102, SpringLayout.WEST, pnl);
		pnl.add(btnreturn);

		getContentPane().add(pnl);

		JPanel panel = new JPanel();
		sl_pnl.putConstraint(SpringLayout.NORTH, panel, 80, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, panel, 70, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, panel, 160, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, panel, 620, SpringLayout.WEST, pnl);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnl.add(panel);

		JLabel A = new JLabel("A");
		sl_pnl.putConstraint(SpringLayout.NORTH, A, 240, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, A, 70, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, A, 260, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, A, 90, SpringLayout.WEST, pnl);
		A.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnl.add(A);

		JLabel AText = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, AText, 240, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, AText, 100, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, AText, 260, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, AText, 160, SpringLayout.WEST, pnl);
		AText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		pnl.add(AText);

		JLabel AResult = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, AResult, 240, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, AResult, 560, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, AResult, 255, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, AResult, 617, SpringLayout.WEST, pnl);
		pnl.add(AResult);

		JLabel B = new JLabel("B");
		sl_pnl.putConstraint(SpringLayout.NORTH, B, 300, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, B, 70, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, B, 320, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, B, 90, SpringLayout.WEST, pnl);
		B.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnl.add(B);

		JLabel BText = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, BText, 300, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, BText, 100, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, BText, 320, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, BText, 160, SpringLayout.WEST, pnl);
		BText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		pnl.add(BText);

		JLabel BResult = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, BResult, 300, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, BResult, 560, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, BResult, 315, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, BResult, 617, SpringLayout.WEST, pnl);
		pnl.add(BResult);

		JLabel C = new JLabel("C");
		sl_pnl.putConstraint(SpringLayout.NORTH, C, 360, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, C, 70, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, C, 380, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, C, 90, SpringLayout.WEST, pnl);
		C.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnl.add(C);

		JLabel CText = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, CText, 360, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, CText, 100, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, CText, 380, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, CText, 160, SpringLayout.WEST, pnl);
		CText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		pnl.add(CText);

		JLabel CResult = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, CResult, 360, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, CResult, 560, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, CResult, 375, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, CResult, 617, SpringLayout.WEST, pnl);
		pnl.add(CResult);

		JLabel D = new JLabel("D");
		sl_pnl.putConstraint(SpringLayout.NORTH, D, 420, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, D, 70, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, D, 440, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, D, 90, SpringLayout.WEST, pnl);
		D.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnl.add(D);

		JLabel DText = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, DText, 420, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, DText, 100, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, DText, 440, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, DText, 160, SpringLayout.WEST, pnl);
		DText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		pnl.add(DText);

		JLabel DResult = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, DResult, 420, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, DResult, 560, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, DResult, 435, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, DResult, 617, SpringLayout.WEST, pnl);
		pnl.add(DResult);

		JLabel E = new JLabel("E");
		sl_pnl.putConstraint(SpringLayout.NORTH, E, 480, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, E, 70, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, E, 500, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, E, 90, SpringLayout.WEST, pnl);
		E.setFont(new Font("SansSerif", Font.BOLD, 20));
		pnl.add(E);

		JLabel EText = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, EText, 480, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, EText, 100, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, EText, 500, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, EText, 160, SpringLayout.WEST, pnl);
		EText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		pnl.add(EText);

		JLabel EResult = new JLabel("");
		sl_pnl.putConstraint(SpringLayout.NORTH, EResult, 480, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, EResult, 560, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, EResult, 495, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, EResult, 617, SpringLayout.WEST, pnl);
		pnl.add(EResult);

		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);

				// 출력값 확인용
				if (lotto.resultBuy != null) {
					System.out.println(lotto.resultBuy.get(0));
				}
			}
		});

//		pnl2.setBounds(0, 0, 684, 561);
		if (lotto.resultBuy != null) {
			for (int i = 0; i < lotto.resultBuy.size(); i++) {
				
				System.out.println(lotto.resultBuy.get(i));
				lotto.showBuyBall(pnl, sl_pnl, -200, lotto.resultBuy.get(i));
				
			}
		}

		

		setSize(700, 600);
		setVisible(false);

	}
}