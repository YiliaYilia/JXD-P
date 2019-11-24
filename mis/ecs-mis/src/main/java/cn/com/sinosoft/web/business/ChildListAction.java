package cn.com.sinosoft.web.business;
import java.io.File; 
import java.io.IOException; 
import java.util.List;
 
import org.apache.commons.io.FileUtils; 
import org.apache.struts2.ServletActionContext; 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.product.service.ChildListService;
 


import java.io.FileInputStream;  
import java.io.InputStream;  
import java.util.ArrayList;  

import javax.servlet.http.HttpServletRequest;
  
import org.apache.commons.io.FilenameUtils;  
import org.springframework.beans.factory.annotation.Autowired;


public class ChildListAction extends Struts2Action{ 
     
    /**
	 * 
	 */
	private HttpServletRequest request = ServletActionContext.getRequest();
	private static final long serialVersionUID = 1L;
	private File file;//获取上传文件  
    private String fileFileName;//获取上传文件名称  
    private String fileContentType;//获取上传文件类型  
     
    @Autowired
    ChildListService cls;
    
    public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	
	@Action(value="uploadpage")
	public String jumpPolicyListPage(){
		return "/page/upload";
	}
	
	@Action(value="upload")
	public String upload(){ 
        String path = ServletActionContext.getServletContext().getRealPath("/files"); 
        String filepath = "";
        String text="";
        System.out.println(path); 
        if(file != null){
	        File savefile = new File(new File(path),fileFileName);
	        if(!savefile.getParentFile().exists()){
	            savefile.getParentFile().mkdirs();
	        }
	        try{
	            FileUtils.copyFile(file , savefile);
	        }catch (IOException e) {
	            // TODO Auto-generated catch block   
	            e.printStackTrace();
	        }
	        String[] t = fileContentType.split("/");
	        for(String s : t)
            System.out.println(s);
	        filepath = path+"/"+fileFileName;
        }
        if(cls.saveChild(filepath)){
        	 text= "success"; 
             request.setAttribute("text", text);
             System.out.println(request.getAttribute("text"));
        }else{
        text= "error";
        request.setAttribute("text", text);
        System.out.println(request.getAttribute("text"));
       
    }
        return "/page/upload";
	}
	
} 