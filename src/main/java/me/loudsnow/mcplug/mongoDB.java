/*
package me.loudsnow.mcplug;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class mongoDB {
    private DBCollection players;
    private DB mcserverdb;
    private MongoClient client;

    public boolean connect(String ip, int port) {
        try {
            client = new MongoClient(ip, port);
        } catch (UnknownHostException e) {
            System.out.println("Could not connect to database!");
            e.printStackTrace();
            return false;
        }
        mcserverdb = client.getDB("mcserver");
        players = mcserverdb.getCollection("players");
        return true;
    }
}
*/