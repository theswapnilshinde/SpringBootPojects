package com.ldap.Ldaplogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldap.Ldaplogin.entity.Info;

@RestController
@RequestMapping(value = "/api")
public class Login {
	
	@Autowired
	public Info info;
	@PostMapping("/login")
	public Object login(@RequestBody Info info )
	{
		Info info2 = new Info();
		Info info3 = new Info();
		info2.getName();
		info2.getPassword();
		
		if(info.name == info2.getName() && info.password == info2.getPassword() )
		
		return info2;
		else
			info3.getResponce();
		return info3;
			
		
		
		
	}

}
