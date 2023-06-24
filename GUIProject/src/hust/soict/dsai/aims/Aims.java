package hust.soict.dsai.aims;

import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;


public class Aims {
    public static void main (String[] args){
        Cart cart = new Cart();
        Store store = new Store();
        new StoreScreen(store, cart);
    }
}