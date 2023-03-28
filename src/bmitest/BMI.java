package bmitest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BMI extends JFrame {

	private JPanel contentPane;
	private JTextField height;
	private JTextField weight;

	public BMI() {

		setTitle("BMI 측정기"); // 타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 메모리에서 닫기
		setBounds(100, 100, 280, 300); // 화면 사이즈 설정
		contentPane = new JPanel(); // 패널 생성
		contentPane.setLayout(null); // 패널 레이아웃 알아서 설정
		setContentPane(contentPane); // 패널 달기
		setLocationRelativeTo(null); // 화면 가운대로 켜지게 설정

		JLabel newLabel = new JLabel("키(CM) :"); // 라벨생성
		newLabel.setBounds(30, 28, 70, 15); // 사이즈설정
		contentPane.add(newLabel); // 패널에 라벨 추가하기

		height = new JTextField(); // 키 입력하는 칸 생성
		height.setBounds(120, 25, 116, 21); // 사이즈설정
		contentPane.add(height); // 키 입력칸 패널에 추가

		JLabel newLabel2 = new JLabel("몸무게(KG) :");
		newLabel2.setBounds(30, 68, 70, 15);
		contentPane.add(newLabel2);

		JLabel newLabel3 = new JLabel(
				"<HTML><body>18.5 ↓ = 저체중<br>18.5 ~ 24.9 = 정상<br>24.9 ~ 29.9 = 과제충 <br>29.9 ↑ = 비만 </HTML></body>");
		newLabel3.setBounds(80, 120, 150, 150);
		contentPane.add(newLabel3);

		weight = new JTextField();
		weight.setBounds(120, 65, 116, 21);
		contentPane.add(weight);

		JButton newButton = new JButton("BMI 측정하기");
		newButton.setBounds(37, 113, 197, 23);
		contentPane.add(newButton);

		newButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double height2 = Integer.parseInt(height.getText());
				double weight2 = Integer.parseInt(weight.getText());
				double bmi = Math.round(weight2 / ((height2 / 100) * (height2 / 100)) * 100) / 100.0;
				// BMI 공식 = 몸무게 /키*키 (cm 미터로 변환)

				String bmiStr = "";
				if (bmi <= 18.5) {
					bmiStr = "저체중";
				} else if (bmi <= 24.9) {
					bmiStr = "정상";
				} else if (bmi <= 29.9) {
					bmiStr = "과체중";
				} else {
					bmiStr = "비만";
				}

				String result = "당신의 BMI는 " + bmi + " " + bmiStr + " 입니다.";

				JOptionPane.showMessageDialog(null, result); // 결과창 띄운다
			}
		});
	}
}
