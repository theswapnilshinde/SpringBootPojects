package com.ldap.application.repo;



import javax.management.RuntimeErrorException;
import javax.naming.directory.DirContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AuthenticatedLdapEntryContextMapper;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapEntryIdentification;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Repository;



@Repository
public interface Repo {

	public static final LdapTemplate ldapTemplate = new LdapTemplate();

	public default boolean auth(String uid,String password)
	{
		boolean flag =false;
		   try {

			 AuthenticatedLdapEntryContextMapper<DirContextOperations> mapper = authenticatedLdapEntryContextMapper();
			DirContextOperations doc= ldapTemplate.authenticate(LdapQueryBuilder.query().where("uid").is(uid),password,mapper);
			flag = ((doc!=null)  && (doc.getAttributes(uid).equals(uid)));
	  }
		catch (Exception e) {
			System.out.println("login Filed"+ e.getMessage());
		}
		return flag;

	}
	
	
	
	private AuthenticatedLdapEntryContextMapper<DirContextOperations> authenticatedLdapEntryContextMapper (){
		return (DirContext  ctx ,LdapEntryIdentification ldapEntryIdentification)-> {
	
        try
        {
		   return (DirContextOperations) ctx.lookup(ldapEntryIdentification.getRelativeName());
        }
        catch (Exception e) {
		              //      throw new RuntimeErrorException("Lookup Failed"+ ldapEntryIdentification.getRelativeName(),e);	
	    	}
	
      };
	
}}


