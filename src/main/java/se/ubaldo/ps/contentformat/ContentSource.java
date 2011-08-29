package se.ubaldo.ps.contentformat;

import java.io.InputStream;
import java.util.Iterator;

import se.ubaldo.ps.contentformat.model.Processable;


public class ContentSource implements Iterable<Processable> {
	
	InputStream inputStream;
	String prefix;
	
	public ContentSource(InputStream inputStream, String prefix) {
		super();
		this.inputStream = inputStream;
		this.prefix = prefix;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public String getPrefix() {
		return prefix;
	}
	
	@Override
	public Iterator<Processable> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
