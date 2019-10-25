package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.BeneficiaryDao;
import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.CompositeKey;

@Service
public class BeneficiaryService 
{
	@Autowired
	private BeneficiaryDao beneficiaryDao;
	String ret="";

		public String saveBeneficiaryDetails( BeneficiaryDetails beneficiarydetails, CompositeKey compositekey, int userid  )
		{
			/*compositekey(compositekey.getBeneficiaryaccno(), userid );*/
			System.out.println("Inside beneficiary");
			System.out.println("baccno is "+compositekey.getBeneficiaryaccno());
			System.out.println("userid is compositekey.getUserid() "+compositekey.getUserid());
			System.out.println("userid is "+userid);
			System.out.println("beneficiaryname is "+beneficiarydetails.getBeneficiaryname());
			System.out.println("beneficiarynickname is "+beneficiarydetails.getNickname());
			
			
			/*compositekey.setBeneficiaryaccno(beneficiaryaccno);*/
			compositekey.setUserid(  userid  );
			beneficiarydetails.setCompositekey(compositekey);
			
			ret = beneficiaryDao.saveBeneficiaryDetails( beneficiarydetails, compositekey, userid );
			return ret;
		}
	
}
