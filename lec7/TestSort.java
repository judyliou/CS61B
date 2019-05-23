import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort{

    @Test
    public void testSort() {
     String[] input = {"i", "love", "watching", "movies"};
     String[] expected = {"i", "love", "movies", "watching"};

     Sort.sort(input);

     assertArrayEquals(expected, input);
    }

    @Test
    public void  testFindSmallest(){
        String[] input =  {"i", "have", "a", "dog"};
        int expected = 2;
        int output = Sort.findSmallest(input, 0);
        assertEquals(expected, output);

        String[] input2 = {"you", "and", "me"};
        int expected2 = 1;
        int output2 = Sort.findSmallest(input2, 0);
        assertEquals(expected2, output2);
    }

    @Test
    public void testSwap(){
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }
}