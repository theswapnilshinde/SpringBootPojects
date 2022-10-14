package com.ldap.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@EnableLdapRepositories
public class Config {
	
	@Bean
	public LdapContextSource ldapContextSource() {
		
		LdapContextSource lcs= new LdapContextSource();
		//lcs.setUrl("ldap://localhost:10389");
		//  ldap://localhost:10380/ou=users,ou=system
		
		lcs.setUrl("ldap://localhost:10389");
		lcs.setBase("dc=example,dc=com");
		
		//ou=users,ou=system
		//lcs.setBase("dc=swapnil,dc=com");
		
		return lcs;
		
	}
	
	@Bean
	public LdapTemplate ldapTemplate() {
			
		return new LdapTemplate(ldapContextSource());
		
	}
	
	@Bean
	public RepoAdditional repoAdditional(){
			
		return new RepoImpl();
		
	}
	
	

}
