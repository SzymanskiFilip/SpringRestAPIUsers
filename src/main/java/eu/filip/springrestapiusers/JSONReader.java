package eu.filip.springrestapiusers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONReader {
    public static List<User> readUsersFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get("users.json").toFile(), mapper.getTypeFactory().constructParametricType(List.class, Object.class));
    }

    public static User getUserFromId(int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = JSONReader.readUsersFromFile();
        List<User> list = mapper.convertValue(users, new TypeReference<List<User>>() {});
        if(id > users.size()){
            return new User(0, "NO USER WITH THAT ID", "NO USER WITH THAT ID");
        }
        try{
            return list.get(id - 1);
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            return new User(0, "NO USER WITH THAT ID", "NO USER WITH THAT ID");
        }
    }

}
