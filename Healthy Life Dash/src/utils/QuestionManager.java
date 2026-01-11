package utils;

import javax.swing.*;

public class QuestionManager {

    static String[] q = {
        "Insulin direnci olan biri hangisini tercih etmeli?",
        "Hangisi kan şekerini daha yavaş yükseltir?",
        "Diyabetli biri için hangisi daha uygundur?",
        "Hangisi daha sağlıklıdır?",
        "Tam tahıllı ürünler neden önerilir?",
        "Şekerli içecekler ne yapar?",
        "Sebze tüketimi ne sağlar?",
        "Protein neye yardımcı olur?"
    };

    static String[][] a = {
        {"Elma", "Kola"},
        {"Tam tahıl", "Beyaz ekmek"},
        {"Sebze","Pasta"},
        {"Meyve", "Kek"},
        {"Lif sağlar","Şeker artırır"},
        {"Kan şekerini yükseltir", "Düşürür"},
        {"Lif ve vitamin", "Sadece şeker"},
        {"Tok tutar" ,"Şeker yükseltir"}
    };

    public static boolean ask() {
        int index = (int)(Math.random() * q.length); 
        String question = q[index];
        String[] options = a[index];

        int result = JOptionPane.showOptionDialog(
                null,
                question,
                "Soru",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0] // varsayılan seçim
        );

        return result == 0;
    }
}
