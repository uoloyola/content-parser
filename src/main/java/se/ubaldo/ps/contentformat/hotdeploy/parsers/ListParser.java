package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import java.util.Map;

import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.SyntaxEcxeption;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ContentList;
import se.ubaldo.ps.contentformat.model.Reference;


public class ListParser extends AbstractContentParser {

	@Override
	public void processLine(Content content, String line, ContentSource source)  throws SyntaxEcxeption {
		
		String[] split = Split(line);
		Reference reference = new Reference();
		String listname = "default";
		if(split.length == 3){
		 listname = split[2];
		}
		Map<String, ContentList> contentLists = content.getContentLists();
		ContentList contentList = contentLists.get(listname);
		reference.setGroup(listname);
		reference.setName("0");
		reference.setExternalId(ExternalIdParser.getId(split[1], source.getPrefix()));
		if(contentList == null) {
			ContentList contentList2 = new ContentList(listname);
			contentList2.addReference(reference);
			contentLists.put(listname, contentList2);
		} else {
			contentList.addReference(reference);
		}

	}

	@Override
	public String getExample() {
		return "No exaplne yet";
	}

	@Override
	public int mandatorySpit() {
		return 2;
	}

}
