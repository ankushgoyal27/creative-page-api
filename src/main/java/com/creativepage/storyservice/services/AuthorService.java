package com.creativepage.storyservice.services;

import com.creativepage.storyservice.models.Author;
import com.creativepage.storyservice.repository.AuthorRepository;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private GridFSBucket gridFSBucket = null;

   @Autowired
    private MongoDatabase mongoDatabase;




    // this variable is used to store ImageId for other actions like: findOne or delete
    private ObjectId imageFileId;

    public Author getAuthor(String userName){
        Author author = authorRepository.findByUserName(userName);

        String uploadImagePath = author.getStories().get(0).getSubStories().get(0).getImageURL();
        String fileName = uploadImagePath.substring(uploadImagePath.lastIndexOf('/') +1);

        ObjectId fileId; //The id of a file uploaded to GridFS, initialize to valid file id

        try {
            FileOutputStream streamToDownloadTo = new FileOutputStream("/Users/ag/creativepage/"+fileName);
            gridFSBucket.downloadToStream(fileName, streamToDownloadTo);
            streamToDownloadTo.close();
            System.out.println(streamToDownloadTo.toString());
        } catch (IOException e) {
            // handle exception
        }

        return author;
    }

    public void addStory(Author author) throws FileNotFoundException {
        gridFSBucket = GridFSBuckets.create(mongoDatabase, "images");
        try {
            //Get Image path from Author Sub stories
            String uploadImagePath = author.getStories().get(0).getSubStories().get(0).getImageURL();

            String fileName = uploadImagePath.substring(uploadImagePath.lastIndexOf('/') +1);

            InputStream streamToUploadFrom = new FileInputStream(new File(uploadImagePath));
            // Create some custom options
            GridFSUploadOptions options = new GridFSUploadOptions()
                    .chunkSizeBytes(358400)
                    .metadata(new Document("type", "image/png"));

            ObjectId fileId = gridFSBucket.uploadFromStream(fileName, streamToUploadFrom, options);
        } catch (FileNotFoundException e){
            // handle exception
        }

        authorRepository.save(author);
    }

}
