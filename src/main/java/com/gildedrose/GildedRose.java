package com.gildedrose;

import com.gildedrose.item.CustomItem;

class GildedRose {
    CustomItem[] items;

    public GildedRose(CustomItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (CustomItem item : items) {
            item.updateQuality();
        }
    }
}