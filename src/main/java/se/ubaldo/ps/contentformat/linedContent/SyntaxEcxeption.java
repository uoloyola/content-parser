package se.ubaldo.ps.contentformat.linedContent;

import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;

@SuppressWarnings("serial")
public class SyntaxEcxeption extends ContentParserException {

	public SyntaxEcxeption(String message, String lineString,
			ContentSource source, int line) {
		super(message, lineString, source, line);
	}




}
