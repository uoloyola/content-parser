package se.ubaldo.ps.contentformat.model;

public interface Validable {
	
	Validable isValid(Validable contentValidators);
	
}
