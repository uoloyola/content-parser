package se.ubaldo.ps.contentformat.simpleformat;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.LineReadListener;
import se.ubaldo.ps.contentformat.linedContent.LinesIterator;


public class LineIteratorTest {

	int counter = 0;

	@Test
	public void shouldIterateOverLines() throws Exception {
		File file = new File("src/test/resources/test.content");
		LinesIterator iter = new LinesIterator(new LineReadListener() {

			@Override
			public void readLine(String line, ContentSource source)
					throws ContentParserException {
				counter++;

			}

		});

		iter.processSource(new ContentSource(new FileInputStream(file), "text"));
		int expected = 21;
		assertTrue("was " + counter + " must be " + expected,
				counter == expected);
	}

}
