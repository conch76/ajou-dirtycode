package ac.kr.ajou.dirt;

public class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    //이름 구분을 Aged, Backstage, Sulfuras, Others로 한다.
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if(items[i].name.equals("Sulfuras, Hand of Ragnaros")) //sulfuras
                continue;

            MinusItemSellIn(i);

            if ( items[i].name.equals("Aged Brie") ) { //aged
                if (items[i].quality < 50) {
                    PlusItemQuality(i);
                }
                if (items[i].sellIn < 0 && items[i].quality < 50)
                    PlusItemQuality(i);
            }
            else if( items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){ //backstage
                if (items[i].quality < 50) {
                    PlusItemQuality(i);
                    if (items[i].sellIn < 11 && items[i].quality < 50) {
                        PlusItemQuality(i);
                    }
                    if (items[i].sellIn < 6 && items[i].quality < 50) {
                        PlusItemQuality(i);
                    }
                }
                if (items[i].sellIn < 0)
                    items[i].quality = 0;
            }
            else{
                if (items[i].quality > 0 ) {
                    MinusItemQuality(i);
                }
                if (items[i].sellIn < 0 && items[i].quality > 0)
                    MinusItemQuality(i);
            } //first if

        }//for

    }

    private void MinusItemSellIn(int i) {
        items[i].sellIn = items[i].sellIn - 1;
    }

    private void MinusItemQuality(int i) {
        items[i].quality = items[i].quality - 1;
    }

    private void PlusItemQuality(int i) {
        items[i].quality = items[i].quality + 1;
    }


}