package se.ubaldo.ps.contentformat.hotdeploy;

import se.ubaldo.ps.contentformat.ContentParser;
import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;
import se.ubaldo.ps.contentformat.linedContent.LineReadListener;
import se.ubaldo.ps.contentformat.linedContent.LinesIterator;
import se.ubaldo.ps.contentformat.model.Batch;
import se.ubaldo.ps.contentformat.model.ErrorHandler;


public final class HotDeployContentParser implements ContentParser, LineReadListener {

	private LinesIterator linesIterator;
	private HotDeployContentModelBuilder hotDeployContentModelBuilder;
	private final ErrorHandler errorHandler;

	public HotDeployContentParser(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
		this.linesIterator = new LinesIterator(this);
		hotDeployContentModelBuilder = new HotDeployContentModelBuilder(errorHandler);
	}

	@Override
	public void readLine(String line, ContentSource source) throws ContentParserException {
		hotDeployContentModelBuilder.processLine(line, source);
	}

	@Override
	public Batch parser(ContentSource source) throws ContentParserException {
		linesIterator.processSource(source);
		return hotDeployContentModelBuilder.getBatch();
	}

	@Override
	public ErrorHandler getErrorHandler() {
		return errorHandler;
	}

}
