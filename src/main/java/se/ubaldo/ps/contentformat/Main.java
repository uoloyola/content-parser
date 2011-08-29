package se.ubaldo.ps.contentformat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import se.ubaldo.ps.contentformat.model.ErrorHandler;


public class Main {

	public static void main(String[] args) {

		
		ContentFormatParserClient parserClient = new ContentFormatParserClient();
		
		
		if (args.length == 0) {
			System.out.println("Arguments are needed");
			System.out.println("command contentfile");
			System.out.println("command contentfile generatexmlfile");
			System.exit(0);
		}

		if (args[0] != null) {
			
			try {
				File file = new File(args[0]);
				String name = file.getName();
			
				ContentSource source = new ContentSource(new FileInputStream(file), name);
				
				String xmlContent = parserClient.getXmlContent(source);
				
				System.out.println(xmlContent);
				
				
				ErrorHandler errorHandler = parserClient.getContentParser().getErrorHandler();
				
				if (errorHandler.hasError()) {
					System.err.println(errorHandler.sumarizeErrors());
				}
				
				
				
			} catch (FileNotFoundException e) {
				System.err.println("The file: "+ args[0] + " does not exist.");
				System.exit(0);
			} catch (ContentParserException e) {
				System.err.println(e.getMessage());
			}

		}

	}


}
