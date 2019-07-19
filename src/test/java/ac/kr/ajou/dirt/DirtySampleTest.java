package ac.kr.ajou.dirt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class DirtySampleTest {

    @Test
    public void updateQuality_잡다한_아이템이고_quality_sellIn이_충분한_경우_(){
        Item[] items = new Item[1];
        items[0] = new Item("rion king", 5, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(4));
        assertThat(items[0].sellIn, is(4));
    }

    @Test
    public void updateQuality_잡다한아이템_sellIn_is_0(){
        Item[] items = new Item[1];
        items[0] = new Item("rion king", 0, 5);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();


    }

}
