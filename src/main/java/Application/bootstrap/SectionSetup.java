package Application.bootstrap;

import Application.model.Section;
import Application.model.StoreSection;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SectionSetup {
    private static final List<Section> sections;
    static{sections = buildSections();}

    public static List<Section> buildSections() {
        return Arrays.asList(
                new Section(1, StoreSection.Laptops, Optional.ofNullable(ProductsSetup.getLaptops())),
                new Section(2,StoreSection.Tablets, Optional.ofNullable(ProductsSetup.getTablets())) ,
                new Section(3,StoreSection.Monitors, Optional.ofNullable(ProductsSetup.getMonitors())));

    }
}




