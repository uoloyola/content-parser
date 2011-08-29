package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Comment;
import se.ubaldo.ps.contentformat.model.Content;


public class CommentParser implements Parser {

	@Override
	public void processLine(Content node, String line, ContentSource source) throws SyntaxEcxeption {
		new Comment(line);
		
	}

	@Override
	public String getExample() {
		return "# This is a comment";
	}

	@Override
	public int mandatorySpit() {
		return 0;
	}

	@Override
	public String splitMarker() {
		// TODO Auto-generated method stub
		return null;
	}

}
