package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import static org.junit.Assert.*;

import org.junit.Test;


import se.ubaldo.ps.contentformat.hotdeploy.parsers.ListParser;
import se.ubaldo.ps.contentformat.hotdeploy.parsers.Parser;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ContentList;
import se.ubaldo.ps.contentformat.model.Reference;


public class ListParserTest extends AbstractPaserBaseTest{

	
	Parser parser = new ListParser();
	
	@Test
	public void testParser() throws Exception {
		
		String line = "list:externalid:listname";
		Content content = new Content();
		parser.processLine(content, line, getSource());
		parser.processLine(content,  "list:externalid2:listname", getSource());
		
		
		ContentList contentList = content.getContentList("listname");
		Reference reference = contentList.getReferences().get(0);
		assertEquals("externalid", reference.getExternalId());
		
		Reference reference2 = contentList.getReferences().get(1);
		assertEquals("externalid2", reference2.getExternalId());
		
	}
	
	@Test
	public void testDefaultList() throws Exception {
		
		String line = "list:externalid:default";
		Content content = new Content();
		parser.processLine(content, line, getSource());
		ContentList contentList = content.getContentList("default");
		String name = contentList.getName();
		assertEquals("default", name);
		assertEquals("externalid", contentList.getReferences().get(0).getExternalId());
		
	}

}
