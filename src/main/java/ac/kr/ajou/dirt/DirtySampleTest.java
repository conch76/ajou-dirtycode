package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirtySampleTest {

    @Test
    public void updateQuality_item의_name이_Sulfuras가_아니면_sellIn_1_감소() {
        Item[] items = new Item[] { new Item("foo", 2, 2) };
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertTrue(items[0].sellIn == 1);
    }

}
