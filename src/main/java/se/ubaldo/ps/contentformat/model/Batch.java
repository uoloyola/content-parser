package se.ubaldo.ps.contentformat.model;

import java.util.ArrayList;
import java.util.List;

public class Batch {
	
	List<Processable> modelObjects = new ArrayList<Processable>();
	
	public void addContent(Content contentRepresentation) throws InvalidContentException {
		Validable contentValidator = new Validable() {
			
			@Override
			public Validable isValid(Validable contentValidators) {
				return contentValidators;
			}
		};
		contentRepresentation.isValid(contentValidator);
		modelObjects.add(contentRepresentation);
	}
	
	public int size() {
		return modelObjects.size();
	}
	
	public List<Processable> getContents() {
		return modelObjects;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Processable cr : modelObjects){
			sb.append(cr.toString());
		}
		return String.valueOf(modelObjects.size()) + sb.toString();
	}

}
