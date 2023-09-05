import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BonusDatesTest {
    private List<String> bonusDates;

    @BeforeEach
    public void setUp() {
        bonusDates = BonusDates.bonusDatesBetween(1, 2023);
    }

    @Test
    public void should_Return_Valid_BonusDates() {
        assertTrue(bonusDates.contains("1-01-01"), "1-01-01 not found");
        assertTrue(bonusDates.contains("10-11-01"), "10-11-01 not found");
        assertTrue(bonusDates.contains("100-10-01"), "100-10-01 not found");
        assertTrue(bonusDates.contains("1001-10-01"), "1001-10-01 not found");
        assertTrue(bonusDates.contains("2020-02-02"), "2020-02-02 not found");
        assertTrue(bonusDates.contains("2021-12-02"), "2021-12-02 not found");
    }
}