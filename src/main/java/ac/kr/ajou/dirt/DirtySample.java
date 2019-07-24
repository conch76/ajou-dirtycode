package ac.kr.ajou.dirt;

class DirtySample {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (Item item : items) {
            if (is_item_name_equal_test(item, SULFURAS_HAND_OF_RAGNAROS)) {

            } else if (is_item_name_equal_test(item, BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (item.quality < 50) {
                    item.quality++;
                    if (item_Sellln_Is_Under_Number(11,  item)) {
                        item.quality++;
                    }
                    if (item_Sellln_Is_Under_Number(6, item)) {
                        item.quality++;
                    }
                }
                item.sellIn--;
                if (item_Sellln_Is_Under_Number(0, item)) {
                    item.quality = 0;
                }
            } else if (is_item_name_equal_test(item, AGED_BRIE)) {
                if (item.quality < 50) {
                    item.quality++;
                }
                item.sellIn--;
                if (item_Sellln_Is_Under_Number(0, item)) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            } else {
                if (item.quality > 0) {
                    item.quality--;
                }
                item.sellIn--;
                if (item_Sellln_Is_Under_Number(0, item)) {
                    if (item.quality > 0) {
                        item.quality--;
                    }
                }
            }
        }
    }

    private boolean is_item_name_equal_test(Item item, String sulfurasHandOfRagnaros) {
        return item.name.equals(sulfurasHandOfRagnaros);
    }
    private boolean item_Sellln_Is_Under_Number(int number, Item item) {
        if (item.sellIn < number)
            return true;
        return false;
    }
}