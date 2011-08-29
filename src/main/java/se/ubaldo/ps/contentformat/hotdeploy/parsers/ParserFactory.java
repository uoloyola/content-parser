package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.hotdeploy.Prefix;

public class ParserFactory {

	public Parser getParser(Prefix prefix)  {

		switch (prefix) {
		case ID:
			return new ExternalIdParser();
		case COMPONENT:
			return new ComponentParser();
		case MAJOR:
			return new MajorParser();
		case NAME:
			return new NameParser();
		case SECURITYPARENT:
			return new SecurityParentParser();
		case INPUTTEMPLATE:
			return new InputtemplateParser();
		case TEMPLATE:
			return new InputtemplateParser();
		case REF:
			return new ReferenceParser();
		case LIST:
			return new ListParser();
		case PUBLISH:
			return new PublishParser();
		case NUMERICALID:
			return new DoNothingParser();
		case COMMENT:
			return new CommentParser();
		}

		
		throw new IllegalArgumentException("The prefix" + prefix.toString()
				+ "  could not be parsed");

	}
}
