package com.ks_pem02.pem_shopping_list.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class DummyContent {



    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();



    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Avocado", "2 Euro", "@drawable/avocado"));
        addItem(new DummyItem("2", "Penne", "1,30 Euro", "@drawable/pasta"));
        addItem(new DummyItem("3", "Soy Sauce", "3 Euro", "@drawable/soysauce"));
        addItem(new DummyItem("2", "Cheese", "3,50 Euro", "@drawable/cheese"));
        addItem(new DummyItem("3", "Chocolate", "1,20 Euro", "@drawable/chocolate"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }



    public static class DummyItem {
        public String id;
        public String firstLine;
        public String secondLine;
        public String uri;

        public DummyItem(String id, String firstLine, String secondLine, String uri) {
            this.id = id;
            this.firstLine = firstLine;
            this.secondLine = secondLine;
            this.uri = uri;
        }

        @Override
        public String toString() {
            return firstLine;
        }

        public String getFirstLine(){ return this.firstLine; }
        public String getSecondLine(){ return this.secondLine; }
        public String getUri(){ return this.uri; }
    }
}
