package sample.service;

public class SOAPServiceProxy implements sample.service.SOAPService {
  private String _endpoint = null;
  private sample.service.SOAPService sOAPService = null;
  
  public SOAPServiceProxy() {
    _initSOAPServiceProxy();
  }
  
  public SOAPServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAPServiceProxy();
  }
  
  private void _initSOAPServiceProxy() {
    try {
      sOAPService = (new sample.service.SOAPServiceServiceLocator()).getSOAPService();
      if (sOAPService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAPService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAPService != null)
      ((javax.xml.rpc.Stub)sOAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sample.service.SOAPService getSOAPService() {
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService;
  }
  
  public java.lang.String hello(java.lang.String input) throws java.rmi.RemoteException{
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService.hello(input);
  }
  
  
}