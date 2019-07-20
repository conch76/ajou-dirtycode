package ac.kr.ajou.dirt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class DirtySampleTest {

    @Test
    public void updateQuality_stuffs_enough_sellIn(){
        //quality, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("frostmourne", 5, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(4));
        assertThat(items[0].sellIn, is(4));
    }

    @Test
    public void update_quality_stuffs_has_negative_sellIn(){
        //quality: - 2 , sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("frostmourne", -3, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(3));
        assertThat(items[0].sellIn, is(-4));

    }

    @Test
    public void update_quality_Aged_Brie_has_enough_sellIn_and_quality_less_than_50(){
        //quality: + 1, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("Aged Brie", 5, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(6));
        assertThat(items[0].sellIn, is(4));
    }

    @Test
    public void update_quality_Aged_Brie_has_enough_sellIn_and_quality_more_than_50(){
        //quality: + 0, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("Aged Brie", 5, 55);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(55));
        assertThat(items[0].sellIn, is(4));
    }

    @Test
    public void update_quality_TAFKAL80ETC_has_sellIn_between_0_and_6_and_quality_less_than_50(){
        //quality: + 3, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(8));
        assertThat(items[0].sellIn, is(4));
    }

    @Test
    public void update_quality_TAFKAL80ETC_has_sellIn_between_6_and_11_and_quality_less_than_50(){
        //quality: + 2, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(7));
        assertThat(items[0].sellIn, is(6));
    }

    @Test
    public void update_quality_TAFKAL80ETC_has_sellIn_more_than_11_and_quality_less_than_50(){
        //quality: + 1, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(6));
        assertThat(items[0].sellIn, is(11));
    }

    @Test
    public void update_quality_TAFKAL80ETC_has_quality_more_than_50(){
        //quality: maintain, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 55);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(55));
        assertThat(items[0].sellIn, is(6));
    }

    @Test
    public void update_quality_TAFKAL80ETC_has_negative_sellIn(){
        //quality: equal 0, sellIn: - 1
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", -2, 55);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.update_quality();

        assertThat(items[0].quality, is(0));
        assertThat(items[0].sellIn, is(-3));
    }

}
