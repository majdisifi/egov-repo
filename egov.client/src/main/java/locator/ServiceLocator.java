package locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.constraints.Null;

public class ServiceLocator {
	private Map<String, Object> cacheProxy;
	private Context context;
	private static ServiceLocator serviceLocator;
	
	public ServiceLocator() {
		try {
			context = new InitialContext();
			cacheProxy = new HashMap<String, Object>();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Map<String, Object> getCacheProxy() {
		return cacheProxy;
	}

	public void setCacheProxy(Map<String, Object> cacheProxy) {
		this.cacheProxy = cacheProxy;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public static ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public static void setServiceLocator(ServiceLocator serviceLocator) {
		ServiceLocator.serviceLocator = serviceLocator;
	}
	
	public static ServiceLocator getInstance(){ // permet de retourner une seule instance de servicelocator
		
		if (serviceLocator==null) // instance unique
			serviceLocator=new ServiceLocator();
		return serviceLocator;
			
	}
	public Object getProxy(String jndi){ // kan l'objet 3anna mennou fel cache s
		
		Object proxy=null;
		proxy=cacheProxy.get(jndi);
		if (proxy==null)
		{
			try {
				proxy=context.lookup(jndi);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cacheProxy.put(jndi, proxy);
		}
		return proxy;
		
		
		
			
	}

}





