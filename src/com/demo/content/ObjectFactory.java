
package com.demo.content;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo.content package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetContentResponse_QNAME = new QName("http://Content.demo.com/", "getContentResponse");
    private final static QName _GetContent_QNAME = new QName("http://Content.demo.com/", "getContent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.content
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetContentResponse }
     * 
     */
    public GetContentResponse createGetContentResponse() {
        return new GetContentResponse();
    }

    /**
     * Create an instance of {@link GetContent }
     * 
     */
    public GetContent createGetContent() {
        return new GetContent();
    }

    /**
     * Create an instance of {@link RetContentBean }
     * 
     */
    public RetContentBean createRetContentBean() {
        return new RetContentBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Content.demo.com/", name = "getContentResponse")
    public JAXBElement<GetContentResponse> createGetContentResponse(GetContentResponse value) {
        return new JAXBElement<GetContentResponse>(_GetContentResponse_QNAME, GetContentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Content.demo.com/", name = "getContent")
    public JAXBElement<GetContent> createGetContent(GetContent value) {
        return new JAXBElement<GetContent>(_GetContent_QNAME, GetContent.class, null, value);
    }

}
