package se.ubaldo.ps.contentformat.linedContent;

import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;

@SuppressWarnings("serial")
public class EmptyLineException extends ContentParserException {

	public EmptyLineException(String message, String lineString,
			ContentSource source, int line) {
		super(message, lineString, source, line);
	}

	

}
