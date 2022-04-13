package Application.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Store extends AbstractEntity {

    private final int id;
    private final String name;
    private final String location;
    private final Optional<List<Section>> storeSections;

    public Store(final int id, final String name, final String location,
                 final Optional<List<Section>> storeSections) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.storeSections = storeSections;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Optional<List<Section>> getStoreSections() {
        return storeSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return id == store.id &&
                Objects.equals(name, store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
