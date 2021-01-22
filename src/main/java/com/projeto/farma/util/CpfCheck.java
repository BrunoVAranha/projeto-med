package com.projeto.farma.util;

import com.mongodb.*;

public class CpfCheck {

    public static boolean cpfRepetido(String cpf) {
        Mongo mongo = new Mongo(new DBAddress("localhost", String.valueOf(127017)));
        DB db = mongo.getDB("farmadb");
        DBCollection collection = db.getCollection("users");
        BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("cpf", cpf);
        BasicDBObject fields = new BasicDBObject();


        DBCursor cursor = collection.find(allQuery, fields);
        try{
            while (cursor.hasNext()){
                if (collection.find(whereQuery).hasNext())
                    throw new Exception();
                System.out.println(cursor.next());
            }
        }catch (Exception e){
            System.out.println("cpf ja existe!");
            return true;
        }
        return false;
    }
}
