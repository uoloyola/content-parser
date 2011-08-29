package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import static org.junit.Assert.*;

import org.junit.Test;


import se.ubaldo.ps.contentformat.hotdeploy.parsers.ExternalIdParser;
import se.ubaldo.ps.contentformat.hotdeploy.parsers.Parser;
import se.ubaldo.ps.contentformat.model.Content;


public class ExternalIdParserTest extends AbstractPaserBaseTest {

	@Test
	public void testPaser() throws Exception {
		Parser parser = new ExternalIdParser();
		Content content = new Content();
		parser.processLine(content, "id:externalid", getSource());
		
		assertEquals("externalid", content.getMetadata().getExternalId().getExternalIdString());
	}
	@Test
	public void testPaserWithPrefix() throws Exception {
		Parser parser = new ExternalIdParser();
		Content content = new Content();
		parser.processLine(content, "id:.externalid", getSource());
		
		assertEquals(getSource().getPrefix()+".externalid", content.getMetadata().getExternalId().getExternalIdString());
	}

	

}
