package ac.kr.ajou.dirt;

public class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if(isSulfuras_HandOfRagnaros(items[i], "Sulfuras, Hand of Ragnaros"))
                continue;

            MinusItemSellIn(i);

            if (isAgedbrie(items[i], "Aged Brie")) {
                updateQualityWhenIsAgedbrie(i);
            }
            else if(isBackstagePassesToATAFKAL80ETCConcert(items[i], "Backstage passes to a TAFKAL80ETC concert")){
                updateQualityWhenIsBackstagePassesToATAFKAL80ETCConcert(i);
            }
            else{
                updateQualityWhenIsNeither(i);
            }

        }

    }


    private void updateQualityWhenIsNeither(int i) {
        if (items[i].quality > 0 ) {
            MinusItemQuality(i);
        }
        if (items[i].sellIn < 0 && items[i].quality > 0)
            MinusItemQuality(i);
    }

    private void updateQualityWhenIsBackstagePassesToATAFKAL80ETCConcert(int i) {
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

    private void updateQualityWhenIsAgedbrie(int i) {
        if (items[i].quality < 50) {
            PlusItemQuality(i);
        }
        if (items[i].sellIn < 0 && items[i].quality < 50)
            PlusItemQuality(i);
    }

    private boolean isBackstagePassesToATAFKAL80ETCConcert(Item item, String s) {
        return item.name.equals(s);
    }

    private boolean isSulfuras_HandOfRagnaros(Item item, String s) {
        return item.name.equals(s);
    }

    private boolean isAgedbrie(Item item, String s) {
        return item.name.equals(s);
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