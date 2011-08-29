package se.ubaldo.ps.contentformat.model;

import java.security.InvalidParameterException;

public class ExternalId {
	
	String major;
	String externalId;
	
	
	public ExternalId(String major, String externalIdString) {
		if( externalIdString == null) {
			throw new InvalidParameterException();
		}
		this.major = major;
		this.externalId = externalIdString;
	}
	
	public String getMajor() {
		return major;
	}

	public String getExternalIdString() {
		return externalId;
	}
	
	boolean isEmpty(){
		if(major.isEmpty() || externalId.isEmpty()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return externalId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((externalId == null) ? 0 : externalId.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExternalId other = (ExternalId) obj;
		if (externalId == null) {
			if (other.externalId != null)
				return false;
		} else if (!externalId.equals(other.externalId))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		return true;
	}
	

}
