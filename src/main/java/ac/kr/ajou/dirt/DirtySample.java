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
                iten_name_is_BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT(item);
            } else if (is_item_name_equal_test(item, AGED_BRIE)) {
                item_quality_name_is_AGED_BRIE(item);
            } else {
                item_is_just_stuff(item);
            }
        }
    }

    private void item_is_just_stuff(Item item) {
        item_quality_is_over_0(item);
        update_sellln(item);
        if (item_Sellln_Is_Under_Number(0, item)) {
            item_quality_is_over_0(item);
        }
    }

    private void item_quality_name_is_AGED_BRIE(Item item) {
        item_quality_is_under_50(item, item.quality < 50);
        update_sellln(item);
        if (item_Sellln_Is_Under_Number(0, item)) {
            item_quality_is_under_50(item, item.quality < 50);
        }
    }

    private void iten_name_is_BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT(Item item) {
        if (item.quality < 50) {
            item.quality++;
            item_quality_is_under_50(item, item_Sellln_Is_Under_Number(11,  item));
            item_quality_is_under_50(item, item_Sellln_Is_Under_Number(6, item));
        }
        update_sellln(item);
        if (item_Sellln_Is_Under_Number(0, item)) {
            item.quality = 0;
        }
    }

    private void item_quality_is_over_0(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void item_quality_is_under_50(Item item, boolean b) {
        if (b) {
            item.quality++;
        }
    }

    private void update_sellln(Item item) {
        item.sellIn--;
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