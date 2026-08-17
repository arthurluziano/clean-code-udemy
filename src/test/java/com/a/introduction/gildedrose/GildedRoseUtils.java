package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseUtils {

    public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
    public static final String AGED_BRIE_ITEM = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MORE_THAN_TEN_SELLIN_VALUE = 15;
    public static final int MORE_THAN_FIVE_SELLIN_VALUE = 7;
    public static final int NOT_EXPIRED_SELLIN_VALUE = 3;
    public static final int EXPIRED_SELLIN_VALUE = -4;
    public static final int DEFAULT_QUALITY_VALUE = 18;
    public static final int MAX_QUALITY_VALUE = 50;

    public static GildedRose createGildedRose(String itemType, int sellInValue, int qualityValue) {
        Item item = new Item(itemType, sellInValue, qualityValue);
        Item[] items = new Item[] { item };

        return new GildedRose(items);
    }

    public static void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }
}
