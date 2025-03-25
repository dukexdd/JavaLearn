import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson2IMTResultTests {
    @Test
    public void testNormalWeight() {
        var actualResult = getIMTResult(180f, 75f);
        Assertions.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testZeroHeight() {
        var actualResult = getIMTResult(0f, 80f);
        Assertions.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void  testZeroMass() {
        var actualResult = getIMTResult(100f, 0f);
        Assertions.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testDifMass() {
        var actualResult = getIMTResult(190f, 40f);
        Assertions.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void testZSmallMass() {
        var actualResult = getIMTResult(190f,70f);
        Assertions.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void testZBigMass() {
        var actualResult = getIMTResult(160f,98f);
        Assertions.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void testZNormalMass() {
        var actualResult = getIMTResult(190f, 90f);
        Assertions.assertEquals("нормальной массе тела", actualResult);
    }


    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex <= 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex <= 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";
        return userResult;
    }
}
