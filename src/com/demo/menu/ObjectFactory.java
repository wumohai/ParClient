
package com.demo.menu;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo.menu package. 
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

    private final static QName _GetMenuResponse_QNAME = new QName("http://Menu.demo.com/", "GetMenuResponse");
    private final static QName _Analysis_QNAME = new QName("http://Menu.demo.com/", "Analysis");
    private final static QName _GetMenu_QNAME = new QName("http://Menu.demo.com/", "GetMenu");
    private final static QName _AnalysisResponse_QNAME = new QName("http://Menu.demo.com/", "AnalysisResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.menu
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMenuResponse }
     * 
     */
    public GetMenuResponse createGetMenuResponse() {
        return new GetMenuResponse();
    }

    /**
     * Create an instance of {@link GetMenu }
     * 
     */
    public GetMenu createGetMenu() {
        return new GetMenu();
    }

    /**
     * Create an instance of {@link Analysis }
     * 
     */
    public Analysis createAnalysis() {
        return new Analysis();
    }

    /**
     * Create an instance of {@link AnalysisResponse }
     * 
     */
    public AnalysisResponse createAnalysisResponse() {
        return new AnalysisResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Menu.demo.com/", name = "GetMenuResponse")
    public JAXBElement<GetMenuResponse> createGetMenuResponse(GetMenuResponse value) {
        return new JAXBElement<GetMenuResponse>(_GetMenuResponse_QNAME, GetMenuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Analysis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Menu.demo.com/", name = "Analysis")
    public JAXBElement<Analysis> createAnalysis(Analysis value) {
        return new JAXBElement<Analysis>(_Analysis_QNAME, Analysis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Menu.demo.com/", name = "GetMenu")
    public JAXBElement<GetMenu> createGetMenu(GetMenu value) {
        return new JAXBElement<GetMenu>(_GetMenu_QNAME, GetMenu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnalysisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Menu.demo.com/", name = "AnalysisResponse")
    public JAXBElement<AnalysisResponse> createAnalysisResponse(AnalysisResponse value) {
        return new JAXBElement<AnalysisResponse>(_AnalysisResponse_QNAME, AnalysisResponse.class, null, value);
    }

}
