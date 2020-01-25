import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void reverseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {
               // arrange
               final String[] EXPECTED = {"X", "Y", "Z"};

               // act
               final String[] actual = CodeTest.uppercaseArray(new String[] {"x", "y", "z"});
       
               // assert
               assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void findWordCountAllWords_returnsExpectedResult() {
        // arrange
        final Map<String,Integer> EXPECTED = new HashMap<String,Integer>();
        EXPECTED.put("the", 2);
        EXPECTED.put("cat", 1);
        EXPECTED.put("jumped", 1);
        EXPECTED.put("over", 1);
        EXPECTED.put("mat", 1);

        // act
        final Map<String,Integer> actual = CodeTest.findWordCountAll("the cat jumped over the mat");

        // assert
        assertTrue(EXPECTED.equals(actual));
    }

    @Test
    public void findWordCount_returnsExpectedResult() {
        // arrange
        final int EXPECTED = 2;

        // act
        final int actual = CodeTest.findWordCount("the cat jumped over the mat", "the");

        // assert
        assertEquals(EXPECTED, actual);
    }


    @Test
    public void composeU_returnsExpectedResult() {
        final Function<Integer,Integer> f1 = (d) -> {return d + 1;};
        final Function<Integer,Integer> f2 = (d) -> {return d * 2;};
        final Function<Integer,Integer> func = CodeTest.composeU(f1, f2);
        assertTrue(4 == func.apply(1));
    }

    @Test
    public void writeContentsToConsole_returnsExpectedResult() {
        CodeTest.writeContentsToConsole();
        assertEquals(String.join("\n",
        "**/.idea/*",
        "**/npm-debug.log*",
        "**/node_modules",
        "**/.npm",
        "**/build/*",
        "**/.DS_Store",
        "**/.env",
        "**/.gradle/*",
        "**/out/*",
        "**/*.log",
        "*.jar",
        "gradle/wrapper/gradle-wrapper.properties",
        "*.bat\n"), outContent.toString());
    }

    @Test
    public void handleInvalidArgument_returnsExpectedResult() {
        IllegalArgumentException err = null;
        try {
            CodeTest.handleInvalidArgument(1);
        } catch (IllegalArgumentException e) {
            err = e;
        }
        assertEquals("Invalid value must be greater than 14 x was: 1", err.getMessage());
    }

    @Test
    public void puzzle_returnsExpectedResult() {

    }
}
