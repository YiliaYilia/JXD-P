package cn.com.sinosoft.web.business;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.ExcelImport;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sell.RenewalBankData;
import cn.com.sinosoft.dto.sell.BankManageDto;
import cn.com.sinosoft.dto.sell.BankManageDto.BankManageRow;
import cn.com.sinosoft.product.service.BankManageService;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankManageAction extends Struts2Action {

    @Autowired
    private BankManageService bankManageService;

    private File file;
    private String fileFileName;
    private String fileContentType;

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

    @Action(value="bankManage")
    public String jumpBankManagePage(){
        return "/page/bankManage";
    }

    @Action(value="searchBankData")
    public String queryBank(){
        String bankCodeID = getHttpServletRequest().getParameter("bankCodeID");
        String bankNameID = getHttpServletRequest().getParameter("bankNameID");
        Page<RenewalBankData> pageObj = bankManageService.findAllBankData(bankCodeID,bankNameID,super.page, super.rows);

        BankManageDto bankData = new BankManageDto();
        bankData.setTotal(pageObj.getTotal() + "");
        List<BankManageRow> listRows = new ArrayList<BankManageRow>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (RenewalBankData data : (List<RenewalBankData>) pageObj.getData()) {
            BankManageRow row = new BankManageRow();
            BeanUtils.copyProperties(data, row);
            listRows.add(row);
        }
        bankData.setRows(listRows);
        String result = JSONObject.fromObject(bankData).toString();
        super.render(result, "text/json;charset=UTF-8");
        return null;
    }

    @Action(value = "saveBankData")
    public String saveBank(){
        String bankID = getHttpServletRequest().getParameter("bankID");
        String bankname = getHttpServletRequest().getParameter("bankname");
        String bankcode = getHttpServletRequest().getParameter("bankcode");
        String paychannel = getHttpServletRequest().getParameter("paychannel");
        String singlelmt = getHttpServletRequest().getParameter("singlelmt");
        String daylmt = getHttpServletRequest().getParameter("daylmt");
        String status = getHttpServletRequest().getParameter("status");
        try {
            bankname = new String (bankname.getBytes("iso-8859-1"), "UTF-8") ;
            paychannel = new String (paychannel.getBytes("iso-8859-1"), "UTF-8") ;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            return null;
        }
        String operateType = getHttpServletRequest().getParameter("operateType");
        String result = "保存成功";
        RenewalBankData rbd =  null;
        if("update".equals(operateType)){
            result = "更新成功";
            rbd = bankManageService.findBankDataByID(bankID);
            rbd.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            rbd.setUpdateuser(SpringSecurityUtil.getCurrentUserName());
        }else{
            List<RenewalBankData> list = bankManageService.findBankDataByBankCode(bankcode);
            if(list!=null&&list.size()>0){
                super.render("{\"success\":false,\"value\":\"" + result + "\"}",
                        "text/json;charset=UTF-8");
                return null;
            }
            rbd =  new RenewalBankData();
            rbd.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            rbd.setCreateuser(SpringSecurityUtil.getCurrentUserName());
        }
        rbd.setBankcode(bankcode);
        rbd.setBankname(bankname);
        rbd.setPaychannel(paychannel);
        rbd.setSinglelmt(singlelmt);
        rbd.setDaylmt(daylmt);
        rbd.setStatus(status);
        bankManageService.saveOrUpdateBankData(rbd, operateType);
        super.render("{\"success\":true,\"value\":\"" + result + "\"}",
                "text/json;charset=UTF-8");
        return null;
    }

    @Action(value = "deleteBankDatas")
    public void deleteBank(){

        String manyIds = getHttpServletRequest().getParameter("deleteIds");
        List<String> ids = new ArrayList<String>();
        if (manyIds.contains(",")) {
            String[] temp = manyIds.split(",");
            for (String str : temp) {
                ids.add(str);
            }
        } else {
            ids.add(manyIds);
        }
        bankManageService.deleteRenewalBankData(ids);
    }

    @Action(value = "editBankData")
    public void updateBank(){
        String bankID = getHttpServletRequest().getParameter("bankID");
        if (bankID != null && !"".equals(bankID)) {
            RenewalBankData bankData = bankManageService.findBankDataByID(bankID);
            super.render(
                    "{\"success\":true,\"bankID\":\""
                            +bankData.getBankID()
                            + "\",\"bankcode\":\""
                            + bankData.getBankcode()
                            + "\",\"bankname\":\""
                            + bankData.getBankname()
                            + "\",\"paychannel\":\""
                            + bankData.getPaychannel()
                            + "\",\"singlelmt\":\""
                            + bankData.getSinglelmt()
                            + "\",\"status\":\""
                            + bankData.getStatus()
                            + "\",\"daylmt\":\""
                            + bankData.getDaylmt() + "\"}",
                    "text/json;charset=UTF-8");
        }
    }

    @Action(value = "expBank")
    public boolean exportBank(){
        boolean flag = false;
        String seleteIds = super.getHttpServletRequest().getParameter("seleteIds");
        String bankname = super.getHttpServletRequest().getParameter("bankNameID");
        String bankcode = super.getHttpServletRequest().getParameter("bankCodeID");
        try {
            bankname = new String (bankname.getBytes("iso-8859-1"), "UTF-8") ;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            return flag;
        }
        List<RenewalBankData> banks = bankManageService.findAllBankData(bankcode,bankname,seleteIds);
        HttpServletResponse response;
        try {
            response = getHttpServletResponse();
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setContentType("application/msexcel");
            String  filename = "banklist" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
            response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1"));
            OutputStream os = response.getOutputStream();
            BankManageAction bm = new BankManageAction();
            flag =  bm.report(os, banks);
            os.close();
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean report(OutputStream os, List<RenewalBankData> accounts) {
        WritableWorkbook wwb = null;
        try {
            wwb = Workbook.createWorkbook(os);
            WritableFont headColor = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);//设置字体的颜色格式大小
            WritableFont headFont = new WritableFont(headColor);//使用上面定义的字体格式
            WritableCellFormat headFormat = new WritableCellFormat(headFont);//设置单元格格式
            headFormat.setBorder(Border.ALL, BorderLineStyle.THIN);// 设置线条线框的格式;
            headFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置垂直对齐
            headFormat.setAlignment(Alignment.CENTRE);// 设置水平对齐方式
            WritableFont normalFont = new WritableFont(WritableFont.createFont("宋体"), 10);
            WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
            normalFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
            normalFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
            normalFormat.setAlignment(Alignment.LEFT);// 水平对齐
            normalFormat.setWrap(true);// 是否换行
            // 创建Excel工作表:用户
            WritableSheet ws = wwb.createSheet("银行表", 0);
            ws.addCell(new Label(0, 0, "银行编码", headFormat));
            ws.setColumnView(0, 13);
            ws.addCell(new Label(1, 0, "付方银行", headFormat));
            ws.setColumnView(1, 14);
            ws.addCell(new Label(2, 0, "支付渠道", headFormat));
            ws.setColumnView(2, 24);
            ws.addCell(new Label(3, 0, "单账户单笔限额", headFormat));
            ws.setColumnView(3, 24);
            ws.addCell(new Label(4, 0, "单账户单日限额", headFormat));
            ws.setColumnView(4, 24);
            ws.addCell(new Label(5, 0, "可用状态", headFormat));
            ws.setColumnView(5, 24);
            ws.addCell(new Label(6, 0, "创建时间", headFormat));
            ws.setColumnView(6, 24);
            ws.addCell(new Label(7, 0, "更新时间", headFormat));
            ws.setColumnView(7, 24);
            int i=0;
            for(RenewalBankData renewalbank : accounts){
                ws.addCell(new Label(0, i+1,renewalbank.getBankcode()==null?"":renewalbank.getBankcode(), normalFormat));
                ws.addCell(new Label(1, i+1,renewalbank.getBankname()==null?"":renewalbank.getBankname(), normalFormat));
                ws.addCell(new Label(2, i+1,renewalbank.getPaychannel()==null?"":renewalbank.getPaychannel(), normalFormat));
                ws.addCell(new Label(3, i+1,renewalbank.getSinglelmt()==null?"":renewalbank.getSinglelmt(), normalFormat));
                ws.addCell(new Label(4, i+1,renewalbank.getDaylmt()==null?"":renewalbank.getDaylmt(), normalFormat));
                ws.addCell(new Label(5, i+1,renewalbank.getStatus()==null?"":renewalbank.getStatus(), normalFormat));
                ws.addCell(new Label(6, i+1,renewalbank.getCreatetime()==null?"":renewalbank.getCreatetime(), normalFormat));
                ws.addCell(new Label(7, i+1,renewalbank.getUpdatetime()==null?"":renewalbank.getUpdatetime(), normalFormat));

                i++;
            }
            wwb.write();
            return true;
        } catch (Exception e) {
            return false;
        } finally{
            try {
                if(wwb != null){
                    wwb.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @Action(value = "download")
    public void downloadBankExcel(){
        HttpServletResponse response;
        try{
            response = getHttpServletResponse();
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setContentType("application/msexcel");
            String  filename = "banklist.xls";
            response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1"));
            OutputStream os = response.getOutputStream();
            BankManageAction bm = new BankManageAction();
            List<RenewalBankData> rbd= new ArrayList<RenewalBankData>();
            bm.report(os, rbd);
        }catch(Exception e){

        }

    }
    @Action(value = "uploadBankExcel")
    public void importBank() {
        String path = getServletContext().getRealPath("/upload");
        System.out.println(path);
        if(file!=null){
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
        }
        File file = new File(path+"\\"+fileFileName);
        Map<String, String> header = new HashMap<String, String>();
        header.put("银行编码", "bankcode");
        header.put("付方银行", "bankname");
        header.put("支付渠道", "paychannel");
        header.put("单账户单笔限额", "singlelmt");
        header.put("单账户单日限额", "daylmt");
        header.put("可用状态", "status");
        header.put("创建时间", "createtime");
        header.put("更新时间", "updatetime");
        ExcelImport export = new ExcelImport(header);
        try {
            export.init(new FileInputStream(file));
            List<RenewalBankData> bankchild = export.bindToBanks(RenewalBankData.class, true);
            for (RenewalBankData bankdata:bankchild) {
                List<RenewalBankData> listrb = bankManageService.findBankDataByBankCode(bankdata.getBankcode());
                if(listrb!=null&&listrb.size()>0){
                    return;
                }
            }
            for (RenewalBankData bankdata:bankchild) {
                bankdata.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                bankdata.setCreateuser(SpringSecurityUtil.getCurrentUserName());
                bankManageService.saveOrUpdateBankData(bankdata,"save");
            }
            super.render(
                    "{\"success\":true}",
                    "text/json;charset=UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
