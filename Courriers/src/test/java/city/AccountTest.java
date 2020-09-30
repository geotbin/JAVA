package city;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fil.coo.city.BankAccount;
public class AccountTest {

	private BankAccount account1;
	private BankAccount account2;
	
	@Before
	public void init() {
		this.account1 = new BankAccount(null);
		this.account2 = new BankAccount(null, 5000);
	}
	
	@Test
	public void testWhenAccountCreated() {
		assertTrue(account1.getAmount() == 0);
		assertTrue(account2.getAmount() == 5000);
	}
	
	@Test
	public void testDebit() throws Exception {
		account2.debit(100);
		assertTrue(account2.getAmount() == 4900);
	}
	
	@Test(expected = Exception.class)
	public void testDebitWithNoBankAmount() throws Exception{
		account1.debit(100);
		assertTrue(account1.getAmount() == -100);
	}
	
	
	@Test
	public void testCredit() {
		// account = 0
		account1.credit(200);
		assertTrue( account1.getAmount() == 200);
	}
	
	@Test(expected = AssertionError.class)
	public void testCreditWithNegativeValue() {
		// account = 0
		account1.credit(-200);
		assertTrue( account1.getAmount() == -200);
	}
	
	
}
