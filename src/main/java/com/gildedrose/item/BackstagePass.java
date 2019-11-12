package com.gildedrose.item;

public class BackstagePass extends DefaultItem{
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void changeQuality(){
        if(sellIn <= 0)
            quality = 0;
        else if(sellIn <= 5)
            quality += 3;
        else if(sellIn <= 10)
            quality += 2;
        else
            quality++;
        checkQualityRange();
    }
}
