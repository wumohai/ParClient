package logininter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2015-01-19T14:48:27.126+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebService(targetNamespace = "http://LoginInter/", name = "LoginInterface")
@XmlSeeAlso({ObjectFactory.class})
public interface LoginInterface {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "Login", targetNamespace = "http://LoginInter/", className = "logininter.Login")
    @WebMethod(operationName = "Login")
    @ResponseWrapper(localName = "LoginResponse", targetNamespace = "http://LoginInter/", className = "logininter.LoginResponse")
    public boolean login(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );
}