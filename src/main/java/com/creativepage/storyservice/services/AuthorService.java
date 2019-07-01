package com.creativepage.storyservice.services;

import com.creativepage.storyservice.models.Author;
import com.creativepage.storyservice.repository.AuthorRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.gridfs.GridFSDBFile;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private GridFSBucket gridFSBucket = null;

//    @Autowired
//    private MongoDatabase mongoDatabase;

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("Story");


    // this variable is used to store ImageId for other actions like: findOne or delete
    private ObjectId imageFileId;

    public Author getAuthor(String userName){
        Author author = authorRepository.findByUserName(userName);

        gridFSBucket.find(eq("metadata.type", "image/png")).forEach(
                new Block<GridFSFile>() {
                    public void apply(final GridFSFile gridFSFile) {
                        System.out.println(gridFSFile.getFilename());
                    }
                });

        ObjectId fileId; //The id of a file uploaded to GridFS, initialize to valid file id

        try {
            FileOutputStream streamToDownloadTo = new FileOutputStream("/Users/ag/Desktop/logo1.png");
            gridFSBucket.downloadToStream("logo1", streamToDownloadTo);
            streamToDownloadTo.close();
            System.out.println(streamToDownloadTo.toString());
        } catch (IOException e) {
            // handle exception
        }

        return author;
    }

    public void addStory(Author author) throws FileNotFoundException {
        gridFSBucket = GridFSBuckets.create(database, "images");
        try {
            InputStream streamToUploadFrom = new FileInputStream(new File("/Users/ag/Desktop/logo1.png"));
            // Create some custom options
            GridFSUploadOptions options = new GridFSUploadOptions()
                    .chunkSizeBytes(358400)
                    .metadata(new Document("type", "image/png"));

            ObjectId fileId = gridFSBucket.uploadFromStream("logo1", streamToUploadFrom, options);
        } catch (FileNotFoundException e){
            // handle exception
        }

        authorRepository.save(author);
    }
}
