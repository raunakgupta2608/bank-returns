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
			compositekey.setBeneficiaryaccno(  beneficiarydetails.getBeneficiaryaccno()   );
			compositekey.setUserid(  userid  );
			beneficiarydetails.setCompositekey(compositekey);
			
			
			ret = beneficiaryDao.saveBeneficiaryDetails( beneficiarydetails, compositekey, userid );
			return ret;
		}
	
}
