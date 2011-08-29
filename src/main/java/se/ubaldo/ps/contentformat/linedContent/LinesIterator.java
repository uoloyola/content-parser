package se.ubaldo.ps.contentformat.linedContent;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import se.ubaldo.ps.contentformat.ContentParserException;
import se.ubaldo.ps.contentformat.ContentSource;


public class LinesIterator  {

	private final LineReadListener listener;
	private int lineNummber = 1;

	public LinesIterator(LineReadListener listener) {
		this.listener = listener;
	}

	public final void processSource(ContentSource source)
			throws ContentParserException {
		DataInputStream in;
		in = new DataInputStream(source.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine = "";
		try {
			while ((strLine = br.readLine()) != null) {
				useListener(listener, strLine, source.getPrefix(), source,lineNummber++);
			}
		} catch (IOException e) {
			throw new ContentParserException(e.getMessage(), strLine, source, lineNummber);
		} catch (SyntaxEcxeption e) {
			throw new ContentParserException(e.getMessage(), strLine, source, lineNummber);
		}

		try {
			in.close();
		} catch (IOException e) {
			throw new ContentParserException(e.getMessage(), strLine, source, lineNummber);
		}
	}

	private void useListener(LineReadListener listener, String line,
			String prefix, ContentSource source, int lineNumber) throws ContentParserException {
		listener.readLine(line,  source);
	}

}
