package com.ks_pem02.pem_shopping_list;

import java.util.ArrayList;
import java.util.List;




public class Content {


    public List<Item> ITEMS = new ArrayList<Item>();


    public Content(){
        addItem(new Item("Avocado","2 Euro","@drawable/avocado"));
        addItem(new Item("Penne", "1,30 Euro", "@drawable/pasta"));
        addItem(new Item("Soy Sauce", "3 Euro", "@drawable/soysauce"));
        addItem(new Item("Cheese", "3,50 Euro", "@drawable/cheese"));
        addItem(new Item("Chocolate", "1,20 Euro", "@drawable/chocolate"));
    }


    public void addItem(Item item) {
        ITEMS.add(item);
    }
    public void addItemFromStrings(String _firstLine, String _secondLine, String _uri){
        addItem(new Item(_firstLine,_secondLine,_uri));
    }

    public List<Item> getItems(){
        return ITEMS;
    }


    public class Item {
        public String id;
        public String firstLine;
        public String secondLine;
        public String uri;

        public Item(String firstLine, String secondLine, String uri) {
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
