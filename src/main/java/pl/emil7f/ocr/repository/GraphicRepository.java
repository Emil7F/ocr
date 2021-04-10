package pl.emil7f.ocr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emil7f.ocr.model.Graphic;

@Repository
public interface GraphicRepository extends JpaRepository<Graphic, Long> {
}
