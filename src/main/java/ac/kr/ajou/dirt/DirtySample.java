package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (Items_ExceptFor_AgedBrie_And_BackstagePasses(items[i])) {
                if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                    items[i].quality = items[i].quality - 1;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

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
                }
            }

            Handle_item_ExceptFor_Sulfuras(items[i]);

            if (items[i].sellIn < 0) {
                Handle_item_Sell_In_is_insufficent(items[i]);
            }
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