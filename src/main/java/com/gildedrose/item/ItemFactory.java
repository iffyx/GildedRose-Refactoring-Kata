package com.gildedrose.item;

public class ItemFactory {
    public DefaultItem createItem(String type, int sellIn, int quality){
        switch(type){
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(type, sellIn, quality);
            case "Conjured Mana Cake":
                return new ConjuredItem(type, sellIn, quality);
            case "Aged Brie":
                return new AgedBrie(type, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(type, sellIn, quality);
            default:
                return new DefaultItem(type, sellIn, quality);
        }
    }
}
