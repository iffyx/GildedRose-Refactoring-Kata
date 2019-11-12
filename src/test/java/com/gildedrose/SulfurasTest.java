package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasTest {
    private GildedRose app;
    private Item[] items;
    private String name = "Sulfuras, Hand of Ragnaros";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 4;
        quality = 6;
    }

    @Test
    void createSulfurasProperlyTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].name).isEqualTo(name);
    }

    @Test
    void sulfurasShouldNotDecreaseSellInTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn);
    }

    @Test
    void sulfurasShouldNotDecreaseQualityTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality);
    }
}
