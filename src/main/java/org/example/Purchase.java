package org.example;

import java.util.Map;

public class Purchase {
    class Item {
        protected String title;

        protected int count;

        public Item(String title, int count) {
            this.title = title;
            this.count = count;
        }

        public String getTitle() {
            return title;
        }

        public int getCount() {
            return count;
        }
        public void add(int count) {
            this.count = getCount() + count;
        }
    }

    protected Item[] purchases;

    public Purchase(int stock) {
        this.purchases = new Item[stock];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Item(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].add(count);
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) continue;
            System.out.println("\t" + purchases[i].getTitle() + " " + purchases[i].getCount() + " шт. в сумме " + (purchases[i].getCount() * prices.get(purchases[i].getTitle())) + " руб.");
            sum += (long) purchases[i].getCount() * prices.get(purchases[i].getTitle());
        }
        return sum;
    }
}
