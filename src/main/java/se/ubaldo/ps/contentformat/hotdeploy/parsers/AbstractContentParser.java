package se.ubaldo.ps.contentformat.hotdeploy.parsers;


public abstract class AbstractContentParser implements Parser {
	
	protected String[] Split(String line) {
		return line.split(":");
	}
	
	public String splitMarker() {
		return ":";
	}
}
