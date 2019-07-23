package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

//code made by : 김성규&이재형
public class DirtySampleTest {

    private Item[] items;
    private DirtySample dirtySample;

    @Test
    public void 이름이_AgedBrie이면_sellIn과_상관없이_quality가_49일때_quality_1증가_테스트() {
        items = new Item[1];
        items[0] = new Item("Aged Brie", 1, 49);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(50));
    }
    @Test
    public void 이름이_AgedBrie이고_sellIn이_0초과이고_quality가_50미만일때_quality_1증가_테스트() {
        items = new Item[1];
        items[0] = new Item("Aged Brie", 1, 30);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(31));
    }

    @Test
    public void 이름이_AgedBrie이고_sellIn이_0이하이고_quality가_49미만일때_quality_2증가_테스트() {
        items = new Item[1];
        items[0] = new Item("Aged Brie", 0, 48);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(50));
    }

    @Test
    public void 이름이_Backstage이고_sellIn이_0이하이면_quality가_0이_되는_테스트() {
        items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(0));
    }

    @Test
    public void 이름이_Backstage이고_sellIn이_0초과이고_quality가_49일때_quality_1증가_테스트() {
        items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(50));
    }

    @Test
    public void 이름이_Backstage이고_sellIn이_0초과_6미만이고_quality가_48미만일때_quality_3증가_테스트() {
        items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30);
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(33));
    }

    @Test
    public void 이름이_Backstage이고_sellIn이_0초과_6미만이고_quality가_48일때_quality_2증가_테스트() {
        items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(50));
    }

    @Test
    public void 이름이_Backstage이고_sellIn이_6이상_11미만이고_quality가_49미만일때_quality_2증가_테스트() {
        items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 48);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(50));
    }

    @Test
    public void 이름이_Sulfuras일때_quality가_변하지_않는_테스트() {
        items = new Item[1];
        items[0] = new Item("Sulfuras, Hand of Ragnaros", 1, 30);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(30));
    }

    @Test
    public void 이름이_Sulfuras일때_sellIn이_변하지_않는_테스트() {
        items = new Item[1];
        items[0] = new Item("Sulfuras, Hand of Ragnaros", 1, 30);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(1));
    }

    @Test
    public void 이름이_Sulfuras가_아닐때_sellIn_1감소_테스트() {
        items = new Item[1];
        items[0] = new Item("", -1, 0);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(-2));
    }


    @Test
    public void 이름이_AgedBrie도_Backstage도_Sulfuras도_아니면_sellIn과_상관없이_quality가_1일때_quality_1감소_테스트() {
        items = new Item[1];
        items[0] = new Item("", -1, 1);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(0));
    }

    @Test
    public void 이름이_AgedBrie도_Backstage도_Sulfuras도_아니고_sellIn과_quality가_0초과일때_quality_1감소_테스트() {
        items = new Item[1];
        items[0] = new Item("", 1, 1);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(0));
    }

    @Test
    public void 이름이_AgedBrie도_Backstage도_Sulfuras도_아니고_sellIn이_0이하이고_quality가_1초과일때_quality_2감소_테스트() {
        items = new Item[1];
        items[0] = new Item("", 0, 2);
        dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].quality, is(0));
    }
}