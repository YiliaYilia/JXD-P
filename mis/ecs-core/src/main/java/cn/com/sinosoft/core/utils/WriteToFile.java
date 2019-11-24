package cn.com.sinosoft.core.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**描述：<br>
 * 作者：dengjiaxing <br>
 * 修改日期：2014-1-16上午10:21:20 <br>
 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
 */
public class WriteToFile {

	/**
	 * 以字符为单位写文件。
	 * @param fileName	文件名
	 */
	public static void writeFileByChars(String content,String fileName){
		File file = new File(fileName);
		Writer writer = null;
		try {
			//打开文件输出流
			writer = new OutputStreamWriter(new FileOutputStream(file));
			writer.write(content);
			System.out.println("写文件" + file.getAbsolutePath() + "成功！");
		} catch (IOException e){
			System.out.println("写文件" + file.getAbsolutePath() + "失败！");
			e.printStackTrace();
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (IOException e1) {
				}
			}
		}
	}

}
