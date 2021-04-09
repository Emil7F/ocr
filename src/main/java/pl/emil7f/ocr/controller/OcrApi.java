package pl.emil7f.ocr.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.emil7f.ocr.model.Graphic;
import pl.emil7f.ocr.service.OcrService;

@RestController
public class OcrApi {

    private final OcrService ocrService;

    public OcrApi(OcrService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("api/ocr")
    public String doOcr(@RequestBody Graphic graphic) {

        String s = ocrService.doOcr(graphic.getUrl());
        return s;
    }
}
