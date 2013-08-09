package test1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Hello {

	
	public static void main(String[] args) {
		
		Enumeration<NetworkInterface> netInterfaces = null;
		
		try {
			netInterfaces = NetworkInterface.getNetworkInterfaces();
			while(netInterfaces.hasMoreElements()){
				NetworkInterface ni = netInterfaces.nextElement();
				System.out.println("Display Name:"+ni.getDisplayName());
				System.out.println("Name:"+ni.getName());
				
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while(ips.hasMoreElements()){
					System.out.println("IP:" + ips.nextElement().getHostAddress());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("-----------------------");
		
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
