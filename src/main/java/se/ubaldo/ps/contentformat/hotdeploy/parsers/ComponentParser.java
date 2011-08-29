package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Component;
import se.ubaldo.ps.contentformat.model.Content;



class ComponentParser extends AbstractContentParser {

	@Override
	public void processLine(Content content, String line, ContentSource source) throws SyntaxEcxeption {
		Component component = new Component();
		String[] split = line.split(":");
		component.setGroup(split[1]);
		component.setName(split[2]);
		component.setValue((split[3]));
		content.addComponent(component);
	}

	@Override
	public int mandatorySpit() {
		return 3;
	}

	@Override
	public String getExample() {
		return "component:<group>:<name>:<value>";
	}


}
