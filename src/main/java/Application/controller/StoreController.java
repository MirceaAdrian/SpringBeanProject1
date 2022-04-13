package Application.controller;

import Application.dto.StoreDTO;
import Application.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        path = "/store"
)
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(final StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Valid StoreDTO storeDTO) {
        storeService.create(storeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public StoreDTO getStore(@PathVariable final int id) {
        return storeService.get(id);
    }

    @GetMapping(
            path = "/byId/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StoreDTO> getStoreUsingResponseEntity(@PathVariable final int id) {
        return ResponseEntity.ok(storeService.get(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<StoreDTO> getAll() {
        return storeService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final int id, @RequestBody StoreDTO storeDTO) {
        storeService.update(id, storeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final int id) {
        storeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
