package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            ItemNameIsNotAllOfTheCaseAndQualityOverZero(i);
            NameIsAgedOrBackageAndQualityLessThan50(i);
            NameIsBackageAndQualityLessThan50(i);
            NameIsNotSulfuras(i);
            if (items[i].sellIn < 0) {
                ItemNameIsNotAllOfTheCaseAndQualityOverZero(i);
                ItemNameIsBackageTButNotAgedBrie(i);
                NameisAgedBrie(i);
            }
        }
    }

    private void ItemNameIsNotAllOfTheCaseAndQualityOverZero(int i) {
        if (!items[i].name.equals("Aged Brie")) {
            if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
        }

    }

    private void ItemNameIsBackageTButNotAgedBrie(int i) {
        if (!items[i].name.equals("Aged Brie")) {

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                items[i].quality = items[i].quality - items[i].quality;
            }
        }
    }

    private void NameisAgedBrie(int i) {
        if (items[i].name.equals("Aged Brie")) {
            if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
            }
        }

    }
    private void NameIsNotAgedBrieNotBackageT(int i){//중복코드
        if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].quality > 0) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].quality = items[i].quality - 1;
                }
            }
        }
    }
    private void NameIsAgedOrBackageAndQualityLessThan50(int i) {
        if (!((!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")))) {
            if (items[i].quality < 50)
                items[i].quality = items[i].quality + 1;
        }
    }
    private void NameIsBackageAndQualityLessThan50(int i){

            if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                if (items[i].quality < 50){
                    if (items[i].sellIn < 11)
                        items[i].quality = items[i].quality + 1;
                    if(items[i].sellIn < 6)
                        items[i].quality = items[i].quality + 1;
                }
            }
    }
    private void NameIsNotSulfuras(int i){
        items[i].sellIn = items[i].sellIn - 1;
    }






}