package se.ubaldo.ps.contentformat.linedContent;

public class Line {

	private String line;
	private int lineNumber;

	public Line(String line, int lineNumber) {
		if(line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.line = line;
		this.lineNumber = lineNumber;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}

	public String getLine() {
		return line;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		result = prime * result + lineNumber;
		return result;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + line + " " + lineNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		if (lineNumber != other.lineNumber)
			return false;
		return true;
	}
	
}