package com.example.ldap;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapConnection {

	DirContext connetion;
	
	public DirContext getLdapConnection()
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
	
}
