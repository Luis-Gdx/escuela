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
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
