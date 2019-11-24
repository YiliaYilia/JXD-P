
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:23:23 CEST)
 */

        
            package com.omgd.ec.ws;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "policy".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Policy.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "contract".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Contract.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "appResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.AppResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "downloadPolicyFileResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.DownloadPolicyFileResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "doApp".equals(typeName)){
                   
                            return  com.omgd.ec.ws.DoApp.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "transRequHeader".equals(typeName)){
                   
                            return  com.omgd.ec.ws.TransRequHeader.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "extraAttrs_type0".equals(typeName)){
                   
                            return  com.omgd.ec.ws.ExtraAttrs_type0.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "advisor".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Advisor.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "greet".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Greet.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "surrenderResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SurrenderResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "surrenderRequest".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SurrenderRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "holder".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Holder.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "BusinessException".equals(typeName)){
                   
                            return  com.omgd.ec.ws.BusinessException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "doSurrenderResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.DoSurrenderResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "downloadPolicyFile".equals(typeName)){
                   
                            return  com.omgd.ec.ws.DownloadPolicyFile.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "doSurrender".equals(typeName)){
                   
                            return  com.omgd.ec.ws.DoSurrender.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "downloadRequest".equals(typeName)){
                   
                            return  com.omgd.ec.ws.DownloadRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "transRespHeader".equals(typeName)){
                   
                            return  com.omgd.ec.ws.TransRespHeader.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "benef".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Benef.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "appRequest".equals(typeName)){
                   
                            return  com.omgd.ec.ws.AppRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "greetResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.GreetResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "agreement".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Agreement.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "bankAccount".equals(typeName)){
                   
                            return  com.omgd.ec.ws.BankAccount.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "doAppResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.DoAppResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "entry_type0".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Entry_type0.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "insured".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Insured.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "product".equals(typeName)){
                   
                            return  com.omgd.ec.ws.Product.Factory.parse(reader);
                        

                  }

                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "sendRestPwdMailResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SendRestPwdMailResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "sendRestPwdMail".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SendRestPwdMail.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "sendPolicyMailWithContent".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SendPolicyMailWithContent.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "sendPolicyMailWithContentResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SendPolicyMailWithContentResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "sendPolicyMail".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SendPolicyMail.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.ec.omgd.com/".equals(namespaceURI) &&
                  "sendPolicyMailResponse".equals(typeName)){
                   
                            return  com.omgd.ec.ws.SendPolicyMailResponse.Factory.parse(reader);
                        

                  }
                  
              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    