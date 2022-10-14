package com.example.ldap;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.LdapTemplate;




@SpringBootApplication
public class LdapConnectingApplication {
	DirContext connetion;
	
	private LdapConnection ldapConnection; 
	
	@Bean
	public LdapConnection ldapConnection()
	{
		return new LdapConnection();
	}
	
	@Bean
	public DirContext LdapConnection()
	{
		System.out.println("hello world");
		Properties env= new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,"ldap://localhost:10380");
		env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
		env.put(Context.SECURITY_CREDENTIALS,"secret");
		
		try {
			//DirContext connetion = new InitialDirContext(env);
			 connetion = new InitialDirContext(env);
			System.out.println("Connetd to server   "+connetion);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("Not  **** Connetd to server");
			e.printStackTrace();
		}
		return connetion;
	}

	
	/*
	public void getAllUsers() throws NamingException {
		//System.out.println("enterd");
		String  serchFilter = "(objectClass=intOrgPerson)";
		String [] req = {"cn"};
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(req);
		System.out.println("enterd");
		NamingEnumeration user = connetion.search("ou=users,ou=system",serchFilter,controls);
		
		SearchResult result= null;
		while(user.hasMore())
		{
			result = (SearchResult) user.next();
			Attributes att = result.getAttributes();
			System.out.println(att.get("cn"));
			System.out.println("enterd");
			
	
			
			
		}
	}
	
	*/
	public List getAllUserss() throws NamingException {
		String searchFilter = "(objectClass=inetOrgPerson)";
		String[] reqAtt = { "cn", "sn" };
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);

		NamingEnumeration users = connetion.search("ou=users,ou=system", searchFilter, controls);

		List list = new ArrayList<>();
		SearchResult result = null;
		while (users.hasMore()) {
			result = (SearchResult) users.next();
			Attributes attr = result.getAttributes();
			String name = attr.get("cn").get(0).toString();
			list.add(users);
			//deleteUserFromGroup(name,"Administrators");
			System.out.println(attr.get("cn"));
			System.out.println(attr.get("sn"));
		}
		
		return list;

	}
	public void newConnection() {
		
		System.out.println("hello world");
		Properties env= new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,"ldap://localhost:10380");
		env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
		env.put(Context.SECURITY_CREDENTIALS,"secret");
		
		try {
			//DirContext connetion = new InitialDirContext(env);
			 connetion = new InitialDirContext(env);
			System.out.println("Connetd to server   "+connetion);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("Not  **** Connetd to server");
			e.printStackTrace();
		}
	}
	
	public void searchUsers() throws NamingException {
		String searchFilter = "(uid=2)"; //  for one user
		//String searchFilterr = "(uid="+uid+")"; //  for one user
		//String searchFilter = "(&(uid=1)(cn=Smith))"; // and condition 
		//String searchFilter = "(|(uid=1)(uid=2)(cn=swapnil))"; // or condition
		String[] reqAtt = { "cn", "sn","uid" };
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);

		NamingEnumeration users = connetion.search("ou=users,ou=system", searchFilter,controls);
        System.out.println("****************");
		SearchResult result = null;
		
		while (users.hasMore()) {
			result = (SearchResult) users.next();
			Attributes attr = result.getAttributes();
			String name = attr.get("cn").get(0).toString();
			//deleteUserFromGroup(name,"Administrators");
			System.out.println(attr.get("cn"));
			System.out.println(attr.get("sn"));
			System.out.println(attr.get("uid"));
		}

	}
	public static boolean authUser(String cn, String password)
	{
		System.out.println("success");
		try {
			Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
			System.out.println("success2");
			env.put(Context.SECURITY_PRINCIPAL,"cn="+cn+",ou=users,ou=system");  //check the DN correctly
			env.put(Context.SECURITY_CREDENTIALS, 1);
			System.out.println("success3");
//			DirContext con= new InitialDirContext(env);
			DirContext con   = new InitialDirContext(env);
			System.out.println("success4");
			con.close();
			System.out.println("success");
			return true;
			
		}catch (Exception e) {
			System.out.println("failed: "+e.getMessage());
			return false;
		}
	}

	public User searchUsers(String uid) throws NamingException {
		
		String searchFilter = "(uid="+uid+")"; //  for one user
	//	String searchFilter1 = "(userPassword="+userPassword+")";
		
		//String searchFilterr = "(uid="+uid+")"; //  for one user
		//String searchFilter = "(&(uid=1)(cn=Smith))"; // and condition 
		//String searchFilter = "(|(uid=1)(uid=2)(cn=swapnil))"; // or condition
		String[] reqAtt = { "cn", "sn","uid" };
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);

		NamingEnumeration users = connetion.search("ou=users,ou=system", searchFilter,controls);
        System.out.println("****************");
		SearchResult result = null;
	User user = new User();
	//user=uid;
		while (users.hasMore()) {
			result = (SearchResult) users.next();
			Attributes attr = result.getAttributes();
			String name = attr.get("cn").get(0).toString();
			String password = attr.get("uid").get(0).toString();
			String sname = attr.get("sn").get(0).toString();
			//deleteUserFromGroup(name,"Administrators");
			System.out.println(attr.get("cn"));
			System.out.println(attr.get("sn"));
			System.out.println(attr.get("uid"));
			
			
//			user= (User) attr.get("cn");
//		    user= (User) attr.get("sn");
			
			//Attribute username=attr.get("uid");
			//Attribute password= attr.get("cn");
			 user = new User(name, sname,password);
		}
		return user ;

		
	}
	
