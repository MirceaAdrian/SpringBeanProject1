package Application.repository;

import Application.bootstrap.StoreSetup;
import Application.model.Store;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class StoreRepository {

        private final List<Store> stores = StoreSetup.buildStores();

        @PostConstruct
        public void init() {
        }

        @SuppressWarnings("unused")
        public Store get(int id) {
            return stores.stream().filter(new Predicate<Store>() {
                @Override
                public boolean test(Store store) {
                    return store.getId() == id;
                }
            }).findFirst().get();
        }


        public List<Store> getAll() {
            return stores;
        }

        public void create(final Store store) {
            stores.add(store);
        }

        public void update(final int id, final Store store) {
            stores.add(store);
        }

        public void delete(final int id) {
            stores.remove(id < stores.size() ? id : 0);
        }


        public Store getByStoreId(int storeId) {
            return get(storeId);
        }
}
