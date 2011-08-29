package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.Reference;


class ReferenceParser extends AbstractContentParser {

	@Override
	public void processLine(Content content, String line, ContentSource source) throws SyntaxEcxeption {
		String[] split = Split(line);
		Reference reference = new Reference();
		reference.setGroup(split[0]);
		reference.setName(split[1]);
		reference.setExternalId(ExternalIdParser.getId(split[2], source.getPrefix()));
		
		content.addReference(reference);
	}

	@Override
	public String getExample() {
		return "reference:externalid";
	}
	@Override
	public int mandatorySpit() {
		return 2;
	}

}
