package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                increaseOneItemQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseOneItemQuality(item);
                if (item.sellIn < 11) {
                    increaseOneItemQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseOneItemQuality(item);
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                decreaseOneItemQuality(item);
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private void increaseOneItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decreaseOneItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}