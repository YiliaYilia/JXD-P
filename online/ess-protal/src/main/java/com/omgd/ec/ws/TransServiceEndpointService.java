

/**
 * TransServiceEndpointService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package com.omgd.ec.ws;

    /*
     *  TransServiceEndpointService java interface
     */

    public interface TransServiceEndpointService {
          

        /**
          * Auto generated method signature
          * 
                    * @param doSurrender0
                
         */

         
                     public com.omgd.ec.ws.DoSurrenderResponseE doSurrender(

                        com.omgd.ec.ws.DoSurrenderE doSurrender0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param doSurrender0
            
          */
        public void startdoSurrender(

            com.omgd.ec.ws.DoSurrenderE doSurrender0,

            final com.omgd.ec.ws.TransServiceEndpointServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param doApp2
                
         */

         
                     public com.omgd.ec.ws.DoAppResponseE doApp(

                        com.omgd.ec.ws.DoAppE doApp2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param doApp2
            
          */
        public void startdoApp(

            com.omgd.ec.ws.DoAppE doApp2,

            final com.omgd.ec.ws.TransServiceEndpointServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param downloadPolicyFile4
                
             * @throws com.omgd.ec.ws.BusinessExceptionException : 
         */

         
                     public com.omgd.ec.ws.DownloadPolicyFileResponseE downloadPolicyFile(

                        com.omgd.ec.ws.DownloadPolicyFileE downloadPolicyFile4)
                        throws java.rmi.RemoteException
             
          ,com.omgd.ec.ws.BusinessExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param downloadPolicyFile4
            
          */
        public void startdownloadPolicyFile(

            com.omgd.ec.ws.DownloadPolicyFileE downloadPolicyFile4,

            final com.omgd.ec.ws.TransServiceEndpointServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param greet6
                
         */

         
                     public com.omgd.ec.ws.GreetResponseE greet(

                        com.omgd.ec.ws.GreetE greet6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param greet6
            
          */
        public void startgreet(

            com.omgd.ec.ws.GreetE greet6,

            final com.omgd.ec.ws.TransServiceEndpointServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    