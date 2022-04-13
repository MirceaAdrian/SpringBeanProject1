package Application.dto;

import Application.model.Section;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class StoreDTO implements Serializable {

    private int id;

    private Optional<List<Section>> sections;

    private String storeName,location;

    public StoreDTO() {}

    public StoreDTO(final int id, final String name, final String location, final Optional<List<Section>>sections) {
        this.id = id; this.storeName = name; this.location = location; this.sections = sections;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Optional<List<Section>> getStoreSections() {
        return sections;
    }

    public void setStoreSections(Optional<List<Section>> sections){this.sections = sections;}

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String name) {
        storeName = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreDTO)) return false;
        StoreDTO that = (StoreDTO) o;
        return id == that.id &&
                Objects.equals(storeName, that.storeName) &&
                Objects.equals(location,that.location) &&
                Objects.equals(sections,that.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeName,location,sections);
    }
}
