package cn.com.sinosoft.ess.protal.service;
    /* 
     * 
     * 官网、电商应答报文
     */  
    public class CwResP{  
      
        private String successFlag;  
        private String errMsg;
		public String getSuccessFlag() {
			return successFlag;
		}
		public void setSuccessFlag(String successFlag) {
			this.successFlag = successFlag;
		}
		public String getErrMsg() {
			return errMsg;
		}
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}  
      
       
    }  