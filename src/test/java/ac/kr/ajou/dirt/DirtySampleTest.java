package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
}
