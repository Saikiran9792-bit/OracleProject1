package utils;

import java.awt.Color;
import java.io.File;
import java.util.Arrays;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class pdfUtil {

	public static void generatePDF(String imageFolderPath, String outputPDFPath) throws Exception {

		File folder = new File(imageFolderPath);
		File[] files = folder.listFiles();

		Arrays.sort(files);

		PDDocument document = new PDDocument();

		for (File file : files) {

			if (file.getName().endsWith(".png")) {
//	        	 BufferedImage bufferedImage = ImageIO.read(file);

				PDPage page = new PDPage();
				document.addPage(page);

				PDImageXObject image = PDImageXObject.createFromFile(file.getAbsolutePath(), document);

				PDPageContentStream content = new PDPageContentStream(document, page);

				float pageWidth = page.getMediaBox().getWidth();
				float pageHeight = page.getMediaBox().getHeight();

				// ---------- TEXT (PROMPTS) ----------
				content.beginText();
				content.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
				content.newLineAtOffset(50, pageHeight - 50);

				content.endText();
				// Reset color
				content.setNonStrokingColor(Color.BLACK);

				// ---------- IMAGE ----------

				float imgWidth = image.getWidth();
				float imgHeight = image.getHeight();

				// Calculate scale factor (VERY IMPORTANT)
				float scale = Math.min(pageWidth / imgWidth, pageHeight / imgHeight);

				// New scaled dimensions
				float scaledWidth = imgWidth * scale;
				float scaledHeight = imgHeight * scale;

				// Center the image
				float x = (pageWidth - scaledWidth) / 2;
				float y = (pageHeight - scaledHeight) / 2;

				// FINAL DRAW
				content.drawImage(image, x, y, scaledWidth, scaledHeight);
				content.close();
			}
		}
		document.save(outputPDFPath);
		document.close();
	}
}
