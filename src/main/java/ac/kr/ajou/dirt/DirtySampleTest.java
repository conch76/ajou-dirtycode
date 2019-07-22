package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class DirtySampleTest {

    //1
    @Test
    public void updateQuality_item의_name이_Aged와_Backstage와_Sulfuras가_모두_아니고_quality_0초과이면_quality_1_감소() {
        Item[] items = new Item[] { new Item("foo", 2, 2) };
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(1));
    }

    //2
    @Test
    public void updateQuality_item의_name이_Aged이고_quality가_50미만이면_quality_1_증가() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 2), new Item("Aged Brie", 2, 3) };
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(3));
        assertThat(items[1].quality, is(4));

    }

    //3
    @Test
    public void updateQuality_item의_name이_Backstage이고_sellIn이_6이상_11미만이고_quality가_50미만이면_quality_2_증가() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 3) };
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(5));
    }

}
