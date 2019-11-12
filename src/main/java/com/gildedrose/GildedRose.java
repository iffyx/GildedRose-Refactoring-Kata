package com.gildedrose;

import com.gildedrose.item.ItemFactory;
import com.gildedrose.item.DefaultItem;

class GildedRose {
    DefaultItem[] items;

    public GildedRose(Item[] items) {
        this.items = new DefaultItem[items.length];
        ItemFactory factory = new ItemFactory();
        for (int i = 0; i < items.length; i++) {
            this.items[i] = factory.createItem(items[i].name, items[i].sellIn, items[i].quality);
        }
    }

    public void updateQuality() {
        for (DefaultItem item : items) {
            item.updateQuality();
        }
    }
}