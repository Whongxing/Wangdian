package JFram;




import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Date;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JProgressBar;
import javax.swing.JTextField;

import Content.Main;
import Eorry.Finish;


public class Client extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static Label la1 = new Label();
	public static Label JD = new Label();
	public JProgressBar progressbar;
	public String path;
	public String xlspath;

	JFileChooser fc = new JFileChooser();
	JFileChooser fc2 = new JFileChooser();
	JTextField text, text2;
	JButton button, button1, button2, button3, button4;
	JLabel la;
	BufferedImage img = null;
	ActionListener listener;
	public static final int LOAD_WIDTH = 455;
	public static final int LOAD_HEIGHT = 295;

	public Client() {

		/************************************************/
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}

	void init() {
		// ImageIcon icon = new ImageIcon("a.jpg");
		//JOptionPane.showMessageDialog(this, "识别完成");
		text = new JTextField();
		text.setBounds(240, 210, 270, 60);
		add(text);
		text2 = new JTextField();
		text2.setBounds(240, 290, 270, 60);
		add(text2);
		button = new JButton("选择图片文件夹");
		button.setBounds(560, 210, 270, 60);
		/*
		 * button.setBorder(null); button.setContentAreaFilled(false);
		 * button.setOpaque(false); button.setBorder(null);
		 * button.setIcon(icon);
		 */
		add(button);
		button2 = new JButton("选择结果的保存位置");
		button2.setBounds(560, 290, 270, 60);
		add(button2);
		button.addActionListener(this);
		button1 = new JButton("开始识别");
		button1.setBounds(365, 361, 313, 65);
		add(button1);
		button3 = new JButton("终止识别");
		button3.setBounds(310, 434, 400, 25);
		add(button3);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int intRetVal = fc.showOpenDialog(this);
			if (intRetVal == JFileChooser.APPROVE_OPTION/* 获取选中的文件对象 */) {
				path = fc.getSelectedFile().getPath();
				text.setText(path);

			}
		}
		if (e.getSource() == button2) {
			fc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int intRetVal = fc2.showOpenDialog(this);
			if (intRetVal == JFileChooser.APPROVE_OPTION/* 获取选中的文件对象 */) {
				xlspath = fc2.getSelectedFile().getPath();
				text2.setText(xlspath);

			}
		}
		if (e.getSource() == button1) {

				/**************************************************************************************/
           if (path == null || xlspath == null) {
			JOptionPane.showMessageDialog(this, "您没有选择文件夹"+"\t\n"+"*请选择所需文件夹*");
		  } else {
			la1.setBounds(470, 500, 100, 30);
			la1.setText("正在识别中...");
			add(la1);
			try{
			BingNow b = new BingNow(path, xlspath);
			b.start();
			/*jindutiao t = new jindutiao(path);
			new Thread(t).start();*/
				/*Main a = new Main();
				long begin = new Date().getTime();
				int successnum = a.Shibie(path, xlspath);
				long over = new Date().getTime();
				long num = a.number(path);
				long times = (over - begin) / 1000;
				Finish f = new Finish(num, successnum, times);
				f.setBounds(400, 200, 650, 400);
				f.setTitle("结果");*/
			}catch(Exception e1){
				JOptionPane.showMessageDialog(this, "您没有选择文件夹"+"\t\n"+"*请选择所需文件夹*");
			}
			
		}
		}
		if (e.getSource() == button3) {
			if(JOptionPane.showConfirmDialog(null, "确定终止程序吗？", "询问",JOptionPane.YES_NO_OPTION)==0){
			System.exit(0);
			}
		}

	}
//重构背景
	public void paint(Graphics g) {
		try {
			URL u = Client.class.getResource("1.jpg");
			img = ImageIO.read(u);
			super.paint(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			text.repaint();
			button1.repaint();
			button.repaint();
			button2.repaint();
			text2.repaint();
			button3.repaint();


		} catch (IOException e) {

			e.printStackTrace();
		}

	}


}
