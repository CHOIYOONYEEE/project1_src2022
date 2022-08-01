package project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;

public class sub extends JFrame{
	JLabel lb1;
	
	public sub() {
		super("메인메뉴"); // Frame title
		setSize(850, 850);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 850, 850);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		

		ImagePanel Main1Panel = new ImagePanel(new ImageIcon("image/gul.png").getImage());
		Main1Panel.setBounds(0, 0, 850, 850);
		Main1Panel.setBackground(Color.ORANGE);
		setSize(Main1Panel.getWidth(),Main1Panel.getHeight()); // 그림크기에 맞춰 프레임 가로 세로 조정
		getContentPane().add(Main1Panel);

		GradientDropdownMenu menu = new GradientDropdownMenu();
		menu.setMenuHeight(70);
		menu.setGradientColor(new Color(230,58,58), new Color(200,150,30));
		menu.setBackground(new Color(0,0,0));
		menu.setHeaderGradient(true);
		menu.addItem("Home");
		menu.addItem("   ");
		menu.addItem("   ");
		menu.addItem("   ");
		menu.addItem("포인트 추가","귤 추가");
		menu.addItem("팀별 현황", "화목한 조 현황", "코른이 대공원 현황", "조명은 LED 현황", "자료구조 현황");
		menu.addItem("포인트 게임","랜덤 박스","주사위","경마");
		menu.addItem("테마","Black","Orange","Green");
		menu.addItem("관리자 설정","학생편집","포인트 리셋");
		menu.applay(this);
		menu.addEvent((MenuEvent) new MenuEvent() {
		
		    @Override
		    public void selected(int index, int subIndex, boolean menuItem) {
		        if (menuItem) {
		            
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Home")) {
		        		dispose();
		        		new sub();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("귤 추가")) {
		        		dispose();
		        		new Addgul();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("화목한 조 현황")) {
		        		dispose();
		        		new SelectTeam1();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("코른이 대공원 현황")) {
		        		dispose();
		        		new SelectTeam2();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("조명은 LED 현황")) {
		        		dispose();
		        		new SelectTeam3();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("자료구조 현황")) {
		        		dispose();
		        		new SelectTeam4();
		        		
		        	}if (menu.getMenuNameAt(index, subIndex).trim().equals("학생편집")) {
						dispose();
						new Addgul2();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Black")) {
		        		menu.setBackground(new Color(0,0,0));
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Orange")) {
		        		menu.setBackground(new Color(230,100,10));
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Green")) {
		        		menu.setBackground(new Color(25,51,0));
		        	}
		        }
		    }
		});
		
		//--------------------------------------------------------------------------------------
	
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}
	
	private Color Color(int i, int j, int k) {
		return null;
	}

	class ImagePanel extends JPanel{
		private Image img;

		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setLayout(null);
		}
		
		public int getWidth() {
			return img.getWidth(null); //이미지 가로 넓이
		}
		public int getHeight() {
			return img.getHeight(null);
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}		

	
}

