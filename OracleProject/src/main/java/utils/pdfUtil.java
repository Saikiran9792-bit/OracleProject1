package utils;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class pdfUtil {

	public static void createPDF(String imageFolder, String pdfName) throws Exception {

	    File folder = new File(imageFolder);
	    File[] files = folder.listFiles();

	    PDDocument document = new PDDocument();

	    for (File file : files) {

	        if (file.getName().endsWith(".png")) {

	            PDPage page = new PDPage();
	            document.addPage(page);

	            PDImageXObject image = PDImageXObject.createFromFile(file.getAbsolutePath(), document);

	            PDPageContentStream content = new PDPageContentStream(document, page);
	            content.drawImage(image, 20, 300);
	            content.close();
	        }
	    }

	    document.save(pdfName);
	    document.close();
	}
}
