package se.ubaldo.ps.contentformat.linedContent;

public class NewContentDetector {

	boolean isNew;
	boolean newIscommin;
	boolean initial = true;

	public boolean isNewBlock(String line) {
		if (initial) {
			initial = false;
			return true;
		} else {
			if (line.length() == 0) {
				newIscommin = true;
				isNew = false;
			} else if(newIscommin) {
				newIscommin = false;
				return true;
			}
			return isNew;
		}
	}

	public void end() {
		initial = false;
	}

}
