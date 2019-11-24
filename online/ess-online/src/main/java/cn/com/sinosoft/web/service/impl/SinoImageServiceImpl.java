package cn.com.sinosoft.web.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.common.service.axis.Add;
import cn.com.sinosoft.common.service.axis.BusiInfo;
import cn.com.sinosoft.common.service.axis.BusiInfoResponse;
import cn.com.sinosoft.common.service.axis.PolicyInformation;
import cn.com.sinosoft.common.service.axis.QueryModel;
import cn.com.sinosoft.common.service.axis.RequestBody;
import cn.com.sinosoft.common.service.axis.RequestEntity;
import cn.com.sinosoft.domain.sale.GeClaimManagement;
import cn.com.sinosoft.domain.sale.GeClaimRider;
import cn.com.sinosoft.domain.user.DateChangeData;
import cn.com.sinosoft.sale.service.ClaimManagementService;
import cn.com.sinosoft.web.service.facade.DateChangeDataService;
import cn.com.sinosoft.web.service.facade.PolicyListQueryService;
import cn.com.sinosoft.web.service.facade.SinoImageService;
import cn.com.sinosoft.web.util.JaxbXmlUtil;
import cn.net.sinodata.domain.BatchInfo;
import cn.net.sinodata.domain.BatchMetadata;
import cn.net.sinodata.domain.ImageInfo;
import cn.net.sinodata.transport.SinoImageClient;

@Service
public class SinoImageServiceImpl implements SinoImageService {
	private final static Logger logger = LoggerFactory.getLogger(SinoImageServiceImpl.class);
	private static Properties pro = new Properties();
	private static String imageServiceIp;// 缓存服务器地址
	private static String httpPort;// http端口,下载端口
	private static String socketPort;// socket端口,上传,通信端口
	private static String ICLSID;// 影像类型编号
	private static String webServiceUrl;// 发送业务数据url
	private static String sourceip;
	private static String mediaPath;
	private static String orgid;
	private static String clerkOrgId;
	private static String batchStartTime;
	private static String batchEndTime;
	@Autowired
	private ClaimManagementService claimManagementService;
	@Autowired
	private PolicyListQueryService policyListQueryService;
	@Autowired
	DateChangeDataService dateChangeDataService;
	private static final String BUSINESSCLAIM = "理赔业务";
	private static final String SPARESONECLAIM = "理赔资料";
	private static final String BUSINESSPRESERVATION = "保全业务";
	private static final String SPARESONEPRESERVATION = "变更申请";
	private static final String PROTEAM = "个险";
	private static final String CLERK = "WECHAT";
	private static final String KEY = "0";;
	
