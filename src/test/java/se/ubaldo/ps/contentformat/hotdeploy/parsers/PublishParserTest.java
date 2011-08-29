package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import se.ubaldo.ps.contentformat.hotdeploy.parsers.PublishParser;
import se.ubaldo.ps.contentformat.model.Content;


public class PublishParserTest extends AbstractPaserBaseTest {
	
	PublishParser target = new PublishParser();
	
	@Test
	public void testParser() throws Exception {
		Content content = new Content();
		target.processLine(content, "publish:externalid", getSource());
		List<Content> referededContent = content.getReferededContent();
		Content refered = referededContent.get(0);
		assertEquals("externalid", refered.getMetadata().getExternalId().getExternalIdString());
	}

}
