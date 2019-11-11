package com.gildedrose;

import com.gildedrose.item.CustomItem;
import com.gildedrose.item.CustomItemFactory;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        CustomItemFactory factory = new CustomItemFactory();

        CustomItem[] items = new CustomItem[] {
                factory.createCustomItem("+5 Dexterity Vest", 10, 20), //
                factory.createCustomItem("Aged Brie", 2, 0), //
                factory.createCustomItem("Elixir of the Mongoose", 5, 7), //
                factory.createCustomItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                factory.createCustomItem("Sulfuras, Hand of Ragnaros", -1, 80),
                factory.createCustomItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                factory.createCustomItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                factory.createCustomItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                factory.createCustomItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 5;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (CustomItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
