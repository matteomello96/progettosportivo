package Business;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;

public class pdfgen {


//	public static class DocumentsManager {

//		private static DocumentsManager instance;
//		
//		public static synchronized DocumentsManager getInstance() {
//			if(instance == null)
//				instance = new DocumentsManager();
//			return instance;
//		}
		
		public static void generaDocumento() {
			
			try {
				
				PDDocument document = new PDDocument();
				PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);
				document.addPage(page);
				
				PDPageContentStream cos = new PDPageContentStream(document, page);

				cos.beginText();
				cos.setFont(PDType1Font.HELVETICA, 12);
				cos.moveTextPositionByAmount(20, 810);
				cos.drawString("TESTO1");
				cos.setFont(PDType1Font.TIMES_BOLD, 10);
				cos.moveTextPositionByAmount(0, -15);
				cos.drawString("TESTO2");
				cos.endText();
				
				cos.close();
				
				document.save("c:\\DOCUMENTO.pdf");
				document.close();
			} catch (IOException | COSVisitorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}


