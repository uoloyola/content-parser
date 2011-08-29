package se.ubaldo.ps.contentformat.model;

import static org.junit.Assert.*;

import org.junit.Test;

import se.ubaldo.ps.contentformat.model.ExternalId;
import se.ubaldo.ps.contentformat.model.Metadata;

public class MetadataTest {
	
	@Test
	public void shouldBeEmpty() throws Exception {
		Metadata metadata = new Metadata();
		assertTrue(metadata.isEmpty());
	}

	@Test
	public void shoudNotlBeEmpty() throws Exception {
		Metadata metadata = new Metadata();
		ExternalId id = new ExternalId("major", "text.id");
		metadata.setExternalId(id);
		
		assertFalse(metadata.isEmpty());
	}
	
	@Test
	public void shoudNotlBeEmpty2() throws Exception {
		Metadata metadata = new Metadata();
		
		ExternalId inputtemplate = new ExternalId("InputTemplate", "inputtemplate.externalid");
		metadata.setInputtemplate(inputtemplate);
		
		assertFalse(metadata.isEmpty());
	}
	
	
}
