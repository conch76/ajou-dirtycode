package ac.kr.ajou.dirt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DirtySampleTest {


    @Test
    public void updateQuality_Aged_Brie() {

        Item[] legacyTestItems = new Item[54];
        Item[] refactoringTestItems = new Item[54];

        for(int i=-2; i<14 ; i++) {
            for(int j=0; j<54; j++) {
                legacyTestItems[j] = new Item("Aged Brie", i, j-2);
                refactoringTestItems[j] = new Item("Aged Brie", i, j-2);
            }
            new DirtySample(refactoringTestItems).updateQuality();
            new OriginalDirtySample(legacyTestItems).updateQuality();
            for(int j=0; j<54; j++){
                assertEquals(legacyTestItems[j].sellIn, refactoringTestItems[j].sellIn);
                assertEquals(legacyTestItems[j].quality, refactoringTestItems[j].quality);
               
            }
        }

    }

    @Test
    public void updateQuality_Backstage_Passes() {

        Item[] legacyTestItems = new Item[54];
        Item[] refactoringTestItems = new Item[54];

        for(int i=-2; i<14 ; i++) {
            for(int j=0; j<54; j++) {
                legacyTestItems[j] = new Item("Backstage passes to a TAFKAL80ETC concert", i, j-2);
                refactoringTestItems[j] = new Item("Backstage passes to a TAFKAL80ETC concert", i, j-2);
            }
            new DirtySample(refactoringTestItems).updateQuality();
            new OriginalDirtySample(legacyTestItems).updateQuality();
            for(int j=0; j<54; j++){
                assertEquals(legacyTestItems[j].sellIn, refactoringTestItems[j].sellIn);
                assertEquals(legacyTestItems[j].quality, refactoringTestItems[j].quality);
            }
        }

    }

    @Test
    public void updateQuality_The_Rest_of_Them() {

        Item[] legacyTestItems = new Item[54];
        Item[] refactoringTestItems = new Item[54];

        for(int i=-2; i<14; i++) {
            for(int j=0; j<54; j++) {
                legacyTestItems[j] = new Item("The rest of them", i, j-2);
                refactoringTestItems[j] = new Item("The rest of them", i, j-2);
            }
            new DirtySample(refactoringTestItems).updateQuality();
            new OriginalDirtySample(legacyTestItems).updateQuality();
            for(int j=0; j<54; j++){
                assertEquals(legacyTestItems[j].sellIn, refactoringTestItems[j].sellIn);
                assertEquals(legacyTestItems[j].quality, refactoringTestItems[j].quality);
            }
        }

    }

    @Test
    public void updateQuality_Sulfuras() {

        Item[] legacyTestItems = new Item[54];
        Item[] refactoringTestItems = new Item[54];

        for(int i=-2; i<14; i++) {
            for(int j=0; j<54; j++) {
                legacyTestItems[j] = new Item("Sulfuras, Hand of Ragnaros", i, j-2);
                refactoringTestItems[j] = new Item("Sulfuras, Hand of Ragnaros", i, j-2);
            }
            new DirtySample(refactoringTestItems).updateQuality();
            new OriginalDirtySample(legacyTestItems).updateQuality();
            for(int j=0; j<54; j++){
                assertEquals(legacyTestItems[j].sellIn, refactoringTestItems[j].sellIn);
                assertEquals(legacyTestItems[j].quality, refactoringTestItems[j].quality);
            }
        }

    }

/*
    // 실제로 if else 문 안에 statements 가 실행되는 test case들
    @Test
    public void updateQuality_Aged_Brie_quality_under_50_and_sellIn_under_0() {
        Item[] testItems = {
                new Item("Aged Brie", -1, 48),
                new Item("Aged Brie", -1, 49)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (-2));
        assertEquals(testItems[0].quality, (50));
        assertEquals(testItems[1].sellIn, (-2));
        assertEquals(testItems[1].quality, (50));
    }

    @Test
    public void updateQuality_backstage_passes_quality_under_50_and_sellIn_under_6() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (4));
        assertEquals(testItems[0].quality, (50));
        assertEquals(testItems[1].sellIn, (4));
        assertEquals(testItems[1].quality, (50));
    }

    @Test
    public void updateQuality_backstage_passes_quality_under_50_and_sellIn_under_11_and_over_5() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 48),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (5));
        assertEquals(testItems[0].quality, (50));
        assertEquals(testItems[1].sellIn, (5));
        assertEquals(testItems[1].quality, (50));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_under_0() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (-2));
        assertEquals(testItems[0].quality, (0));
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
        assertEquals(testItems[0].sellIn, (-2));
        assertEquals(testItems[0].quality, (0));
        assertEquals(testItems[1].sellIn, (-1));
        assertEquals(testItems[1].quality, (0));
        assertEquals(testItems[2].sellIn, (-2));
        assertEquals(testItems[2].quality, (0));
        assertEquals(testItems[3].sellIn, (-1));
        assertEquals(testItems[3].quality, (0));
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void updateQuality_Aged_Brie_sellIn_minus1() {
        Item[] testItems = {
                new Item("Aged Brie", -1, -2),
                new Item("Aged Brie", -1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (-2));
        assertEquals(testItems[0].quality, (0));
        assertEquals(testItems[1].sellIn, (-2));
        assertEquals(testItems[1].quality, (50));
    }

    @Test
    public void updateQuality_Aged_Brie_sellIn_1() {
        Item[] testItems = {
                new Item("Aged Brie", 1, -2),
                new Item("Aged Brie", 1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (0));
        assertEquals(testItems[0].quality, (-1));
        assertEquals(testItems[1].sellIn, (0));
        assertEquals(testItems[1].quality, (49));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_minus1() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (-2));
        assertEquals(testItems[0].quality, (0));
        assertEquals(testItems[1].sellIn, (-2));
        assertEquals(testItems[1].quality, (0));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_1() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (0));
        assertEquals(testItems[0].quality, (1));
        assertEquals(testItems[1].sellIn, (0));
        assertEquals(testItems[1].quality, (50));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_6() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (5));
        assertEquals(testItems[0].quality, (0));
        assertEquals(testItems[1].sellIn, (5));
        assertEquals(testItems[1].quality, (50));
    }

    @Test
    public void updateQuality_backstage_passes_sellIn_11() {
        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 48)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (10));
        assertEquals(testItems[0].quality, (-1));
        assertEquals(testItems[1].sellIn, (10));
        assertEquals(testItems[1].quality, (49));
    }

    @Test
    public void updateQuality_the_rest_sellIn_minus1() {
        Item[] testItems = {
                new Item("The rest of them",-1,-2),
                new Item("The rest of them", -1, 48),
                new Item("The rest of them", -1, 50)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (-2));
        assertEquals(testItems[0].quality, (-2));
        assertEquals(testItems[0].sellIn, (-2));
        assertEquals(testItems[1].quality, (46));
        assertEquals(testItems[2].sellIn, (-2));
        assertEquals(testItems[2].quality, (48));
    }

    @Test
    public void updateQuality_the_rest_sellIn_1() {
        Item[] testItems = {
                new Item("The rest of them", 1, -2),
                new Item("The rest of them", 1, 48),
                new Item("The rest of them", 1, 50)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (0));
        assertEquals(testItems[0].quality, (-2));
        assertEquals(testItems[1].sellIn, (0));
        assertEquals(testItems[1].quality, (47));
        assertEquals(testItems[2].sellIn, (0));
        assertEquals(testItems[2].quality, (49));
    }

    @Test
    public void updateQuality_sulfrus_hand_of_Ragnaros_immutable() {
        Item[] testItems = {
                new Item("Sulfuras, Hand of Ragnaros", -1, -2),
                new Item("Sulfuras, Hand of Ragnaros", 3, 6),
                new Item("Sulfuras, Hand of Ragnaros", 1, 50)
        };

        new DirtySample(testItems).updateQuality();
        assertEquals(testItems[0].sellIn, (-1));
        assertEquals(testItems[0].quality, (-2));
        assertEquals(testItems[1].sellIn, (3));
        assertEquals(testItems[1].quality, (6));
        assertEquals(testItems[2].sellIn, (1));
        assertEquals(testItems[2].quality, (50));
    }

*/

}