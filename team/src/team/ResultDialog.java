import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class ResultDialog extends JDialog {
	private LottoProgram lotto;

	public ResultDialog(LottoProgram lottoProgram) {
		this.lotto = lottoProgram;

		JLabel backgroundImage = new JLabel(new ImageIcon("images/lottoResult.png"));
		SpringLayout springLayout = new SpringLayout();
		backgroundImage.setLayout(null);

		setTitle("구매내역");
		
		setModal(true);
		setSize(380, 522);
		setLocation(lotto.getX() + lotto.getWidth() + 190, lotto.getY());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JLabel lblTitle = new JLabel("구매내역/결과확인");
		
		lblTitle.setBounds(33, 10, 110, 19);
//		lblTitle.setBounds(33, 32, 110, 19);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 13));


		JLabel lottoDate = new JLabel("0000-00-00");
		lottoDate.setBounds(115, 120, 138, 17);
		LocalDateTime nowDT = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = nowDT.format(formatter);

        lottoDate.setText(formattedDate);
		lottoDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("제 1회");
		lblNewLabel_1.setBounds(235, 81, 59, 27);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setText("제 " + lotto.roundNum + "회");


		JLabel titleA = new JLabel("");
		titleA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleA.setBounds(51, 200, 69, 15);

		JLabel titleB = new JLabel("");
		titleB.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleB.setBounds(51, 240, 69, 15);

		JLabel titleC = new JLabel("");
		titleC.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleC.setBounds(51, 280, 69, 15);

		JLabel titleD = new JLabel("");
		titleD.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleD.setBounds(51, 320, 69, 15);

		JLabel titleE = new JLabel("");
		titleE.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		titleE.setBounds(51, 360, 69, 15);

		JLabel resultA = new JLabel("");
		resultA.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultA.setBounds(140, 200, 177, 15);

		JLabel resultB = new JLabel("");
		resultB.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultB.setBounds(140, 240, 177, 15);

		JLabel resultC = new JLabel("");
		resultC.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultC.setBounds(140, 280, 177, 15);

		JLabel resultD = new JLabel("");
		resultD.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultD.setBounds(140, 320, 177, 15);

		JLabel resultE = new JLabel("");
		resultE.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		resultE.setBounds(140, 360, 177, 15);


		JLabel total = new JLabel("");
		total.setBounds(270, 422, 57, 15);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(147, 422, 69, 34);

		System.out.println(lotto.resultBuy.get(0));

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});

		char ch = 'A';
		JLabel[] resultTitleLabels = { titleA, titleB, titleC, titleD, titleE };
		for (int j = 0; j < resultTitleLabels.length; j++) {
			if (!lotto.resultBuyTitle.get(j).isEmpty() && j < lotto.resultBuyTitle.size()
					&& lotto.resultBuyTitle.size() > 0) {
				StringBuilder resultTitleText = new StringBuilder();
				System.out.println((char) (ch + j));
				resultTitleText.append(ch).append(" ").append(lotto.resultBuyTitle.get(j)).append(" ");
				ch += 1;
				resultTitleLabels[j].setText(resultTitleText.toString());

			} else if (lotto.resultBuyTitle.get(j).equals("미지정")) {
				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
				resultTitleLabels[j].setText("");
			}
		}

		JLabel[] resultLabels = { resultA, resultB, resultC, resultD, resultE };
		for (int j = 0; j < resultLabels.length; j++) {
			if (!lotto.resultBuy.isEmpty() && j < lotto.resultBuy.size() && lotto.resultBuy.get(j).size() > 0) {
				StringBuilder resultText = new StringBuilder();
				for (int i = 0; i < 6 && i < lotto.resultBuy.get(j).size(); i++) {
					resultText.append(lotto.resultBuy.get(j).get(i)).append("  ");
				}
				resultLabels[j].setText(resultText.toString());
				
			} else {
				
				if (resultLabels[j].getText().isEmpty()) {
					resultTitleLabels[j].setText("");
				}
				// 이 블록은 예외를 방지하기 위한 로직을 추가할 수 있습니다.
				// 예를 들어, 메시지를 출력하거나 기본값을 설정하는 등의 작업을 수행할 수 있습니다.
				resultLabels[j].setText("");
			}
		}
		
		// 윈도우 빌더 사용가능
//		getContentPane().setLayout(null);
//		getContentPane().add(lblTitle);
//		getContentPane().add(lottoIcon);
//		getContentPane().add(lottoDate);
//		getContentPane().add(lblNewLabel_1);
//		getContentPane().add(secondLine);
//		getContentPane().add(titleA);
//		getContentPane().add(titleB);
//		getContentPane().add(titleC);
//		getContentPane().add(titleD);
//		getContentPane().add(titleE);
//		getContentPane().add(resultA);
//		getContentPane().add(resultB);
//		getContentPane().add(resultC);
//		getContentPane().add(resultD);
//		getContentPane().add(resultE);
//		getContentPane().add(thirdLine);
//		getContentPane().add(total);
//		getContentPane().add(btnNewButton);
//		

		backgroundImage.add(lblTitle);
		backgroundImage.add(lottoDate);
		backgroundImage.add(lblNewLabel_1);
		backgroundImage.add(titleA);
		backgroundImage.add(titleB);
		backgroundImage.add(titleC);
		backgroundImage.add(titleD);
		backgroundImage.add(titleE);
		backgroundImage.add(resultA);
		backgroundImage.add(resultB);
		backgroundImage.add(resultC);
		backgroundImage.add(resultD);
		backgroundImage.add(resultE);
		backgroundImage.add(total);
		backgroundImage.add(btnNewButton);

		getContentPane().add(backgroundImage);

	}

}
