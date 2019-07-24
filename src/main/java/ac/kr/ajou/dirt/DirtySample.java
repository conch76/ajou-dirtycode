package ac.kr.ajou.dirt;

//code made by : 김수영&전혜진
public class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            ChecktheName(item);

            if (!isSulfuras(item)) {
                SellInDown_1(item);
            }

            if (item.sellIn < 0) {
                SellInLowerThanZero(item);
            }
        }
    }

    private void ChecktheName(Item item) {

        if (!isAged_brie(item) && !isBackstage(item)) {
            QualitySufficientAndNotSulfuras(item);
        }
        else {
            QualityLowerThan50(item);
        }
    }

    private void QualitySufficientAndNotSulfuras(Item item) {
        if (item.quality > 0 && !isSulfuras(item)) {
            QualityDown_1(item);
        }
    }

    private void SellInLowerThanZero(Item item) {
        if (!isAged_brie(item)) {
            NotAgedBrieCase(item);
        }

        else {
            if (item.quality < 50) {
                QualityUp_1(item);
            }
        }
    }

    private void NotAgedBrieCase(Item item) {
        if (!isBackstage(item))
        {
            QualitySufficientAndNotSulfuras(item);
        }
        else {
            item.quality = 0;
        }
    }

    private void QualityLowerThan50(Item item) {
        if (item.quality < 50) {
            QualityUp_1(item);
            BackstageCase(item);
        }
    }

    private void BackstageCase(Item item) {
        if (isBackstage(item)) {
            QualityUp_BySellIn(item);
        }
    }

    private void QualityUp_BySellIn(Item item) {
        QualityUp_with_Sellln_amount(item, 11);
        QualityUp_with_Sellln_amount(item, 6);
    }

    private void QualityUp_with_Sellln_amount(Item item, int i) {
        if (item.sellIn < i && item.quality < 50) {
            QualityUp_1(item);
        }
    }

    private void QualityUp_1(Item item) {
        item.quality = item.quality + 1;
    }

    private void QualityDown_1(Item item) {
        item.quality = item.quality - 1;
    }

    private void SellInDown_1(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAged_brie(Item item) {
        return item.name.equals("Aged Brie");
    }

}
