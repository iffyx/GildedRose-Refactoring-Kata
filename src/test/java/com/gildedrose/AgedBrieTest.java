package com.gildedrose;

import com.gildedrose.item.CustomItem;
import com.gildedrose.item.CustomItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieTest {
    private CustomItemFactory factory;
    private GildedRose app;
    private CustomItem[] items;
    private String name = "Aged Brie";
    private int sellIn;
    private int quality;

    @BeforeEach
    void setUp(){
        sellIn = 4;
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
    void agedBrieShouldDecreaseSellInTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - 1);
    }

    @Test
    void agedBrieShouldDecreaseSellInAfterFewDaysTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = sellIn + 2;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - updateCount);
    }

    @Test
    void agedBrieShouldDecreaseSellInBelowZeroTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getSellIn()).isEqualTo(sellIn - updateCount);
    }

    @Test
    void agedBrieShouldIncreaseQualityTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + 1);
    }

    @Test
    void agedBrieShouldIncreaseQualityAfterFewDaysTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality + updateCount);
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
}
