package com.a.introduction.gildedrose;

import static com.a.introduction.gildedrose.GildedRoseUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

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
}