public User searchUsers(String cn,String userPassword) throws NamingException {
		
	//uid="3";
//	userPassword="1";
		String searchFilter = "(cn="+cn+")"; //  for one user
		String searchFilter1 = "(userPassword="+userPassword+")";
		System.out.println(searchFilter);
		System.out.println(searchFilter1);
		
		//String searchFilterr = "(uid="+uid+")"; //  for one user
		//String searchFilter = "(&(uid=1)(cn=Smith))"; // and condition 
		//String searchFilter = "(|(uid=1)(uid=2)(cn=swapnil))"; // or condition
		//String[] reqAtt = { "cn", "sn","uid","userPassword"};
		String[] reqAtt = { "cn", "sn","uid"};
		SearchControls controls = new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		controls.setReturningAttributes(reqAtt);

		NamingEnumeration users = connetion.search("ou=users,ou=system", searchFilter,controls);
        System.out.println("****************");
		SearchResult result = null;
	User user = new User();
	//user=uid;
		while (users.hasMore()) {
			result = (SearchResult) users.next();
			Attributes attr = result.getAttributes();
			String name = attr.get("cn").get(0).toString();
			String uid = attr.get("uid").get(0).toString();
			String sname = attr.get("sn").get(0).toString();
			//deleteUserFromGroup(name,"Administrators");
			System.out.println(attr.get("cn"));
			System.out.println(attr.get("sn"));
			System.out.println(attr.get("uid"));
			System.out.println(attr.get("userPassword"));
			
//			user= (User) attr.get("cn");
//		    user= (User) attr.get("sn");
			
			//Attribute username=attr.get("uid");
			//Attribute password= attr.get("cn");
			 user = new User(uid, name,sname);
		}
		return user ;

		
	}

public boolean userVerify(String cn, String passwd) throws Exception {
    /*
     * System.out.println(uname); System.out.println(passwd);
     */
    boolean userVerify = true;
    Hashtable<String, String> env = new Hashtable<>();
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, "ldap://localhost:2389/dc=springframework,dc=org");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, "uid=bob,ou=people,dc=springframework,dc=org");
    env.put(Context.SECURITY_CREDENTIALS, "bobspassword");

    try {
        DirContext ctx = new InitialDirContext(env);
     // System.out.println("connected");
        System.out.println(ctx.getEnvironment());
        userVerify = false;
        ctx.close();

    } catch (AuthenticationNotSupportedException ex) {
        System.out.println("The authentication is not supported by the server");
    } catch (AuthenticationException ex) {
        System.out.println("incorrect password or username");
        System.out.println(ex.getLocalizedMessage());
        throw new AuthenticationException();
    } catch (NamingException ex) {
        System.out.println("error when trying to create the context");
    }
    return userVerify;
}


}
