public class BonusDatesDisplay {
    private BonusDatesDisplay() {
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        var bonusDatesBetween = BonusDates.bonusDatesBetween(fromYear, toYear);

        for (String date : bonusDatesBetween) {
            System.out.println(date);
        }
    }
}