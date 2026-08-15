package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

    private static final String DEFAULT_ITEM = "DEFAULT_ITEM";

    private static final int NOT_EXPIRED_SELLIN_VALUE = 3;
    private static final int EXPIRED_SELLIN_VALUE = -4;
    private static final int DEFAULT_QUALITY_VALUE = 18;

	@Test
	public void shouldDecreaseItemQualityByOne_whenItemSellInValueIsNotExpired() {
        // Setup
		GildedRose app = createGildedRose(DEFAULT_ITEM, NOT_EXPIRED_SELLIN_VALUE, DEFAULT_QUALITY_VALUE);

        // Invoke
		app.updateQuality();

        // Verify
        Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELLIN_VALUE - 1, DEFAULT_QUALITY_VALUE - 1);

        assertItem(expected, app.items[0]);
    }

	@Test
	public void shouldDecreaseItemQualityByTwo_whenItemSellInValueIsExpired() {
        // Setup
		GildedRose app = createGildedRose(DEFAULT_ITEM, EXPIRED_SELLIN_VALUE, DEFAULT_QUALITY_VALUE);

        // Invoke
		app.updateQuality();

        // Verify
        Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELLIN_VALUE - 1, DEFAULT_QUALITY_VALUE - 2);

        assertItem(expected, app.items[0]);
	}

    private GildedRose createGildedRose(String itemType, int sellinValue, int qualityValue) {
        Item item = new Item(itemType, sellinValue, qualityValue);
        Item[] items = new Item[] { item };

        return new GildedRose(items);
    }

    private void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }
}