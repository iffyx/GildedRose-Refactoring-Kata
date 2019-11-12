package com.gildedrose.item;

public class ConjuredItem extends DefaultItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void changeQuality(){
        quality -= 2;
        checkQualityRange();
    }
}
