package Application.repository;

import Application.bootstrap.SectionSetup;
import Application.model.Section;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class SectionRepository{

        private final List<Section> sections = SectionSetup.buildSections();

        @PostConstruct
        public void init() {
        }

        @SuppressWarnings("unused")
        public Section get(int id) {
            return sections.stream().filter(new Predicate<Section>() {
                @Override
                public boolean test(Section section) {
                    return section.getId() == id;
                }
            }).findFirst().get();
        }


        public List<Section> getAll() {
            return sections;
        }

        public void create(final Section section) {
            sections.add(section);
        }

        public void update(final int id, final Section section) {
            sections.add(section);
        }

        public void delete(final int id) {
            sections.remove(id < sections.size() ? id : 0);
        }


        public Section getBySectionId(int sectionId) {
            return get(sectionId);
        }
}
