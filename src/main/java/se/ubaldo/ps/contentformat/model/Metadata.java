package se.ubaldo.ps.contentformat.model;

public class Metadata implements Validable {
	
	private ExternalId externalId;
	private String major;
	private ExternalId inputtemplate;
	private ExternalId securityParentObject;
	
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public ExternalId getExternalId() {
		return externalId;
	}
	
	public boolean isEmpty() {
		boolean isEmpty = true;
		ExternalId externalId2 = getExternalId();
		String major2 = getMajor();
		ExternalId inputtemplate2 = getInputtemplate();
		ExternalId securityParent2 = getSecurityParent();
		
		if(externalId2 != null && !externalId2.isEmpty()) {
			return false;
		}
		if(major2 != null && !major2.isEmpty()) {
			return false;
		}
		if(inputtemplate2 != null && !inputtemplate2.isEmpty()) {
			return false;
		}
		if(major2 != null && !major2.isEmpty()) {
			return false;
		}
		if(securityParent2 != null && !securityParent2.isEmpty()) {
			return false;
		}

		
		return isEmpty;
	}
	
	public void setExternalId(ExternalId externalId) throws OperationInvalidException {
		if(externalId == null) {
			new IllegalArgumentException();
		}
		if(this.externalId != null) {
			throw new OperationInvalidException(" Already declared as:" + this.externalId);
		}
		this.externalId = externalId;
	}

	public void setInputtemplate(ExternalId inputtemplate) {
		this.inputtemplate = inputtemplate;
	}

	public void setSecurityParent(ExternalId securityParent) {
		this.securityParentObject = securityParent;
	}

	public ExternalId getInputtemplate() {
		return inputtemplate;
	}
	public ExternalId getSecurityParent() {
		return securityParentObject;
	}
	
	public boolean isMetadata(String line) {
		return true;
	}

	@Override
	public String toString() {
		return "["+this.getClass().getSimpleName()+ " major:" + getMajor()+" id:"+getExternalId().getExternalIdString()+" ]";
	}

	@Override
	public Validable isValid(Validable contentValidators) {
		return null;
	}

}
