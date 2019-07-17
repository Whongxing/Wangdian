package JFram;

import java.util.Date;



import Content.Main;
import Eorry.Finish;

public class BingNow extends Thread{
  
	public String path;
	public String xpath;
	public BingNow(String path,String xpath){
		this.path = path;
		this.xpath = xpath;
	}
	public void run() {

		Main a = new Main();
		long begin = new Date().getTime();
		try {
			int successnum = a.Shibie(path, xpath);
			long over = new Date().getTime();
			long num = a.number(path);
			long times = (over - begin) / 1000;
			Finish f = new Finish(num, successnum, times);
			f.setBounds(400, 200, 650, 400);
			f.setTitle("½á¹û");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
