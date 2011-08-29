package se.ubaldo.ps.contentformat.hotdeploy;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.hotdeploy.HotDeployContentModelBuilder;
import se.ubaldo.ps.contentformat.model.Batch;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ErrorHandler;
import se.ubaldo.ps.contentformat.model.Processable;


public class HotDeployContentModelBuilderTest {
	
	HotDeployContentModelBuilder hotDeployContentModelBuilder;
	ContentSource source;
	@Before
	public void ini() {
		ErrorHandler errorHandler = new ErrorHandler();
		hotDeployContentModelBuilder = new HotDeployContentModelBuilder(errorHandler);
		
		InputStream input = new InputStream() {
			
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
		source = new ContentSource(input, "test");
	}
	
	@Test
	public void testReadLines() throws Exception {

		hotDeployContentModelBuilder.processLine("id:value", source);
		hotDeployContentModelBuilder.processLine("name:value", source);
		hotDeployContentModelBuilder.processLine("component:group:name:value", source);
		hotDeployContentModelBuilder.processLine("#this is a comment", source);
		hotDeployContentModelBuilder.processLine("", source);
		hotDeployContentModelBuilder.processLine("", source);
		hotDeployContentModelBuilder.processLine("id:value2", source);
		hotDeployContentModelBuilder.processLine("name:value2", source);
		hotDeployContentModelBuilder.processLine("", source);
		hotDeployContentModelBuilder.processLine("id:value3", source);
		hotDeployContentModelBuilder.processLine("name:value3", source);
		hotDeployContentModelBuilder.processLine("component:group:name:value", source);
		hotDeployContentModelBuilder.processLine("component:group:name:value", source);
		
		Batch batch = hotDeployContentModelBuilder.getBatch();
		int size = batch.size();
		
		Assert.assertTrue("Expected: " + 3 + " was: " + size ,size == 3);
		
	}

	@Test
	public void testAddId() throws Exception {
		
		hotDeployContentModelBuilder.processLine("securityparent:securityparent.value", source);
		hotDeployContentModelBuilder.processLine("id:externalid", source);
		hotDeployContentModelBuilder.processLine("major:Article", source);
		List<Processable> content = hotDeployContentModelBuilder.getBatch().getContents();
		Content onlyOneContent = (Content) content.get(0);	
		assertEquals("externalid", onlyOneContent.getMetadata().getExternalId().getExternalIdString());
		assertEquals("securityparent.value", onlyOneContent.getMetadata().getSecurityParent().getExternalIdString());
		assertEquals("Article", onlyOneContent.getMetadata().getMajor());
		
	}
}