	static{
		try {
			pro.load(SinoImageServiceImpl.class.getResourceAsStream("/config/App.properties"));
			mediaPath = pro.getProperty("mediaPath");
			pro.load(new InputStreamReader(SinoImageServiceImpl.class.getResourceAsStream("/config/sinoImage.properties"), "UTF-8"));
			imageServiceIp = pro.getProperty("imageServiceIp");// 缓存服务器地址
			httpPort = pro.getProperty("httpPort");// http端口,下载端口
			socketPort = pro.getProperty("socketPort");// socket端口,上传,通信端口
			ICLSID = pro.getProperty("iclsid");// 影像类型编号
			webServiceUrl = pro.getProperty("webServiceUrl");// 下载票据影像文件存储路径
			sourceip = pro.getProperty("sourceip");
			orgid = pro.getProperty("orgid");
			clerkOrgId = pro.getProperty("clerkOrgId");
			batchStartTime = pro.getProperty("batchStartTime");
			batchEndTime = pro.getProperty("batchEndTime");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBatchNo() {
		logger.info("****从影像系统获取批次号****");
		String path = pro.getProperty("image.file.upload");
		String czjg = ("999");// 操作机构
		// 获取批次号
		SinoImageClient sinoImageClient = new SinoImageClient(imageServiceIp, httpPort, socketPort, false, path);
		String batchNo = sinoImageClient.getBatchNo(czjg, socketPort, ICLSID, KEY);// 操作机构去收款人开户行结构号
		logger.info("获取批次号1：" + batchNo);
		batchNo = batchNo.replaceAll("</batchNo></root>", "");
		batchNo = batchNo.substring(batchNo.length() - 36, batchNo.length());
		batchNo = batchNo.trim();
		logger.info("获取批次号2：" + batchNo);
		return batchNo;
	}

	@Override
	public String uploadYXFile(BatchInfo batch) {
		String path = pro.getProperty("image.file.upload");
		SinoImageClient sinoImageClient1 = new SinoImageClient(imageServiceIp, httpPort, socketPort, false, path);
		String batchNo = sinoImageClient1.addBatch(batch, KEY);
		logger.info("上传批次号：" + batchNo);
		return batchNo;
	}

	@Override
	public BusiInfoResponse sendBusiInfo(BusiInfo busiInfo) {
		BusiInfoResponse busiInfoResponse;
		RequestEntity requestEntity= new RequestEntity();
		requestEntity.setBody(new RequestBody(new Add(busiInfo))); 
		String busiInfoXml;
		try {
			busiInfoXml = JaxbXmlUtil.convertToXml(requestEntity);
			logger.info("发送报文："+busiInfoXml);
			Map response = JaxbXmlUtil.sendXml(busiInfoXml, webServiceUrl);
			logger.info("响应code:"+response.get("code")+",返回报文："+response.get("message"));
			if(response.get("code") != null && "200".equals(response.get("code").toString())){
				Document document = DocumentHelper.parseText(response.get("message").toString());  
				String beanXml = document.getRootElement().element("Body").element("ADDResponse").element("return").asXML();  
				busiInfoResponse = JaxbXmlUtil.convertToJavaBean(beanXml, BusiInfoResponse.class);
				logger.info("返回报文："+busiInfoResponse.toString());
			}else{
				busiInfoResponse = new BusiInfoResponse("failed","业务数据发送失败，code:"+response.get("code"));
			}
		} catch (Exception e) {
			logger.error("业务数据发送异常：",e);
			busiInfoResponse = new BusiInfoResponse("failed","业务数据发送异常："+ e.getMessage());
		}
		return busiInfoResponse;
	}
	

	@Override
	public void sinoImageClaim(GeClaimManagement claimManagement,String filePath) {
		Set<GeClaimRider> claimRiders = claimManagement.getGeClaimRider();
		logger.info("claimNo:"+claimManagement.getClaimManagementNo()+",filePath:"+filePath+",上传图片个数："+claimRiders.size());
		//业务信息
		int imagepages = claimRiders.size();//影像数量
		String policyid = claimManagement.getPolicyCode();//保单号
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String guidangtime = df.format(date);//当前日期
		df = new SimpleDateFormat("yyyyMMddHHmmss");
		String claimappid = policyid + df.format(date);
		//获取批次号
		String batchNo = this.getBatchNo();
		//组装批次信息
		BatchInfo batch = new BatchInfo();
		batch.setBatchNo(batchNo);// 批次号
		//**下列批次属性代码逻辑上未非必输属性，业务逻辑上建议上传 *//*
		batch.setTellerNo(clerkOrgId);//创建人 虚拟柜员
		batch.setSourceIp(sourceip);//来源IP
		batch.setImgAmount(imagepages);//影像数量
		batch.setIclsId(ICLSID);//影像类型
		batch.setSerialNumber(BUSINESSCLAIM+":"+policyid);//业务流水号，强烈建议上传
		BatchMetadata batchMetadata1 = new BatchMetadata();
		batchMetadata1.setBatchNo(batchNo);
		batchMetadata1.setIclsId(ICLSID);
		batchMetadata1.setNodeNo(batch.getNodeNo());	
		batchMetadata1.setMetaName("ProTeam");
		batchMetadata1.setMetaAlias("来源");
		batchMetadata1.setMetaValue(PROTEAM);
		batch.getMetas().add(batchMetadata1);
		for(GeClaimRider claimRider:claimRiders){
			String fileName = claimRider.getRiderPath().substring(mediaPath.length());
			logger.info("fileName:"+fileName);
			ImageInfo image = new ImageInfo();
			image.setSparesOne(SPARESONECLAIM);//必输属性,如果不输，影像批次无法正常按照结构树显示
			image.setImgNo(fileName.split("\\.")[0]);
			image.setBatchNo(batchNo);
			image.setIclsId(ICLSID);
			image.setImgName(fileName);
			image.setImgMemi(fileName.split("\\.")[1]);
			image.setImgPath(filePath + fileName);
			image.setImgSize(new File(filePath + fileName).length() + "");
			image.setImgSequence(fileName.split("\\.")[0]);
			//将图像信息添加到批次信息中
			batch.getImages().add(image);
			//批次信息组装完成
			claimRider.setBatchNo(batchNo);
			claimRider.setClaimappid(claimappid);
		}
		//上传图像批次
		logger.info("****组装批次信息完毕，开始影像上传****");
		this.uploadYXFile(batch);
		logger.info("影像上传成功，批次号："+batchNo);
		//提交业务信息 
		BusiInfo busiInfo = new BusiInfo(BUSINESSCLAIM, batchNo, imagepages+"", PROTEAM, null, policyid, claimManagement.getPolName(), CLERK, null, guidangtime, orgid, clerkOrgId);
		busiInfo.setClaimappid(claimappid);
		BusiInfoResponse busiInfoResponse = this.sendBusiInfo(busiInfo);
		logger.info("返回报文："+busiInfoResponse.toString());
		if(busiInfoResponse.getRetCode() != null && "success".equals(busiInfoResponse.getRetCode())){
			//存储图片对应影像相关信息
			claimManagementService.saveClaimManagement(claimManagement);
		}
	}

	@Override  
	public void sinoImageCertificate(DateChangeData dateChangeData, String filePath) {
		String partyCode = dateChangeData.getCoustomerid();
		logger.info("partyCode:"+dateChangeData.getCoustomerid()+",filePath:"+filePath);
		//查询该客户下的所有符合要求的保单，上传影像到这些保单里
		PolicyInformation  polPolicyInformation = policyListQueryService.policyListQuery(partyCode,"POLICY-HOL");
		PolicyInformation  insuredPolicyInformation = policyListQueryService.policyListQuery(partyCode,"LIFE-ASSD");
		QueryModel[] polModel = null;
		QueryModel[] insuredModel = null;
		if("0".equals(polPolicyInformation.getCode().toString())){
			polModel = polPolicyInformation.getModel();
		}
		if("0".equals(insuredPolicyInformation.getCode().toString())){
			insuredModel = insuredPolicyInformation.getModel();
		}
		List<String> polPolicyList = new ArrayList<String>();
		logger.info("作为投保人保单个数："+ (polModel==null?0:polModel.length));
		logger.info("作为被保险人保单个数："+ (insuredModel==null?0:insuredModel.length));
		//符合要求的保单状态('05','06','13','15','19','21','03')
		String[] policyStatusArray = {"05","06","13","15","19","21","03"};
		if(polModel != null){
			for(QueryModel policyModel : polModel) {
				String policyStatus = policyModel.getPolicyStatus();
				if (policyStatus != null && Arrays.asList(policyStatusArray).contains(policyStatus)) {
					//上传影像资料
					List<String> files = new ArrayList<String>();
					files.add(dateChangeData.getFront().substring(mediaPath.length()));
					files.add(dateChangeData.getContrary().substring(mediaPath.length()));
					sinoImagePreservation(policyModel.getPolicyNum(),files,filePath);
					polPolicyList.add(policyModel.getPolicyNum());
				}
			}
		}
		if(insuredModel != null){
			for(QueryModel policyModel : insuredModel) {
				String policyStatus = policyModel.getPolicyStatus();
				if (!polPolicyList.contains(policyModel.getPolicyNum())//去除投保人已上传的保单
						&& policyStatus != null 
						&& Arrays.asList(policyStatusArray).contains(policyStatus)) {
					//上传影像资料
					List<String> files = new ArrayList<String>();
					files.add(dateChangeData.getFront().substring(mediaPath.length()));
					files.add(dateChangeData.getContrary().substring(mediaPath.length()));
					sinoImagePreservation(policyModel.getPolicyNum(),files,filePath);
				}
			}
		}
		dateChangeData.setSinoImageFlag("2");
		dateChangeDataService.saveOrUpdate("coustomerid",partyCode,dateChangeData);
	}
	
	public Map sinoImagePreservation(String policyid,List<String> files,String filePath){
		Map retMap = new HashMap();
		//业务信息
		int imagepages = files.size();//影像数量
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String guidangtime = df.format(date);//当前日期
		df = new SimpleDateFormat("yyyyMMddHHmmss");
		String policyappid = policyid + df.format(date);
		//获取批次号
		String batchNo = this.getBatchNo();
		//组装批次信息
		BatchInfo batch = new BatchInfo();
		batch.setBatchNo(batchNo);// 批次号
		//**下列批次属性代码逻辑上未非必输属性，业务逻辑上建议上传 *//*
		batch.setTellerNo(clerkOrgId);//创建人 虚拟柜员
		batch.setSourceIp(sourceip);//来源IP
		batch.setImgAmount(imagepages);//影像数量
		batch.setIclsId(ICLSID);//影像类型
		batch.setSerialNumber(BUSINESSPRESERVATION+":"+policyid);//业务流水号，强烈建议上传
		BatchMetadata batchMetadata1 = new BatchMetadata();
		batchMetadata1.setBatchNo(batchNo);
		batchMetadata1.setIclsId(ICLSID);
		batchMetadata1.setNodeNo(batch.getNodeNo());	
		batchMetadata1.setMetaName("ProTeam");
		batchMetadata1.setMetaAlias("来源");
		batchMetadata1.setMetaValue(PROTEAM);
		batch.getMetas().add(batchMetadata1);
		//拼装影像
		for(String fileName:files){
			logger.info("fileName:"+fileName);
			ImageInfo image = new ImageInfo();
			image.setSparesOne(SPARESONEPRESERVATION);//必输属性,如果不输，影像批次无法正常按照结构树显示
			image.setImgNo(fileName.split("\\.")[0]);
			image.setBatchNo(batchNo);
			image.setIclsId(ICLSID);
			image.setImgName(fileName);
			image.setImgMemi(fileName.split("\\.")[1]);
			image.setImgPath(filePath + fileName);
			image.setImgSize(new File(filePath + fileName).length() + "");
			image.setImgSequence(fileName.split("\\.")[0]);
			//将图像信息添加到批次信息中
			batch.getImages().add(image);
		}
		//批次信息组装完成
		
		logger.info("****组装批次信息完毕，开始影像上传****");
		this.uploadYXFile(batch);
		logger.info("影像上传成功，批次号："+batchNo);
		//提交业务信息 
		BusiInfo busiInfo = new BusiInfo(BUSINESSPRESERVATION, batchNo, imagepages+"", PROTEAM, null, policyid, "", CLERK, null, guidangtime, orgid, clerkOrgId);
		busiInfo.setPolicyappid(policyappid);
		BusiInfoResponse busiInfoResponse = this.sendBusiInfo(busiInfo);
		logger.info("返回报文："+busiInfoResponse.toString());
		retMap.put("policyappid", policyappid);
		retMap.put("batchNo", batchNo);
		retMap.put("code", busiInfoResponse.getRetCode());
		return retMap;
	}
	
	public void sinoImageBatchUpload(){
		logger.info("*************批量上传资料到影像系统开始************");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = df.parse(batchStartTime);
			endTime = df.parse(batchEndTime);
			logger.info("开始时间:" + startTime + ",结束时间:" + endTime);
			if(startTime != null && endTime != null){
				//查询指定时间段未上传到影像系统的数据
				List<DateChangeData> dateChangeDatas = dateChangeDataService.getDateChangeDataByTime(startTime, endTime, "0");
				dateChangeDatas.addAll(dateChangeDataService.getDateChangeDataByTime(startTime, endTime, "1"));
				String filePath = SinoImageServiceImpl.class.getClassLoader().getResource("../../").getPath() + "/IdentityImage/";
				logger.info("filePath:" + filePath+",dateChangeDatas:" + dateChangeDatas.size());
				for(DateChangeData dateChangeData:dateChangeDatas){
					String partyType = dateChangeData.getChangeType();
					logger.info("partyType:" + partyType);
					if(partyType.equals("投保人") || partyType.equals("被保险人")){
						sinoImageCertificateOnlyInsured(dateChangeData,filePath);
					}
				}
			}
		} catch (Exception e) {
			logger.error("上传异常：",e);;
			e.printStackTrace();
		}
	}
	
	public void sinoImageCertificateOnlyInsured(DateChangeData dateChangeData, String filePath) {
		String partyCode = dateChangeData.getCoustomerid();
		logger.info("partyCode:"+dateChangeData.getCoustomerid()+",filePath:"+filePath);
		//查询该客户下的所有符合要求的保单，上传影像到这些保单里
		PolicyInformation  polPolicyInformation = policyListQueryService.policyListQuery(partyCode,"POLICY-HOL");
		PolicyInformation  insuredPolicyInformation = policyListQueryService.policyListQuery(partyCode,"LIFE-ASSD");
		QueryModel[] polModel = null;
		QueryModel[] insuredModel = null;
		if("0".equals(polPolicyInformation.getCode().toString())){
			polModel = polPolicyInformation.getModel();
		}
		if("0".equals(insuredPolicyInformation.getCode().toString())){
			insuredModel = insuredPolicyInformation.getModel();
		}
		List<String> polPolicyList = new ArrayList<String>();
		logger.info("作为投保人保单个数："+ (polModel==null?0:polModel.length));
		logger.info("作为被保险人保单个数："+ (insuredModel==null?0:insuredModel.length));
		//符合要求的保单状态('05','06','13','15','19','21','03')
		String[] policyStatusArray = {"05","06","13","15","19","21","03"};
		if(polModel != null){
			for(QueryModel policyModel : polModel){
				polPolicyList.add(policyModel.getPolicyNum());
			}
		}
		if(insuredModel != null){
			for(QueryModel policyModel : insuredModel) {
				String policyStatus = policyModel.getPolicyStatus();
				if (!polPolicyList.contains(policyModel.getPolicyNum())//去除投保人已上传的保单
						&& policyStatus != null 
						&& Arrays.asList(policyStatusArray).contains(policyStatus)) {
					//上传影像资料
					List<String> files = new ArrayList<String>();
					files.add(dateChangeData.getFront().substring(mediaPath.length()));
					files.add(dateChangeData.getContrary().substring(mediaPath.length()));
					sinoImagePreservation(policyModel.getPolicyNum(),files,filePath);
				}
			}
		}
		dateChangeData.setSinoImageFlag("2");
		dateChangeDataService.saveOrUpdate("coustomerid",partyCode,dateChangeData);
	}
	
}
