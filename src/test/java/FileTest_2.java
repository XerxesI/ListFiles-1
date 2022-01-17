import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileTest_2 {
    public static final int DEPTH = 1;

    @Test
    public void TestDirectoryList() {
        try {
            Map<Path,Path> result = listFilesUsingFileWalk("E:\\AZ-500\\Exercises\\01\\Configure-Security-Policies-main", 2);
            Iterator<Map.Entry<Path, Path>> iterator = result.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Path, Path> entry = iterator.next();
                System.out.println(entry.getValue().toString() + "\\" + entry.getKey().toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }
    }
    public Map<Path, Path> listFilesUsingFileWalk(String dir, int depth) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .collect(Collectors.toMap(Path::getFileName ,Path::getParent));

        }
    }
}