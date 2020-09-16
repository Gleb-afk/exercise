package Test;

import com.bsu.Main;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Tests {
    @Test
    void test() {
        int rows = 3;
        int columns = 4;

        int[][] matrix = {
                {1,1,3,7},
                {10,2,4,8},
                {9,18,10,2}};
        int res = Main.maxNumberTwoTimes(matrix, rows, columns);
        assertEquals(res, 10);
    }
}