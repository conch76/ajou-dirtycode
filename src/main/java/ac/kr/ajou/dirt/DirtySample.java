package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (Items_ExceptFor_AgedBrie_And_BackstagePasses(items[i])) {
                Handle_item_ExceptFor_Sulfuras(items[i]);
            }
            else {
                Handle_Items_AgedBrie_And_BackstagePasses(items[i]);
            }

            Handle_item_ExceptFor_Sulfuras(items[i]);

            if (items[i].sellIn < 0) {
                Handle_item_Sell_In_is_insufficent(items[i]);
            }
        }
    }

    private void Handle_Items_AgedBrie_And_BackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                Handle_Items_By_Sell_In_And_Quality(item);
            }
        }
    }

    private void Handle_Items_By_Sell_In_And_Quality(Item item) {
        if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
        }

        if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
        }
    }

    private void Handle_item_ExceptFor_Sulfuras(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void Handle_item_Sell_In_is_insufficent(Item item) {
        if (item.name != "Aged Brie") {
            Handle_Item_ExceptFor_AgedBrie(item);
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void Handle_Item_ExceptFor_AgedBrie(Item item) {
        if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
            Handle_item_ExceptFor_Sulfuras(item);
        } else {
            item.quality = item.quality - item.quality;
        }
    }


    private boolean Items_ExceptFor_AgedBrie_And_BackstagePasses(Item item) {
        return !item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}