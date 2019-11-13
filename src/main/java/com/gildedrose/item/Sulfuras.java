package com.gildedrose.item;

public class Sulfuras extends DefaultItem {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        //nothing changes
    }
}
