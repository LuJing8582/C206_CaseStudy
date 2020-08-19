import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Bike b1;
	private Bike b2;

	 private ArrayList<Bike> bikeList;
	 
	
	@Before
	public void setUp() throws Exception {
		b1=new Bike ("b001","Merida",10);
		b2=new Bike ("b002","Trek",5);
		
		bikeList= new ArrayList<Bike>();
	}
	public void addBikeTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Bike arraylist to add to", bikeList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addbike(bikeList, b1);
		assertEquals("Check that Camcorder arraylist size is 1", 1, bikeList.size());
		assertSame("Check that Camcorder is added", b1, bikeList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addbike(bikeList, b2);
		assertEquals("Check that id bike start with b and 3 digits ", 2, bikeList.get(2).getId());
		assertSame("Check that Camcorder is added", b2, bikeList.get(1));
	}

	public void retrieveAllBikeinfoTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", bikeList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
		String allbikeinfo= C206_CaseStudy.viewbikeinfo(bikeList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allbikeinfo);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addbike(bikeList, b1);
		C206_CaseStudy.addbike(bikeList, b2);
		assertEquals("Test that bike arraylist size is 2", 2, bikeList.size());
		
		//test if the expected output display error message for zero selected - error
		allbikeinfo= C206_CaseStudy.viewbikeinfo(bikeList);
		for(int i =0;i<bikeList.size();i++) {
			if(bikeList.get(i).getName()==null) {
				testOutput="Empty";
			}
		}
		assertEquals("Test that View All Bike list", testOutput, allbikeinfo);
		
	}
	
	public void deleteBikeInfoTest() {
		//boundary
		assertNotNull("Test if there is valid Chromebook arraylist to add to", bikeList);
		C206_CaseStudy.addbike(bikeList, b1);
		//normal
		Boolean ok = C206_CaseStudy.deletebikeinfo(bikeList,"b001");
		assertTrue("Test if an available item is ok to delete?", ok);		
		//error condition
		ok = C206_CaseStudy.deletebikeinfo(bikeList,"");
		assertFalse("Test if the same item is NOT ok to delete ?", ok);	
		//error
		ok = C206_CaseStudy.deletebikeinfo(bikeList,"b1111");
		assertFalse("Test if the same item is NOT ok to delete ?", ok);	
		
	}
	
	@After
	public void tearDown() throws Exception {
		b1=null;
		b2=null;
		bikeList= null;
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
