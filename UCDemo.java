package Internet;
import java.net.*;
import java.io.*;
import java.util.Date;
public class UCDemo {
	public static void main(String args[]) throws Exception
	{
		int c;
		URL hp = new URL("http://www.internic.net");
		URLConnection hpCon = hp.openConnection();
		long d = hpCon.getDate();
		if(d==0)
			System.out.println("No date information");
		else 
			System.out.println("Date : " + new Date(d));
		System.out.println("Content-Type : " + hpCon.getContentType());
		d = hpCon.getExpiration();
		if(d==0)
			System.out.println("No last-modified information");
		else
			System.out.println("Expires : " + new Date(d));
		
		int len = hpCon.getContentLength();
		if(len == -1)
			System.out.println("Content lengh unavailabe");
		else
			System.out.println("Content-Length : " +len);
		if(len != 0)
			System.out.println("=== COntent ===");
		InputStream input = hpCon.getInputStream();
		int i = len;
		while(((c = input.read()) != -1))
		{
			System.out.println((char) c);
			
		}
		input.close();
	} 
}

