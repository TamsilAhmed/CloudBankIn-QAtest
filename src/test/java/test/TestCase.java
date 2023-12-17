package test;


import page.CreateLoan;
import page.CreatePerson;

public class TestCase extends CreateLoan{
	@org.testng.annotations.Test(priority=0)
	public void Test1() {
		
		CreatePerson cf = new CreatePerson();
		
		cf.Login("qatest@habile.in", "Qatest123$");
		
		cf.CreateClient();
		
		cf.FillForm("Heath", "Ledger", "9825455689", "10 May 1999", "22,MGR Main Street");
		
	}
	
    @org.testng.annotations.Test(priority=1)
	public void Test2() throws Exception  {
    	
    	CreateLoan cf = new CreateLoan();
    	
    	cf.Login("qatest@habile.in", "Qatest123$");
    	
    	cf.switchTab();
    	
    	cf.TitleCheck();
    	
    	cf.ClientsClick();
    	
    	cf.NewLoan();
    	
    	cf.Detailes("12 December 2024");
    	
    	cf.Terms("500000","2","10","2");
    	
    	cf.Lender("Joker");
    	
    	cf.ChargesAndReview("300000");
    	
    	
    	
		

	}

}
