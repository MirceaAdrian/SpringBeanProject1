package Application.service;

import Application.dto.SectionDTO;
import Application.model.Product;
import Application.model.Section;
import Application.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(final SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public void create(final SectionDTO sectionDTO) {
        sectionRepository.create(getDTOConverter().apply(sectionDTO));
    }

    public SectionDTO get(final int id) {
        final Section section =
                Optional.ofNullable(sectionRepository.get(id))
                        .orElseThrow(() -> new IllegalArgumentException("There is no section with the id " + id));

        return getSectionConverter().apply(section);
    }

    public SectionDTO getBySectionId(final int sectionId) {
        Section section = sectionRepository.getBySectionId(sectionId);
        return new SectionDTO(section.getId(), section.getStoreSection(),section.getProducts());
    }

    public List<SectionDTO> getAll() {
        return sectionRepository.getAll()
                                .parallelStream()
                                .map(getSectionConverter())
                                .collect(Collectors.toList());
    }

    public void update(final int id, final SectionDTO sectionDTO) {
        sectionRepository.update(id, getDTOConverter().apply(sectionDTO));
    }

    public void delete(final int id) {
        sectionRepository.delete(id);
    }

    private Function<SectionDTO, Section> getDTOConverter() {
        return dto -> new Section(dto.getId(), dto.getStoreSection(),dto.getProducts());
    }

    private Function<Section, SectionDTO> getSectionConverter() {
        return section -> new SectionDTO(section.getId(), section.getStoreSection(),section.getProducts());
    }

    private Predicate<Product> filterItem() {
        return product -> product.getName().isEmpty() || product.getId() > 20;
    }
}
