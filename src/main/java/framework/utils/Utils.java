/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package framework.utils;

import net.bytebuddy.utility.RandomString;

import java.util.Random;

public class Utils {

    public static String getRandomString(int length) {
        return RandomString.make(length);
    }

    public static String getRandomString() {
        Random random = new Random();
        int length = random.nextInt(100);
        return RandomString.make(length);
    }

    public static Integer getRandomInteger(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound);
    }
}