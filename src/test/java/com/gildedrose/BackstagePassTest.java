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
    void createAgedBrieProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        assertThat(app.items[0].getName()).isEqualTo(name);
    }

    @Test
    void agedBrieShouldDecreaseSellInProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - 1);
    }

    @Test
    void agedBrieShouldDecreaseSellInAfterFewDaysProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = sellIn + 2;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - updateCount);
    }

    @Test
    void agedBrieShouldDecreaseSellInUnderZeroProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - updateCount);
    }

    @Test
    void agedBrieShouldIncreaseQualityProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + 1);
    }

    @Test
    void agedBrieShouldIncreaseQualityTwiceWhenSellInIsBelow10ProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, 8, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + 2);
    }

    @Test
    void agedBrieShouldIncreaseQualityThriceWhenSellInIsBelow5ProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, 4, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + 3);
    }

    @Test
    void agedBrieShouldNotIncreaseQualityAbove50Test(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, 49) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(50);
    }

    @Test
    void agedBrieShouldDecreaseTo0WhenSellInIs0ProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, 1, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(0);
    }
}
