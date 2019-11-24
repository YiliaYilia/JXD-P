package cn.com.sinosoft.weixin.client;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.activation.MimetypesFileTypeMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import cn.com.sinosoft.weixin.util.HttpClientUtil;

public class TenpayHttpClient {
	
	private static final String USER_AGENT_VALUE = 
		"Mozilla/4.0 (compatible; MSIE 6.0; Windows XP)";
	
	private static final String JKS_CA_FILENAME = 
		"tenpay_cacert.jks";
	
	private static final String JKS_CA_ALIAS = "tenpay";
	
	private static final String JKS_CA_PASSWORD = "";
	
	private File caFile;
	
	private File certFile;
	
	private String certPasswd;
	
	private String reqContent;
	
	private String resContent;
	
	private String method;
	
	private String errInfo;
	
	private int timeOut;
	
	private int responseCode;

	private String charset;
	
	private InputStream inputStream;
	
	public TenpayHttpClient() {
		this.caFile = null;
		this.certFile = null;
		this.certPasswd = "";
		
		this.reqContent = "";
		this.resContent = "";
		this.method = "POST";
		this.errInfo = "";
		this.timeOut = 30;
		
		this.responseCode = 0;
		this.charset = "UTF-8";
		
		this.inputStream = null;
	}
		
	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setCertInfo(File certFile, String certPasswd) {
		this.certFile = certFile;
		this.certPasswd = certPasswd;
	}
	

