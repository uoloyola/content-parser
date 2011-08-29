package se.ubaldo.ps.contentformat;

import se.ubaldo.ps.contentformat.hotdeploy.HotDeployContentParser;
import se.ubaldo.ps.contentformat.model.Batch;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ErrorHandler;
import se.ubaldo.ps.contentformat.model.Processable;
import se.ubaldo.ps.contentformat.xmlio.XmlIOContentWriter;


public class ContentFormatParserClient {
	
	private Batch bootstrap = new Batch();
	private ContentParser contentParser;
	private XmlIOContentWriter xmlWriter = new XmlIOContentWriter();

	public ContentFormatParserClient() {
		this.contentParser = new HotDeployContentParser(new ErrorHandler());
	}
	
	public ContentParser getContentParser() {
		return contentParser;
	}

	public String getBootstrap() {
		return xmlWriter.write(bootstrap);
	}
	

	public String getXmlContent(ContentSource source) throws ContentParserException {
		Batch batch = contentParser.parser(source);

		for (Processable contentItem : batch.getContents()) {
			bootstrap.addContent(new Content(((Content) contentItem).getMetadata()));
		}
		return xmlWriter.write(batch);
	}

}
