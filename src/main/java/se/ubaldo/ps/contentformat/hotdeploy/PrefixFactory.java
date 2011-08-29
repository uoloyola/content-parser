package se.ubaldo.ps.contentformat.hotdeploy;


class PrefixFactory {
	
	public Prefix discover(String line) {
		if(line.length() == 0) {
			throw new IllegalArgumentException("The line can not be empty");
		}
		
		if(line.startsWith("#")){
			return Prefix.COMMENT;
		}
		
		String[] split = line.split(":");
		
		for (Prefix prefix: Prefix.values()) {
			if(prefix.toString().toLowerCase().equals(split[0])){
				return prefix;
			}
		}
		throw new IllegalArgumentException("Not prefix could be calculated");
	}
}
