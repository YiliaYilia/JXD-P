package cn.com.sinosoft.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

;

public class IPAddressUtils {
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
		}
		if ("0:0:0:0:0:0:0:1".equals(ip)) {
			ip = "127.0.0.1";
		}
		// 如果是多级代理，那么取第一个ip为客户ip 
		if (ip != null && ip.indexOf(",") != -1) { 
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim(); 
		}
		return ip;
	}

	public static String getLocalIP() {
		String ip = "";
		try {
			Enumeration<?> e1 = NetworkInterface.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				if (ni.getName().equals("eth0")) {
					Enumeration<?> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						InetAddress ia = (InetAddress) e2.nextElement();
						if (!(ia instanceof Inet6Address)) {
							ip = ia.getHostAddress();
						}
					}
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return ip;
	}

	public static String getRealIp() throws SocketException {
		String localip = null;
		String netip = null;

		Enumeration<NetworkInterface> netInterfaces = NetworkInterface
				.getNetworkInterfaces();
		InetAddress ip = null;
		boolean finded = false;
		while ((netInterfaces.hasMoreElements()) && (!finded)) {
			NetworkInterface ni = (NetworkInterface) netInterfaces
					.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while (address.hasMoreElements()) {
				ip = (InetAddress) address.nextElement();
				if ((!ip.isSiteLocalAddress()) && (!ip.isLoopbackAddress())
						&& (ip.getHostAddress().indexOf(":") == -1)) {
					netip = ip.getHostAddress();
					finded = true;
					break;
				}
				if ((ip.isSiteLocalAddress()) && (!ip.isLoopbackAddress())
						&& (ip.getHostAddress().indexOf(":") == -1)) {
					localip = ip.getHostAddress();
				}
			}
		}
		if ((netip != null) && (!"".equals(netip))) {
			return netip;
		}
		return localip;
	}

	public static String getIpServer() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "";
	}

	// public static String getWinLocalIP()
	// {
	// String ip = "";
	// try
	// {
	// Enumeration<?> e1 =
	// NetworkInterface.getNetworkInterfaces();
	// Enumeration<?> e2;
	// for (; e1.hasMoreElements(); e2.hasMoreElements())
	// {
	// NetworkInterface ni = (NetworkInterface)e1.nextElement();
	// e2 = ni.getInetAddresses();
	// continue;
	// InetAddress ia = (InetAddress)e2.nextElement();
	// ip = ia.getHostAddress();
	// }
	// }
	// catch (SocketException e)
	// {
	// e.printStackTrace();
	// System.exit(-1);
	// }
	// return ip;
	// }

	public static String getMacAddress() {
		String mac = "";
		String line = "";
		String os = System.getProperty("os.name");
		if ((os != null) && (os.startsWith("Windows"))) {
			try {
				String command = "cmd.exe /c ipconfig /all";
				Process p = Runtime.getRuntime().exec(command);

				BufferedReader br = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				while ((line = br.readLine()) != null) {
					if (line.indexOf("Physical Address") > 0) {
						int index = line.indexOf(":") + 2;

						mac = line.substring(index);

						break;
					}
				}
				br.close();
			} catch (IOException localIOException) {
			}
		}
		return mac;
	}

	public String getMacAddress(String host) {
		String mac = "";
		StringBuffer sb = new StringBuffer();
		try {
			NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress
					.getByName(host));

			byte[] macs = ni.getHardwareAddress();
			for (int i = 0; i < macs.length; i++) {
				mac = Integer.toHexString(macs[i] & 0xFF);
				if (mac.length() == 1) {
					mac = '0' + mac;
				}
				sb.append(mac + "-");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		mac = sb.toString();
		mac = mac.substring(0, mac.length() - 1);

		return mac;
	}

	public static String getServerIP() {
		String serverip = "";
		try {
			Enumeration<NetworkInterface> netInterfaces = null;
			netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netInterfaces
						.nextElement();
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					InetAddress ip = (InetAddress) ips.nextElement();
					if (ip.isSiteLocalAddress()) {
						serverip = ip.getHostAddress();
						break;
					}
				}
			}
		} catch (Exception ex) {
			serverip = "192.168.200.200";
		}
		return serverip;
	}

	public static String getServerPort() {
		String port = "9999";
		try {
			Context myCtx = new InitialContext();
			MBeanServer tMBeanServer = (MBeanServer) myCtx
					.lookup("java:comp/env/jmx/runtime");
			ObjectName tObjectName = new ObjectName(
					"com.bea:Name=RuntimeService,Type=weblogic.management.mbeanservers.runtime.RuntimeServiceMBean");
			ObjectName serverrt = (ObjectName) tMBeanServer.getAttribute(
					tObjectName, "ServerRuntime");
			port = String.valueOf(tMBeanServer.getAttribute(serverrt,
					"ListenPort"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return port;
	}
	
	public static void main(String[] args) throws SocketException {
		System.out.println(IPAddressUtils.getServerIP());
		System.out.println(IPAddressUtils.getIpServer());
		System.out.println(IPAddressUtils.getLocalIP());
		System.out.println(IPAddressUtils.getMacAddress());
		System.out.println(IPAddressUtils.getRealIp());
	}
}
