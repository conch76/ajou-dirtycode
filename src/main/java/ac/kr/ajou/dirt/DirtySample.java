package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            // invert 1
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    increaseItemQuality(item);
                }
                if (item.quality > 0) {
                    // invert 2
                    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseItemQuality(item);
                    }
                    // invert 2 end
                }
            }
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    increaseItemQuality(item);
                }
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        increaseItemQuality(item);
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        increaseItemQuality(item);
                    }
                }
                if (item.quality > 0) {
                    // invert 2
                    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseItemQuality(item);
                    }
                    // invert 2 end
                }
            }
            // invert 1 end
            else {

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
                        if (item.quality > 0) {
                            // invert 6
                            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseItemQuality(item);
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
                    if (item.quality < 50) {
                        increaseItemQuality(item);
                    }
                }
            }
        }
    }

    private void increaseItemQuality(Item item) {
        item.quality += 1;
    }

    private void decreaseItemQuality(Item item) {
        item.quality -= 1;
    }
}