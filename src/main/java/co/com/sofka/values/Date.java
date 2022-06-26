package co.com.sofka.values;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    private LocalDate value;
    
    private Date(LocalDate value) {
        this.value = value;
    }

    public static Date date(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Date(LocalDate.parse(date, format));
    }

    public LocalDate value() {
        return value;
    }
}
