package cn.com.sinosoft.ess.protal.util;

import java.io.StringWriter;

import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 描述：处理报文<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-6下午06:36:41 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br>
 */
public class XMLUtil {
	/**
	 * 返回格式化XML内容
	 * @param XMLContent
	 * @return XML formatter
	 * @throws Exception
	 */
	public synchronized static String formatXML(String XMLContent) throws Exception {
		XMLWriter xwoutput = null;
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndentSize(4);
		format.setEncoding("GBK");
		StringWriter resultCollector = new StringWriter();
		xwoutput = new XMLWriter(resultCollector, format);
		xwoutput.write(DocumentHelper.parseText(XMLContent));
		xwoutput.close();
		return resultCollector.getBuffer().toString();
	}
	/**
	 * 格式化XML内容
	 * @param XMLContent
	 * @param encod	编码格式
	 * @return XML formatter
	 * @throws Exception
	 */
	public synchronized static String formatXML(String XMLContent,String encod) throws Exception {
		XMLWriter xwoutput = null;
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndentSize(4);
		format.setEncoding(encod);
		StringWriter resultCollector = new StringWriter();
		xwoutput = new XMLWriter(resultCollector, format);
		xwoutput.write(DocumentHelper.parseText(XMLContent));
		xwoutput.close();
		return resultCollector.getBuffer().toString();
	}
}
