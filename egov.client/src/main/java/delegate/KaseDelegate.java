package delegate;

import java.util.List;

import egov.entities.Company;
import egov.entities.Kase;
import locator.ServiceLocator;
import sessionbeans.ICaseManagementRemote;

public class KaseDelegate {
	public static ICaseManagementRemote remote;
	public static final String jndi="/egov.ejb/CaseManagement!sessionbeans.ICaseManagementRemote";
	public static ICaseManagementRemote getProxy(){
		return (ICaseManagementRemote) ServiceLocator.getInstance().getProxy(jndi);
		
	}
	
	public static boolean CreateCase(Kase c){
		return getProxy().addCase(c);
}
	public static boolean doDeleteCase(Kase c){
		return getProxy().remove(c);
		
	}
	public static boolean doUpdateCase(Kase c){
		return getProxy().update(c);
		
	}
	public static Kase doFindCaseById(int id){
		return getProxy().findCaseById(id);
		
	}

public static List<Kase> doFindAllCases(){
	return getProxy().findAll();
	
}
}
