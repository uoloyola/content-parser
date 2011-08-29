package se.ubaldo.ps.contentformat.linedContent;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import se.ubaldo.ps.contentformat.ContentSource;


public class SourceContentIterator implements Iterator<Line> {

	BufferedReader br;
	private String next;
	private int currentlineNumber;
	private boolean isOpen = true;

	SourceContentIterator(ContentSource source) {
		br = new BufferedReader(new InputStreamReader(new DataInputStream(source.getInputStream())));
		currentlineNumber = 1;
	}

	@Override
	public boolean hasNext() {
		try {
			if (isOpen) {
				next = br.readLine();
			} else {
				return false;
			}

		} catch (IOException e) {
			return false;
		}
		if (next == null) {
			try {
				isOpen = false;
				br.close();
			} catch (IOException e) {
				return false;
			}
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Line next() {
		return new Line(next, currentlineNumber++);
	}

	@Override
	public void remove() {
		throw new RuntimeErrorException(new Error(), "operation not supported");
	}

}
