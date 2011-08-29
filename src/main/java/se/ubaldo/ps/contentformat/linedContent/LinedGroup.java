package se.ubaldo.ps.contentformat.linedContent;

import java.util.ArrayList;
import java.util.List;

public class LinedGroup {
	
	private List<Line> group = new ArrayList<Line>();

	public void  addLine(Line line) {
		group.add(line);
	}
	
	public List<Line> getLines() {
		return group;
	}
}
