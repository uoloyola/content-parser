package se.ubaldo.ps.contentformat.model;

import java.util.ArrayList;
import java.util.List;

public class ContentList {

	private final String _name;
	private List<Reference> references = new ArrayList<Reference>();
	
	public ContentList(String name) {
		this._name = name;
	}
	
	public String getName(){
		return _name;
	}
	
	public int size() {
		return references.size();
	}
	
	public boolean isEmpty() {
		return references.isEmpty();
	}
	
	public void addReference(Reference reference) {
		references.add(reference);
	}
	
	public List<Reference> getReferences() {
		return references;
	}
	
}
