import java.net.*;
public class udprece {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//
		DatagramSocket ds = new DatagramSocket(10000);
		
		//
		byte[] buf = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//
		
		ds.receive(dp);
		
		String ip = dp.getAddress().getHostAddress();
		
		String data = new String(dp.getData(),0,dp.getLength());
		
		int port = dp.getPort();
		
		System.out.println(ip+"::"+data+"::"+port);
		//
		ds.close();
	}

}