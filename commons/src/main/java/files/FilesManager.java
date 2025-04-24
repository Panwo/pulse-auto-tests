package files;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;

@UtilityClass
public class FilesManager {

    @SneakyThrows
    public static Object deserialize(String fileName) {
        return new ObjectMapper().readValue(new File(fileName), Object.class);
    }

}