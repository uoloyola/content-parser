package se.ubaldo.ps.contentformat;

import se.ubaldo.ps.contentformat.model.Batch;
import se.ubaldo.ps.contentformat.model.ErrorHandler;

public interface ContentParser {
	
	Batch parser(ContentSource source) throws ContentParserException;
	
	ErrorHandler getErrorHandler();
}
