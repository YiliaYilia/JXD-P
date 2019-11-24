package cn.com.sinosoft.core.ca;


import cn.com.sinosoft.core.utils.FilePathUtil;
import cn.com.sinosoft.core.utils.PropertyFileUtils;
import cn.org.bjca.seal.esspdf.client.message.ChannelMessage;
import cn.org.bjca.seal.esspdf.client.tools.ESSPDFClientTool;

/**
 * 描述：生成PDF文件并进行CA认证（签章）<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月31日上午11:40:28 <br>
 * E-mail:wanhonghui@sinosoft.com.cn  <br>
 */
public class EcsESSPDFClientTool {
//	private static final Logger logger = Logger.getLogger(EcsESSPDFClientTool.class);
	private static ESSPDFClientTool essPDFClientTool = null;
	
	static{
		PropertyFileUtils.init(FilePathUtil.getClassBuildPath()+ "config/electronicSignature.properties");
	}
	private  static void connect() throws Exception{
		essPDFClientTool = new ESSPDFClientTool(PropertyFileUtils.getConfig("ip"),
				Integer.valueOf(PropertyFileUtils.getConfig("port")));
		essPDFClientTool.setTimeout(Integer.valueOf(PropertyFileUtils.getConfig("timeout")));
	}
	 
	/**
	 * 方法名称: pdfSign<br>
	 * 描述：进行签章操作
	 * 作者: wanhonghui
	 * 修改日期：2013年8月31日上午11:44:24
	 * @param pdfBty 待签章pdf二进制
	 * @param ruleNum 模板号
	 * @return 成功返回签章后pdf 二进制,失败返回 null
	 */
	public static byte[] pdfSign(byte[] pdfBty,String ruleNum){
		byte[] returnPdfSign = null;
		try{
			connect();
		}
		catch(Exception e){
//			logger.error("连接CA服务器失败"+e);
			return returnPdfSign;
		}
		try {
			if(null != pdfBty && null != ruleNum && ruleNum.length() > 0){
				ChannelMessage message = essPDFClientTool.pdfSign(ruleNum, pdfBty);
//				logger.info("签章状态="+message.getStatusCode());
				if ("200".equals(message.getStatusCode())) {
//					logger.info("签章成功");
					returnPdfSign = message.getBody();
				}
				else{
//					logger.info("签章失败");
				}
			}
		} catch (Exception e) {
//			logger.error("签章失败:"+e);
			e.printStackTrace();
		}
		return returnPdfSign;
	}
}