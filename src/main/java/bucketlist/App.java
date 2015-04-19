/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist;

import bucketlist.controller.BucketlistUserInfoController;
import bucketlist.model.BucketlistUserInfo;

/**
 *
 * @author Daniel
 */
public class App {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //  Configuration config = new Configuration();
        //  config.addAnnotatedClass(BucketlistUserInfo.class);
        //  config.addAnnotatedClass(BucketlistListItem.class);
        //To add new table:
        //config.addAnnotatedClass(*.class);
        //  config.configure("hibernate.cfg.xml");
        //new SchemaExport(config).create(true, true);

        Test();

    }

    public static void Test() {
        BucketlistUserInfoController c = new BucketlistUserInfoController();
        c.addUserInfoToDB("Jan", "Kowalski", "kowal82@buziaczek.pl", "irenka15");
        c.addUserInfoToDB("Jan", "Nowak", "j.nowak@gmail.com", "trudn3h45l0");
        c.addUserAndItemListToDB("Zastac Polske drewniana, a zostawic murowana.");

        BucketlistUserInfo u = c.getUserInfoFromDB(1);

        c.CloseSession();
        System.out.println(u.getLastName());
    }
}
