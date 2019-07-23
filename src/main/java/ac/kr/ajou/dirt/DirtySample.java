package ac.kr.ajou.dirt;

public class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    //이름 구분을 Aged, Backstage, Sulfuras, Others로 한다.
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].quality = items[i].quality - 1;
                }
            }
            else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            } //first if

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            } //second if

            if (items[i].sellIn < 0) {
               if(items[i].name.equals("Aged Brie")){ //aged일때
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
                else{
                    if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { //backstage
                        items[i].quality = 0;
                    }
                    else { //sulfuras or others
                        if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                }

            } //third if

        }//for

    }


    public static void Quality가0보다크고_Sulfuras가아니라면_퀄리티1감소(Item[] items, int count) {
       
    }


    public static void Quality가50보다작으면_퀄리티1증가후_Backstage판단(Item[] items, int count) {
       
    }

    public static void Backstage판단(Item[] items, int count) {
       
    }

    public static void Quality와SellIn에_따라_퀄리티1증가(Item[] items, int count) {
       
    }

    public static void SellIn이_0이하라면(Item[] items, int count){
        
    }

    public static void AgedBrie_인지아닌지(Item[] items, int count) {
       
    }

    public static void AgedBrie인지에따라_Quality변화(Item[] items, int count) {
        
    }

    public static void Sulfras가아니고_Quality가0보다크면_Quality1감소(Item[] items, int count){
       
    }

    public static void Quality가50보다작으면_Quality1증가(Item[] items, int count) {
       
    }

    public static void Sulfras가아니면_SellIn이1감소(Item[] items, int count){
        
    }


}