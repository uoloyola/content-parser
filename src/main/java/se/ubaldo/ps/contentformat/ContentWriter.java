package se.ubaldo.ps.contentformat;

import se.ubaldo.ps.contentformat.model.Batch;

public interface ContentWriter {
	
	String write(Batch batch);
	
}
