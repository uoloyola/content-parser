package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import java.io.IOException;
import java.io.InputStream;

import se.ubaldo.ps.contentformat.ContentSource;


public abstract class AbstractPaserBaseTest {
	
	
	protected final ContentSource getSource() {
		return new ContentSource(new InputStream() {
			@Override
			public int read() throws IOException {
				return 0;
			}
		}, "test");
	}
	


}
