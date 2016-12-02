package in.net.dpl.core;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class Test {
 public static void main(String[] args) throws IOException {
	 String userName="durgapur";
		String password="112233";
		String senderID="THEDPL";
		String recipient="9531705788";
		String msg="TEST";
		String response1="Y";
		
		
		
		//String url = "http://www.smsjust.com/sms/user/urlsms.php?username="+userName+"&pass="+password+"&senderid="+senderID+"&dest_mobileno="+recipient+"&message="+msg+"&response="+response1;
		
		
  URL url = new URL("http://www.smsjust.com/sms/user/urlsms.php?username="+userName+"&pass="+password+"&senderid="+senderID+"&dest_mobileno="+recipient+"&message="+msg+"&response="+response1);
  HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
  httpCon.setDoOutput(true);
  httpCon.setRequestMethod("GET");
  OutputStreamWriter out = new OutputStreamWriter(
      httpCon.getOutputStream());
  System.out.println(httpCon.getResponseCode());
  System.out.println(httpCon.getResponseMessage());
  out.close();
 }
}