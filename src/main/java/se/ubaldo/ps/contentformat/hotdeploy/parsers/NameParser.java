package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Component;
import se.ubaldo.ps.contentformat.model.Content;


class NameParser extends AbstractContentParser {


	@Override
	public void processLine(Content content,String line, ContentSource source) throws SyntaxEcxeption {
		String[] split = Split(line);
		Component component = new Component();
		component.setGroup("polopoly.Content");
		component.setName("name");
		component.setValue(split[1]);
		content.addComponent(component);
	}

	@Override
	public String getExample() {
		return "name:TheNameOftheContent";
	}

	@Override
	public int mandatorySpit() {
		return 2;
	}

	
}
