package se.ubaldo.ps.contentformat.hotdeploy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.Test;

import se.ubaldo.ps.contentformat.ContentParser;
import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.hotdeploy.HotDeployContentParser;
import se.ubaldo.ps.contentformat.model.Batch;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ErrorHandler;
import se.ubaldo.ps.contentformat.model.Processable;


public class HotDeployContentParserTest {

	@Test
	public void testParser() throws Exception {
		
		File file = new File("src/test/resources/test.content");

		ContentParser hotDeploycontentParser = new HotDeployContentParser(new ErrorHandler());

		assertTrue(file.exists());

		ContentSource source = new ContentSource(new FileInputStream(file),
				file.getName());
		Batch batch = hotDeploycontentParser.parser(source);

		List<Processable> contents = batch.getContents();
		assertTrue("was: " + contents.size() +" expected: " + 3,contents.size() == 3);

		Content content = (Content) contents.get(0);

		String externalId = "relatedGalleriesSlotTemplates";
		String major = "Department";
		String inputtemplate = "p.TemplateRoot";

		assertContentMetadata(content, externalId, major, inputtemplate);

	}

	@Test
	public void testParserWithPrefix() throws Exception {

		ContentParser hotDeploycontentParser = new HotDeployContentParser(new ErrorHandler());
		
		File file = new File("src/test/resources/testWithPrefix.content");

		assertTrue("The file " + file + " does not exists",file.exists());

		ContentSource source = new ContentSource(new FileInputStream(file),
				file.getName());
		
		Batch batch = hotDeploycontentParser.parser(source);

		List<Processable> contents = batch.getContents();

		Content content = (Content) contents.get(0);

		String externalId = file.getName()+".relatedGalleriesSlotTemplates";
		String major = "Department";
		String inputtemplate = "p.TemplateRoot";

		assertContentMetadata(content, externalId, major, inputtemplate);

	}

	private void assertContentMetadata(Content content, String externalid,
			String major, String inputtemplate) {
		assertEquals(externalid, content.getMetadata().getExternalId().getExternalIdString());
		assertEquals(major, content.getMetadata().getMajor());
		assertEquals(inputtemplate, content.getMetadata().getInputtemplate().getExternalIdString());
	}

}
