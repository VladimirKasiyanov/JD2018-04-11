package by.it.lanevich.jd01_15;

import java.io.*;

/**
 * sdfsdf
 * sdfsdf
 * fdsdfs
 * sdfsd
 */
public class TaskB {
    public static void main(String[] args) {
        boolean out = true;
        boolean typeComment = false;
        boolean suspect = false;
        String fileName = TaskA.path("TaskB.java");
        String fileNameOut = TaskA.path("TaskB.txt");
        System.out.println(fileName);
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader(fileName));
        ) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line).append("\n");
//            }
//            System.out.println(sb);
            char prev = 0;
            while (reader.ready()) {
                char ch = (char) reader.read();
                if (ch == '/') out = false;
                if (prev == '/') {
                    if (ch == '*') {
                        suspect = true;
                        typeComment = true;
                    }
                    if (ch == '/') {
                        suspect = true;
                        typeComment = false;
                    }
                    if (suspect == false) {
                        sb.append(prev);
                        out = true;
                    }
                }
                if ((prev == '*') & (ch == '/')) typeComment = false;

                if (((suspect == true) & (typeComment == false)) & (ch == 10)) {
                    out = true;
                    suspect = false;
                }
                if (out) sb.append(ch);
                prev = ch;
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileNameOut))) {
            pr.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
           fdsfsdfsdfsdf sd sdfsd
*/