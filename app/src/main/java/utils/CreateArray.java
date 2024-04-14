package utils;

import java.util.ArrayList;
import java.util.Collections;

public class CreateArray {
    public ArrayList<String> createArray(int num) {
        ArrayList<String> numbers = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            numbers.add(String.valueOf(i));
        }

        Collections.shuffle(numbers);
        return numbers;
    }

    /**
     * String型の配列を作成
     */
    public ArrayList<String> createStringArray(String... values) {
        ArrayList<String> stringArray = new ArrayList<>();

        Collections.addAll(stringArray, values);
        return stringArray;
    }


}
