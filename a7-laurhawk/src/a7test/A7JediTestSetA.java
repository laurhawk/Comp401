package a7test;

import a7.*;

import comp401sushi.*;
import comp401sushi.Nigiri.NigiriType;
import comp401sushi.Sashimi.SashimiType;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import a7.Belt;
import a7.PlateCounter;
import a7.ProfitCounter;

public class A7JediTestSetA {

	// Belt object with six positions created for testing
	private Belt testBelt;

	private Sushi testContentsRed;
	private Sushi testContentsGreen;
	private Sushi testContentsBlue;
	private Sushi testContentsGold;

	private Plate redPlate;
	private Plate greenPlate;
	private Plate bluePlate;
	private Plate goldPlate;

	private PlateCounter plateCounter;
	private ProfitCounter profitCounter;

	private Customer a;
	private Customer b;
	private Customer c;
	private Customer d;
	private Customer e;
	private Customer f;

	@Before
	public void SetUp() throws PlatePriceException {
		// declares Belt object with six positions for testing
		testBelt = new BeltImpl(6);

		// creates Sashimi and Nigiri Sushi objects to set Plate contents
		testContentsRed = new Nigiri(NigiriType.CRAB); // costs $0.62
		testContentsGreen = new Sashimi(SashimiType.EEL);  // costs $1.64

		// creates Ingredients to be added to Rolls
		// Ikura Gunkan
		YellowtailPortion salmon = new YellowtailPortion(.75);
		SeaweedPortion seaweedMedium = new SeaweedPortion(.3);
		// Tekkamaki
		TunaPortion tuna = new TunaPortion(1.2);
		RicePortion rice = new RicePortion(.6);
		SeaweedPortion seaweedSmall = new SeaweedPortion(.15);

		// creates IngredientPortion arrays to be added to Rolls
		IngredientPortion[] ikuraGunkanIngredients = {salmon, seaweedMedium};
		IngredientPortion[] tekkamakiIngredients = {tuna, rice, seaweedSmall};

		// creates two Roll Sushi objects to set Plate contents
		testContentsBlue = new Roll("Ikura Gunkan", ikuraGunkanIngredients); // costs $1.43
		testContentsGold = new Roll("Ebi Nigiri", tekkamakiIngredients);	 // costs $2.64

		// constructs test Plates
		redPlate = new RedPlate(testContentsRed);
		greenPlate = new GreenPlate(testContentsGreen);
		bluePlate = new BluePlate(testContentsBlue);
		goldPlate = new GoldPlate(testContentsGold, 5.0);

		// sets Plate contents
		redPlate.setContents(testContentsRed);
		greenPlate.setContents(testContentsGreen);
		bluePlate.setContents(testContentsBlue);
		goldPlate.setContents(testContentsGold);

		// creates Customer objects for testing
		a = new EmptyCustomerImpl();
		b = new EmptyCustomerImpl();
		c = new EmptyCustomerImpl();
		d = new EmptyCustomerImpl();
		e = new EmptyCustomerImpl();
		f = new EmptyCustomerImpl();

		// creates observer classes that observe the testBelt
		plateCounter = new PlateCounter(testBelt);
		profitCounter = new ProfitCounter(testBelt);
	}

	@Rule // used for detecting Exceptions
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testRegisterCustomerExceptions() {
		testBelt.registerCustomerAtPosition(a, 0);
		testBelt.registerCustomerAtPosition(b, 1);
		testBelt.registerCustomerAtPosition(c, 2);

		// anticipates Exception using predefined Rule
		exception.expect(RuntimeException.class);

		// makes sure the register and unregister Customer methods will throw exceptions
		// makes sure exception is thrown when Customer is already observing
		testBelt.registerCustomerAtPosition(a, 4);
		// makes sure exception is thrown when a Customer is already at that position
		testBelt.registerCustomerAtPosition(d, 0);
	}
	
	@Test
	public void testUnregisterCustomer() {
		// registers a Customer to every position
		testBelt.registerCustomerAtPosition(a, 0);
		testBelt.registerCustomerAtPosition(b, 1);
		testBelt.registerCustomerAtPosition(c, 2);
		testBelt.registerCustomerAtPosition(d, 3);
		testBelt.registerCustomerAtPosition(e, 4);
		testBelt.registerCustomerAtPosition(f, 5);
		
		// removes a few Customers
		assertEquals(a, testBelt.unregisterCustomerAtPosition(0));
		assertEquals(c, testBelt.unregisterCustomerAtPosition(2));
		assertEquals(e, testBelt.unregisterCustomerAtPosition(4));
		
		// tries to remove two Customer objects again and should return null
		assertEquals(null, testBelt.unregisterCustomerAtPosition(0));
		assertEquals(null, testBelt.unregisterCustomerAtPosition(4));
		
		// removes the rest of the Customer objects
		assertEquals(b, testBelt.unregisterCustomerAtPosition(1));
		assertEquals(d, testBelt.unregisterCustomerAtPosition(3));
		assertEquals(f, testBelt.unregisterCustomerAtPosition(5));
	}

}