package carv;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.concurrent.TimeUnit;



import org.bson.Document;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            String url = "mongodb://Carvi3:password@127.0.0.1:27017";
            MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(url))
                .applyToSocketSettings(builder -> builder.connectTimeout(5, TimeUnit.SECONDS))
                .build());

            MongoDatabase database = mongoClient.getDatabase("demo");

    
            MongoCollection<Document> collection = database.getCollection("associates");
    
            //Document document = new Document();
            //document.append("firstName", "test");
            //document.append("lastName", "user");
            //collection.insertOne(document);
            FindIterable<Document> result = collection.find();

            result.forEach((document) -> {System.out.println(document);});


        }catch(Exception e){
            System.out.println("Something Went wrong");
            e.printStackTrace();
        }


        System.out.println("Finished Program");
    }
}
