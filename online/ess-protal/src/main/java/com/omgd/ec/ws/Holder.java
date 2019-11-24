
/**
 * Holder.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:23:23 CEST)
 */

            
                package com.omgd.ec.ws;
            

            /**
            *  Holder bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Holder
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = holder
                Namespace URI = http://ws.ec.omgd.com/
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Addr
                        */

                        
                                    protected java.lang.String localAddr ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAddrTracker = false ;

                           public boolean isAddrSpecified(){
                               return localAddrTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAddr(){
                               return localAddr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Addr
                               */
                               public void setAddr(java.lang.String param){
                            localAddrTracker = param != null;
                                   
                                            this.localAddr=param;
                                    

                               }
                            

                        /**
                        * field for AnnualSalary
                        */

                        
                                    protected double localAnnualSalary ;
                                

                           /**
                           * Auto generated getter method
                           * @return double
                           */
                           public  double getAnnualSalary(){
                               return localAnnualSalary;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AnnualSalary
                               */
                               public void setAnnualSalary(double param){
                            
                                            this.localAnnualSalary=param;
                                    

                               }
                            

                        /**
                        * field for Birthday
                        */

                        
                                    protected java.util.Calendar localBirthday ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getBirthday(){
                               return localBirthday;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Birthday
                               */
                               public void setBirthday(java.util.Calendar param){
                            
                                            this.localBirthday=param;
                                    

                               }
                            

                        /**
                        * field for Email
                        */

                        
                                    protected java.lang.String localEmail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmailTracker = false ;

                           public boolean isEmailSpecified(){
                               return localEmailTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEmail(){
                               return localEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Email
                               */
                               public void setEmail(java.lang.String param){
                            localEmailTracker = param != null;
                                   
                                            this.localEmail=param;
                                    

                               }
                            

                        /**
                        * field for Gender
                        */

                        
                                    protected java.lang.String localGender ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGender(){
                               return localGender;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Gender
                               */
                               public void setGender(java.lang.String param){
                            
                                            this.localGender=param;
                                    

                               }
                            

                        /**
                        * field for IdExpiryDate
                        */

                        
                                    protected java.util.Calendar localIdExpiryDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdExpiryDateTracker = false ;

                           public boolean isIdExpiryDateSpecified(){
                               return localIdExpiryDateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getIdExpiryDate(){
                               return localIdExpiryDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdExpiryDate
                               */
                               public void setIdExpiryDate(java.util.Calendar param){
                            localIdExpiryDateTracker = param != null;
                                   
                                            this.localIdExpiryDate=param;
                                    

                               }
                            

                        /**
                        * field for IdNo
                        */

                        
                                    protected java.lang.String localIdNo ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIdNo(){
                               return localIdNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdNo
                               */
                               public void setIdNo(java.lang.String param){
                            
                                            this.localIdNo=param;
                                    

                               }
                            

                        /**
                        * field for IdType
                        */

                        
                                    protected java.lang.String localIdType ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIdType(){
                               return localIdType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdType
                               */
                               public void setIdType(java.lang.String param){
                            
                                            this.localIdType=param;
                                    

                               }
                            

                        /**
                        * field for Married
                        */

                        
                                    protected java.lang.String localMarried ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMarriedTracker = false ;

                           public boolean isMarriedSpecified(){
                               return localMarriedTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMarried(){
                               return localMarried;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Married
                               */
                               public void setMarried(java.lang.String param){
                            localMarriedTracker = param != null;
                                   
                                            this.localMarried=param;
                                    

                               }
                            

                        /**
                        * field for Mobile
                        */

                        
                                    protected java.lang.String localMobile ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMobile(){
                               return localMobile;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mobile
                               */
                               public void setMobile(java.lang.String param){
                            
                                            this.localMobile=param;
                                    

                               }
                            

                        /**
                        * field for Name
                        */

                        
                                    protected java.lang.String localName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(java.lang.String param){
                            
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for OccupationCode
                        */

                        
                                    protected java.lang.String localOccupationCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOccupationCodeTracker = false ;

                           public boolean isOccupationCodeSpecified(){
                               return localOccupationCodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOccupationCode(){
                               return localOccupationCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OccupationCode
                               */
                               public void setOccupationCode(java.lang.String param){
                            localOccupationCodeTracker = param != null;
                                   
                                            this.localOccupationCode=param;
                                    

                               }
                            

                        /**
                        * field for Province
                        */

                        
                                    protected java.lang.String localProvince ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getProvince(){
                               return localProvince;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Province
                               */
                               public void setProvince(java.lang.String param){
                            
                                            this.localProvince=param;
                                    

                               }
                            

                        /**
                        * field for RelationWithInsured
                        */

                        
                                    protected java.lang.String localRelationWithInsured ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRelationWithInsured(){
                               return localRelationWithInsured;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RelationWithInsured
                               */
                               public void setRelationWithInsured(java.lang.String param){
                            
                                            this.localRelationWithInsured=param;
                                    

                               }
                            

                        /**
                        * field for TelArea
                        */

                        
                                    protected java.lang.String localTelArea ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTelAreaTracker = false ;

                           public boolean isTelAreaSpecified(){
                               return localTelAreaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTelArea(){
                               return localTelArea;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TelArea
                               */
                               public void setTelArea(java.lang.String param){
                            localTelAreaTracker = param != null;
                                   
                                            this.localTelArea=param;
                                    

                               }
                            

                        /**
                        * field for TelExt
                        */

                        
                                    protected java.lang.String localTelExt ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTelExtTracker = false ;

                           public boolean isTelExtSpecified(){
                               return localTelExtTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTelExt(){
                               return localTelExt;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TelExt
                               */
                               public void setTelExt(java.lang.String param){
                            localTelExtTracker = param != null;
                                   
                                            this.localTelExt=param;
                                    

                               }
                            

                        /**
                        * field for TelNo
                        */

                        
                                    protected java.lang.String localTelNo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTelNoTracker = false ;

                           public boolean isTelNoSpecified(){
                               return localTelNoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTelNo(){
                               return localTelNo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TelNo
                               */
                               public void setTelNo(java.lang.String param){
                            localTelNoTracker = param != null;
                                   
                                            this.localTelNo=param;
                                    

                               }
                            

                        /**
                        * field for WorkType
                        */

                        
                                    protected java.lang.String localWorkType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWorkTypeTracker = false ;

                           public boolean isWorkTypeSpecified(){
                               return localWorkTypeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getWorkType(){
                               return localWorkType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WorkType
                               */
                               public void setWorkType(java.lang.String param){
                            localWorkTypeTracker = param != null;
                                   
                                            this.localWorkType=param;
                                    

                               }
                            

                        /**
                        * field for Zipcode
                        */

                        
                                    protected java.lang.String localZipcode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localZipcodeTracker = false ;

                           public boolean isZipcodeSpecified(){
                               return localZipcodeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getZipcode(){
                               return localZipcode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Zipcode
                               */
                               public void setZipcode(java.lang.String param){
                            localZipcodeTracker = param != null;
                                   
                                            this.localZipcode=param;
                                    

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
                           namespacePrefix+":holder",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "holder",
                           xmlWriter);
                   }

               
                   }
                if (localAddrTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "addr", xmlWriter);
                             

                                          if (localAddr==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("addr cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAddr);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "";
                                    writeStartElement(null, namespace, "annualSalary", xmlWriter);
                             
                                               if (java.lang.Double.isNaN(localAnnualSalary)) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("annualSalary cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAnnualSalary));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    writeStartElement(null, namespace, "birthday", xmlWriter);
                             

                                          if (localBirthday==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("birthday cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBirthday));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localEmailTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "email", xmlWriter);
                             

                                          if (localEmail==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEmail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "";
                                    writeStartElement(null, namespace, "gender", xmlWriter);
                             

                                          if (localGender==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("gender cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGender);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localIdExpiryDateTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "idExpiryDate", xmlWriter);
                             

                                          if (localIdExpiryDate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("idExpiryDate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdExpiryDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "";
                                    writeStartElement(null, namespace, "idNo", xmlWriter);
                             

                                          if (localIdNo==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("idNo cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIdNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    writeStartElement(null, namespace, "idType", xmlWriter);
                             

                                          if (localIdType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("idType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIdType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMarriedTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "married", xmlWriter);
                             

                                          if (localMarried==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("married cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMarried);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "";
                                    writeStartElement(null, namespace, "mobile", xmlWriter);
                             

                                          if (localMobile==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("mobile cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMobile);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    writeStartElement(null, namespace, "name", xmlWriter);
                             

                                          if (localName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localOccupationCodeTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "occupationCode", xmlWriter);
                             

                                          if (localOccupationCode==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("occupationCode cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOccupationCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "";
                                    writeStartElement(null, namespace, "province", xmlWriter);
                             

                                          if (localProvince==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("province cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProvince);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    writeStartElement(null, namespace, "relationWithInsured", xmlWriter);
                             

                                          if (localRelationWithInsured==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("relationWithInsured cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRelationWithInsured);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localTelAreaTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "telArea", xmlWriter);
                             

                                          if (localTelArea==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("telArea cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTelArea);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTelExtTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "telExt", xmlWriter);
                             

                                          if (localTelExt==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("telExt cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTelExt);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTelNoTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "telNo", xmlWriter);
                             

                                          if (localTelNo==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("telNo cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTelNo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWorkTypeTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "workType", xmlWriter);
                             

                                          if (localWorkType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("workType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localWorkType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localZipcodeTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "zipcode", xmlWriter);
                             

                                          if (localZipcode==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("zipcode cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localZipcode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
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

                 if (localAddrTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "addr"));
                                 
                                        if (localAddr != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddr));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("addr cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "annualSalary"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAnnualSalary));
                            
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "birthday"));
                                 
                                        if (localBirthday != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBirthday));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("birthday cannot be null!!");
                                        }
                                     if (localEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "email"));
                                 
                                        if (localEmail != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("email cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "gender"));
                                 
                                        if (localGender != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGender));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("gender cannot be null!!");
                                        }
                                     if (localIdExpiryDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "idExpiryDate"));
                                 
                                        if (localIdExpiryDate != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdExpiryDate));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("idExpiryDate cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "idNo"));
                                 
                                        if (localIdNo != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdNo));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("idNo cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "idType"));
                                 
                                        if (localIdType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("idType cannot be null!!");
                                        }
                                     if (localMarriedTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "married"));
                                 
                                        if (localMarried != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMarried));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("married cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "mobile"));
                                 
                                        if (localMobile != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMobile));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("mobile cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "name"));
                                 
                                        if (localName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
                                        }
                                     if (localOccupationCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "occupationCode"));
                                 
                                        if (localOccupationCode != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOccupationCode));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("occupationCode cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "province"));
                                 
                                        if (localProvince != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProvince));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("province cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "relationWithInsured"));
                                 
                                        if (localRelationWithInsured != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRelationWithInsured));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("relationWithInsured cannot be null!!");
                                        }
                                     if (localTelAreaTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "telArea"));
                                 
                                        if (localTelArea != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTelArea));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("telArea cannot be null!!");
                                        }
                                    } if (localTelExtTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "telExt"));
                                 
                                        if (localTelExt != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTelExt));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("telExt cannot be null!!");
                                        }
                                    } if (localTelNoTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "telNo"));
                                 
                                        if (localTelNo != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTelNo));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("telNo cannot be null!!");
                                        }
                                    } if (localWorkTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "workType"));
                                 
                                        if (localWorkType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWorkType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("workType cannot be null!!");
                                        }
                                    } if (localZipcodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "zipcode"));
                                 
                                        if (localZipcode != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localZipcode));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("zipcode cannot be null!!");
                                        }
                                    }

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
        public static Holder parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Holder object =
                new Holder();

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
                    
                            if (!"holder".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Holder)com.omgd.ec.ws.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","addr").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAddr(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","annualSalary").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAnnualSalary(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDouble(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","birthday").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBirthday(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","email").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEmail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","gender").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGender(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","idExpiryDate").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdExpiryDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","idNo").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","idType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIdType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","married").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMarried(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","mobile").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMobile(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","name").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","occupationCode").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOccupationCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","province").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProvince(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","relationWithInsured").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRelationWithInsured(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","telArea").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTelArea(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","telExt").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTelExt(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","telNo").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTelNo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","workType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWorkType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","zipcode").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setZipcode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
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
           
    