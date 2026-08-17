package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static com.a.introduction.gildedrose.GildedRoseUtils.*;

public class GildedRoseCBackstagePassesTest {
	
	@Test
	public void testUpdateQualityBackstagePasses1() {
        // Setup
        GildedRose app = createGildedRose(BACKSTAGE_PASSES, MORE_THAN_TEN_SELLIN_VALUE, DEFAULT_QUALITY_VALUE);

        // Invoke
		app.updateQuality();

        // Verify
        GildedRose expected = createGildedRose(BACKSTAGE_PASSES, MORE_THAN_TEN_SELLIN_VALUE - 1, DEFAULT_QUALITY_VALUE + 1);

        assertItem(expected.items[0], app.items[0]);
	}

	@Test
	public void testUpdateQualityBackstagePasses2() {
        // Setup
        GildedRose app = createGildedRose(BACKSTAGE_PASSES, MORE_THAN_FIVE_SELLIN_VALUE, DEFAULT_QUALITY_VALUE);

        // Invoke
		app.updateQuality();

        // Verify
        GildedRose expected = createGildedRose(BACKSTAGE_PASSES, MORE_THAN_FIVE_SELLIN_VALUE - 1, DEFAULT_QUALITY_VALUE + 2);

        assertItem(expected.items[0], app.items[0]);
	}

	@Test
	public void testUpdateQualityBackstagePasses3() {
        // Setup
        GildedRose app = createGildedRose(BACKSTAGE_PASSES, NOT_EXPIRED_SELLIN_VALUE, DEFAULT_QUALITY_VALUE);

        // Invoke
		app.updateQuality();

        // Verify
        GildedRose expected = createGildedRose(BACKSTAGE_PASSES, NOT_EXPIRED_SELLIN_VALUE - 1, DEFAULT_QUALITY_VALUE + 3);

        assertItem(expected.items[0], app.items[0]);
	}

}