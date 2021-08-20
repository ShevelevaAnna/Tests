package utils;
import org.testng.annotations.DataProvider;

public class ParametersForTest {
    @DataProvider(name = "Auth")
    public Object[][] Auth() {
        return new Object[][]{
                {RandomParameters.randomPassword(6),RandomParameters.randomWord(5),
                RandomParameters.randomDomain(), RandomParameters.randomWord(3),
                RandomParameters.randomInterests(3),
                "/home/anya/Документы/git/test_1/src/test/resources"}
        };
    }
}
