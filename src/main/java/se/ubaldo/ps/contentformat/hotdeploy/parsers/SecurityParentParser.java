package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ExternalId;


class SecurityParentParser extends AbstractContentParser {

	@Override
	public void processLine(Content content, String line, ContentSource source) throws SyntaxEcxeption {
		String[] split = Split(line);
		ExternalId externalId = new ExternalId("major",ExternalIdParser.getId(split[1], source.getPrefix()));
		content.getMetadata().setSecurityParent(externalId);
	}

	@Override
	public String getExample() {
		return "securityparent:externalid";
	}

	@Override
	public int mandatorySpit() {
		return 2;
	}
}
