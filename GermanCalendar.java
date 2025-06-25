import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class GermanCalendar {

    public static void main(String[] args) {
        int year = 2025; // You can change this to any year
        for (Month month : Month.values()) {
            printMonthCalendar(month, year);
            System.out.println();
        }
    }

    public static void printMonthCalendar(Month month, int year) {
        Locale locale = Locale.GERMAN;

        // Print month name
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println("Mo Di Mi Do Fr Sa So");

        // Start on the 1st of the month
        LocalDate firstOfMonth = LocalDate.of(year, month, 1);
        int lengthOfMonth = firstOfMonth.lengthOfMonth();

        // Determine offset for the first day
        int startOffset = firstOfMonth.getDayOfWeek().getValue(); // 1 = Monday ... 7 = Sunday

        // Print leading spaces
        for (int i = 1; i < startOffset; i++) {
            System.out.print("   ");
        }

        // Print each day of the month
        for (int day = 1; day <= lengthOfMonth; day++) {
            System.out.printf("%2d ", day);
            if ((startOffset + day - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
