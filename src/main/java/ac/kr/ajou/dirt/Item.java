package ac.kr.ajou.dirt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public Boolean isNamed(String name) {
        return name.equals(this.name);
    }

    public Boolean isNamed3Cases() {
        return this.isNamed("Aged Brie") || this.isNamed("Backstage passes to a TAFKAL80ETC concert") || this.isNamed("Sulfuras, Hand of Ragnaros");
    }

}