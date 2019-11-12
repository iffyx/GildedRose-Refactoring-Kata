package com.gildedrose;

import com.gildedrose.item.CustomItem;
import com.gildedrose.item.CustomItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConjuredItemTest {
    private CustomItemFactory factory;
    private GildedRose app;
    private CustomItem[] items;
    private String name = "Conjured Mana Cake";
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
    void agedBrieShouldDecreaseQualityProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality - 2);
    }

    @Test
    void agedBrieShouldIncreaseQualityAfterFewDaysProperlyTest(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, quality) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(quality - (2 *updateCount));
    }

    @Test
    void agedBrieShouldNotDecreaseQualityBelow0Test(){
        items = new CustomItem[] { factory.createCustomItem(name, sellIn, 1) };
        app = new GildedRose(items);
        int updateCount = 3;

        for(int i = 0; i < updateCount; i++)
            app.updateQuality();

        assertThat(app.items[0].getQuality()).isEqualTo(0);
    }
}
