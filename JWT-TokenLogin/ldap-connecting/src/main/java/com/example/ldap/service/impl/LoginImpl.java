

/*package com.example.ldap.service.impl;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.ldap.LdapConnection;
import com.example.ldap.User;
import com.example.ldap.service.Login;


@SpringBootApplication
public class LoginImpl implements Login {

	@Override
	public User loign(User user) {

		return null;
	}

	DirContext connetion;

	private LdapConnection ldapConnection; 

	//@Bean
	public LdapConnection ldapConnection()
	{
		return new LdapConnection();
	}

	//@Bean
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
	public User searchUsers(String uid) throws NamingException {

		String searchFilter = "(uid="+uid+")"; //  for one user
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

}*/
