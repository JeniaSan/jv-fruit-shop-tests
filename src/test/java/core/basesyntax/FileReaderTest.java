package core.basesyntax;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import core.basesyntax.service.CustomFileReader;
import core.basesyntax.service.impl.CsvFileReader;
import java.util.List;
import org.junit.Test;

public class FileReaderTest {
    @Test
    public void read_ValidFile_Ok() {
        CustomFileReader fileReader = new CsvFileReader();
        List<String> lines = fileReader.read("src/test/resources/valid_input.csv");
        assertNotNull(lines);
        assertEquals(4, lines.size());
    }

    @Test
    public void read_NonexistentFile_ExceptionThrown() {
        CustomFileReader fileReader = new CsvFileReader();
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class, () -> fileReader.read("nonexistent_file.csv"));
        assertEquals(runtimeException.getMessage(),
                "Can't read data from file nonexistent_file.csv");
    }
}
