
/**
 * MailServiceEndpointServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.omgd.ec.ws;

    /**
     *  MailServiceEndpointServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MailServiceEndpointServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MailServiceEndpointServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MailServiceEndpointServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for sendPolicyMailWithContent method
            * override this method for handling normal response from sendPolicyMailWithContent operation
            */
           public void receiveResultsendPolicyMailWithContent(
                    com.omgd.ec.ws.SendPolicyMailWithContentResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendPolicyMailWithContent operation
           */
            public void receiveErrorsendPolicyMailWithContent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendRestPwdMail method
            * override this method for handling normal response from sendRestPwdMail operation
            */
           public void receiveResultsendRestPwdMail(
                    com.omgd.ec.ws.SendRestPwdMailResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendRestPwdMail operation
           */
            public void receiveErrorsendRestPwdMail(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendPolicyMail method
            * override this method for handling normal response from sendPolicyMail operation
            */
           public void receiveResultsendPolicyMail(
                    com.omgd.ec.ws.SendPolicyMailResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendPolicyMail operation
           */
            public void receiveErrorsendPolicyMail(java.lang.Exception e) {
            }
                


    }
    