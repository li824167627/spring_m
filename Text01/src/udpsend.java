
import java.net.*;
public class udpsend {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//
		DatagramSocket ds = new DatagramSocket();
		
		//
		byte[] buf = "udp lai le".getBytes();
		DatagramPacket dp = 
				new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.0.109"),10000);
		//
		ds.send(dp);
		
		//
		ds.close();
	}

}


