package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ExternalId;



class InputtemplateParser extends AbstractContentParser {

	@Override
	public void processLine(Content content, String line, ContentSource source) throws SyntaxEcxeption {
		String[] split = Split(line);
		ExternalId inputTemplate = new ExternalId("InputTemplate", split[1]);
		content.getMetadata().setInputtemplate(inputTemplate);
	}

	@Override
	public String getExample() {
		return "inputtemplate:YourInputTemplateExternalId";
	}

	@Override
	public int mandatorySpit() {
		return 2;
	}

}
