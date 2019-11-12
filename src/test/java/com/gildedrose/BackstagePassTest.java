package com.gildedrose;

import com.gildedrose.item.CustomItem;
import com.gildedrose.item.CustomItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassTest {
    private CustomItemFactory factory;
    private GildedRose app;
    private CustomItem[] items;
    private String name = "Backstage passes to a TAFKAL80ETC concert";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 20;
        quality = 6;
        factory = new CustomItemFactory();
    }

    @Test
    void createBackstagePassProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].getName()).isEqualTo(name);
    }

    @Test
    void backstagePassShouldDecreaseSellInTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - 1);
    }

    @Test
    void backstagePassShouldDecreaseSellInAfterFewDaysTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = sellIn + 2;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - updateCount);
    }

    @Test
    void backstagePassShouldDecreaseSellInUnderZeroTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - updateCount);
    }

    @Test
    void backstagePassShouldIncreaseQualityTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + 1);
    }

    @Test
    void backstagePassShouldIncreaseQualityTwiceWhenSellInIsBelow10Test(){
        items = new CustomItem[] { factory.createCustomItem(name, 8, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + 2);
    }

    @Test
    void backstagePassShouldIncreaseQualityThriceWhenSellInIsBelow5Test(){
        items = new CustomItem[] { factory.createCustomItem(name, 4, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + 3);
    }

    @Test
    void backstagePassShouldNotIncreaseQualityAbove50Test(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, 49) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(50);
    }

    @Test
    void backstagePassShouldDecreaseTo0WhenSellInIs0Test(){
        items = new CustomItem[] { factory.createCustomItem(name, 1, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(0);
    }
}
