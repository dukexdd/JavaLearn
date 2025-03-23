import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson2_2 {

    @Test
    public void testVeryBadMark() {
      var resultMark = getMarkResult(15);
        Assertions.assertEquals("2", resultMark);
    }
    @Test
    public void testBadMark() {
        var resultMark = getMarkResult(37);
        Assertions.assertEquals("3", resultMark);
    }
    @Test
    public void testGoodMark () {
        var resultMark = getMarkResult(65);
        Assertions.assertEquals("4", resultMark);
    }
    @Test
    public void testPerfMark () {
        var resultMark = getMarkResult(89);
        Assertions.assertEquals("5", resultMark);
    }
    @Test
    public void testWrongMark () {
        var resultMark = getMarkResult(1000);
        Assertions.assertEquals("no mark result", resultMark);
    }
    @Test
    public void test35Mark () {
        var resultMark = getMarkResult(35);
        Assertions.assertEquals("2", resultMark);
    }
    @Test
    public void test56Mark () {
        var resultMark = getMarkResult(56);
        Assertions.assertEquals("3", resultMark);
    }
    @Test
    public void test71Mark () {
        var resultMark = getMarkResult(71);
        Assertions.assertEquals("4", resultMark);
    }
    @Test
    public void test100Mark () {
        var resultMark = getMarkResult(100);
        Assertions.assertEquals("5", resultMark);
    }
    @Test
    public void test1Mark () {
        var resultMark = getMarkResult(1);
        Assertions.assertEquals("2", resultMark);
    }
    @Test
    public void test36Mark () {
        var resultMark = getMarkResult(36);
        Assertions.assertEquals("3", resultMark);
    }






    private String getMarkResult(Integer mark)
    {
        if(mark>=0 && mark <=35) return "2";
        if(mark>35 && mark <=56) return "3";
        if(mark>56 && mark<71) return "4";
        if(mark>72 && mark<100) return "5";
        return "no mark result";
    }

}
