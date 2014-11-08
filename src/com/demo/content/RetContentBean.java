
package com.demo.content;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>retContentBean complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="retContentBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retbyte" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retContentBean", propOrder = {
    "fileName",
    "retString",
    "retbyte"
})
public class RetContentBean {

    protected String fileName;
    protected String retString;
    protected byte[] retbyte;

    /**
     * 获取fileName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置fileName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * 获取retString属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetString() {
        return retString;
    }

    /**
     * 设置retString属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetString(String value) {
        this.retString = value;
    }

    /**
     * 获取retbyte属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getRetbyte() {
        return retbyte;
    }

    /**
     * 设置retbyte属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setRetbyte(byte[] value) {
        this.retbyte = value;
    }

}
