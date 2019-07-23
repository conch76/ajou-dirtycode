package ac.kr.ajou.dirt;

class ManageItem {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    ManageItem(Item[] items) {
        this.items = items;
    }

    void updateItemFields() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    updateAgedBrieFields(item);
                    break;
                case BACKSTAGE:
                    updateBackstageFields(item);
                    break;
                case SULFURAS:
                    break;
                default:
                    updateElseFields(item);
                    break;
            }
        }
    }

    private void updateElseFields(Item item) {
        decreaseQualityHigherThanZero(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) decreaseQualityHigherThanZero(item);
    }

    private void updateBackstageFields(Item item) {
        increaseQualityLowerThanFifty(item);
        if (item.sellIn < 11) increaseQualityLowerThanFifty(item);
        if (item.sellIn < 6) increaseQualityLowerThanFifty(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) item.quality = 0;
    }

    private void updateAgedBrieFields(Item item) {
        increaseQualityLowerThanFifty(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) increaseQualityLowerThanFifty(item);
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQualityLowerThanFifty(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

    private void decreaseQualityHigherThanZero(Item item) {
        if (item.quality > 0)
            item.quality--;
    }
}