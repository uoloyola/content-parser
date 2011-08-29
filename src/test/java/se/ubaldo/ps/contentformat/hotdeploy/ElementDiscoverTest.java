package se.ubaldo.ps.contentformat.hotdeploy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static se.ubaldo.ps.contentformat.hotdeploy.Prefix.ID;

import org.junit.Test;

import se.ubaldo.ps.contentformat.hotdeploy.Prefix;
import se.ubaldo.ps.contentformat.hotdeploy.PrefixFactory;

public class ElementDiscoverTest {
	
	PrefixFactory discover = new PrefixFactory();
	
	@Test
	public void testDiscover() throws Exception {
		Prefix discover2 = discover.discover("id:lskdj:oiuwe:sdf");
		assertEquals(ID, discover2);
		
		try {
		discover.discover("papa:");		
		fail();
		} catch (Exception e) {
			
		}
		
	}

}
