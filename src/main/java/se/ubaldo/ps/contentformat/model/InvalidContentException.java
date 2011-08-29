package se.ubaldo.ps.contentformat.model;

import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;

@SuppressWarnings("serial")
public class InvalidContentException extends ContentParserException {

	public InvalidContentException(String message, String lineString,
			ContentSource source, int line) {
		super(message, lineString, source, line);
		// TODO Auto-generated constructor stub
	}

	
}
