package project1;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class developers extends JFrame {

	JLabel lb, lb1, lb2, lb3, lb4, lb5;
	private JFrame frame;

	public developers() {
		initialize();
	}

	private void initialize() {
		
		setTitle("개발자123");
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 850);
		frame.setVisible(true);
		
		ImagePn Mainmenu = new ImagePn(new ImageIcon("image/developer.png").getImage());
		frame.getContentPane().add(Mainmenu, BorderLayout.NORTH);
		Mainmenu.setLayout(null);

		JButton bt1 = new JButton("\uD300\uBCC4 \uD604\uD669"); // '팀별현황'이 유니코드로 바뀐거
		bt1.setBounds(35, 40, 150, 50);
		Mainmenu.add(bt1);
		bt1.setBackground(new Color(225, 225, 225));

		JButton bt2 = new JButton("\uB79C\uB364 \uBF51\uAE30"); // '랜덤뽑기'
		bt2.setBounds(35, 160, 150, 50);
		Mainmenu.add(bt2);
		bt2.setBackground(new Color(225, 225, 225));

		JButton bt3 = new JButton("\uAC1C\uBC1C\uC790"); // '개발자'
		bt3.setBounds(35, 280, 150, 50);
		Mainmenu.add(bt3);
		bt3.setBackground(new Color(225, 225, 225));

		JButton bt4 = new JButton("\uCC98\uC74C\uC73C\uB85C"); // '처음으로'
		bt4.setForeground(new Color(0, 0, 0));
		bt4.setBounds(35, 400, 150, 50);
		Mainmenu.add(bt4);
		bt4.setBackground(new Color(225, 225, 225));

		bt1.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		bt2.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		bt3.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		bt4.setFont(new Font("휴먼모음T", Font.PLAIN, 17));

		// 팀명 : 팀업시켜조 / 프로젝트명 : 규리짱의 귤점제
		lb = new JLabel("   \uD300\uBA85 : \uCDE8\uC5C5\uC2DC\uCF1C\uC870  / \uD504\uB85C\uC81D\uD2B8 \uBA85  : \uADDC\uB9AC\uCA29\uC758 \uADE4\uC810\uC81C");
		lb.setBackground(new Color(255, 201, 125));
		lb.setBounds(280, 10, 510, 40);

		// 팀장 : 이해민
		lb1 = new JLabel("    \uD300 \uC7A5 : \uC774\uD574\uBBFC");
		lb1.setBackground(new Color(255, 228, 181));
		lb1.setBounds(300, 56, 181, 40);
		// 부팀장 : 윤근혁
		lb2 = new JLabel("  \uBD80 \uD300\uC7A5 : \uC724\uADFC\uD601");
		lb2.setBackground(new Color(255, 228, 181));
		lb2.setBounds(593, 56, 181, 40);
		// 조원 : 강승재
		lb3 = new JLabel("    \uC870 \uC6D0 : \uAC15\uC2B9\uC7AC");
		lb3.setBackground(new Color(255, 228, 181));
		lb3.setBounds(300, 310, 181, 50);
		// 조원 : 최창현
		lb4 = new JLabel("   \uC870 \uC6D0 : \uCD5C\uCC3D\uD604");
		lb4.setBackground(new Color(255, 228, 181));
		lb4.setBounds(593, 310, 181, 50);
		// 조원 : 박소현
		lb5 = new JLabel("   \uC870 \uC6D0 : \uBC15\uC18C\uD604");
		lb5.setBackground(new Color(255, 228, 181));
		lb5.setBounds(454, 558, 172, 50);
		

		lb.setFont(new Font("HY견고딕", Font.PLAIN, 20)); // 라벨 폰트
		lb1.setFont(new Font("휴먼엑스포", Font.PLAIN, 20)); // 라벨 폰트
		lb2.setFont(new Font("휴먼엑스포", Font.PLAIN, 20)); // 라벨 폰트
		lb3.setFont(new Font("휴먼엑스포", Font.PLAIN, 20)); // 라벨 폰트
		lb4.setFont(new Font("휴먼엑스포", Font.PLAIN, 20)); // 라벨 폰트
		lb5.setFont(new Font("휴먼엑스포", Font.PLAIN, 20)); // 라벨 폰트

		frame.pack();

		Mainmenu.add(lb);
		Mainmenu.add(lb1);
		Mainmenu.add(lb2);
		Mainmenu.add(lb3);
		Mainmenu.add(lb4);
		Mainmenu.add(lb5);

		// 각 팀원 프로필 사진 넣는 부분
		JButton HMBT = new JButton("New button");
		HMBT.setIcon(new ImageIcon("image/team1.jpg"));
		HMBT.setBounds(320, 102, 150, 186);
		Mainmenu.add(HMBT);

		JButton GHBT = new JButton("New button");
		GHBT.setIcon(new ImageIcon("image/team2.jpg"));
		GHBT.setBounds(608, 102, 150, 186);
		Mainmenu.add(GHBT);

		JButton SJBT = new JButton("New button");
		SJBT.setIcon(new ImageIcon("image/team3.png"));
		SJBT.setBounds(320, 366, 150, 186);
		Mainmenu.add(SJBT);

		JButton CHBT = new JButton("New button");
		CHBT.setIcon(new ImageIcon("image/team4.jpg"));
		CHBT.setBounds(608, 366, 150, 186);
		Mainmenu.add(CHBT);

		JButton SHBT = new JButton("New button");
		SHBT.setIcon(new ImageIcon("image/team5.jpg"));
		SHBT.setBounds(465, 612, 150, 186);
		Mainmenu.add(SHBT);
		
		
		// 각 팀원 별 프로필 사진 눌렀을 시 다이얼로그 창 뜸
		frame.setLocationRelativeTo(null);
		
		HMBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(HMBT, "우리팀오면 연예인시켜줌");
			}
		});

		GHBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(GHBT, "나보다 잘생긴사람 찾습니다");
			}
		});

		SJBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(SJBT, "지금 내기분이그래 어이가없네ㅎ?");
			}
		});

		CHBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(CHBT, "#코딩중 #7교시 #피곤하다 #셀카한장");
			}
		});

		SHBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(SHBT, "디자인의 디 자도 모르는 사람이 난생 처음으로 포토샵 깔았습니다. 창좀 빨리 닫아주세요ㅜㅜ ");
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SelectTeam1();
			}
		});

		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new random();
			}
		});
		

		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "이미 열려있습니다");
			}
		});

		bt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new sub();
			}
		});
	}
}
