package sample;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import sample.data.Message;
import sample.service.SOAPService;
import sample.service.SOAPServiceServiceLocator;

public class SOAPClient {
	
	public static void main(String args[]) throws ServiceException, RemoteException {
		SOAPService ss = new SOAPServiceServiceLocator().getSOAPService();
		
		System.out.println(ss.hello(new Message("Dude")).getMsg());
	}

}
