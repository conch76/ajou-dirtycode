package ac.kr.ajou.dirt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (IfNameIsNotAgedBrieAndBackstage(item)) {
                DoIfQualityIsPositiveAndNameIsNotSulfuras(item);
            } else DoIfNameIsBackstageOrAged(item);
            ReduceSellInOneIfNameIsNotSulfuras(item);
            DoIfSellInIsNegative(item);
        }
    }


    private void DoIfSellInIsNegative(Item item) {
        if(item.sellIn<0){
            if (IfNameIsNotAgedBrieAndBackstage(item)) {
                DoIfQualityIsPositiveAndNameIsNotSulfuras(item);
            }
            else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                item.quality=0;
            }
            else if(item.name.equals("Aged Brie")){
                if(item.quality<50) {
                    item.quality++;
                }
            }
        }
    }

    private void ReduceSellInOneIfNameIsNotSulfuras(Item item) {
        if(!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn=item.sellIn-1;
        }
    }



    private void DoIfNameIsBackstageOrAged(Item item) {
        if(item.quality<50){
            item.quality++;
            if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 6) item.quality = item.quality + 2;
                else if (item.sellIn < 11) item.quality = item.quality + 1;
            }
        }
    }

    private void DoIfQualityIsPositiveAndNameIsNotSulfuras(Item item) {
        if(item.quality>0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }

    private boolean IfNameIsNotAgedBrieAndBackstage(Item item) {
        return (!item.name.equals("Aged Brie") &&
                !item.name.equals("Backstage passes to a TAFKAL80ETC concert"));
    }
}