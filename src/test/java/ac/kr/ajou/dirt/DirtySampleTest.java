package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class DirtySampleTest {

    @Test
    public void AgedBrie아니고NOBackstagePasses아니고Sulfuras아닐때Test(){
        Item[] items = {new Item("aaa", 0, 1)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(0));

    }

}
