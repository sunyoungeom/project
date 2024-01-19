
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

// 기표
public class ResultFrame extends JFrame {
	private LottoProgram lotto;

	public ResultFrame(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;
		setTitle("로또 결과 확인");
		JLabel backgroundImage = new JLabel(new ImageIcon("images/lottoResult.png"));
		SpringLayout spring = new SpringLayout();
		backgroundImage.setLayout(spring);
		
		
//		btnreturn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				lotto.setVisible(true);
//
//			}
//		});
		getContentPane().add(backgroundImage);
		pack();
		setVisible(false);

	}

//	public void updateResultLabels() {
//		if (lotto.resultBuy != null && lotto.resultBuy.size() <= 5) {
//			aResult.setText(lotto.resultBuy.get(0).toString());
//			bResult.setText(lotto.resultBuy.get(1).toString());
//			cResult.setText(lotto.resultBuy.get(2).toString());
//			dResult.setText(lotto.resultBuy.get(3).toString());
//			eResult.setText(lotto.resultBuy.get(4).toString());
//		}
//	}
}