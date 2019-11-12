package com.gildedrose;

import com.gildedrose.item.CustomItem;
import com.gildedrose.item.CustomItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasTest {
    private CustomItemFactory factory;
    private GildedRose app;
    private CustomItem[] items;
    private String name = "Sulfuras, Hand of Ragnaros";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 4;
        quality = 6;
        factory = new CustomItemFactory();
    }

    @Test
    void createSulfurasProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].getName()).isEqualTo(name);
    }

    @Test
    void sulfurasShouldNotDecreaseSellInTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn);
    }

    @Test
    void sulfurasShouldNotDecreaseQualityTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality);
    }
}
