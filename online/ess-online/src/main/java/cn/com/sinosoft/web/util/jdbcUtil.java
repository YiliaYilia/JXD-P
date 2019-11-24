package cn.com.sinosoft.web.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class jdbcUtil {
	private static Logger log = LoggerFactory.getLogger(jdbcUtil.class);
	private java.sql.Connection connection;
	 public  Connection  getconnectionSQLserver(){
		 Properties properties = new Properties();
				try {
					properties.load(jdbcUtil.class.getResourceAsStream("/config/sqlserverjdbc.properties"));
				} catch (IOException e) {
					log.error("properties读取异常");
					e.printStackTrace();
				}
				String driverClassName = properties.getProperty("jdbc.driverClassName1");
				String url = properties.getProperty("jdbc.url1");
				String username = properties.getProperty("jdbc.username1");
				String password = properties.getProperty("jdbc.password1");
				try {
					Class.forName(driverClassName);
				} catch (ClassNotFoundException e) {
					log.error("驱动加载失败");
					e.printStackTrace();
				}
				try {
				 connection = DriverManager.getConnection(url,username,password);
					log.info("数据库连接成功");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return  connection;
	 }
	 public static Connection getconnection(){
		 jdbcUtil jdbc=new jdbcUtil();
		 Connection connection = jdbc.getconnectionSQLserver();
		 return connection;
	 }		
}
