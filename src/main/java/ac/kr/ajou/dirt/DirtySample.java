package ac.kr.ajou.dirt;

public class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    //이름 구분을 Aged, Backstage, Sulfuras, Others로 한다.
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals("Aged Brie") && items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                Quality가50보다작으면_퀄리티1증가후_Backstage판단(items, i);
            }
            else {
                Quality가0보다크고_Sulfuras가아니라면_퀄리티1감소(items, i); //others라면
            }

            Sulfras가아니면_SellIn이1감소(items, i); //Aged or Backstage or others라면

            SellIn이_0이하라면(items, i);
        }
    }


    public static void Quality가0보다크고_Sulfuras가아니라면_퀄리티1감소(Item[] items, int count) {
        if (items[count].quality > 0 && !items[count].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[count].quality = items[count].quality - 1;
        }
    }


    public static void Quality가50보다작으면_퀄리티1증가후_Backstage판단(Item[] items, int count) {
        if (items[count].quality < 50) {
            items[count].quality = items[count].quality + 1;

            Backstage판단(items, count);
        }
    }

    public static void Backstage판단(Item[] items, int count) {
        if (items[count].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            Quality와SellIn에_따라_퀄리티1증가(items, count);
        }
    }

    public static void Quality와SellIn에_따라_퀄리티1증가(Item[] items, int count) {
        if (items[count].sellIn < 11 && items[count].quality < 50) {
            items[count].quality = items[count].quality + 1;
        }
        if (items[count].sellIn < 6 && items[count].quality < 50) {
            items[count].quality = items[count].quality + 1;
        }
    }

    public static void SellIn이_0이하라면(Item[] items, int count){
        if (items[count].sellIn < 0) {
            AgedBrie_인지아닌지(items, count);
        }
    }

    public static void AgedBrie_인지아닌지(Item[] items, int count) {
        if (!items[count].name.equals("Aged Brie")) {
            AgedBrie인지에따라_Quality변화(items, count);
        }
        else {
            Quality가50보다작으면_Quality1증가(items, count);
        }
    }

    public static void AgedBrie인지에따라_Quality변화(Item[] items, int count) {
        if (!items[count].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            Sulfras가아니고_Quality가0보다크면_Quality1감소(items, count);
        }
        else {
            items[count].quality = 0;
        }
    }

    public static void Sulfras가아니고_Quality가0보다크면_Quality1감소(Item[] items, int count){
        if (items[count].quality > 0 && !items[count].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[count].quality = items[count].quality - 1;
        }
    }

    public static void Quality가50보다작으면_Quality1증가(Item[] items, int count) {
        if (items[count].quality < 50) {
            items[count].quality = items[count].quality + 1;
        }
    }

    public static void Sulfras가아니면_SellIn이1감소(Item[] items, int count){
        if (!items[count].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[count].sellIn = items[count].sellIn - 1;
        }
    }


}