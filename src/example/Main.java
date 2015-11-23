package example;

import Logic.Loogic;
import SDK.ServerConnection;

/**
 * Created by Calvin on 29/10/2015.
 */

public class Main {

    public static void main(String args[]) {

        Loogic start = new Loogic();
        start.run();

        ServerConnection sc = new ServerConnection();
        sc.get("users");



    }
}

