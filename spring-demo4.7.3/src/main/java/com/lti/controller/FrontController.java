package com.lti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.entity.Admin;
import com.lti.entity.BeneficiaryDetails;
import com.lti.entity.CompositeKey;
import com.lti.entity.Customer;
import com.lti.entity.Otp;
import com.lti.entity.Registerib;
import com.lti.entity.Transaction;

@Controller
public class FrontController
{
	int globaluserid;
	@Autowired
	private CustomerContoller customerContoller;
	
	@RequestMapping(path="/opensavingaccount.lti")
	//public String register(HttpServletRequest request){
	//public String register(@RequestParam("name") String name , @RequestParam("email") String email){
	public String openSavingAccount(Customer customer, Admin admin) 
	{
		customerContoller.openSavingAccount(customer,admin);
		return "confirmation.jsp";
	}

	@Autowired 
	private RegisterController registerController;
	
	String ret ="";
	@RequestMapping(path="/setpassword.lti", method=RequestMethod.POST)
	public String fetchAccountNumberFromRegisterIBPage(@RequestParam("accno") int accno )
	{
		System.out.println("entering front controller fetchAccountNumberFromRegisterIBPage");
		
		ret = registerController.fetchAccountNumberFromRegisterIBPage(accno);
		
		System.out.println("leaving front controller fetchAccountNumberFromRegisterIBPage");
		return ret;
	}

	 
	@RequestMapping(path="/enterotp.lti", method=RequestMethod.POST)
	public String fetchPasswordFromSetPasswordPage(Registerib secondreqobj, @RequestParam("loginpass") String loginpass , @RequestParam("transpass") String transpass )
	{
		System.out.println("entering front controller fetchPasswordFromSetPasswordPage");
		
		registerController.fetchPasswordFromSetPasswordPage(secondreqobj, loginpass, transpass);
		
		System.out.println("leaving front controller fetchPasswordFromSetPasswordPage");
		return "enterotp.jsp";
	}
	
	@RequestMapping(path="/userlogin.lti", method=RequestMethod.POST)
	public String otpEnteredByUser( Registerib thirdreqobj, Otp otpobj, @RequestParam("otp") int otp )
	{
		System.out.println("entering front controller otpEnteredByUser");
		
		ret = registerController.otpEnteredByUser( thirdreqobj, otpobj, otp );
		
		System.out.println("leaving front controller otpEnteredByUser");
		return ret;
	}
	
	
	@Autowired
	private LoginController loginController;
	
	@RequestMapping(path="/dashboard.lti",method=RequestMethod.POST)
	public String loginDetailsEnteredByUser(@RequestParam("userid")int  userid,@RequestParam("password")String password, HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		session.setAttribute("userid", userid);
		globaluserid= userid;
		System.out.println("entering front controller fetch");
		
		ret = loginController.loginDetailsEnteredByUser(userid,password);
		
		System.out.println("leaving front controller fetch");
		return ret;
	}
	
	@Autowired
	private BeneficiaryController beneficiaryController;
	
	
	@RequestMapping(path="/dashboardafterpayee.lti", method=RequestMethod.POST)
	public String saveBeneficiaryDetails( BeneficiaryDetails beneficiarydetails, @RequestParam("beneficiaryaccno")int  baccno, Model model, CompositeKey compositekey )
	{
		int beneficiaryaccno = baccno;
		int userid = globaluserid;
		
		System.out.println("entering front controller saveBeneficiaryDetails");
		
		ret = beneficiaryController.saveBeneficiaryDetails( beneficiarydetails, compositekey, userid,  beneficiaryaccno );
		
		if(ret.equals("dashboard.jsp"))
		{
			return ret;
		}
		else 
		{
			model.addAttribute( "msg" , "Invalid beneficiary account number" );
			return ret;
		}
	}	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private TransactionContoller transactionController;
	
	@RequestMapping(path="/imps.lti", method=RequestMethod.GET)
	public String dropDownForBeneficiary( Model model )
	{
		int userid = globaluserid;
		//System.out.println( "userid in front controller is :"+userid);
		transactionController.dropDownForBeneficiary( userid );
		//System.out.println("leaving front contoller");
		model.addAttribute("listofbeneficiary", transactionController.dropDownForBeneficiary( userid )); 
		return "imps.jsp";
	}
	
	@RequestMapping(path="/transactionresult.lti", method=RequestMethod.POST)
	public String initiateImps( Transaction transaction, Model model  )
	{
		//System.out.println("inside front controller  initiateImps ");
		int userid = globaluserid;
		ret = transactionController.initiateImps( transaction, userid );
		if(ret.equals("dashboard.jsp"))
		{
			return ret;
		}
		else 
		{
			model.addAttribute( "msg" , "Insufficient Balance" );
			return ret;
		}
	}
	
	
	
	@Autowired
	private AdminContoller adminController;
	
	@RequestMapping(path="/adminview.lti", method=RequestMethod.POST)
	public String fetchDataForAdmin( Model model )
	{
		model.addAttribute("alladmindata", adminController.fetchDataForAdmin()); 
		return "adminview.jsp";
	}
	
	@RequestMapping(path="/adminapprovednowsendmail.lti", method=RequestMethod.POST)
	public String adminApprovedNowSendMail( )
	{
		System.out.println("entering front controller adminApprovedNowSendMail");
		adminController.adminApprovedNowSendMail();
		return "adminview.jsp";
	}
	

		

	
	
}
