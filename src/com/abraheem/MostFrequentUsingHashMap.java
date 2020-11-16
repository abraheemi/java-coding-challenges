package com.abraheem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Expected output based on file.txt:
 *
 * Geeks : 6
 * and : 4
 * to : 4
 * well : 3
 * your : 3
 */
public class MostFrequentUsingHashMap {
    File file;
    HashMap<String, Integer> map = new HashMap<>();

    public MostFrequentUsingHashMap(String filename){
        file = new File("src\\com\\abraheem\\input\\" + filename);
    }

    public void findMostFrequentWords(int k){
        if(!buildHashMap()){
            System.out.println("Could not read file");
            return;
        }
        Map<String, Integer> sortedMap = sortByValues();
        int i=0;
        for (String key: sortedMap.keySet()) {
            if(i == k)
                break;
            System.out.println(key + " " + sortedMap.get(key));
            i++;
        }
        // Prints all hashmap using Java 8 lambda expression
        //sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private boolean buildHashMap() {
        try {
            Scanner scanner = new Scanner(file);
            //HashMap<String, Integer> map = new HashMap<>();
            while (scanner.hasNext()) {
                //System.out.println(scanner.next().toLowerCase());
                String s = scanner.next();
                if (!map.containsKey(s)) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private HashMap<String, Integer> sortByValues(){
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        // Put data from sorted list to hashmap
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }
        return sortedMap;
    }

}
