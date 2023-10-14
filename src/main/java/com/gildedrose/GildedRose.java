package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  private boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
}

private boolean isBackstagePass(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
}

private boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
}
private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
}

private void decreaseQuality(Item item) {
    if (item.quality > 0 && !isSulfuras(item)) {
        item.quality--;
    }
}

private void updateSellIn(Item item) {
    if (!isSulfuras(item)) {
        item.sellIn--;
    }
}



  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {

      if (!isAgedBrie(items[i]) && !isBackstagePass(items[i])) {
        decreaseQuality(items[i]);
        
      } else {
         increaseQuality(items[i]); {

          if (isBackstagePass(items[i])) {
            if (items[i].sellIn < 11) {
              increaseQuality(items[i]);
            }

            if (items[i].sellIn < 6) {
              increaseQuality(items[i]);}
          }
        }
      }

      updateSellIn(items[i]);

      if (items[i].sellIn < 0) {
        if (!isAgedBrie(items[i])) {
          if (!isBackstagePass(items[i])) {
            decreaseQuality(items[i]);
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
         increaseQuality(items[i]);
      }
    }
  }
}
}