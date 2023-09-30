
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setupBeforeEachTest() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void afterEachTestRemoveTestSetup() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

	@Test
    public void verifyThatLoginIsWorkingWithCorrectUserNameAndPasswordUser1() {
		Bankomat bank = new Bankomat();
        assertTrue(bank.login("Karthi", "Volvo"));
        
    }
    
    @Test
    public void verifyThatLoginIsWorkingWithCorrectUserNameAndPasswordUser2() {
    	Bankomat bank = new Bankomat();
        assertTrue(bank.login("Haasini","Beautiful"));
       
    }
    
    @Test
    public void verifyThatLoginFailsWithWrongUserNameAndWrongPasswordUser3() {
    	Bankomat bank = new Bankomat();
    	assertTrue(!bank.login("Nandhana","Volvo"));
        
    }
    @Test
    public void verifyThatCheckAccountBalanceIsWorkingWithCorrectAmountUser1() {
        Bankomat bank = new Bankomat();
        bank.login("Karthi","Volvo");
        bank.checkAccountbalance("69112");
        assertEquals("Your current balance is 10000.0", outContent.toString().trim());
		
    }
    
    @Test
    public void verifyThatCheckAccountBalanceIsWorkingWithCorrectAccountNumberAndAmountUser2() {
    	Bankomat bank = new Bankomat();
    	bank.login("Anu","Mylife");
    	bank.checkAccountbalance("12345");
    	assertEquals("Your current balance is 5000.0", outContent.toString().trim());
    
       
    }
    
    
    
    @Test
    public void verifyThatwithdrawMoneyIsWorkingWithCorrectAccountNumberAndAmountUser1() {
    	Bankomat bank = new Bankomat();
        bank.login("Karthi","Volvo");
        bank.withdrawMoney("69112", 1000.0);
        assertEquals("Your current balance is 9000.0", outContent.toString().trim());
        
    }
    
    @Test
    public void verifyThatwithdrawMoneyIsWorkingWithCorrectAccountNumberAndAmountUser2() {
    	Bankomat bank = new Bankomat();
        bank.login("Anu","Mylife");
        bank.withdrawMoney("12345",1000.00);
        assertEquals("Your current balance is 4000.0", outContent.toString().trim());
       
    }
    
    
   
    
    
    
   
    
}

    