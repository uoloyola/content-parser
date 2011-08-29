package se.ubaldo.ps.contentformat;

@SuppressWarnings("serial")
public class ContentParserException extends Exception {

	private final ContentSource source;
	private final int line;
	private final String lineString;

	public ContentParserException(String message, String lineString, ContentSource source,int line) {
		super(message);
		this.lineString = lineString;
		this.source = source;
		this.line = line;
	}

	public ContentSource getSource() {
		return source;
	}
	
	public int getLine() {
		return line;
	}
	
	public String getLineString() {
		return lineString;
	}
	
	
}
