import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.service.StatelessEJBRemote;


public class StatelessEJBClient {
	

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	/*public StatelessEJBClient() {
		super();
	}*/

	
	public static void main(String[] args) {
		try{
		Context ctx = StatelessEJBClient.getInitialContext();
		StatelessEJBRemote remote = (StatelessEJBRemote) ctx.lookup("StatelessEJB/remote");
		remote.getStatlessEJBMethod();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Context getInitialContext() throws NamingException, Exception{
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");

		return new InitialContext(props);
		
	}
}