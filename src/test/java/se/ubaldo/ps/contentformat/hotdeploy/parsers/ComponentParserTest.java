package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import se.ubaldo.ps.contentformat.hotdeploy.parsers.ComponentParser;
import se.ubaldo.ps.contentformat.hotdeploy.parsers.Parser;
import se.ubaldo.ps.contentformat.model.Component;
import se.ubaldo.ps.contentformat.model.Content;



public class ComponentParserTest extends AbstractPaserBaseTest{

	Parser componentParser;
	
	@Test
	public void shouldParse() throws Exception {
		componentParser = new ComponentParser();
		String conpoment = "component:group:name:value";
		Content content = new Content();
		componentParser.processLine(content, conpoment, getSource());
		
		Component component = content.getComponents().get(0);
		
		assertEquals("group", component.getGroup());
		assertEquals("name", component.getName());
		assertEquals("value", component.getValue());
	}
	
	
}
