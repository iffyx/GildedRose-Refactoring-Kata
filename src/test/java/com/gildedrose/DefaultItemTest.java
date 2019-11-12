package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultItemTest {
    private GildedRose app;
    private Item[] items;
    private String name = "+5 Dexterity Vest";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 20;
        quality = 6;
    }

    @Test
    void createDefaultItemProperlyTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].name).isEqualTo(name);
    }

    @Test
    void defaultItemShouldDecreaseSellInTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - 1);
    }

    @Test
    void defaultItemShouldDecreaseSellInAfterFewDaysTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = sellIn + 2;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void defaultItemShouldDecreaseSellInUnderZeroTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void defaultItemShouldDecreaseQualityTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality - 1);
    }

    @Test
    void defaultItemShouldDecreaseQualityTwiceWhenSellInIsBelow0Test(){
        items = new Item[] { new Item(name, 0, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality - 2);
    }

    @Test
    void defaultItemShouldNotDecreaseQualityBelow0Test(){
        items = new Item[] { new Item(name, sellIn, 1) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
