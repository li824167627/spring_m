package xiancheng;

public class TraditonalTreadSynchronized {
	
	public static void main(String[] args) {
		new TraditonalTreadSynchronized().init();
			
	}
	
	private void init() {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					
				}
				outputer.output("lixiaoming");
			}
		
		}
	}).start();
		
	}
	
	class Outputer{
		public void output(String name) {
			int len = name.length();
			for(int i=0;i<len;i++) {
				System.out.print(name.charAt(i));
				
			}
			System.out.println();
			System.out.println("++++++++++");
		}
	}
}
