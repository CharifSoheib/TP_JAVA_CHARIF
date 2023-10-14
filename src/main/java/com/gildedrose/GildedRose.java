package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

  
//____________________UpdateQuality_______________________________//

public void updateQuality() {
    for (Item item : items) {
        switch (item.name) {
            case "Aged Brie":
                increaseQuality(item);
                updateSellIn(item);
                if (item.sellIn < 0) {
                    increaseQuality(item);
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQuality(item);
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }
                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
                updateSellIn(item);
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
            
                break;
            default:
                decreaseQuality(item);
                updateSellIn(item);
                if (item.sellIn < 0) {
                    decreaseQuality(item);
                }
                break;
        }
    }
}
}
