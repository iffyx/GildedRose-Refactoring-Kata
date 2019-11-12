package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConjuredItemTest {
    private GildedRose app;
    private Item[] items;
    private String name = "Conjured Mana Cake";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 8;
        quality = 6;
    }

    @Test
    void createConjuredItemProperlyTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].name).isEqualTo(name);
    }

    @Test
    void conjuredItemShouldDecreaseSellInTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - 1);
    }

    @Test
    void conjuredItemShouldDecreaseSellInAfterFewDaysTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = sellIn + 2;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void conjuredItemShouldDecreaseSellInUnderZeroTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void conjuredItemShouldDecreaseQualityTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality - 2);
    }

    @Test
    void conjuredItemShouldIncreaseQualityAfterFewDaysTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality - (2 *updateCount));
    }

    @Test
    void conjuredItemShouldNotDecreaseQualityBelow0Test(){
        items = new Item[] { new Item(name, sellIn, 0) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
