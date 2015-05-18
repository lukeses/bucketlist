/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist;

import bucketlist.controller.BucketlistController;
import bucketlist.model.BucketlistUserInfo;

/**
 * Klasa startowa przechowująca metodę main. Wykorzystywana głównie w celach
 * testowych lub inicjalizacji aplikacji.
 *
 * @author Daniel
 */
public class App {

    /**
     * Metoda startowa, wywoływana automatycznie przy starcie aplikacji
     *
     * @param args tablica parametrów startowych używana do inicjalizacji
     * aplikacji
     */
    public static void main(String[] args) {
        Test();
    }

    /**
     * Metoda testowa używana do inicjalizacji bazy danych przykłądowymi danymi,
     * metoda nie jest używana w wersji produkcyjnej.
     */
    public static void Test() {
        BucketlistController c = new BucketlistController();
        c.openSession();
        c.addNewUser("Jan", "Kowalski", "kowal82@buziaczek.pl", "irenka15");
        c.addNewUser("Jan", "Nowak", "j.nowak@gmail.com", "trudn3h45l0");


        c.addListItemToUser(1, "Zasadzic drzewo.", "");
        c.addListItemToUser(1, "Zwiedzic Chiny.", "");
        c.addListItemToUser(1, "Isc do opery.", "");
        
        c.addListItemToUser(2, "Isc na piknik", "");
        c.addListItemToUser(2, "Zarobic milion dolarow.", "");
        c.addListItemToUser(2, "Kupic BMW.", "");
        
        BucketlistUserInfo u = c.getUser(1);
        c.closeSession();
    }
}
