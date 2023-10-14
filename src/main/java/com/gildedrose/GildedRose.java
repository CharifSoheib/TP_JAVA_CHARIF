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
        if (item.quality > 0 ) {
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
            case "Conjured":
            if (item.sellIn >= 0) {
                item.quality -= 2;
            } else {
                item.quality -= 4;
            }
            break;
            case "Aged Brie":
                increaseQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQuality(item);
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }
                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
                break;
            case "Sulfuras, Hand of Ragnaros":

                break;
            default:
                decreaseQuality(item);
                break;
        }

        updateSellIn(item);

        if (item.sellIn <0)
        {
            switch (item.name) {
                case "Aged Brie":
                    increaseQuality(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality = 0;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                
                    break;
                default:
                    decreaseQuality(item);
                    break;
            }
        }  
    }
}
}


