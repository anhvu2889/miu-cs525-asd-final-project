package domain.framework.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utils {

    public static LocalDate parseTextToLocalDate(String text) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(text, formatter);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    public static long parseTextToLong(String text) {
        try {
            return Long.parseLong(text);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
