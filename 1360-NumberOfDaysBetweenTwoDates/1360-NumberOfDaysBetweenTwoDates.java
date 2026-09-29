// Last updated: 9/29/2026, 11:13:39 AM
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1=LocalDate.parse(date1);
        LocalDate d2=LocalDate.parse(date2);
        return (int) Math.abs(ChronoUnit.DAYS.between(d1,d2));
    }
}