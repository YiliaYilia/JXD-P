package cn.com.sinosoft.core.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;

import org.xhtmlrenderer.pdf.ITextRenderer;

import cn.com.sinosoft.core.ca.CAPropertityUtil;
import cn.com.sinosoft.core.ca.EcsESSPDFClientTool;
import cn.com.sinosoft.core.utils.PathUtil;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

/**
 * 描述：PDF工具类<br>
 * 作者：liyang <br>
 * 修改日期：2014-1-2上午11:57:12 <br>
 * E-mail: <br>
 */
public class PDFUtil {

	/**
	 * 方法名称: generatePDF<br>
	 * 描述：通用生成PDF方法
	 * 作者: liyang
	 * 修改日期：2014-1-3下午12:27:35
	 * @param sw 整合好内容的writer
	 * @param pdfPlus 要拼接的PDF文件对象
	 * @return
	 */
	public static byte[] generatePDF(StringWriter sw,File pdfPlus) {
		String fontDir = PathUtil.getClassBuildPath()+"epolicyTemplate/fonts";
		//临时路径需要配置起来
		 
		//用字体渲染流利的内容
		ITextRenderer render = new ITextRenderer();
		render.setDocumentFromString(sw.toString());
		//初始化字体
		FlyingSaucerUtils.initFlyingSaucerFonts(render, fontDir);
		render.layout();
		
		//生成一个临时文件，存放前半部分PDF
		String random = new Date().getTime()+".pdf";
		File randomFile = new File(fontDir+"\\"+random);
		//声明各种流
		ByteArrayOutputStream newFileOutPutStream = null;
		PdfReader pdfReader = null;
		PdfReader jsnPdfReader = null;
		InputStream jsnInputStream = null;
		InputStream oldFileinInputStream = null;
		FileOutputStream reportOutputStream = null;
		byte[] pdf = null;
		try {
			//保存前半部分PDF
			randomFile.createNewFile();
			reportOutputStream = new FileOutputStream(randomFile);
			newFileOutPutStream = new ByteArrayOutputStream();
			render.createPDF(reportOutputStream);
			reportOutputStream.flush();
			//拼接后半部分PDF
			oldFileinInputStream = new FileInputStream(randomFile);
			pdfReader = new PdfReader(oldFileinInputStream);
			Document document = new Document(pdfReader.getPageSize(1));
			PdfCopy pdfCopy = new PdfCopy(document, newFileOutPutStream);
			document.open();
			jsnInputStream = new FileInputStream(pdfPlus);
			jsnPdfReader = new PdfReader(jsnInputStream);
			int oldPages = pdfReader.getNumberOfPages();
			for(int i=1;i<=oldPages;i++){
				document.newPage();
				PdfImportedPage page = pdfCopy.getImportedPage(pdfReader, i);
				pdfCopy.addPage(page);
			}
			int pages = jsnPdfReader.getNumberOfPages();
			for(int i=1;i<=pages;i++){
				document.newPage();
				PdfImportedPage page = pdfCopy.getImportedPage(jsnPdfReader, i);
				pdfCopy.addPage(page);
			}
			newFileOutPutStream.flush();
			document.close();
			pdf = newFileOutPutStream.toByteArray();
//			FileOutputStream ops = new FileOutputStream(new File("D:/aaaaa.pdf"));
//			ops.write(pdf);
//			ops.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reportOutputStream != null){
				try {
					reportOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(newFileOutPutStream != null){
				try {
					newFileOutPutStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(pdfReader != null){
				pdfReader.close();
			}
			if(jsnPdfReader != null){
				jsnPdfReader.close();
			}
			if(jsnInputStream !=null){
				try {
					jsnInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(oldFileinInputStream != null){
				try {
					oldFileinInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(randomFile.exists()){
				randomFile.delete();
			}
			
		}
		
//		byte[] capdf = null;
//		if("0".equals(CAPropertityUtil.get("isCa"))){
//			capdf = EcsESSPDFClientTool.pdfSign(pdf,CAPropertityUtil.get("ruleNum"));
//			capdf = EcsESSPDFClientTool.pdfSign(capdf,CAPropertityUtil.get("ruleNumCom"));
//			if(capdf == null){
//				//记录Ca 签章状态记录
//				System.out.println("签章失败");
//			}
//		}
//		else{
//			capdf = pdf;
//		}
//		//返回拼接好的PDF或者null
//		return capdf;
		return pdf;
	}

}
