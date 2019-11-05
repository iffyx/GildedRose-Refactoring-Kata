package com.gildedrose.item;

public class AgedBrie extends DefaultItem {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void decreaseQuality(){
        quality++;
        checkQualityRange();
    }
}
