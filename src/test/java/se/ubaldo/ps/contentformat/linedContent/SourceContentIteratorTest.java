package se.ubaldo.ps.contentformat.linedContent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.Line;
import se.ubaldo.ps.contentformat.linedContent.SourceContentIterator;


public class SourceContentIteratorTest {
	
	
	SourceContentIterator sourceIterator = null;
	
	@Before
	public void setup() throws FileNotFoundException {
		File file = new File("src/test/resources/testWithPrefix.content");
		ContentSource source = new ContentSource(new FileInputStream(file), file.getName());
		sourceIterator = new SourceContentIterator(source);
	}
	
	@Test
	public void testname() throws Exception {
		Assert.assertTrue(sourceIterator.hasNext());
		Assert.assertEquals(new Line("id:.relatedGalleriesSlotTemplates",1), sourceIterator.next());

		Assert.assertTrue(sourceIterator.hasNext());
		Assert.assertEquals(new Line("major:Department", 2), sourceIterator.next());

		Assert.assertTrue(sourceIterator.hasNext());
		Assert.assertEquals(new Line("inputtemplate:p.TemplateRoot", 3), sourceIterator.next());

		Assert.assertTrue(sourceIterator.hasNext());
		Assert.assertEquals(new Line("securityparent:p.TemplateDepartment", 4), sourceIterator.next());
		
		Assert.assertTrue(sourceIterator.hasNext());
		Assert.assertEquals(new Line("name:SZ Article Templates", 5), sourceIterator.next());
		
		Assert.assertTrue(sourceIterator.hasNext());
		Assert.assertEquals(new Line("publish:p.TemplateDepartment", 6), sourceIterator.next());
		
		Assert.assertTrue(sourceIterator.hasNext());
		Assert.assertEquals(new Line("list:relatedGalleriesSlotTemplates.gallery", 7), sourceIterator.next());
		
		Assert.assertFalse(sourceIterator.hasNext());
		Assert.assertFalse(sourceIterator.hasNext());
		
	}

}
