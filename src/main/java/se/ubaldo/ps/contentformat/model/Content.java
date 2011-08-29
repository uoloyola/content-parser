package se.ubaldo.ps.contentformat.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final public class Content implements Validable, Processable {

	private Metadata metadata = new Metadata();
	private List<Reference> references = new ArrayList<Reference>();
	private List<Component> components = new ArrayList<Component>();
	private List<Content> published = new ArrayList<Content>();
	private Map<String ,ContentList> contentLists = new HashMap<String ,ContentList>();

	
	public Content() {}
	
	public Content(Metadata metadata) {
		if(metadata == null) {
			throw new IllegalArgumentException();
		}
		this.metadata = metadata;
	}
	
	public Metadata getMetadata() {
		return metadata;
	}
	
	public Map<String ,ContentList> getContentLists() {
		return contentLists;
	}
	public ContentList getContentList(String name) {
		return contentLists.get(name);
	}


	public void publishOn(Content content) {
		published.add(content);
	}

	public List<Reference> getReferences() {
		return references;
	}

	public void addReference(Reference reference) {
		references.add(reference);
	}

	public List<Component> getComponents() {
		return components;
	}

	public void addComponent(Component component) {
		components.add(component);
	}

	@Override
	public String toString() {
		return "[Id: \"" + getMetadata().getExternalId() + "\"; "
				+ components.size() + " components, " + references.size()
				+ " references]";
	}

	public List<Content> getReferededContent() {
		return published;
	}

	@Override
	public Validable isValid(Validable  contentValidator) {
		return contentValidator;
	}

}
