package utils;

import java.util.ArrayList;
import java.util.Collections;

public class CreateNumberArray {
    public ArrayList<String> createArray(int num) {
        ArrayList<String> numbers = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            numbers.add(String.valueOf(i));
        }

        Collections.shuffle(numbers);
        return numbers;
    }
}
