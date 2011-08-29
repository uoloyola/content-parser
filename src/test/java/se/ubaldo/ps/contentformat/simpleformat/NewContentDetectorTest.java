package se.ubaldo.ps.contentformat.simpleformat;

import static org.junit.Assert.*;

import org.junit.Test;

import se.ubaldo.ps.contentformat.linedContent.NewContentDetector;


public class NewContentDetectorTest {
	
	NewContentDetector target = new NewContentDetector();
	
	@Test
	public void testWhenisAnewContent() throws Exception {
		
		assertTrue("should be true",(target.isNewBlock("id:lkj")));
		assertFalse("should be false, the content is not ended",(target.isNewBlock("name:lkj")));
		assertFalse((target.isNewBlock("")));
		assertFalse((target.isNewBlock("")));
		assertFalse((target.isNewBlock("")));
		assertTrue("Should be start new content",(target.isNewBlock("id:lkj")));
		assertFalse("should be false, the content is not ended",(target.isNewBlock("name:lkj")));
		assertFalse((target.isNewBlock("")));
		assertFalse((target.isNewBlock("")));
		assertTrue("Should be start new content",(target.isNewBlock("id:lkj")));
		assertFalse("should be false",(target.isNewBlock("name:lkj")));
		assertFalse("should be false",(target.isNewBlock("component:lkj")));
		assertFalse("should be false",(target.isNewBlock( "reference:lkj")));
		assertFalse("should be false",(target.isNewBlock("id:lkj")));
		
	}

}
