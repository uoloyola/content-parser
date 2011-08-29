package se.ubaldo.ps.contentformat.model;

import java.util.ArrayList;
import java.util.List;

import se.ubaldo.ps.contentformat.ContentParserException;


public class ErrorHandler {

	boolean hasErrors;
	List<ContentParserException> errors = new ArrayList<ContentParserException>();

	public void addError(ContentParserException error) {
		hasErrors = true;
		errors.add(error);
	}

	public boolean hasError() {
		return hasErrors;
	}

	public String sumarizeErrors() {

		StringBuffer stringBuffer = new StringBuffer(
				"------------------------------------------------------------------------\n");
		stringBuffer.append("BUILD FAIL with " + errors.size() + " error(s)"+"\n");
		stringBuffer
				.append("------------------------------------------------------------------------\n");
		for (ContentParserException error : errors) {
			stringBuffer.append("Error: " + error.getMessage() + " at line: "+ error.getLine() + " " + error.getLineString());
			
		}
		return stringBuffer.toString();
	}
}
