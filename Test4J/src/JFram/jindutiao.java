package JFram;



import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.JProgressBar;
import javax.swing.JWindow;

import Content.Main;

public class jindutiao extends JWindow  implements Runnable{
	

	private static final long serialVersionUID = 1L;
	// ������ش��ڴ�С
	public static final int LOAD_WIDTH = 1080;
	public static final int LOAD_HEIGHT = 25;
    public String path;
	public JProgressBar progressbar;
	// �����ǩ���
	public JLabel label;
	
      public jindutiao(String path){
        this.path = path;
		// ����������
		progressbar = new JProgressBar();
		// ��ʾ��ǰ����ֵ��Ϣ
		progressbar.setStringPainted(true);
		// ���ý������߿���ʾ
		progressbar.setBorderPainted(false);
		// ���ý�������ǰ��ɫ
		progressbar.setForeground(new Color(0, 210, 40));
		// ���ý������ı���ɫ
		progressbar.setBackground(new Color(188, 190, 194));
		progressbar.setBounds(0, 0, 1080, 25);
		// ������
		this.add(progressbar);
		// ���ò���Ϊ��
		this.setLayout(null);
		// ���ô��ڳ�ʼλ��
		this.setLocation(310, 755);
		// ���ô��ڴ�С
		this.setSize(LOAD_WIDTH, LOAD_HEIGHT);
		// ���ô�����ʾ
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
	//	JOptionPane.showMessageDialog(this, "ʶ�����");
		this.dispose();
	}
	
}
