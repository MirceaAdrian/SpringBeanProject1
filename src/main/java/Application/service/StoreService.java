package Application.service;

import Application.dto.StoreDTO;
import Application.model.Store;
import Application.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(final StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void create(final StoreDTO storeDTO) {
        storeRepository.create(getDTOConverter().apply(storeDTO));
    }

    public StoreDTO get(final int id) {
        final Store store =
                Optional.ofNullable(storeRepository.get(id))
                        .orElseThrow(() -> new IllegalArgumentException("There is no section with the id " + id));

        return getStoreConverter().apply(store);
    }

    public StoreDTO getByStoreId(final int storeId) {
        Store store = storeRepository.getByStoreId(storeId);
        return new StoreDTO(store.getId(), store.getName(),store.getLocation(),store.getStoreSections());
    }

    public List<StoreDTO> getAll() {
        return storeRepository.getAll()
                                .parallelStream()
                                .map(getStoreConverter())
                                .collect(Collectors.toList());
    }

    public void update(final int id, final StoreDTO storeDTO) {
        storeRepository.update(id, getDTOConverter().apply(storeDTO));
    }

    public void delete(final int id) {
        storeRepository.delete(id);
    }

    private Function<StoreDTO, Store> getDTOConverter() {
        return dto -> new Store(dto.getId(), dto.getStoreName(),dto.getLocation(),dto.getStoreSections());
    }

    private Function<Store, StoreDTO> getStoreConverter() {
        return store -> new StoreDTO(store.getId(), store.getName(),store.getLocation(),store.getStoreSections());
    }

}
