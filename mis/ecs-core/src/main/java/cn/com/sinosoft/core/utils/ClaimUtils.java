package cn.com.sinosoft.core.utils;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 理赔通用信息
 * @author GHY
 */
public class ClaimUtils {
	
	//测试地址
	public static final String RIDER = "http://testweixin.oldmutual-guodian.com/";
	private static final String  DATE_TYPE = "yyyyMMddHHmmssSSS";
	
	private static final String  ZYJT = "住院津贴";
	private static final String  YLBX = "医疗报销";
	private static final String  ZJ = "重疾";
	private static final String  SC = "伤残";
	private static final String  SG = "身故";
	
	private static final String  SF = "本人";
	private static final String  FA = "父亲";
	private static final String  MO = "母亲";
	
	private static final String YES = "是";
	private static final String NO = "否";
	
	private static final String STATE_ONE = "已报案";
	private static final String STATE_TWO = "已提交";
	private static final String STATE_THREE = "已退回";
	private static final String STATE_FOUR = "审核中";
	private static final String STATE_FIVE = "已完成";
	
	private static final String COMMIT_TYPE_ONE = "柜台提交";
	private static final String COMMIT_TYPE_TWO = "微信提交";
	private static final String COMMIT_TYPE_THREE = "邮箱提交";
	
	private static final String PAY_TYPE_ONE = "银行转账";
	private static final String PAY_TYPE_TWO = "微信支付";
	
	//提交方式
	public static String getPayType(String tag){
		String str ="";
		if("01".equals(tag)){
			str = PAY_TYPE_ONE;
		} else if("02".equals(tag)){
			str = PAY_TYPE_TWO;
		}
		return str;
	}
	
	//提交方式
	public static String getCommitType(String tag){
		String str ="";
		if("01".equals(tag)){
			str = COMMIT_TYPE_ONE;
		} else if("02".equals(tag)){
			str = COMMIT_TYPE_TWO;
		} else if("03".equals(tag)){
			str = COMMIT_TYPE_THREE;
		}
		return str;
	}
	
	//状态
	public static String getState(String tag){
		String str ="";
		if("01".equals(tag)){
			str = STATE_ONE;
		} else if("02".equals(tag)){
			str = STATE_TWO;
		} else if("03".equals(tag)){
			str = STATE_THREE;
		} else if("04".equals(tag)){
			str = STATE_FOUR;
		} else if("05".equals(tag)){
			str = STATE_FIVE;
		}
		return str;
	}
	
	//索赔类别
	public static String getClaimManagementType(String tag){
		String str ="";
		if("1".equals(tag)){
			str = ZYJT;
		} else if("2".equals(tag)){
			str = YLBX;
		} else if("3".equals(tag)){
			str = ZJ;
		} else if("4".equals(tag)){
			str = SC;
		} else if("5".equals(tag)){
			str = SG;
		}
		return str;
	}
	
	//被保险人关系
	public static String getInsrelationApp(String tag){
		String str ="";
		if("SF".equals(tag)){
			str = SF;
		} else if("FA".equals(tag)){
			str = FA;
		} else if("MO".equals(tag)){
			str = MO;
		}
		return str;
	}
	
	//是否在其他保险公司有人身保险
	public static String getIsInsure(String tag){
		String str ="";
		if("Y".equals(tag)){
			str = YES;
		} else if("N".equals(tag)){
			str = NO;
		} 
		return str;
	}
	
	/**
	 * 返回标准日期格式
	 * @param date
	 * @return
	 */
	public static String getStrDate(Date date){
		return DateUtils.format(date, DateUtils.DEFAULT);
	}
	
	/**
	 * 生成流水号
	 */
	public static synchronized String createFlowNo(String claimManagementType){
		String datestr = DateAndTime.getCurrentDateTime(DATE_TYPE);
		String num = RandomStringUtils.random(3, false, true);
		return datestr + claimManagementType + num;
	}
}
