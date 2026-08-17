package com.a.introduction.gildedrose;

import static com.a.introduction.gildedrose.GildedRoseUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseBAgedBrieTest {

	@Test
	public void shouldIncreaseQualityByOne_whenExpiredSellInValueIsExpiring() {
        // Setup
        GildedRose app = createGildedRose(AGED_BRIE_ITEM, NOT_EXPIRED_SELLIN_VALUE, DEFAULT_QUALITY_VALUE);

        // Invoke
		app.updateQuality();

        // Verify
        GildedRose expected = createGildedRose(AGED_BRIE_ITEM, NOT_EXPIRED_SELLIN_VALUE - 1, DEFAULT_QUALITY_VALUE + 1);

        assertItem(expected.items[0], app.items[0]);
    }

	@Test
	public void shouldIncreaseQualityByTwice_whenExpiredSellInValueIsAlreadyExpired() {
        // Setup
        GildedRose app = createGildedRose(AGED_BRIE_ITEM, EXPIRED_SELLIN_VALUE, DEFAULT_QUALITY_VALUE);

        // Invoke
        app.updateQuality();

        // Verify
        GildedRose expected = createGildedRose(AGED_BRIE_ITEM, EXPIRED_SELLIN_VALUE - 1, DEFAULT_QUALITY_VALUE + 2);

        assertItem(expected.items[0], app.items[0]);
    }

	@Test
	public void shouldMaintainQualityValue_whenQualityIsAlreadyAtMaximumValue() {
        // Setup
        GildedRose app = createGildedRose(AGED_BRIE_ITEM, NOT_EXPIRED_SELLIN_VALUE, MAX_QUALITY_VALUE);

        // Invoke
		app.updateQuality();

        // Verify
        GildedRose expected = createGildedRose(AGED_BRIE_ITEM, NOT_EXPIRED_SELLIN_VALUE - 1, MAX_QUALITY_VALUE);

        assertItem(expected.items[0], app.items[0]);
	}
}
