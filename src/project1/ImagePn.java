package project1;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePn extends JPanel{
	private Image img;

	public ImagePn (Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));  //기본 사이즈
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null))); // 더 편한 사이즈? 둘다 해야지 사이즈가 적용된대요
		setLayout(null); // 필요한 컴퍼넌트를 절대값으로 넣을 수 있게 해줌
		
}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		
	}
}