
/**
 * AppRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:23:23 CEST)
 */

            
                package com.omgd.ec.ws;
            

            /**
            *  AppRequest bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class AppRequest
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = appRequest
                Namespace URI = http://ws.ec.omgd.com/
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Advisor
                        */

                        
                                    protected com.omgd.ec.ws.Advisor localAdvisor ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdvisorTracker = false ;

                           public boolean isAdvisorSpecified(){
                               return localAdvisorTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.Advisor
                           */
                           public  com.omgd.ec.ws.Advisor getAdvisor(){
                               return localAdvisor;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Advisor
                               */
                               public void setAdvisor(com.omgd.ec.ws.Advisor param){
                            localAdvisorTracker = param != null;
                                   
                                            this.localAdvisor=param;
                                    

                               }
                            

                        /**
                        * field for Agreement
                        */

                        
                                    protected com.omgd.ec.ws.Agreement localAgreement ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAgreementTracker = false ;

                           public boolean isAgreementSpecified(){
                               return localAgreementTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.Agreement
                           */
                           public  com.omgd.ec.ws.Agreement getAgreement(){
                               return localAgreement;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Agreement
                               */
                               public void setAgreement(com.omgd.ec.ws.Agreement param){
                            localAgreementTracker = param != null;
                                   
                                            this.localAgreement=param;
                                    

                               }
                            

                        /**
                        * field for BankAccount
                        */

                        
                                    protected com.omgd.ec.ws.BankAccount localBankAccount ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBankAccountTracker = false ;

                           public boolean isBankAccountSpecified(){
                               return localBankAccountTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.BankAccount
                           */
                           public  com.omgd.ec.ws.BankAccount getBankAccount(){
                               return localBankAccount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BankAccount
                               */
                               public void setBankAccount(com.omgd.ec.ws.BankAccount param){
                            localBankAccountTracker = param != null;
                                   
                                            this.localBankAccount=param;
                                    

                               }
                            

                        /**
                        * field for Benef
                        * This was an Array!
                        */

                        
                                    protected com.omgd.ec.ws.Benef[] localBenef ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBenefTracker = false ;

                           public boolean isBenefSpecified(){
                               return localBenefTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.Benef[]
                           */
                           public  com.omgd.ec.ws.Benef[] getBenef(){
                               return localBenef;
                           }

                           
                        


                               
                              /**
                               * validate the array for Benef
                               */
                              protected void validateBenef(com.omgd.ec.ws.Benef[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Benef
                              */
                              public void setBenef(com.omgd.ec.ws.Benef[] param){
                              
                                   validateBenef(param);

                               localBenefTracker = true;
                                      
                                      this.localBenef=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.omgd.ec.ws.Benef
                             */
                             public void addBenef(com.omgd.ec.ws.Benef param){
                                   if (localBenef == null){
                                   localBenef = new com.omgd.ec.ws.Benef[]{};
                                   }

                            
                                 //update the setting tracker
                                localBenefTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localBenef);
                               list.add(param);
                               this.localBenef =
                             (com.omgd.ec.ws.Benef[])list.toArray(
                            new com.omgd.ec.ws.Benef[list.size()]);

                             }
                             

                        /**
                        * field for Header
                        */

                        
                                    protected com.omgd.ec.ws.TransRequHeader localHeader ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.TransRequHeader
                           */
                           public  com.omgd.ec.ws.TransRequHeader getHeader(){
                               return localHeader;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Header
                               */
                               public void setHeader(com.omgd.ec.ws.TransRequHeader param){
                            
                                            this.localHeader=param;
                                    

                               }
                            

                        /**
                        * field for Holder
                        */

                        
                                    protected com.omgd.ec.ws.Holder localHolder ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.Holder
                           */
                           public  com.omgd.ec.ws.Holder getHolder(){
                               return localHolder;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Holder
                               */
                               public void setHolder(com.omgd.ec.ws.Holder param){
                            
                                            this.localHolder=param;
                                    

                               }
                            

                        /**
                        * field for Insured
                        */

                        
                                    protected com.omgd.ec.ws.Insured localInsured ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInsuredTracker = false ;

                           public boolean isInsuredSpecified(){
                               return localInsuredTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.Insured
                           */
                           public  com.omgd.ec.ws.Insured getInsured(){
                               return localInsured;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Insured
                               */
                               public void setInsured(com.omgd.ec.ws.Insured param){
                            localInsuredTracker = param != null;
                                   
                                            this.localInsured=param;
                                    

                               }
                            

                        /**
                        * field for Product
                        */

                        
                                    protected com.omgd.ec.ws.Product localProduct ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.omgd.ec.ws.Product
                           */
                           public  com.omgd.ec.ws.Product getProduct(){
                               return localProduct;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Product
                               */
                               public void setProduct(com.omgd.ec.ws.Product param){
                            
                                            this.localProduct=param;
                                    

                               }
                            

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
               return factory.createOMElement(dataSource,parentQName);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://ws.ec.omgd.com/");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":appRequest",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "appRequest",
                           xmlWriter);
                   }

               
                   }
                if (localAdvisorTracker){
                                            if (localAdvisor==null){
                                                 throw new org.apache.axis2.databinding.ADBException("advisor cannot be null!!");
                                            }
                                           localAdvisor.serialize(new javax.xml.namespace.QName("","advisor"),
                                               xmlWriter);
                                        } if (localAgreementTracker){
                                            if (localAgreement==null){
                                                 throw new org.apache.axis2.databinding.ADBException("agreement cannot be null!!");
                                            }
                                           localAgreement.serialize(new javax.xml.namespace.QName("","agreement"),
                                               xmlWriter);
                                        } if (localBankAccountTracker){
                                            if (localBankAccount==null){
                                                 throw new org.apache.axis2.databinding.ADBException("bankAccount cannot be null!!");
                                            }
                                           localBankAccount.serialize(new javax.xml.namespace.QName("","bankAccount"),
                                               xmlWriter);
                                        } if (localBenefTracker){
                                       if (localBenef!=null){
                                            for (int i = 0;i < localBenef.length;i++){
                                                if (localBenef[i] != null){
                                                 localBenef[i].serialize(new javax.xml.namespace.QName("","benef"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "", "benef", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "", "benef", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 }
                                            if (localHeader==null){
                                                 throw new org.apache.axis2.databinding.ADBException("header cannot be null!!");
                                            }
                                           localHeader.serialize(new javax.xml.namespace.QName("","header"),
                                               xmlWriter);
                                        
                                            if (localHolder==null){
                                                 throw new org.apache.axis2.databinding.ADBException("holder cannot be null!!");
                                            }
                                           localHolder.serialize(new javax.xml.namespace.QName("","holder"),
                                               xmlWriter);
                                         if (localInsuredTracker){
                                            if (localInsured==null){
                                                 throw new org.apache.axis2.databinding.ADBException("insured cannot be null!!");
                                            }
                                           localInsured.serialize(new javax.xml.namespace.QName("","insured"),
                                               xmlWriter);
                                        }
                                            if (localProduct==null){
                                                 throw new org.apache.axis2.databinding.ADBException("product cannot be null!!");
                                            }
                                           localProduct.serialize(new javax.xml.namespace.QName("","product"),
                                               xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://ws.ec.omgd.com/")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localAdvisorTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "advisor"));
                            
                            
                                    if (localAdvisor==null){
                                         throw new org.apache.axis2.databinding.ADBException("advisor cannot be null!!");
                                    }
                                    elementList.add(localAdvisor);
                                } if (localAgreementTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "agreement"));
                            
                            
                                    if (localAgreement==null){
                                         throw new org.apache.axis2.databinding.ADBException("agreement cannot be null!!");
                                    }
                                    elementList.add(localAgreement);
                                } if (localBankAccountTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "bankAccount"));
                            
                            
                                    if (localBankAccount==null){
                                         throw new org.apache.axis2.databinding.ADBException("bankAccount cannot be null!!");
                                    }
                                    elementList.add(localBankAccount);
                                } if (localBenefTracker){
                             if (localBenef!=null) {
                                 for (int i = 0;i < localBenef.length;i++){

                                    if (localBenef[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("",
                                                                          "benef"));
                                         elementList.add(localBenef[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("",
                                                                          "benef"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("",
                                                                          "benef"));
                                        elementList.add(localBenef);
                                    
                             }

                        }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "header"));
                            
                            
                                    if (localHeader==null){
                                         throw new org.apache.axis2.databinding.ADBException("header cannot be null!!");
                                    }
                                    elementList.add(localHeader);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "holder"));
                            
                            
                                    if (localHolder==null){
                                         throw new org.apache.axis2.databinding.ADBException("holder cannot be null!!");
                                    }
                                    elementList.add(localHolder);
                                 if (localInsuredTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "insured"));
                            
                            
                                    if (localInsured==null){
                                         throw new org.apache.axis2.databinding.ADBException("insured cannot be null!!");
                                    }
                                    elementList.add(localInsured);
                                }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "product"));
                            
                            
                                    if (localProduct==null){
                                         throw new org.apache.axis2.databinding.ADBException("product cannot be null!!");
                                    }
                                    elementList.add(localProduct);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AppRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AppRequest object =
                new AppRequest();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"appRequest".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AppRequest)com.omgd.ec.ws.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list4 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","advisor").equals(reader.getName())){
                                
                                                object.setAdvisor(com.omgd.ec.ws.Advisor.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","agreement").equals(reader.getName())){
                                
                                                object.setAgreement(com.omgd.ec.ws.Agreement.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","bankAccount").equals(reader.getName())){
                                
                                                object.setBankAccount(com.omgd.ec.ws.BankAccount.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","benef").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list4.add(null);
                                                              reader.next();
                                                          } else {
                                                        list4.add(com.omgd.ec.ws.Benef.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone4 = false;
                                                        while(!loopDone4){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone4 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("","benef").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list4.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list4.add(com.omgd.ec.ws.Benef.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setBenef((com.omgd.ec.ws.Benef[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.omgd.ec.ws.Benef.class,
                                                                list4));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","header").equals(reader.getName())){
                                
                                                object.setHeader(com.omgd.ec.ws.TransRequHeader.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","holder").equals(reader.getName())){
                                
                                                object.setHolder(com.omgd.ec.ws.Holder.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","insured").equals(reader.getName())){
                                
                                                object.setInsured(com.omgd.ec.ws.Insured.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","product").equals(reader.getName())){
                                
                                                object.setProduct(com.omgd.ec.ws.Product.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    