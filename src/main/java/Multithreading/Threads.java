package Multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Threads {
    private static List<Thread> allThreads = new ArrayList<>();
    private static double[] results = new double[4 * 250000];


    static int size = 1_000_000;
    static int chunkSize = size / 4;

    public static void main(String[] args) throws Exception {
        for (int threadNum = 0; threadNum < 4; threadNum++) {
            startThread(threadNum);
        }

        joinAll();

        for (int i = 0; i < size; i++) {
            double result = results[i];
            System.out.println(result);
        }

        File file = new File("sqrtMassive.cvs");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(Arrays.toString(results));
        }

    }


    public static void startThread(int threadNum) {
        Thread thread = new Thread(() -> {
            for (int i = chunkSize * threadNum; i < chunkSize * (threadNum + 1); i++) {
                double result = Math.sqrt(i);
                results[i] = result;
            }
        });
        thread.start();
        allThreads.add(thread);

    }

    private static void joinAll() throws InterruptedException {
        for (Thread thread : allThreads) {
            thread.join();
        }
    }
}



