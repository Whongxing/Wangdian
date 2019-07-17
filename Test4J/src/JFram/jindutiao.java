package JFram;



import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.JProgressBar;
import javax.swing.JWindow;

import Content.Main;

public class jindutiao extends JWindow  implements Runnable{
	

	private static final long serialVersionUID = 1L;
	// 定义加载窗口大小
	public static final int LOAD_WIDTH = 1080;
	public static final int LOAD_HEIGHT = 25;
    public String path;
	public JProgressBar progressbar;
	// 定义标签组件
	public JLabel label;
	
      public jindutiao(String path){
        this.path = path;
		// 创建进度条
		progressbar = new JProgressBar();
		// 显示当前进度值信息
		progressbar.setStringPainted(true);
		// 设置进度条边框不显示
		progressbar.setBorderPainted(false);
		// 设置进度条的前景色
		progressbar.setForeground(new Color(0, 210, 40));
		// 设置进度条的背景色
		progressbar.setBackground(new Color(188, 190, 194));
		progressbar.setBounds(0, 0, 1080, 25);
		// 添加组件
		this.add(progressbar);
		// 设置布局为空
		this.setLayout(null);
		// 设置窗口初始位置
		this.setLocation(310, 755);
		// 设置窗口大小
		this.setSize(LOAD_WIDTH, LOAD_HEIGHT);
		// 设置窗口显示
		this.setVisible(true);
  }


	public void run() {
		Main a = new Main();
		long num = a.number(path);
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(/*100*/num*3*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progressbar.setValue(i);
		}
	//	JOptionPane.showMessageDialog(this, "识别完成");
		this.dispose();
	}
	
}
