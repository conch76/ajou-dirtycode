package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class DirtySampleTest {

    // 실제로 if else 문 안에 statements 가 실행되는 test case들
    @Test
    public void updateQuality_Aged_Brie_quality_under_50_and_sellIn_under_0() {
        Item[] testItems = {
                new Item("Aged Brie", -1, 48),
                new Item("Aged Brie", -1, 49)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(-2));
        assertThat(testItems[0].quality, is(50));
        assertThat(testItems[1].sellIn, is(-2));
        assertThat(testItems[1].quality, is(50));
    }

    @Test
    public void updateQuality_backstage_passes_quality_under_50_and_sellIn_under_6() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(4));
        assertThat(testItems[0].quality, is(50));
        assertThat(testItems[1].sellIn, is(4));
        assertThat(testItems[1].quality, is(50));
    }

    @Test
    public void updateQuality_backstage_passes_quality_under_50_and_sellIn_under_11_and_over_5() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(5));
        assertThat(testItems[0].quality, is(50));
        assertThat(testItems[1].sellIn, is(5));
        assertThat(testItems[1].quality, is(50));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_under_0() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(-2));
        assertThat(testItems[0].quality, is(0));
    }

    @Test
    public void updateQuality_the_rest_sellIn_under_or_equal_0_and_quality_over_1_or_equal_1() {
        Item[] testItems = {
                new Item("the rest of them", -1, 1),
                new Item("the rest of them", 0, 1),
                new Item("the rest of them", -1, 2),
                new Item("the rest of them", 0, 2)

        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(-2));
        assertThat(testItems[0].quality, is(0));
        assertThat(testItems[1].sellIn, is(-1));
        assertThat(testItems[1].quality, is(0));
        assertThat(testItems[2].sellIn, is(-2));
        assertThat(testItems[2].quality, is(0));
        assertThat(testItems[3].sellIn, is(-1));
        assertThat(testItems[3].quality, is(0));
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void updateQuality_Aged_Brie_sellIn_minus1() {
        Item[] testItems = {
                new Item("Aged Brie", -1, -2),
                new Item("Aged Brie", -1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(-2));
        assertThat(testItems[0].quality, is(0));
        assertThat(testItems[1].sellIn, is(-2));
        assertThat(testItems[1].quality, is(50));
    }

    @Test
    public void updateQuality_Aged_Brie_sellIn_1() {
        Item[] testItems = {
                new Item("Aged Brie", 1, -2),
                new Item("Aged Brie", 1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(0));
        assertThat(testItems[0].quality, is(-1));
        assertThat(testItems[1].sellIn, is(0));
        assertThat(testItems[1].quality, is(49));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_minus1() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(-2));
        assertThat(testItems[0].quality, is(0));
        assertThat(testItems[1].sellIn, is(-2));
        assertThat(testItems[1].quality, is(0));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_1() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(0));
        assertThat(testItems[0].quality, is(1));
        assertThat(testItems[1].sellIn, is(0));
        assertThat(testItems[1].quality, is(50));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_6() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(5));
        assertThat(testItems[0].quality, is(0));
        assertThat(testItems[1].sellIn, is(5));
        assertThat(testItems[1].quality, is(50));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_11() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(10));
        assertThat(testItems[0].quality, is(-1));
        assertThat(testItems[1].sellIn, is(10));
        assertThat(testItems[1].quality, is(49));
    }

    @Test
    public void updateQuality_the_rest_sellIn_minus1() {
        Item[] testItems = {
                new Item("The rest of them",-1,-2),
                new Item("The rest of them", -1, 48),
                new Item("The rest of them", -1, 50)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(-2));
        assertThat(testItems[0].quality, is(-2));
        assertThat(testItems[0].sellIn, is(-2));
        assertThat(testItems[1].quality, is(46));
        assertThat(testItems[2].sellIn, is(-2));
        assertThat(testItems[2].quality, is(48));
    }

    @Test
    public void updateQuality_the_rest_sellIn_1() {
        Item[] testItems = {
                new Item("The rest of them", 1, -2),
                new Item("The rest of them", 1, 48),
                new Item("The rest of them", 1, 50)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(0));
        assertThat(testItems[0].quality, is(-2));
        assertThat(testItems[1].sellIn, is(0));
        assertThat(testItems[1].quality, is(47));
        assertThat(testItems[2].sellIn, is(0));
        assertThat(testItems[2].quality, is(49));
    }

    @Test
    public void updateQuality_sulfrus_hand_of_Ragnaros_immutable() {
        Item[] testItems = {
                new Item("Sulfuras, Hand of Ragnaros", -1, -2),
                new Item("Sulfuras, Hand of Ragnaros", 3, 6),
                new Item("Sulfuras, Hand of Ragnaros", 1, 50)
        };

        new DirtySample(testItems).updateQuality();
        assertThat(testItems[0].sellIn, is(-1));
        assertThat(testItems[0].quality, is(-2));
        assertThat(testItems[1].sellIn, is(3));
        assertThat(testItems[1].quality, is(6));
        assertThat(testItems[2].sellIn, is(1));
        assertThat(testItems[2].quality, is(50));
    }


}