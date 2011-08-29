package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.model.Content;


class MajorParser extends AbstractContentParser {


	@Override
	public void processLine(Content content, String line, ContentSource source) {
		String[] split = Split(line);
		String string = split[1];
		if(string == null) {
			string = "Unknow";
		}
		content.getMetadata().setMajor(string);
	}

	@Override
	public String getExample() {
		return "major:YourMayor";
	}

	@Override
	public int mandatorySpit() {
		return 2;
	}

	

}
