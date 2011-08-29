package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ExternalId;


public class PublishParser extends AbstractContentParser {

	@Override
	public void processLine(Content content, String line, ContentSource source) throws SyntaxEcxeption {
		String[] split = Split(line);
		Content publishIn = new Content();	
		ExternalId externalId = new ExternalId("major",split[1] );
		try {
			publishIn.getMetadata().setExternalId(externalId);
		} catch (Exception e) {
			throw new SyntaxEcxeption(e.getMessage(), line, source, 10);
		}
		content.publishOn(publishIn);
	}

	@Override
	public String getExample() {
		return "publish:listname:content";
	}

	@Override
	public int mandatorySpit() {
		return 3;
	}


}
