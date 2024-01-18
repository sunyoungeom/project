
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

// 기표
public class ResultFrame extends JFrame {
	private LottoProgram lotto;
	private JLabel aResult;
	private JLabel bResult;
	private JLabel cResult;
	private JLabel dResult;
	private JLabel eResult;

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

		aResult = new JLabel("");
		aResult.setBounds(560, 240, 57, 15);
		pnl.add(aResult);

		JLabel aNumber = new JLabel("New label");
		aNumber.setBounds(291, 240, 57, 15);
		pnl.add(aNumber);
		if (lotto.resultBuy != null && lotto.resultBuy.size() >= 5) {
			StringBuilder indexNumber = new StringBuilder();
			aNumber.setText(lotto.resultBuy.get(0).toString());
		}

		JLabel B = new JLabel("B");
		B.setFont(new Font("SansSerif", Font.BOLD, 20));
		B.setBounds(70, 300, 20, 20);
		pnl.add(B);

		JLabel BText = new JLabel("");
		BText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		BText.setBounds(100, 300, 60, 20);
		pnl.add(BText);

		bResult = new JLabel("");
		bResult.setBounds(560, 300, 57, 15);
		pnl.add(bResult);

		JLabel C = new JLabel("C");
		C.setFont(new Font("SansSerif", Font.BOLD, 20));
		C.setBounds(70, 360, 20, 20);
		pnl.add(C);

		JLabel CText = new JLabel("");
		CText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		CText.setBounds(100, 360, 60, 20);
		pnl.add(CText);

		cResult = new JLabel("");
		cResult.setBounds(560, 360, 57, 15);
		pnl.add(cResult);

		JLabel D = new JLabel("D");
		D.setFont(new Font("SansSerif", Font.BOLD, 20));
		D.setBounds(70, 420, 20, 20);
		pnl.add(D);

		JLabel DText = new JLabel("");
		DText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		DText.setBounds(100, 420, 60, 20);
		pnl.add(DText);

		dResult = new JLabel("");
		dResult.setBounds(560, 420, 57, 15);
		pnl.add(dResult);

		JLabel E = new JLabel("E");
		E.setFont(new Font("SansSerif", Font.BOLD, 20));
		E.setBounds(70, 480, 20, 20);
		pnl.add(E);

		JLabel EText = new JLabel("");
		EText.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		EText.setBounds(100, 480, 60, 20);
		pnl.add(EText);

		eResult = new JLabel("");
		eResult.setBounds(560, 480, 57, 15);
		pnl.add(eResult);

		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				lotto.setVisible(true);

			}
		});

////		pnl2.setBounds(0, 0, 684, 561);
//		if (lotto.resultBuy != null) {
//				
//				System.out.println(lotto.resultBuy.get(0));
//				lotto.showBuyBall(pnl, sl_pnl, -200, lotto.resultBuy.get(0));
//				
//		}
//
//		

		setSize(700, 600);
		setVisible(false);

	}

	public void updateResultLabels() {
		if (lotto.resultBuy != null && lotto.resultBuy.size() <= 5) {
			aResult.setText(lotto.resultBuy.get(0).toString());
			bResult.setText(lotto.resultBuy.get(1).toString());
			cResult.setText(lotto.resultBuy.get(2).toString());
			dResult.setText(lotto.resultBuy.get(3).toString());
			eResult.setText(lotto.resultBuy.get(4).toString());
		}
	}
}