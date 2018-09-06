package xiancheng;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
	public static void main(String[] args) {
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("boom!!");
				new Timer().schedule(new TimerTask() {
					
					@Override
					public void run() {
						System.out.println("mood!!!");
						
					}
				}, 2000);
			}
		},2000);
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
			
		}
	}
}
