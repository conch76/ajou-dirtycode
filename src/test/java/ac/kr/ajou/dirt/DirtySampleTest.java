package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class DirtySampleTest {

    public static final String NONE_OF_THREE_NAMES = "Refactoring!!";
    public static final String AGED_BRIE = "Aged Brie";

    @Test
    public void doSomething_이름이셋다아니고_sellIn이음수이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, -5, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이음수이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, -5, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(23));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이음수이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, -5, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(58));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이3이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 3, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이3이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 3, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(24));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이3이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 3, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(59));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이8이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 8, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이8이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 8, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(24));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이8이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 8, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(59));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이13이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 13, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이13이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 13, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(24));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이13이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 13, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(59));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이음수이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, -5, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(-3));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이음수이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, -5, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(27));
    }

    @Test
    public void doSomething_이름이AGEDBRIEC이고_sellIn이음수이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, -5, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(60));
    }
    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이3이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, 3, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(-4));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이3이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, 3, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(26));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이3이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, 3, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이8이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, 8, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(-4));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이8이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, 8, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(26));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이8이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, 8, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이13이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, 13, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(-4));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이13이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, 13, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(26));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고sellIn이13이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, 13, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(60));
    }
}
