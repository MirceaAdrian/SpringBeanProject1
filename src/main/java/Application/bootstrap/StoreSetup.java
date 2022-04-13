package Application.bootstrap;

import Application.model.Store;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StoreSetup {
    private static final List<Store> stores;
    static{stores = buildStores();}

    public static List<Store> buildStores() {
        return Arrays.asList(
                new Store(1, "Peny", "Sydney", Optional.of(SectionSetup.buildSections())),
                new Store(2, "Flanco", "Lugoj",  Optional.of(SectionSetup.buildSections())));
    }

}




