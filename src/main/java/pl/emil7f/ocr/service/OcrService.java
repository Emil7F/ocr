package pl.emil7f.ocr.service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Service
public class OcrService {

    private static final Logger logger = LogManager.getLogger(OcrService.class);
    public static final String URL_TO_TEST = "https://www.quotemaster.org/images/e1/e1ba0870fdf0d99388a599078a191f88.jpg";
    // should return string: NOTALL WHO WANDER ARE LOST.  -lollien

    public static final String TESSDATA_FILES = "C:\\Users\\emilf\\IdeaProjects\\ocr\\src\\main\\resources\\tessdata";

    public String doOcr(String url) {
        URL imageUrl = null;
        BufferedImage bufferedImage = null;
        try {
            imageUrl = new URL(url);
            bufferedImage = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Problem with URL or ImageIO reader");
        }

        ITesseract instance = new Tesseract();
        instance.setDatapath(TESSDATA_FILES);
//        instance.setLanguage("pol");

        try {
            String result = instance.doOCR(bufferedImage);
            return result;
        } catch (TesseractException e) {
            e.printStackTrace();
            logger.error("Problem with Tesseract");
        }

        return "There is some problem with OCR";
    }
}

