package config;

import java.util.Random;

/**
 *
 * @author Luis G
 */
public class ArrayConfig {

    public int[] createRandomArray(int arraySize, int maxValue) {
        Random random = new Random();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }

    public int[] createrandomArray(int arraySize) {
        Random random = new Random();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public String view(int[] array) {
        String data = "[";
        for (int i = 0; i < array.length; i++) {
            data += array[i] + ", ";
        }
        data = data.substring(0, data.length() - 2) + "]";
        return data;
    }
}
