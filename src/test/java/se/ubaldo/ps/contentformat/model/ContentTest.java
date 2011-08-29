package se.ubaldo.ps.contentformat.model;

import org.junit.Test;

import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ExternalId;
import se.ubaldo.ps.contentformat.model.Metadata;

public class ContentTest {
	
	@Test
	public void shouldBeValidOnlyIdAndMajor() throws Exception {
		
		Content content = new Content(new Metadata());
		
		ExternalId id = new ExternalId("major", "externalid");
		content.getMetadata().setExternalId(id);
//		assertTrue(content.isValid());
		
	}
	
	
	@Test
	public void shouldBeInvalid() throws Exception {
		Content content = new Content(new Metadata());
		ExternalId template = new ExternalId("","");
		content.getMetadata().setInputtemplate(template);
//		assertFalse(content.isValid());
	}

}
