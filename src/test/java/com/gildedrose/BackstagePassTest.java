package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassTest {
    private GildedRose app;
    private Item[] items;
    private String name = "Backstage passes to a TAFKAL80ETC concert";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 20;
        quality = 6;
    }

    @Test
    void createBackstagePassProperlyTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].name).isEqualTo(name);
    }

    @Test
    void backstagePassShouldDecreaseSellInTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - 1);
    }

    @Test
    void backstagePassShouldDecreaseSellInAfterFewDaysTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = sellIn + 2;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void backstagePassShouldDecreaseSellInUnderZeroTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - updateCount);
    }

    @Test
    void backstagePassShouldIncreaseQualityTest(){
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + 1);
    }

    @Test
    void backstagePassShouldIncreaseQualityTwiceWhenSellInIsBelow10Test(){
        items = new Item[] { new Item(name, 8, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + 2);
    }

    @Test
    void backstagePassShouldIncreaseQualityThriceWhenSellInIsBelow5Test(){
        items = new Item[] { new Item(name, 4, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + 3);
    }

    @Test
    void backstagePassShouldNotIncreaseQualityAbove50Test(){
        items = new Item[] { new Item(name, sellIn, 49) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void backstagePassShouldDecreaseTo0WhenSellInIs0Test(){
        items = new Item[] { new Item(name, 0, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
