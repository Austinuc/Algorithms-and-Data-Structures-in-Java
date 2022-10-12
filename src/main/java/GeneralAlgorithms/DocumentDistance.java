package GeneralAlgorithms;
import java.io.*;
import java.util.*;

/**
 *
 */

public class DocumentDistance {

    /**
     *
     * @param doc1
     * @param doc2
     */
    public void findDocumentDistanceBetween(String doc1, String doc2) {
        Map<String, Integer> D1 = new HashMap<>();
        Map<String, Integer> D2 = new HashMap<>();
        Integer w1Count = 0, w2Count = 0;
        String line1, line2;

        try (BufferedReader d1 = new BufferedReader(new FileReader(doc1));
             BufferedReader d2 = new BufferedReader(new FileReader(doc2))) {
            while ((line1 = d1.readLine()) != null) {
                String[] words = line1.toLowerCase().split("[^a-zA-Z0-9]");
                w1Count += words.length;
                addWordToMap(D1, words);
            }
            Double normD1 = calculateNorm(D1);
            while ((line2 = d2.readLine()) != null) {
                String[] words = line2.toLowerCase().split("[^a-zA-Z0-9]");
                w2Count += words.length;
                addWordToMap(D2, words);
            }
            Double normD2 = calculateNorm(D2);

            Double D1byD2 = dotProductBtw(D1, D2);
//            System.out.println(D1byD2);
//            System.out.println(normD1*normD2);
            System.out.println(Math.acos(D1byD2/(normD1 * normD2))* Math.PI/180);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> Double dotProductBtw(Map<T, Integer> D1, Map<T, Integer> D2) {
        Double dotProduct = 0.0;
        for (Map.Entry<T, Integer> wordD1: D1.entrySet()) {
            if (D2.containsKey(wordD1.getKey())) {
                dotProduct += wordD1.getValue() * D2.get(wordD1.getKey());
            }
        }
        return dotProduct;
    }

    private  <T> Double calculateNorm(Map<T, Integer> D) {
        long sumOfValuesSquared = 0;
        for (Map.Entry<T, Integer> item: D.entrySet()) {
            sumOfValuesSquared += Math.pow(item.getValue(), 2);
        }
        return Math.sqrt(sumOfValuesSquared);
    }

    private <T> void addWordToMap(Map<T, Integer> d, T[] words) {
        for (T word: words) {
            if (d.containsKey(word)) {
                d.replace(word,d.get(word) + 1);
            } else {
                d.put(word, 1);
            }
        }
    }

//    public static void main(String[] args) {
//        findDocumentDistanceBetween("src/main/java/uploads/doc1.txt", "src/main/java/uploads/doc2.txt");
//    }
}
