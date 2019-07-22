package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn -= 1;
            }

            if (item.name.equals("Aged Brie")) {
                increaseOneItemQuality(item);
                if (item.sellIn < 0) {
                    increaseOneItemQuality(item);
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseOneItemQuality(item);
                if (item.sellIn < 11) {
                    increaseOneItemQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseOneItemQuality(item);
                }
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else {
                decreaseOneItemQuality(item);
                if (item.sellIn < 0) {
                    decreaseOneItemQuality(item);

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