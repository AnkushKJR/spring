package com.zepto.invoice.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;


public class DateValidator {
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd")
            .withResolverStyle(ResolverStyle.STRICT); // Enforce strict parsing

    /**
     * Validates if the given date string is in the "yyyy-MM-dd" format.
     * 
     * @param date2 The date string to validate.
     * @throws DateTimeParseException if the date string is not in the correct format or is an invalid date (e.g., Feb 30th).
     */
    public static boolean validateDueDate(String date) {
             
        try {
            // We don't need to store the result, just check if it parses without error.
            LocalDate.parse(date, DATE_FORMATTER);
            return true; // Parsing succeeded, date is valid

        } catch (DateTimeParseException e) {
            // Parsing failed, the format is incorrect or the date value is invalid
            return false;
        }
        
    }


}
