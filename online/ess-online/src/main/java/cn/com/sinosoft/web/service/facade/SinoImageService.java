package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.common.service.axis.BusiInfo;
import cn.com.sinosoft.common.service.axis.BusiInfoResponse;
import cn.com.sinosoft.domain.sale.GeClaimManagement;
import cn.com.sinosoft.domain.user.DateChangeData;
import cn.net.sinodata.domain.BatchInfo;

public interface SinoImageService {

	/**
	 * 获取影像批次号
	 * @return
	 */
	public String getBatchNo();
	
	/**
	 * 上传图片到影像系统
	 * @param batch
	 * @return
	 */
	public String uploadYXFile(BatchInfo batch);
	
	/**
	 * 发送业务数据到影像系统
	 * @param busiInfo
	 * @return
	 */
	public BusiInfoResponse sendBusiInfo(BusiInfo busiInfo);
	
	/**
	 * 理赔影像上传
	 * @param claimManagement
	 * @param filePath
	 */
	public void sinoImageClaim(GeClaimManagement claimManagement,String filePath);
	
	/**
	 * 证件影像上传
	 * @param claimManagement
	 * @param filePath
	 */
	public void sinoImageCertificate(DateChangeData dateChangeData,String filePath);
	
	/**
	 * 批量上传资料到影像系统
	 */
	public void sinoImageBatchUpload();
}
