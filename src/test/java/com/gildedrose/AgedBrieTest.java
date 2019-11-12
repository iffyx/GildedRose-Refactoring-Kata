package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieTest {
    private GildedRose app;
    private Item[] items;
    private String name = "Aged Brie";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 4;
        quality = 6;
    }

    @Test
    void createAgedBrieProperlyTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].name).isEqualTo(name);
    }

    @Test
    void agedBrieShouldDecreaseSellInTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - 1);
    }

    @Test
    void agedBrieShouldDecreaseSellInAfterFewDaysTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = sellIn + 2;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void agedBrieShouldDecreaseSellInBelowZeroTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void agedBrieShouldIncreaseQualityTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + 1);
    }

    @Test
    void agedBrieShouldIncreaseQualityAfterFewDaysTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + updateCount);
    }

    @Test
    void agedBrieShouldNotIncreaseQualityAbove50Test(){
        items = new Item[] { new Item(name, sellIn, 49) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(50);
    }
}
