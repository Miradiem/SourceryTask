import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BonusDates {
    private BonusDates() {
    }

    public static List<String> bonusDatesBetween(int fromYear, int toYear) {
        List<String> result = new ArrayList<>();
        var formatter = DateTimeFormatter.ofPattern("yMMdd");

        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                var lastDayOfMonth = getLastDayOfMonth(year, month);

                for (int day = 1; day <= lastDayOfMonth; day++) {
                    var date = LocalDate.of(year, month, day);
                    var formattedDate = date.format(formatter);

                    if (isPalindrome(formattedDate)) {
                        var resultFormat = DateTimeFormatter.ofPattern("y-MM-dd");
                        var formattedResult = date.format(resultFormat);
                        result.add(formattedResult);
                    }
                }
            }
        }

        return result;
    }

    private static int getLastDayOfMonth(int year, int month) {
        if (month == 2 && LocalDate.ofYearDay(year, 1).isLeapYear()) {
            return 29;
        }

        return LocalDate.of(year, month, 1).lengthOfMonth();
    }

    private static boolean isPalindrome(String str) {
        var reversedStr = new StringBuilder(str).reverse().toString();

        return str.equals(reversedStr);
    }
}