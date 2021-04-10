package pl.emil7f.ocr.controller;

import org.springframework.web.bind.annotation.*;
import pl.emil7f.ocr.model.Graphic;
import pl.emil7f.ocr.service.GraphicService;
import pl.emil7f.ocr.service.OcrService;

import java.util.List;

@RestController
@RequestMapping("api/ocr")
public class OcrApi {

    private final OcrService ocrService;
    private final GraphicService graphicService;

    public OcrApi(OcrService ocrService, GraphicService graphicService) {
        this.ocrService = ocrService;
        this.graphicService = graphicService;
    }

    @PostMapping
    public String doOcr(@RequestBody Graphic graphic) {
        String contentFromLink = ocrService.doOcr(graphic.getUrl());
        graphic.setContent(contentFromLink);
        graphicService.saveGraphic(graphic);
        return contentFromLink;
    }

    @GetMapping
    public List<Graphic> getGraphic() {
        return graphicService.findAllGraphics();
    }
}
