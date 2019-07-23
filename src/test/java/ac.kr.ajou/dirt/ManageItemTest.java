package ac.kr.ajou.dirt;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class ManageItemTest {
    private static final String A = "Aged Brie";
    private static final String B = "Backstage passes to a TAFKAL80ETC concert";
    private static final String S = "Sulfuras, Hand of Ragnaros";
    private static final String E = "else..";


    @Test
    public void A_B_S_가아니고_quality가_0보다_크고_sellIn이_0보다_클_때_테스트() {
        Item[] items = new Item[1];
        items[0] = new Item(E, 3, 30);
        ManageItem manageItem = new ManageItem(items);

        manageItem.updateItemFields();
        assertThat(items[0].quality, is(29));
        assertThat(items[0].sellIn, is(2));
    }

    @Test
    public void A_B_S가_아니고_quality가_0보다_크고_sellIn이_0일때_테스트() {
        Item[] items = new Item[1];
        items[0] = new Item(E, 0, 30);
        ManageItem manageItem = new ManageItem(items);

        manageItem.updateItemFields();
        assertThat(items[0].quality, is(28));
        assertThat(items[0].sellIn, is(-1));
    }

    @Test
    public void A_B_S가_아니고_quality가_0보다_크고_sellIn이_0보다_작을_때_테스트() {
        Item[] items = new Item[1];
        items[0] = new Item(E, -3, 30);
        ManageItem manageItem = new ManageItem(items);

        manageItem.updateItemFields();
        assertThat(items[0].quality, is(28));
        assertThat(items[0].sellIn, is(-4));
    }

    @Test
    public void A이고_quality가_50보다_작고_sellIn이_0보다_클_때_테스트(){
        Item[] items = new Item[1];
        items[0] = new Item(A, 4, 30);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(31));
        assertThat(items[0].sellIn, is(3));
    }

    @Test
    public void A이고_quality가_50보다_작고_sellIn이_0일때_테스트(){
        Item[] items = new Item[2];
        items[0] = new Item(A, 0, 30);
        items[1] = new Item(A, 0, 49);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(32));
        assertThat(items[0].sellIn, is(-1));
        assertThat(items[1].quality, is(50));
        assertThat(items[1].sellIn, is(-1));
    }

    @Test
    public void A이고_quality가_50보다_작고_sellIn이_0보다_작을_때_테스트(){
        Item[] items = new Item[2];
        items[0] = new Item(A, -1, 30);
        items[1] = new Item(A, -1, 49);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(32));
        assertThat(items[0].sellIn, is(-2));
        assertThat(items[1].quality, is(50));
        assertThat(items[1].sellIn, is(-2));
    }

    @Test
    public void B이고_quality가_50보다_작고_sellIn이_0보다_작을_때_테스트(){
        Item[] items = new Item[1];
        items[0] = new Item(B, -3, 30);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(0));
        assertThat(items[0].sellIn, is(-4));
    }

    @Test
    public void B이고_quality가_50보다_작고_sellIn이_0일때_테스트(){
        Item[] items = new Item[1];
        items[0] = new Item(B, 0, 30);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(0));
        assertThat(items[0].sellIn, is(-1));
    }

    @Test
    public void B이고_quality가_50보다_작고_sellIn이_0보다_크고_6보다_작을때_테스트(){
        Item[] items = new Item[3];
        items[0] = new Item(B, 1, 30);
        items[1] = new Item(B, 3, 48);
        items[2] = new Item(B, 5, 49);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(33));
        assertThat(items[0].sellIn, is(0));
        assertThat(items[1].quality, is(50));
        assertThat(items[1].sellIn, is(2));
        assertThat(items[2].quality, is(50));
        assertThat(items[2].sellIn, is(4));
    }

    @Test
    public void B이고_quality가_50보다_작고_sellIn이_6보다_크거나_같고_11보다_작을때_테스트(){
        Item[] items = new Item[3];
        items[0] = new Item(B, 6, 30);
        items[1] = new Item(B, 8, 48);
        items[2] = new Item(B, 10, 49);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(32));
        assertThat(items[0].sellIn, is(5));
        assertThat(items[1].quality, is(50));
        assertThat(items[1].sellIn, is(7));
        assertThat(items[2].quality, is(50));
        assertThat(items[2].sellIn, is(9));
    }

    @Test
    public void S가_아닐때_sellIn_1감소하는지_테스트() {
        Item[] testItems = new Item[2];
        testItems[0] = new Item(E, 1, 10);
        testItems[1] = new Item(S, 1, 10);
        ManageItem manageItem = new ManageItem(testItems);
        manageItem.updateItemFields();
        int result_name_notS = manageItem.items[0].sellIn;
        int result_name_S = manageItem.items[1].sellIn;
        assertThat(result_name_notS, is(0));
        assertThat(result_name_S, not(0));
    }

    @Test
    public void S일때_quality와_sellIn이_변화가_없는지_테스트(){
        Item[] items = new Item[3];
        items[0] = new Item(S, -3, -30);
        items[1] = new Item(S, 0, 0);
        items[2] = new Item(S, 10, 57);

        ManageItem manageItem = new ManageItem(items);
        manageItem.updateItemFields();

        assertThat(items[0].quality, is(-30));
        assertThat(items[0].sellIn, is(-3));
        assertThat(items[1].quality, is(0));
        assertThat(items[1].sellIn, is(0));
        assertThat(items[2].quality, is(57));
        assertThat(items[2].sellIn, is(10));
    }

}
