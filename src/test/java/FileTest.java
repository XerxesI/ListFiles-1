import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileTest {
    public static final int DEPTH = 1;

    @Test
    public void TestDirectoryList() {
        try {
            Set<String> result = listFilesUsingFileWalk("E:\\AZ-500\\Exercises\\01\\Configure-Security-Policies-main", 2);
            result.stream().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }
    }
    public Set<String> listFilesUsingFileWalk(String dir, int depth) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
//                    .map(Path::getParent)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }
}
