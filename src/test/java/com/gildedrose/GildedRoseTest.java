package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name did not change");
  }

  private GildedRose app;
  private Item[] items;

  @BeforeEach
  public void setUp() {
    items = new Item[]{
      new Item("Aged Brie", 10, 20),
      new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30),
      new Item("Sulfuras, Hand of Ragnaros", 5, 80),
      new Item("Normal Item", 5, 10)
    };
    app = new GildedRose(items);
  }

  @Test
  public void testUpdateQuality() {
    app.updateQuality();

    // Test pour Aged Brie
    assertEquals("Aged Brie", app.items[0].name);
    assertEquals(9, app.items[0].sellIn);
    assertEquals(21, app.items[0].quality);

    // Test pour Backstage passes
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
    assertEquals(14, app.items[1].sellIn);
    assertEquals(31, app.items[1].quality);

    // Test pour Sulfuras
    assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
    assertEquals(5, app.items[2].sellIn);
    assertEquals(80, app.items[2].quality);

    // Test pour normal item
    assertEquals("Normal Item", app.items[3].name);
    assertEquals(4, app.items[3].sellIn);
    assertEquals(9, app.items[3].quality);
  }

 
  @Test
  public void testBackstagePassQualityAfterSellIn() {
    app.items[1].sellIn = 0;
    app.updateQuality();

    // Test pour Backstage passes apres sellIn
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
    assertEquals(-1, app.items[1].sellIn);
    assertEquals(0, app.items[1].quality);
  }

  @Test
  public void testBackstageQualityIncreaseSellInLessThanSixAndQualityFifty() {
    app.items[1].sellIn = 5;
    app.items[1].quality = 49;
    app.updateQuality();

    // Test pour Backstage passes pour sellIn moins de six et quality 50
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
    assertEquals(4, app.items[1].sellIn);
    assertEquals(50, app.items[1].quality);
  }

  @Test 
  public void testNormalItemQualityDecreaseAfterSellIn() {
      app.items[3].sellIn = 0;
      
      
          app.updateQuality();
  // Test pour normal item qualité decrementer apres sellIn
          // Test for normal item
          assertEquals("Normal Item", app.items[3].name);
          assertEquals(-1, app.items[3].sellIn);
          assertEquals(8, app.items[3].quality);
      
  }
  
    @Test
    public void testAgedBrieQualityIncreaseAfterSellIn() {
      app.items[0].sellIn = 0;
      app.updateQuality();
  
      // Test pour Aged Brie  qualité incremente apres sellIn
      assertEquals("Aged Brie", app.items[0].name);
      assertEquals(-1, app.items[0].sellIn);
      assertEquals(22, app.items[0].quality);
    }
  
    @Test
    public void testAgedBrieQualityIncreaseAfterSellInAndQualityFifty() {
      app.items[0].sellIn = 0;
      app.items[0].quality = 50;
      app.updateQuality();
  
      // Test pour Aged Brie qualité incremente apres sellIn et qualité 50
      assertEquals("Aged Brie", app.items[0].name);
      assertEquals(-1, app.items[0].sellIn);
      assertEquals(50, app.items[0].quality);

      
    }

  @Test
  public void testNotSulfurasHandOfRagnarosAfterSellInLessThanZeroAndQualityMoreThanZero() {
    app.items[2].sellIn = -1;
    app.items[2].quality = 1;
    app.updateQuality();

    // Test pour Sulfuras apres sellIn < 0 et quality > 0
    assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
    assertEquals(-1, app.items[2].sellIn);
    assertEquals(1, app.items[2].quality);
  }

   @Test
  public void testToString() {
    Item item = new Item("foo", 0, 0);
  
    //test pour toString item
    assertEquals("foo, 0, 0", item.toString() );

  
  }


  @Test
  public void testQualityNeverNegative() {
    app.items[3].sellIn = 0;
    app.items[3].quality = 0;
    app.updateQuality();
  
    // Test pour normal item qualité jamais negative
    assertEquals("Normal Item", app.items[3].name);
    assertEquals(-1, app.items[3].sellIn);
    assertEquals(0, app.items[3].quality);
  }
  
  @Test
  public void testBackstageQualityIncreaseSellInMoreThanEleven() {
    app.items[1].sellIn = 11;
    app.updateQuality();
  
    // Test pour Backstage passes qualité incremente sellIn > 11
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
    assertEquals(10, app.items[1].sellIn);
    assertEquals(31, app.items[1].quality);
  }
  @Test 
  public void testBackstageQualityIncreaseSellInMoreThanOne() {
    app.items[1].sellIn = 1;
    app.updateQuality();
  
    // Test pour Backstage passes qualité incremente  quand sellIn > 1
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
    assertEquals(0, app.items[1].sellIn);
    assertEquals(33, app.items[1].quality);
  
  }

  @Test
public void testBackstageQualityIncreaseSellInMoreThanSix() {
  app.items[1].sellIn = 6;
  app.updateQuality();

  // Test pour Backstage passes qualité incremente sellIn > 6
  assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
  assertEquals(5, app.items[1].sellIn);
  assertEquals(32, app.items[1].quality);} 


}


