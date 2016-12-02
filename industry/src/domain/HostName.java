package domain;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostName {

	public String getHostName() throws UnknownHostException {
		InetAddress IP=InetAddress.getLocalHost();
		return IP.getHostName();
	}

}
