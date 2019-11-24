package cn.com.sinosoft.ess.protal.service;
    /* 
     * 
     * 客服登录返回json
     */  
    public class CloginP{  
      
        private String successFlag;  
        private String errMsg;
        private String userId;
        private String dse_sessionId;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getDse_sessionId() {
			return dse_sessionId;
		}
		public void setDse_sessionId(String dse_sessionId) {
			this.dse_sessionId = dse_sessionId;
		}
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