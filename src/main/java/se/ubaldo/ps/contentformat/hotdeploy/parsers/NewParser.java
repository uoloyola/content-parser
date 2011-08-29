package se.ubaldo.ps.contentformat.hotdeploy.parsers;

import se.ubaldo.ps.contentformat.model.Processable;

public interface NewParser<E extends Processable> {
	
	void parser(E node, String line, String prefix);

}
