package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;


public class DoNothingParser extends AbstractContentParser {

	@Override
	public void processLine(Content content, String line, ContentSource source)
			throws SyntaxEcxeption {
		//do nothing
	}

	@Override
	public String getExample() {
		return "";
	}

	@Override
	public int mandatorySpit() {
		return 0;
	}

}
