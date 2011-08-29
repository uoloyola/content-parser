package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;


public interface Parser {

	void processLine(Content node, String line, ContentSource source) throws SyntaxEcxeption;

	String getExample();

	int mandatorySpit();
	
	String splitMarker();

}
