package se.ubaldo.ps.contentformat.simpleformat;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;

import se.ubaldo.ps.contentformat.ContentFormatParserClient;
import se.ubaldo.ps.contentformat.ContentSource;


public class ContantFormatParserIntegrationTest {

	private ContentFormatParserClient target;
	private FileInputStream fileInputStream ;

	@Before
	public void init() throws Exception {
	fileInputStream =  new FileInputStream(new File(
	"src/test/resources/test.content"));	
	}
	
	@Test
	public void testGetXmlContent() throws Exception {
		target = new ContentFormatParserClient();
	    ContentSource source = new ContentSource(fileInputStream, "");
		String xmlContent = target.getXmlContent(source);
		String bootstrap = target.getBootstrap();
		assertTrue(xmlContent.startsWith("<?xml version="));
		assertTrue(bootstrap.startsWith("<?xml version="));

	}
}
