package files;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;
import static java.nio.file.Paths.*;
import static java.nio.file.Paths.get;
import static java.util.Optional.of;

@UtilityClass
public class FilesManager {

    @SneakyThrows
    public static Object deserialize(String fileName) {
        if (fileName.endsWith(".raw.json")) {
            return Files.readString(get(fileName), UTF_8);
        }
        return new ObjectMapper().readValue(new File(fileName), Object.class);
    }

}