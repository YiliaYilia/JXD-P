//package cn.com.sinosoft.util.pdf;
//
//import java.io.File;
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.Velocity;
//import org.apache.velocity.app.VelocityEngine;
//import cn.com.sinosoft.core.pdf.PDFUtil;
//import cn.com.sinosoft.core.utils.DateUtils;
//import cn.com.sinosoft.domain.sale.GeApplicantinsured;
//import cn.com.sinosoft.domain.sale.GeBeneficiary;
//import cn.com.sinosoft.domain.sale.GePolicy;
//public class InvestmentlinkedPDFMaker{
//
//	/**
//	 * 方法名称: makePDF<br>
//	 * 描述：创建PDF
//	 * 作者: liyang
//	 * 修改日期：2014-1-3下午12:26:41
//	 * @param resource_loder_path 资源加载路径
//	 * @param templateName 模板名称
//	 * @param pdfPlusPath 拼接PDF路径
//	 * @param policy 保单对象
//	 * @return PDF二进制数组
//	 */
//	public byte[] makePDF(String resource_loder_path,String templateName,String pdfPlusPath,GePolicy policy){
//		//新建Velocity引擎
//		VelocityEngine ve = new VelocityEngine();
//		//获取PDF模板
//		ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, resource_loder_path);
//		Template template = null;
//		template = ve.getTemplate(templateName, "UTF-8");
//		
//		//设置模板内容
//		VelocityContext context = new VelocityContext();
//		DateUtils dateUtils = new DateUtils();
//		
////		//设置受益人
//		Set<GeBeneficiary> ben = policy.getBeneficiaries();	
//		List<GeBeneficiary> beneficiaries = new ArrayList<GeBeneficiary>();
//		beneficiaries.addAll(ben);
//        String name1 = "";
//        String name2 = "";
//        String name3 = "";
//        String name4 = "";
//        String name5 = "";
//        if(beneficiaries != null || !beneficiaries.isEmpty()){
//        	List<String>  tempList = new ArrayList<String>();
//        	tempList.add("--");
//        	tempList.add("--");
//        	tempList.add("--");
//        	tempList.add("--");
//        	tempList.add("--");
//        	
//        	for (int i = 0; i < beneficiaries.size(); i++) {
//        		GeBeneficiary temp = beneficiaries.get(i);
//        		tempList.add(i, temp.getBenname());
//			}
//        	
//        	name1 = tempList.get(0);
//        	name2 = tempList.get(1);
//        	name3 = tempList.get(2);
//        	name4 = tempList.get(3);
//        	name5 = tempList.get(4);
//        }
//		context.put("name1",name1);
//		context.put("name2",name2);
//		context.put("name3",name3);
//		context.put("name4",name4);
//		context.put("name5",name5);
//		
//		//设置地址换行
//		String address = policy.getApplicantaddress();
//		char[] caddress = address.toCharArray();
//		int index = 0;
//		String tempPcity = "";
//		for(int i=0;i<caddress.length;i++){
//			index++;
//			if(index==20){
//				tempPcity=tempPcity+caddress[i]+"<br/>";
//				index =0;
//			}
//			else{
//				tempPcity=tempPcity+caddress[i];
//			}
//		}
//		address = tempPcity;
//		context.put("address", address);
//		
//		
//		//投被保人属性
//        List<GeApplicantinsured> applicantinsureds = new ArrayList<GeApplicantinsured>();
//        applicantinsureds.addAll(policy.getApplicantinsureds());
//        Applicant applicant = new Applicant();
//        Insurer insurer = new Insurer();
//        for(GeApplicantinsured geApplicantinsured : applicantinsureds) {
//        	if(("1").equals(geApplicantinsured.getFlag())){//投被保人标志1为投保人，2被保人
//        		applicant.setName(geApplicantinsured.getName());
//        		applicant.setCarNumber(geApplicantinsured.getIdentifynumber());
//        	}else{
//        		insurer.setName(geApplicantinsured.getName());
//        		insurer.setCarNumber(geApplicantinsured.getIdentifynumber());
//        		insurer.setBirthday(geApplicantinsured.getBirthday());
//        		insurer.setSex(geApplicantinsured.getSex());
//        		try {
//        			insurer.setAge(dateUtils.getAge(geApplicantinsured.getBirthday()));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//        	}
//        }
//        //投被保人属性
//        context.put("insurer",insurer);
//        context.put("applicant",applicant );
//		//保单基础属性        基本保险金额、每期保险费、总保费
//		context.put("policy", policy);
//		double sumpremium;
//		if("1".equals(policy.getPaymentInfo().getInvestment())){//月缴为1，年缴为12
//			sumpremium = policy.getPaymentInfo().getPremiumeach()*5*12;
//		}else{
//			sumpremium = policy.getPaymentInfo().getPremiumeach()*5;
//		}
//		context.put("sumpremium", sumpremium);//总保费、保费合计
//		context.put("CampName", "运筹帷幄终身寿险");//保险计划
//		context.put("dateUtils", dateUtils);//时间工具
//		//页眉页脚、背景
//		context.put("logo", resource_loder_path+"\\cigna.png");
//		context.put("back",resource_loder_path+"\\"+"pdf-back.png");
//		context.put("top",resource_loder_path+"\\"+"pdf-top.png");
//		context.put("botton",resource_loder_path+"\\"+"pdf-bottom.png");
//		context.put("hands",resource_loder_path+"\\"+"hand.png");
//		context.put("welcome",resource_loder_path+"\\"+"welcome.png");
//		//设置到流
//		StringWriter sw = new StringWriter();
//		template.merge(context, sw);
//		//获取要拼接的PDF文件
//		File pdfPlus = new File(pdfPlusPath);
//		return PDFUtil.generatePDF(sw, pdfPlus);
//	}
//	
//	//投保人
//	public static class Applicant{
//		private String name;
//		private String carNumber;
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public String getCarNumber() {
//			return carNumber;
//		}
//		public void setCarNumber(String carNumber) {
//			this.carNumber = carNumber;
//		}
//	}
//	//被保人
//	public static class Insurer{
//		private String name;
//		private String carNumber;
//		private String age;
//		private Date birthday;
//		private String sex;
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public String getCarNumber() {
//			return carNumber;
//		}
//		public void setCarNumber(String carNumber) {
//			this.carNumber = carNumber;
//		}
//		public String getAge() {
//			return age;
//		}
//		public void setAge(String age) {
//			this.age = age;
//		}
//		public Date getBirthday() {
//			return birthday;
//		}
//		public void setBirthday(Date birthday) {
//			this.birthday = birthday;
//		}
//		public String getSex() {
//			return sex;
//		}
//		public void setSex(String sex) {
//			this.sex = sex;
//		}
//	}
//}
