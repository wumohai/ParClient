
package com.demo.analysis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo.analysis package. 
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

    private final static QName _GetFileTypeResponse_QNAME = new QName("http://Analysis.demo.com/", "getFileTypeResponse");
    private final static QName _GetFileType_QNAME = new QName("http://Analysis.demo.com/", "getFileType");
    private final static QName _FixCommandResponse_QNAME = new QName("http://Analysis.demo.com/", "fixCommandResponse");
    private final static QName _FixCommand_QNAME = new QName("http://Analysis.demo.com/", "fixCommand");
    private final static QName _GetFilePath_QNAME = new QName("http://Analysis.demo.com/", "getFilePath");
    private final static QName _GetFilePathResponse_QNAME = new QName("http://Analysis.demo.com/", "getFilePathResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.analysis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFileType }
     * 
     */
    public GetFileType createGetFileType() {
        return new GetFileType();
    }

    /**
     * Create an instance of {@link GetFileTypeResponse }
     * 
     */
    public GetFileTypeResponse createGetFileTypeResponse() {
        return new GetFileTypeResponse();
    }

    /**
     * Create an instance of {@link FixCommandResponse }
     * 
     */
    public FixCommandResponse createFixCommandResponse() {
        return new FixCommandResponse();
    }

    /**
     * Create an instance of {@link GetFilePath }
     * 
     */
    public GetFilePath createGetFilePath() {
        return new GetFilePath();
    }

    /**
     * Create an instance of {@link FixCommand }
     * 
     */
    public FixCommand createFixCommand() {
        return new FixCommand();
    }

    /**
     * Create an instance of {@link GetFilePathResponse }
     * 
     */
    public GetFilePathResponse createGetFilePathResponse() {
        return new GetFilePathResponse();
    }

    /**
     * Create an instance of {@link FileType }
     * 
     */
    public FileType createFileType() {
        return new FileType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Analysis.demo.com/", name = "getFileTypeResponse")
    public JAXBElement<GetFileTypeResponse> createGetFileTypeResponse(GetFileTypeResponse value) {
        return new JAXBElement<GetFileTypeResponse>(_GetFileTypeResponse_QNAME, GetFileTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Analysis.demo.com/", name = "getFileType")
    public JAXBElement<GetFileType> createGetFileType(GetFileType value) {
        return new JAXBElement<GetFileType>(_GetFileType_QNAME, GetFileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FixCommandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Analysis.demo.com/", name = "fixCommandResponse")
    public JAXBElement<FixCommandResponse> createFixCommandResponse(FixCommandResponse value) {
        return new JAXBElement<FixCommandResponse>(_FixCommandResponse_QNAME, FixCommandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FixCommand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Analysis.demo.com/", name = "fixCommand")
    public JAXBElement<FixCommand> createFixCommand(FixCommand value) {
        return new JAXBElement<FixCommand>(_FixCommand_QNAME, FixCommand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilePath }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Analysis.demo.com/", name = "getFilePath")
    public JAXBElement<GetFilePath> createGetFilePath(GetFilePath value) {
        return new JAXBElement<GetFilePath>(_GetFilePath_QNAME, GetFilePath.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilePathResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Analysis.demo.com/", name = "getFilePathResponse")
    public JAXBElement<GetFilePathResponse> createGetFilePathResponse(GetFilePathResponse value) {
        return new JAXBElement<GetFilePathResponse>(_GetFilePathResponse_QNAME, GetFilePathResponse.class, null, value);
    }

}
