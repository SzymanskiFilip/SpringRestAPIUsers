package eu.filip.springrestapiusers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JSONReader {
    public static List<User> readUsersFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get("users.json").toFile(), mapper.getTypeFactory().constructParametricType(List.class, Object.class));
    }
}
