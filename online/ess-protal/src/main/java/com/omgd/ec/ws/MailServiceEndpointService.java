

/**
 * MailServiceEndpointService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.omgd.ec.ws;

    /*
     *  MailServiceEndpointService java interface
     */

    public interface MailServiceEndpointService {
          

        /**
          * Auto generated method signature
          * 
                    * @param sendPolicyMailWithContent0
                
         */

         
                     public com.omgd.ec.ws.SendPolicyMailWithContentResponseE sendPolicyMailWithContent(

                        com.omgd.ec.ws.SendPolicyMailWithContentE sendPolicyMailWithContent0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendPolicyMailWithContent0
            
          */
        public void startsendPolicyMailWithContent(

            com.omgd.ec.ws.SendPolicyMailWithContentE sendPolicyMailWithContent0,

            final com.omgd.ec.ws.MailServiceEndpointServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendRestPwdMail2
                
         */

         
                     public com.omgd.ec.ws.SendRestPwdMailResponseE sendRestPwdMail(

                        com.omgd.ec.ws.SendRestPwdMailE sendRestPwdMail2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendRestPwdMail2
            
          */
        public void startsendRestPwdMail(

            com.omgd.ec.ws.SendRestPwdMailE sendRestPwdMail2,

            final com.omgd.ec.ws.MailServiceEndpointServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendPolicyMail4
                
         */

         
                     public com.omgd.ec.ws.SendPolicyMailResponseE sendPolicyMail(

                        com.omgd.ec.ws.SendPolicyMailE sendPolicyMail4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendPolicyMail4
            
          */
        public void startsendPolicyMail(

            com.omgd.ec.ws.SendPolicyMailE sendPolicyMail4,

            final com.omgd.ec.ws.MailServiceEndpointServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    