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
            }
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseOneItemQuality(item);
                if (item.sellIn < 11) {
                    increaseOneItemQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseOneItemQuality(item);
                }
            }
            else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            }
            else {
                decreaseOneItemQuality(item);
            }

            // invert 3
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
            // invert 3 end
            if (item.sellIn < 0) {
                // invert 4
                if (item.name.equals("Aged Brie")) {
                    // invert 5
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            // invert 6
                            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseOneItemQuality(item);
                            }
                            // invert 6 end
                        }
                    }
                    // invert 5 end
                    else {
                        item.quality = item.quality - item.quality;
                    }
                }
                // invert 4 end
                else {
                increaseOneItemQuality(item);
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