	public void setCaInfo(File caFile) {
		this.caFile = caFile;
	}
	
	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}
	
	public String getResContent() {
		try {
			this.doResponse();
		} catch (IOException e) {
			this.errInfo = e.getMessage();

		}
		
		return this.resContent;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getErrInfo() {
		return this.errInfo;
	}
	
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	public int getResponseCode() {
		return this.responseCode;
	}

	public boolean call() {
		
		boolean isRet = false;
		
		//http
		if(null == this.caFile && null == this.certFile) {
			try {
				this.callHttp();
				isRet = true;
			} catch (IOException e) {
				this.errInfo = e.getMessage();
			}
			return isRet;
		}
		
		//https
		try {
			this.callHttps();
			isRet = true;
		} catch (UnrecoverableKeyException e) {
			this.errInfo = e.getMessage();
		} catch (KeyManagementException e) {
			this.errInfo = e.getMessage();
		} catch (CertificateException e) {
			this.errInfo = e.getMessage();
		} catch (KeyStoreException e) {
			this.errInfo = e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			this.errInfo = e.getMessage();
		} catch (IOException e) {
			this.errInfo = e.getMessage();
		}
		
		return isRet;
		
	}
	
	public boolean call(String url,String message) {
		
		boolean isRet = false;
		
		//http
		if(null == this.caFile && null == this.certFile) {
			try {
				this.callHttp(url,message);
				isRet = true;
			} catch (IOException e) {
				this.errInfo = e.getMessage();
			}
			return isRet;
		}
		
		//https
		try {
			this.callHttps(url,message);
			isRet = true;
		} catch (UnrecoverableKeyException e) {
			this.errInfo = e.getMessage();
		} catch (KeyManagementException e) {
			this.errInfo = e.getMessage();
		} catch (CertificateException e) {
			this.errInfo = e.getMessage();
		} catch (KeyStoreException e) {
			this.errInfo = e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			this.errInfo = e.getMessage();
		} catch (IOException e) {
			this.errInfo = e.getMessage();
		}
		
		return isRet;
		
	}
	
	public boolean call(String url,String message,String fileUrl) {
		
		boolean isRet = false;
		
		//http
		if(null == this.caFile && null == this.certFile) {
			try {
				this.callHttp(url,message,fileUrl);
				isRet = true;
			} catch (IOException e) {
				this.errInfo = e.getMessage();
			}
			return isRet;
		}
		
		//https
		try {
			this.callHttps(url,message);
			isRet = true;
		} catch (UnrecoverableKeyException e) {
			this.errInfo = e.getMessage();
		} catch (KeyManagementException e) {
			this.errInfo = e.getMessage();
		} catch (CertificateException e) {
			this.errInfo = e.getMessage();
		} catch (KeyStoreException e) {
			this.errInfo = e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			this.errInfo = e.getMessage();
		} catch (IOException e) {
			this.errInfo = e.getMessage();
		}
		
		return isRet;
		
	}
	
	protected void callHttp(String url,String queryString) throws IOException {
		
		if("POST".equals(this.method.toUpperCase())) {
			byte[] postData = queryString.getBytes(this.charset);
			this.httpPostMethod(url, postData);
			
			return ;
		}
		
		this.httpGetMethod(this.reqContent);
		
	}
	
	protected void callHttp(String url,String queryString,String fileUrl) throws IOException {
		
		if("POST".equals(this.method.toUpperCase())) {
			byte[] postData = queryString.getBytes(this.charset);
			this.httpPostMethod(url, postData,fileUrl);
			
			return ;
		}
		
		this.httpGetMethod(this.reqContent);
		
	}
	
	protected void callHttp() throws IOException {
		
		if("POST".equals(this.method.toUpperCase())) {
			String url = HttpClientUtil.getURL(this.reqContent);
			String queryString = HttpClientUtil.getQueryString(this.reqContent);
			byte[] postData = queryString.getBytes(this.charset);
			this.httpPostMethod(url, postData);
			
			return ;
		}
		
		this.httpGetMethod(this.reqContent);
		
	}
	
	protected void callHttps() throws IOException, CertificateException,
			KeyStoreException, NoSuchAlgorithmException,
			UnrecoverableKeyException, KeyManagementException {


		String caPath = this.caFile.getParent();

		File jksCAFile = new File(caPath + "/"
				+ TenpayHttpClient.JKS_CA_FILENAME);
		if (!jksCAFile.isFile()) {
			X509Certificate cert = (X509Certificate) HttpClientUtil
					.getCertificate(this.caFile);

			FileOutputStream out = new FileOutputStream(jksCAFile);

			// store jks file
			HttpClientUtil.storeCACert(cert, TenpayHttpClient.JKS_CA_ALIAS,
					TenpayHttpClient.JKS_CA_PASSWORD, out);

			out.close();

		}

		FileInputStream trustStream = new FileInputStream(jksCAFile);
		FileInputStream keyStream = new FileInputStream(this.certFile);

		SSLContext sslContext = HttpClientUtil.getSSLContext(trustStream,
				TenpayHttpClient.JKS_CA_PASSWORD, keyStream, this.certPasswd);
		
		keyStream.close();
		trustStream.close();
		
		if("POST".equals(this.method.toUpperCase())) {
			String url = HttpClientUtil.getURL(this.reqContent);
			String queryString = HttpClientUtil.getQueryString(this.reqContent);
			byte[] postData = queryString.getBytes(this.charset);
			
			this.httpsPostMethod(url, postData, sslContext);
			
			return ;
		}
		
		this.httpsGetMethod(this.reqContent, sslContext);

	}
	
	protected void callHttps(String url,String queryString) throws IOException, CertificateException,
	KeyStoreException, NoSuchAlgorithmException,
	UnrecoverableKeyException, KeyManagementException {

String caPath = this.caFile.getParent();

File jksCAFile = new File(caPath + "/"
		+ TenpayHttpClient.JKS_CA_FILENAME);
if (!jksCAFile.isFile()) {
	X509Certificate cert = (X509Certificate) HttpClientUtil
			.getCertificate(this.caFile);

	FileOutputStream out = new FileOutputStream(jksCAFile);

	// store jks file
	HttpClientUtil.storeCACert(cert, TenpayHttpClient.JKS_CA_ALIAS,
			TenpayHttpClient.JKS_CA_PASSWORD, out);

	out.close();

}

FileInputStream trustStream = new FileInputStream(jksCAFile);
FileInputStream keyStream = new FileInputStream(this.certFile);

SSLContext sslContext = HttpClientUtil.getSSLContext(trustStream,
		TenpayHttpClient.JKS_CA_PASSWORD, keyStream, this.certPasswd);

keyStream.close();
trustStream.close();

if("POST".equals(this.method.toUpperCase())) {
	byte[] postData = queryString.getBytes(this.charset);
	
	this.httpsPostMethod(url, postData, sslContext);
	
	return ;
}

this.httpsGetMethod(this.reqContent, sslContext);

}

	protected void httpPostMethod(String url, byte[] postData)
			throws IOException {

		HttpURLConnection conn = HttpClientUtil.getHttpURLConnection(url);

		this.doPost(conn, postData);
	}
	
	protected void httpPostMethod(String url, byte[] postData,String fileUrl)
			throws IOException {

		HttpURLConnection conn = HttpClientUtil.getHttpURLConnection(url);

		this.doPost(conn, postData,fileUrl);
	}

	protected void httpGetMethod(String url) throws IOException {
		
		HttpURLConnection httpConnection =
			HttpClientUtil.getHttpURLConnection(url);
		
		this.setHttpRequest(httpConnection);
		
		httpConnection.setRequestMethod("GET");
		
		this.responseCode = httpConnection.getResponseCode();
		
		this.inputStream = httpConnection.getInputStream();
		
	}
	

	protected void httpsGetMethod(String url, SSLContext sslContext)
			throws IOException {

		SSLSocketFactory sf = sslContext.getSocketFactory();

		HttpsURLConnection conn = HttpClientUtil.getHttpsURLConnection(url);

		conn.setSSLSocketFactory(sf);

		this.doGet(conn);

	}
	
	protected void httpsPostMethod(String url, byte[] postData,
			SSLContext sslContext) throws IOException {

		SSLSocketFactory sf = sslContext.getSocketFactory();

		HttpsURLConnection conn = HttpClientUtil.getHttpsURLConnection(url);

		conn.setSSLSocketFactory(sf);

		this.doPost(conn, postData);

	}
	

	protected void setHttpRequest(HttpURLConnection httpConnection) {
		
		httpConnection.setConnectTimeout(this.timeOut * 1000);
		
		//User-Agent
		httpConnection.setRequestProperty("User-Agent", 
				TenpayHttpClient.USER_AGENT_VALUE);

		httpConnection.setUseCaches(false);

		httpConnection.setDoInput(true);
		httpConnection.setDoOutput(true);
		
	}

	protected void doResponse() throws IOException {
		
		if(null == this.inputStream) {
			return;
		}
		this.resContent=HttpClientUtil.InputStreamTOString(this.inputStream,this.charset); 

		this.inputStream.close();
		
	}
	
	protected void doPost(HttpURLConnection conn, byte[] postData)
			throws IOException {
		conn.setRequestMethod("POST");
		this.setHttpRequest(conn);

		// Content-Type
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		BufferedOutputStream out = new BufferedOutputStream(conn
				.getOutputStream());

		final int len = 1024; // 1KB
		HttpClientUtil.doOutput(out, postData, len);
		out.close();
		this.responseCode = conn.getResponseCode();
		this.inputStream = conn.getInputStream();

	}
	
	protected void doPost(HttpURLConnection conn, byte[] postData,String fileUrl)
			throws IOException {

		conn.setRequestMethod("POST");
		this.setHttpRequest(conn);
		
		String boundary = "------------"+ System.currentTimeMillis();
		
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
	      OutputStream outputStream = conn.getOutputStream();

	      File file = new File(fileUrl);
	      String filename = file.getName();
			String contentType = new MimetypesFileTypeMap()
					.getContentType(file);
	      outputStream.write(("--" + boundary + "\r\n").getBytes());
	      outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\""+filename.substring(0, filename.indexOf("."))+"%s\"\r\n", filename.substring(filename.indexOf(".")-1)).getBytes());
	      outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());
	      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	      byte[] buf = new byte[8096];
	      int size = 0;
	      while ((size = bis.read(buf)) != -1) {
	        outputStream.write(buf, 0, size);
	      }
	      outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
	      outputStream.close();
	      bis.close();
		this.responseCode = conn.getResponseCode();

		this.inputStream = conn.getInputStream();

	}

	protected void doGet(HttpURLConnection conn) throws IOException {
		conn.setRequestMethod("GET");
		this.setHttpRequest(conn);
		this.responseCode = conn.getResponseCode();
		this.inputStream = conn.getInputStream();
	}

	
}
