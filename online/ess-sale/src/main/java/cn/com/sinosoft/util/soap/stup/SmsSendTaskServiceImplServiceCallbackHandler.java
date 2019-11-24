
/**
 * SmsSendTaskServiceImplServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package cn.com.sinosoft.util.soap.stup;

    /**
     *  SmsSendTaskServiceImplServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SmsSendTaskServiceImplServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SmsSendTaskServiceImplServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SmsSendTaskServiceImplServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for sendSPSendTasks method
            * override this method for handling normal response from sendSPSendTasks operation
            */
           public void receiveResultsendSPSendTasks(
                    cn.com.sinosoft.util.soap.stup.SmsSendTaskServiceImplServiceStub.SendSPSendTasksResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendSPSendTasks operation
           */
            public void receiveErrorsendSPSendTasks(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendSPSendTasksAndSaveSendUser method
            * override this method for handling normal response from sendSPSendTasksAndSaveSendUser operation
            */
           public void receiveResultsendSPSendTasksAndSaveSendUser(
                    cn.com.sinosoft.util.soap.stup.SmsSendTaskServiceImplServiceStub.SendSPSendTasksAndSaveSendUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendSPSendTasksAndSaveSendUser operation
           */
            public void receiveErrorsendSPSendTasksAndSaveSendUser(java.lang.Exception e) {
            }
                


    }
    