package loginimp;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import logininter.LoginInterface;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2015-01-19T14:48:27.185+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebServiceClient(name = "LoginImplement", 
                  wsdlLocation = "http://127.0.0.1:9001/LoginImp?wsdl",
                  targetNamespace = "http://LoginImp/") 
public class LoginImplement extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://LoginImp/", "LoginImplement");
    public final static QName LoginImplementPort = new QName("http://LoginImp/", "LoginImplementPort");
    static {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:9001/LoginImp?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(LoginImplement.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://127.0.0.1:9001/LoginImp?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public LoginImplement(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LoginImplement(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoginImplement() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public LoginImplement(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public LoginImplement(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public LoginImplement(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns LoginInterface
     */
    @WebEndpoint(name = "LoginImplementPort")
    public LoginInterface getLoginImplementPort() {
        return super.getPort(LoginImplementPort, LoginInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LoginInterface
     */
    @WebEndpoint(name = "LoginImplementPort")
    public LoginInterface getLoginImplementPort(WebServiceFeature... features) {
        return super.getPort(LoginImplementPort, LoginInterface.class, features);
    }

}
