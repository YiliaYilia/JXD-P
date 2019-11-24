package cn.com.sinosoft.web.service.facade;

import java.util.Date;
import java.util.List;

import cn.com.sinosoft.domain.sale.GE_ProductcodeOTM;

public interface ElectronicPolicyQueryService {
	/**
	 * 功能：电销服务器获取pdf
	 * @param filepath 文件路径
	 * @throws Exception
	 */
	void QueryElectronicPolicy(String filepath,String policyNo,String ProductCode,String policytime) throws Exception;
	/**
	 * 功能：删除指定路径下所有文件
	 */
	void delete();
	/**
	 * 功能：核心获取pdf 
	 * @param policyNo 保单号
	 * @param PrintID 
	 * @return byte[]  pdf byte流
	 */
	byte[] getPDF(String policyNo,String PrintID);
	/**
	 * 功能：获取电销eml文件路径
	 * @param policyNo
	 * @return path  eml路径
	 */
	String getDOCUMENTPATH(String policyNo);
	/**
	 * 功能：将pdf byte[]写入指定路径
	 * @param  pdf  byte流
	 * @param pdfname pdf文件名
	 * @param policyNo 保单号
	 */
	void writeFile(byte pdf[],String pdfname,String policyNO);
	/**
	 * 功能：从电销获取保单时间
	 * @return
	 */
	Date getDate(String policyNo);
	/**
	 * 功能：从数据库查找pdf对应name
	 * @param prodauctcode
	 * @return
	 */
	List<GE_ProductcodeOTM> findPdfnamebycode(String prodauctcode,String name,String path);
}
