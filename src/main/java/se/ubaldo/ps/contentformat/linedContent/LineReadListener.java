package se.ubaldo.ps.contentformat.linedContent;

import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;

public interface LineReadListener {

	void readLine(String line, ContentSource source) throws ContentParserException;

}
