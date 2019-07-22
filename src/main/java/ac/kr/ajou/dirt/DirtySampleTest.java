package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DirtySampleTest {

    @Test
    public void updateQuality_item의_name이_Sulfuras가_아니면_sellIn_1_감소() {
        Item[] items = new Item[]{new Item("foo", 2, 2)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertTrue(items[0].sellIn == 1);
    }

    @Test
    public void updateQuality_item의_sellIn이_0미만이고_name이_Aged와_Backstage와_Sulfuras가_아니고_quality가_0보다_크면_quality_2_감소() {
        Item[] items = new Item[]{new Item("foo", -2, 3)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(1));
    }
    @Test
    public void updateQuality_item의_sellIn이_0미만이고_name이_Aged가_아니고_Backstage이면_quality_0 () {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -2, 3) };
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(0));
    }


}
