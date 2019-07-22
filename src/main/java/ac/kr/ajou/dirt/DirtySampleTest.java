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

}
