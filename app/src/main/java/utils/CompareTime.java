package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class CompareTime {
    private final ArrayList<String> defaultArray = new ArrayList<>(Collections.singletonList("00:00:00"));
//    private boolean isShowNewScoreText;

    public ArrayList<String> parseArrayTime(ArrayList<String> arrayValue) {
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS", Locale.JAPAN);
        try {
            ArrayList<String> sortedDate = new ArrayList<>();
            ArrayList<String> formattedDates = new ArrayList<>();

            for (int i = 0; i < arrayValue.size(); i++) {
                String value = arrayValue.get(i);

                if (value == null) {
                    value = "00:00:00";
                }

                Date parseEachDate = formatter.parse(value);
                if (parseEachDate == null) return defaultArray;

                long parsedTime = parseEachDate.getTime();

                if (parsedTime != 0) {
                    sortedDate.add(String.valueOf(parsedTime));
                }

            }

//            sortedDate.sort((a, b) -> Long.compare(Long.parseLong(a), Long.parseLong(b)));
            sortedDate.sort(Comparator.comparingLong(Long::parseLong));

            for (String timeString : sortedDate) {
                long timeInMillis = Long.parseLong(timeString);
                Date date = new Date(timeInMillis);
                formattedDates.add(formatter.format(date));
            }

            if (formattedDates.size() >= 4) {
                formattedDates.remove(formattedDates.size() - 1);
            } else if (formattedDates.size() < 3) {
                while (formattedDates.size() < 3) {
                    formattedDates.add("00:00:00");
                }
            }

            return formattedDates;

        } catch (ParseException e) {
            e.printStackTrace();
            return defaultArray;
        }
    }

    public boolean isShowNewScoreText(ArrayList<String> arrayValue, String score) {
        if (arrayValue.size() != 0 && score != null) {
            return arrayValue.get(0).equals(score);
        } else {
            return false;
        }

    }

}
