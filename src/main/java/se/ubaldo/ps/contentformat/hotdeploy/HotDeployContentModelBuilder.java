package se.ubaldo.ps.contentformat.hotdeploy;

import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.hotdeploy.parsers.Parser;
import se.ubaldo.ps.contentformat.hotdeploy.parsers.ParserFactory;
import se.ubaldo.ps.contentformat.linedContent.NewContentDetector;
import se.ubaldo.ps.contentformat.model.Batch;
import se.ubaldo.ps.contentformat.model.Content;
import se.ubaldo.ps.contentformat.model.ErrorHandler;


class HotDeployContentModelBuilder {

	private final ErrorHandler errorHandler;

	public HotDeployContentModelBuilder(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	private Batch batch = new Batch();
	private Content content = null;
	private NewContentDetector contentDetector = new NewContentDetector();
	private PrefixFactory discover = new PrefixFactory();
	private ParserFactory factory = new ParserFactory();

	public void processLine(String line, ContentSource source)
			throws ContentParserException {
		if (isEmpty(line)) {
			contentDetector.isNewBlock(line);
		} else {
			if (contentDetector.isNewBlock(line)) {
				content = new Content();
				try {
					localAdd(content, line, source);
				} catch (ContentParserException e) {
					System.err.println(e);
					errorHandler.addError(e);
				}
				batch.addContent(content);
			} else {
				try {
				localAdd(content, line, source);
				} catch (ContentParserException e) {
					System.err.println(e);
					errorHandler.addError(e);
				}
			}
		}
	}

	private void localAdd(Content content, String line, ContentSource source)
			throws ContentParserException {
		
		try {
		Prefix prefix = discover.discover(line);
		Parser parser = factory.getParser(prefix);
		parser.processLine(content, line, source);
		} catch (Exception e) {
			throw new ContentParserException(e.getMessage(), line, source, 1 );
		}
	}

	public Batch getBatch() {
		return batch;
	}

	private boolean isEmpty(String line) {
		return line.length() == 0;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [" + batch.toString() + "]";
	}

}
