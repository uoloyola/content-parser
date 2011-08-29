package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ExternalId;
import se.ubaldo.ps.contentformat.model.OperationInvalidException;


public class ExternalIdParser extends AbstractContentParser {
	
	public ExternalIdParser() {
		
	}
	
	@Override
	public final void processLine(Content content, String line, ContentSource source) throws SyntaxEcxeption {
		
		String[] split = Split(line);
		ExternalId externalId = new ExternalId("major", getId(split[1], source.getPrefix()));
		try {
			content.getMetadata().setExternalId(externalId);
		} catch (OperationInvalidException e) {
			throw new SyntaxEcxeption(e.getMessage(), line, source, 10);
		}
	}

	public static String getId(String externalId, String prefix) {
		return (externalId.startsWith(".")) ? prefix + externalId
				: externalId;
	}

	@Override
	public String getExample() {
		return "externalid:example or externalid:.example";
	}

	@Override
	public int mandatorySpit() {
		return 2;
	}

}
