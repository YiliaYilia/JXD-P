package cn.com.sinosoft.core.utils;

import java.lang.reflect.Method;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * Export工具类
 * @author liangkesai
 * @date 2017年8月29日 下午9:34:28
 */
public class ExportUtil {
	private static Log logger = LogFactory.getLog(ExportUtil.class);
	
	/**
	 * 设置sheet表头信息
	 * @author liangkesai
	 * @param titlesInfo 表头的String数组
	 * @param sheet
	 */
	public static void outputHeaders(String[] titlesInfo,HSSFSheet sheet ){
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < titlesInfo.length; i++) {
			sheet.setColumnWidth(i, 4000);
			row.createCell(i).setCellValue(titlesInfo[i]);
		}
	}
	
	/**
	 * 循环插入数据
	 * @author liangkesai
	 * @param headersInfo  表体的String数组
	 * @param columnsInfo  包含表体数据的list集合
	 * @param sheet
	 * @param rowIndex     从第几行开始插入数据
	 */
	public static void outputColumns(String[] headersInfo,
			List columnsInfo,HSSFSheet sheet,int rowIndex ){
		HSSFRow row ;
		//循环插入多少行
		for (int i = 0; i < columnsInfo.size(); i++) {
			row = sheet.createRow(rowIndex+i);
			Object obj = columnsInfo.get(i);
			//循环每行多少列
			for (int j = 0; j < headersInfo.length; j++) {
				Object value = getFieldValueByName(headersInfo[j],obj);
				if(value == null){
					value="";
				}
				row.createCell(j).setCellValue(value.toString());
			}
		}
		
	}
	
	/**
	 * 根据对象的属性获取值
	 * @author liangkesai
	 * @param string
	 * @param obj
	 * @return
	 */
	private static Object getFieldValueByName(String fieldName, Object obj) {
		String firstLetter = fieldName.substring(0,1).toUpperCase();
		String getter = "get" +firstLetter + fieldName.substring(1);
		try {
			Method method = obj.getClass().getMethod(getter, new Class[]{});
			Object value = method.invoke(obj, new Object[]{});
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("属性不存在！");
			return null;
		} 
	}
}
