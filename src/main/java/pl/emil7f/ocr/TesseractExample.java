package pl.emil7f.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class TesseractExample {

    public static final String URL = "https://www.quotemaster.org/images/e1/e1ba0870fdf0d99388a599078a191f88.jpg";
    public static final String TESSDATA_FILES = "C:\\Users\\emilf\\IdeaProjects\\ocr\\src\\main\\resources\\tessdata";

    public static void main(String[] args) throws IOException {
        URL imageUrl = new URL(URL);
        BufferedImage bufferedImage = ImageIO.read(imageUrl);



        ITesseract instance = new Tesseract();
        instance.setDatapath(TESSDATA_FILES);
//        instance.setLanguage("pol");

        try {
            String result = instance.doOCR(bufferedImage);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}

