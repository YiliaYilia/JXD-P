package cn.com.sinosoft.web.system;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.config.service.GeDepartmentService;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.MatrixToImageWriter;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.GeChannel;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.dto.system.GeChannelForm;
import cn.com.sinosoft.dto.system.GeChannelForm.GeChannelRow;
import cn.com.sinosoft.user.service.GeChannelService;
import net.sf.json.JSONObject;

/**
 * 渠道图片配置
 * @author GHY
 */
public class GeChannelAction extends Struts2Action{
	private static final long serialVersionUID = 1L;
	@Autowired
	GeChannelService geChannelService;
	
	@Autowired
	private GeDepartmentService geDepartmentService;
	
	@Autowired
	private DictDataService dictDataService;
	
	private GeChannel geChannel;
	
	private File file;//获取上传文件  
	
	String logo;
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(GeChannelAction.class.getResourceAsStream("/config/config.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Action(value = "GeChannelForm")
	public String geChannelForm() {
		List<GeDepartment> departmentList = geDepartmentService.getGeDepartmentAll();
		this.setRequestAttribute("departmentList", departmentList);
		if(logo==null||"".equals(logo)){
			this.setRequestAttribute("logo", logo);
			return "/page/main/GeChannel";
		}
		if(logo.equals("1")){
			//机构
			List<GeDepartment> geDepartments = geDepartmentService.getGeDepartmentAll();
			setRequestAttribute("geDepartments", geDepartments);
			this.setRequestAttribute("logo", logo);
			return "/page/main/GeChannelInfo";
		}
		return "/page/main/GeChannel";
	}

	@Action(value="GeChannelSearch")
	public void geChannelSearch(){
		Page<GeChannel> pageObj = geChannelService.findChannelList(geChannel,page,rows);
		List<GeChannel> list = pageObj.getData();
		GeChannelForm geChannelForm = new GeChannelForm();
		geChannelForm.setTotal(pageObj.getTotal() + "");
		List<GeDepartment> geDepartments = geDepartmentService.getGeDepartmentAll();
		List<GeChannelRow> rows = new ArrayList<GeChannelRow>();
		for (GeChannel geChannel : list) {
			GeChannelRow row = new GeChannelRow();
			BeanUtils.copyProperties(geChannel, row);
			
			for (GeDepartment tment : geDepartments) {
				if(tment.getDeptCode().equals(geChannel.getDeptCode())){
					row.setShowDeptCode(tment.getDeptname());
				}
			}
			String policyNmae = geChannel.getPolicyName();
			if(null != policyNmae && !"".equals(policyNmae)){
				GeDictData ge = dictDataService.findDictDataByDictDataCode(policyNmae);
				if(ge != null){
					row.setShowPolicyName(ge.getDictdataname());
				}
			}
			rows.add(row);
		}
		geChannelForm.setRows(rows);
		String result = JSONObject.fromObject(geChannelForm).toString();
		super.render(result, "text/json;charset=UTF-8");
		
	}
	
	@Action(value="deleteGeChannelData")
	public String deleteGeChannelData(){
		//String id = this.getHttpServletRequest().getParameter("id");
		String deleteIds = this.getHttpServletRequest().getParameter("deleteIds");
		String[] ids = deleteIds.split(",");
		for(int i=0;i<ids.length;i++){
			String id=ids[i];
			geChannelService.deleteChannelData(id);
		}
		return "/page/main/GeChannel";
	}
	
	@Action(value="findGeChannelData")
	public String findGeChannelData(){
		//机构
		List<GeDepartment> geDepartments = geDepartmentService.getGeDepartmentAll();
		setRequestAttribute("geDepartments", geDepartments);
		String id = this.getHttpServletRequest().getParameter("id");
		GeChannel geChannel = geChannelService.getChannelById(id);
		String matrix = geChannel.getPolicyMatrix();
		if(null == matrix){
			geChannel.setPolicyMatrix("");
		}
		GeChannelRow row = new GeChannelRow();
		BeanUtils.copyProperties(geChannel, row);
		this.setRequestAttribute("geChannel", row);
		if(logo==null||"".equals(logo)){
			this.setRequestAttribute("logo", logo);
			return "/page/main/GeChannelInfo";
		}
		if(logo.equals("2")){
			this.setRequestAttribute("logo", logo);
		}
		return "/page/main/GeChannelInfo";
	}
	
	@Action(value="addGeChannelData")
	public String addGeChannelData(){
		geChannel.setChannelCode(getHttpServletRequest().getParameter("geChannel.channelCode"));
		geChannel.setChannelName(getHttpServletRequest().getParameter("geChannel.channelName"));
		geChannel.setDeptCode(getHttpServletRequest().getParameter("geChannel.deptCode"));
		geChannel.setIsAgentcode(getHttpServletRequest().getParameter("geChannel.isAgentcode"));
		geChannel.setPolicyName(getHttpServletRequest().getParameter("geChannel.policyName"));
		//生成产品链接以及二维码
		try {
			setPictureUrlAndMatrix(geChannel.getPolicyName(), geChannel.getChannelCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		upload(geChannel);//保持照片
		geChannelService.addChannelData(geChannel);
		return "/page/main/GeChannel";
	}
	
	/**
	 * 保存产品首页照片
	 * @param geChannel
	 */
	public void upload(GeChannel geChannel) {
		if(file != null){
			int length = 0;
			byte[] sendBytes = null;
			Socket socket = null;
			DataOutputStream dos = null;
			FileInputStream fis = null;
			try {
				try {
					//将图片保存到online系统中
					socket = new Socket();
					socket.connect(new InetSocketAddress(pro.getProperty("pictureIp"), 7777), 10 * 1000);
					dos = new DataOutputStream(socket.getOutputStream());
					//File file = new File("D:\\test.jpg");
					fis = new FileInputStream(file);
					sendBytes = new byte[1024];
					String pathName =geChannel.getPolicyName()+geChannel.getChannelCode()+"_HomePage";
					byte b[] = pathName.getBytes();
					int len = b.length+2;
					dos.write((len+pathName).getBytes(), 0, len);
					while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
						dos.write(sendBytes, 0, length);
						dos.flush();
					}
					String imgUrl = pro.getProperty("picturePath")+pathName+".jpg";
			        geChannel.setImgUrl(imgUrl);
				} finally {
					if (dos != null)
						dos.close();
					if (fis != null)
						fis.close();
					if (socket != null)
						socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        } else {
        	geChannel.setImgUrl(getHttpServletRequest().getParameter("geChannel.imgUrl"));
        }
	}
	
	/**
	 * 组装产品地址已经生成二维码
	 * @throws Exception 
	 */
	public void setPictureUrlAndMatrix(String policyCode,String channelCode) throws Exception{
		String policyUrl = pro.getProperty(policyCode);
		if(null != policyUrl && policyUrl.contains("A0000")){
			policyUrl = policyUrl.replace("A0000", channelCode);
		} else if(policyUrl.contains("brNo")){
			String str = policyUrl.substring(policyUrl.indexOf("brNo"));
			policyUrl = policyUrl.replace(str.substring(str.indexOf("brNo"), str.indexOf("&")), "brNo="+channelCode);
		} else {
			policyUrl = "请正确配置产品默认地址";
		}
		geChannel.setPolicyUrl(policyUrl);
		//生成二维码并保存
		int width = 300;
		int height = 300;
		//二维码的图片格式
		String format = "png";
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		//内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(policyUrl,BarcodeFormat.QR_CODE, width, height, hints);
		//生成二维码
		String path = ServletActionContext.getServletContext().getRealPath("/picture");
		String pathName = policyCode+channelCode+"_Matrix.png";
		String policyMatrix = path+File.separator+pathName;
		File outputFile = new File(policyMatrix);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		String contextPath = getHttpServletRequest().getContextPath();
		geChannel.setPolicyMatrix(contextPath+"/picture/"+pathName);
	}
	
	private static final String  DATE_TYPE = "yyyyMMddHHmmssSSS";
	public static synchronized String createFlowNo(){
		String datestr = DateAndTime.getCurrentDateTime(DATE_TYPE);
		String num = RandomStringUtils.random(3, false, true);
		return datestr + num;
	}
	
	/**
     * 从输入流中读取数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len = inStream.read(buffer)) !=-1 ){
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();//网页的二进制数据
        outStream.close();
        inStream.close();
        return data;
    }
	
	@Action(value="updateGeChannelData")
	public String updateGeChannelData(){
		geChannel.setId(getHttpServletRequest().getParameter("geChannel.id"));
		geChannel.setChannelCode(getHttpServletRequest().getParameter("geChannel.channelCode"));
		geChannel.setChannelName(getHttpServletRequest().getParameter("geChannel.channelName"));
		geChannel.setDeptCode(getHttpServletRequest().getParameter("geChannel.deptCode"));
		geChannel.setIsAgentcode(getHttpServletRequest().getParameter("geChannel.isAgentcode"));
		geChannel.setPolicyName(getHttpServletRequest().getParameter("geChannel.policyName"));
		//生成产品链接以及二维码
		try {
			setPictureUrlAndMatrix(geChannel.getPolicyName(), geChannel.getChannelCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		upload(geChannel);//保持照片
		geChannelService.updateChannelData(geChannel);
		return "/page/main/GeChannel";
	}
	
	@Action(value="addCheck")
	public void addCheck(){
		List<GeChannel> channel =null;
		String policyName = getHttpServletRequest().getParameter("policyName");//产品名称
		String channelCode = getHttpServletRequest().getParameter("channelCode");//合作伙伴代码
		String id = getHttpServletRequest().getParameter("id");//修改标识id
		if(null!=id && !"".equals(id)){
			channel = geChannelService.getChannelByUpdae(policyName, channelCode, id);
		} else {
			channel = geChannelService.getChannel(policyName,channelCode);
		}
		
		String info = "";
		if(null !=channel && channel.size()>0){
			info = "1";//数据库中存在此记录
		}
		List<GeDepartment> geDepartments = geDepartmentService.getGeDepartmentAll();//所有的机构
		String mes = "";
		for (GeDepartment geDepartment : geDepartments) {
			if("A0000".equals(channelCode)){
				mes = "1"; //可以通过
				break;
			}else if(channelCode.substring(0, 2).equals(geDepartment.getDeptCode())){
				mes = "2";//可以通过
				break;
			}else{
				mes = "3";
			}
		}
		String res = JSONObject.fromObject("{\"info\":\""+info+"\",\"mes\":\""+mes+"\"}").toString();
		render(res,"text/json;charset=UTF-8");
	}
	
	public GeChannel getGeChannel() {
		return geChannel;
	}

	public void setGeChannel(GeChannel geChannel) {
		this.geChannel = geChannel;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}