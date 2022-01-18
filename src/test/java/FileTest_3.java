import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileTest_3 {
    public static final int DEPTH = 1;

    @Test
    public void TestDirectoryList() {
        System.out.println(PropertiesCache.getInstance().getProperty("filepath"));
        try {
            String filePath = PropertiesCache.getInstance().getProperty("filepath");
            Set<String> results = listFilesUsingFileWalk(filePath, 1);
            results.stream().forEach(System.out::println);
            for (String result:results) {
                System.out.println(result.replaceAll("^.*?(?=[^1])/", ""));
                // ^.*?(?=\/)/
                // ([^\/]+)$
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }
    }
    public Set<String> listFilesUsingFileWalk(String dir, int depth) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::toAbsolutePath)
                    .map(Object::toString)
                    .collect(Collectors.toSet());
        }
    }
}

