package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.dao.LoginDao;

@Service
public class LoginService
{
		@Autowired
		private LoginDao loginDao;
		
		String ret="";
		
		public String loginDetailsEnteredByUser(int userid,String password)
		{
			System.out.println("Inside Service Controller.........");
			ret=loginDao.loginDetailsEnteredByUser(userid, password);
			return ret;
		}

}
