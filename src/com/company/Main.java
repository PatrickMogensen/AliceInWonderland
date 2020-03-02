package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        var url = new URL("https://www.gutenberg.org/files/11/11.txt");
        try (var br = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String line;

            var sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);

            //antal bogstaver i teksten
            int count = 0 ;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isLetter(sb.charAt(i)))
                    count++;
            }

            System.out.println("Antal Bogstaver iteksten: " + count);

            String[] words = sb.toString().split("\\s+");
            System.out.println("Antal ord: " + words.length);

            HashMap<String, Integer> map = new HashMap();

            for (int i = 0; i < words.length ; i++) {
             if (map.containsKey(words[i])){
                 map.put(words[i], map.get(words[i]) + 1);
             } else {

                 map.put(words[i],1);
            }
        }
            System.out.println( "antal gange et ord optræder: " + map);

    }
}
}

