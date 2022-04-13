package Application.controller;

import Application.dto.SectionDTO;
import Application.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        path = "/section"
)
public class SectionController {

    private final SectionService sectionService;

    @Autowired
    public SectionController(final SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Valid SectionDTO sectionDTO) {
        sectionService.create(sectionDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SectionDTO getSection(@PathVariable final int id) {
        return sectionService.get(id);
    }

    @GetMapping(
            path = "/byId/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SectionDTO> getProductUsingResponseEntity(@PathVariable final int id) {
        return ResponseEntity.ok(sectionService.get(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<SectionDTO> getAll() {
        return sectionService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final int id, @RequestBody SectionDTO sectionDTO) {
        sectionService.update(id, sectionDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        sectionService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
