package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

    private static final String DEFAULT_ITEM_NAME = "DEFAULT_ITEM";

    private Item buildDefaultItem(int sellInValue, int qualityValue) {
        return new Item(DEFAULT_ITEM_NAME, sellInValue, qualityValue);
    }

    private Item[] buildItemsList(Item itemToAdd) {
        return new Item[] { itemToAdd };
    }

	@Test
	public void testUpdateQualityDefault1() {
        int sellInValue = 3;
        int qualityValue = 18;
        Item item = buildDefaultItem(sellInValue, qualityValue);
		Item[] items = buildItemsList(item);
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(DEFAULT_ITEM_NAME, app.items[0].name);
		assertEquals(sellInValue - 1, app.items[0].sellIn);
		assertEquals(qualityValue - 1, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityForExpiredItem() {
        int sellInValue = -4;
        int qualityValue = 7;
        Item item = buildDefaultItem(sellInValue, qualityValue);
        Item[] items = buildItemsList(item);
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(DEFAULT_ITEM_NAME, app.items[0].name);
		assertEquals(sellInValue - 1, app.items[0].sellIn);
		assertEquals(qualityValue - 2, app.items[0].quality);
	}
}