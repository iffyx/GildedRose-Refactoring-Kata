1.Stworzenie interfejsu CustomItem zawierającego metodę void updateQuality()
2.Utworzenie klasy DefaultItem oraz zdefiniowanie działania zwykłego przedmiotu:
```
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
```
3.Usunięcie fragmentów
```
if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    items[i].quality = items[i].quality - 1;
}
```
oraz 
```
if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    items[i].sellIn = items[i].sellIn - 1;
}
```
oraz stworzenie klasy Sulfuras dziedziczącą po DefaultItem z nadpisaną metodą
```
@Override
public void updateQuality(){

}
```
4.Usunięcie fragmentu
``` 
if(items[i].name.equals("Conjured Mana Cake")){
        items[i].quality--;
}
```
oraz stworzenie klasy ConjuredItem dziedzicząca po DefaultItem z nadpisaną metodą
```
@Override
public void decreaseQuality(){
    quality -= 2;
    checkQualityRange();
}
```
5.Usunięcie fragmentu
```
if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    if (items[i].sellIn < 11) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

    if (items[i].sellIn < 6) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }
}
```
oraz stworzenie klasy BackstagePass dziedziączące po DefaultItem z nadpisaną metodą
```
@Override
public void decreaseQuality(){
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
```
