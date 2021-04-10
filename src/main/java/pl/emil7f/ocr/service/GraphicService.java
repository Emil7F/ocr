package pl.emil7f.ocr.service;

import org.springframework.stereotype.Service;
import pl.emil7f.ocr.model.Graphic;
import pl.emil7f.ocr.repository.GraphicRepository;

import java.util.List;

@Service
public class GraphicService {

    private final GraphicRepository graphicRepository;

    public GraphicService(GraphicRepository graphicRepository) {
        this.graphicRepository = graphicRepository;
    }


    public List<Graphic> findAllGraphics() {
        return graphicRepository.findAll();
    }

    public Graphic saveGraphic(Graphic graphic) {
        return graphicRepository.save(graphic);
    }
}
