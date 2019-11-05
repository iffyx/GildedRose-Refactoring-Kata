package com.gildedrose;

import com.gildedrose.item.CustomItem;

class GildedRose {
    CustomItem[] items;

    public GildedRose(CustomItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].updateQuality();
        }
    }
}