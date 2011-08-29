package se.ubaldo.ps.contentformat.xmlio;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import se.ubaldo.ps.contentformat.ContentWriter;
import se.ubaldo.ps.contentformat.model.Batch;
import se.ubaldo.ps.contentformat.model.Comment;
import se.ubaldo.ps.contentformat.model.Component;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ContentList;
import se.ubaldo.ps.contentformat.model.ExternalId;
import se.ubaldo.ps.contentformat.model.Metadata;
import se.ubaldo.ps.contentformat.model.Processable;
import se.ubaldo.ps.contentformat.model.Reference;


public class XmlIOContentWriter implements ContentWriter {

	private StringBuffer stringBuffer;

	public XmlIOContentWriter() {
		stringBuffer = new StringBuffer();
	}

	private void xmlHader(StringBuffer stringBuffer) {
		stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	}

	private void batch(StringBuffer stringBuffer) {
		stringBuffer
				.append("<batch xmlns=\"http://www.polopoly.com/polopoly/cm/xmlio\">\n");
	}

	private void closeBatch(StringBuffer stringBuffer) {
		stringBuffer.append("</batch>\n");
	}

	private void println(String string) {
		stringBuffer.append(string + "\n");
	}

	private void printContent(Processable printable) {
		Content content = (Content) printable;
		
		println("<content>");
		printMetadata((Content) content);
		for (Component component : content.getComponents()) {
			printComponents(component);
		}
		for (Reference reference : content.getReferences()) {
			printReference(reference);
		}

		printContentLists(content);

		println("</content>");
		println("");

		if (!content.getReferededContent().isEmpty()) {
			println("<!-- Publish: " + content.getMetadata().getExternalId()
					+ " in content -->");
			println("<content>");
			for (Content publish : content.getReferededContent()) {
				printMetadata(publish);
			}
			println("</content>");
			println("<!-- End -->");
			println("");
		}
	}

	private void printReference(Reference reference) {
		println("<contentref group=\"" + reference.getGroup() + "\" name=\""
				+ reference.getName() + "\">");
		println("  <contentid>");
		println("    <major>Unknown</major>");
		println("    <externalid>" + reference.getExternalId()
				+ "</externalid>");
		println("  </contentid>");
		println("</contentref>");
	}

	private void printMetadata(Content content) {
		
		Metadata metadata = content.getMetadata();
		
		if (metadata == null || metadata.getExternalId() == null) {
			//Do nothing
		}else {
		println("<metadata>");
		println("  <contentid>");
		if (content.getMetadata().getMajor() != null) {
			println("    <major>" + content.getMetadata().getMajor()
					+ "</major>");
		}
		
		println("    <externalid>"
				+ content.getMetadata().getExternalId()
				+ "</externalid>");
		println("  </contentid>");
		printInputtemplate(content);
		printSecurityParent(content);
		println("</metadata>");
		}
	}

	private void printInputtemplate(Content content) {
		ExternalId inputTemplate = content.getMetadata().getInputtemplate();
		if (inputTemplate != null && !inputTemplate.equals("")) {
			println("  <input-template>");
			println("    <major>" + inputTemplate.getMajor() + "</major>");
			println("    <externalid>" + inputTemplate.getExternalIdString()
					+ "</externalid>");
			println("  </input-template>");
		}
	}

	private void printSecurityParent(Content content) {
		ExternalId securityParent = content.getMetadata().getSecurityParent();
		if (securityParent != null && !securityParent.equals("")) {
			println("  <security-parent>");
			println("    <major>" + securityParent.getMajor() + "</major>");
			println("    <externalid>" + securityParent.getExternalIdString()
					+ "</externalid>");
			println("  </security-parent>");
		}
	}

	private void printComponents(Component component) {
		println("<component group=\"" + component.getGroup() + "\" name=\""
				+ component.getName() + "\">" + component.getValue()
				+ "</component>");
	}

	public void add(String string) {
		stringBuffer.append(string + "\n");

	}

	public String write(Batch batch) {
		xmlHader(stringBuffer);
		printToolinfo(stringBuffer);
		batch(stringBuffer);
		for (Processable content : batch.getContents()) {
			
			if(content instanceof Content) {
				printContent((Content) content);
			}
			if(content instanceof Comment) {
				printComment((Comment) content);
			}
		}

		closeBatch(stringBuffer);
		return stringBuffer.toString();
	}

	private void printComment(Comment comment) {
		println("<!--"+ comment +" -->");
	}

	private void printToolinfo(StringBuffer stringBuffer2) {
		println("<!--This file was atomatically generated " + new Date()
				+ " by the xml-converter -->");
	}

	private void printContentList(ContentList contentList) {
		println("<contentlist>");
		for (Reference reference : contentList.getReferences()) {
			println("  <entry>");
			println("    <contentid>" + reference.getExternalId()
					+ "</contentid>");
			println("  </entry>");
		}
		println("</contentlist>");
	}

	private void printContentLists(Content content) {
		Map<String, ContentList> contentLists = content.getContentLists();
		Set<Entry<String, ContentList>> entrySet = contentLists.entrySet();
		for (Iterator<Entry<String, ContentList>> iterator = entrySet
				.iterator(); iterator.hasNext();) {
			Entry<String, ContentList> entry = (Entry<String, ContentList>) iterator
					.next();
			printContentList(entry.getValue());

		}
	}

}
