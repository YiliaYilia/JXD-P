
/**
 * TransServiceEndpointServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package com.omgd.ec.ws;

    /**
     *  TransServiceEndpointServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TransServiceEndpointServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TransServiceEndpointServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TransServiceEndpointServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for doSurrender method
            * override this method for handling normal response from doSurrender operation
            */
           public void receiveResultdoSurrender(
                    com.omgd.ec.ws.DoSurrenderResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from doSurrender operation
           */
            public void receiveErrordoSurrender(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for doApp method
            * override this method for handling normal response from doApp operation
            */
           public void receiveResultdoApp(
                    com.omgd.ec.ws.DoAppResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from doApp operation
           */
            public void receiveErrordoApp(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for downloadPolicyFile method
            * override this method for handling normal response from downloadPolicyFile operation
            */
           public void receiveResultdownloadPolicyFile(
                    com.omgd.ec.ws.DownloadPolicyFileResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from downloadPolicyFile operation
           */
            public void receiveErrordownloadPolicyFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for greet method
            * override this method for handling normal response from greet operation
            */
           public void receiveResultgreet(
                    com.omgd.ec.ws.GreetResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from greet operation
           */
            public void receiveErrorgreet(java.lang.Exception e) {
            }
                


    }
    