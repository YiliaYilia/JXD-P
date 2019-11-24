
/**
 * BusinessExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

package com.omgd.ec.ws;

public class BusinessExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1383882854117L;
    
    private com.omgd.ec.ws.BusinessExceptionE faultMessage;

    
        public BusinessExceptionException() {
            super("BusinessExceptionException");
        }

        public BusinessExceptionException(java.lang.String s) {
           super(s);
        }

        public BusinessExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public BusinessExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.omgd.ec.ws.BusinessExceptionE msg){
       faultMessage = msg;
    }
    
    public com.omgd.ec.ws.BusinessExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    