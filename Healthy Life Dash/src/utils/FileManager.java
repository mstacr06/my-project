package utils;

import java.io.*;

public class FileManager {

    public static void saveGame(String name, int level) {
    try {
        File file = new File(name + ".save");
        System.out.println("Saving to: " + file.getAbsolutePath());

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(level);
        }

        System.out.println("SAVE SUCCESS");

    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static int loadGame(String name) {
        
        try (BufferedReader br =
                     new BufferedReader(new FileReader(name + ".save"))) {
            
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {

            return -1;
        }
        
    }
}
