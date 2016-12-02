

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostName {
	
	String hostName=null;
	

	public HostName() {
		try {
			this.hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}
