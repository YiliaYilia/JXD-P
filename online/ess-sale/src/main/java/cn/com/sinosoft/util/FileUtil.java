//package cn.com.sinosoft.util;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import cn.com.sinosoft.core.utils.PathUtil;
//import cn.com.sinosoft.domain.sale.GePolicy;
//
//public class FileUtil {
//	/**
//	 * 生成文件、返回file
//	 * @param File
//	 * @return
//	 */
//
//	public static File saveTempFile(byte[] pdf,GePolicy policy) {
//		String filepath = PathUtil.getClassBuildPath()+"epolicyTemplate"+"/"+policy.getPolicycode()+".pdf";
////		String filepath = "c:\\temp\\" + policy.getPolicycode() + ".pdf";
//		File f = null;
//		try {
//			f = new File(filepath);
//			f.createNewFile();
//			FileOutputStream fos = new FileOutputStream(f);
//			fos.write(pdf);
//			fos.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("邮件附件获取失败");
//		}
//		return f;
//	}
//	
//	 /**方法名称: deleteFile<br>
//	 * 描述：邮件发送成功后删除临时文件
//	 * 作者: dengjiaxing
//	 * 修改日期：2014-1-14下午06:11:58
//	 * @param fileName
//	 * @return
//	 */
//	public static void deleteFile(GePolicy policy){
//		String filepath = PathUtil.getClassBuildPath()+"epolicyTemplate"+"/"+policy.getPolicycode()+".pdf";
////		String filepath = "c:\\temp\\" + policy.getPolicycode() + ".pdf";
//	        File file = new File(filepath);     
//	        if(file.isFile() && file.exists()){     
//	            file.delete();     
//	        }else{
//	        	System.out.println("不存在需要删除的临时文件");
//	        }     
//	    }     
//}
