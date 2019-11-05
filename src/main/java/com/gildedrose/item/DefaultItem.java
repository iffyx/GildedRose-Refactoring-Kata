package com.gildedrose.item;

import com.gildedrose.Item;

public class DefaultItem extends Item implements CustomItem {
    private static final int MAX_VALUE = 50;
    private static final int MIN_VALUE = 0;

    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        if(quality < MAX_VALUE && quality >= MIN_VALUE)
            decreaseQuality();
        if(sellIn < 0)
            decreaseQuality();

        checkQualityRange();
    }

    protected void checkQualityRange(){
        if(quality < MIN_VALUE)
            quality = 0;
        else if(quality > MAX_VALUE)
            quality =  50;
    }

    protected void decreaseSellIn(){
        sellIn--;
    }

    protected void decreaseQuality(){
        quality--;
    }
}
