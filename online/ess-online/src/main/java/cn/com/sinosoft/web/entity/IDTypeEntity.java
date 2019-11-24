package cn.com.sinosoft.web.entity;

import java.util.HashMap;

public class IDTypeEntity {
	//DB保存代码
	private  static String[] saveType	={"ID_CARD","PASSPORT","MOC","DRIVING_LICENSE","BC","OTHERS","CTC","SOLDIERS","HKMTP","MID","HHR","BIRTHCERT"};		
	//长险代码
	private  static String[] longType  	={"ID Card","Passport","MOC","DL","BC","Others","CTC","MOC","HKMTP","MID","HHR","BirthCert"} ;
	//短险代码
	private  static String[] shortType 	={"A","B","C","D","H","I","K","L","N","Q","",""};
	//中文
	private  static String[] chineseType={"身份证","护照","军官证","驾照","出生证明","其他","台胞证","士兵证","港澳通行证","港澳台回乡证","户口本","出生日期"};
	
	private  static HashMap longTypeMap = new HashMap();
	static{
		longTypeMap.put("saveType", saveType);
		longTypeMap.put("longType", longType);
		longTypeMap.put("shortType", shortType);
		longTypeMap.put("chineseType", chineseType);
	}
	/**
	 * 证件类型字符串依据其适用范围的改变
	 * @param fromType saveType&longType&shortType&chineseType
	 * @param toType saveType&longType&shortType&chineseType
	 * @param thisType 具体字符串
	 * @return
	 */
	public static String formatIDType(String fromType,String toType,String thisType) {
		//TODO:线程安全？
		String result = null;
		if(longTypeMap.containsKey(fromType)&&longTypeMap.containsKey(toType)){
			String[] tempList = (String[])longTypeMap.get(fromType);
			String[] returnList = (String[])longTypeMap.get(toType);
			for(int i = 0;i<tempList.length;i++){
				if(tempList[i].equals(thisType)){
					result = returnList[i];
					break;
				}
			}
		}
		return result;
	}
}
