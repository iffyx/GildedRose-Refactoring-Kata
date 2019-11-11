package com.gildedrose;

import com.gildedrose.item.CustomItem;
import com.gildedrose.item.CustomItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AgedBrieTest {
    private CustomItemFactory factory;
    private GildedRose app;
    private CustomItem[] items;
    private String name = "Aged brie";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 4;
        quality = 6;
        factory = new CustomItemFactory();
    }

    @Test
    void createAgedBrieProperly(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].getName()).isEqualTo(name);
    }
}
