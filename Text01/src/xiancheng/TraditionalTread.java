package xiancheng;

public class TraditionalTread {
	
	public static void main(String[] args) {
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					}catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("1"+Thread.currentThread().getName());
					System.out.println("2"+this.getName());
				}
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					}catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("1"+Thread.currentThread().getName());
				}
			}
		});
			
		thread2.start();
	}
}

	