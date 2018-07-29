import java.io.*;
import java.util.*;

public class BinarySearchString {

    public static int binarySearch(String term, String[] collection) {
        int start = 0;
        int end = collection.length - 1;
        int stepCount = 0;
        long startTime, endTime;

        startTime = System.nanoTime();
        while (start <= end) {

            int middle = (start + end) / 2;

            if (term.compareTo(collection[middle]) < 0) {
                stepCount++;
                end = middle - 1;
            }

            if (term.compareTo(collection[middle]) > 0) {
                stepCount++;
                start = middle + 1;
            }

            if (term.compareTo(collection[middle]) == 0) {
                endTime = System.nanoTime();
                System.out.println("Binary took " + (endTime - startTime) + " milliseconds, in " + stepCount + " steps");
                System.out.println("Found title: '" + term + "' at index " + middle);
                return middle;
            }
        }
        return -1;
    }

    public static int linearSearch(String term, String[] collection) {
        long startTime, endTime;
        int stepCount = 0;

        startTime = System.nanoTime();
        for (int i = 0; i < collection.length; i++) {
            stepCount++;
            if (collection[i].equals(term)) {
                endTime = System.nanoTime();
                System.out.println("Linear took " + (endTime - startTime) + " milliseconds, in " + stepCount + " steps");
                System.out.println("Found title: '" + term + "' at index " + i);
                return i;
            }
        }
        return -1;
    }

    public static String[] getDataFromFile(String fileName) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            File txt = new File(fileName);
            Scanner scan = new Scanner(txt);
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            scan.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
        return data.toArray(new String[] {});
    }

    public static void main(String[] args) {
    	System.out.println("A Search through a small dataset\n");
        String[] smallData = getDataFromFile("movieTitles20.txt");
        linearSearch("Contact ", smallData);
        binarySearch("Contact ", smallData);
    	
        System.out.println();
        
    	System.out.println("A Search through a Medium dataset\n");
        String[] medData = getDataFromFile("moviesTopGrossing200.txt");
        linearSearch("World Is Not Enough", medData);
        binarySearch("World Is Not Enough", medData);
        
        System.out.println();
        
    	System.out.println("A Search through a Large dataset\n");
        String[] bigData = getDataFromFile("movieTitles10K.txt");
        linearSearch("Юдифь из Ветулии", bigData);
        binarySearch("Юдифь из Ветулии", bigData);
    	
        System.out.println();
        
    	System.out.println("A Search through a Extra Large dataset\n");
        String[] extraBigData = getDataFromFile("movieTitles400K.txt");
        linearSearch("оСЯРЭ ЦНБНПЪР", extraBigData);
        binarySearch("оСЯРЭ ЦНБНПЪР", extraBigData);
    }

}
