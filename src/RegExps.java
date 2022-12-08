import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExps {
    public static void main(String[] args) throws IOException {
        //Строка содержит только один символ
        check(".", " ", "ab");
        //Строка содержит 5 символов
        check(".{5}","12345","321");
        //Строка содержит одну или более букву "a", а за ней одну букву "b"
        check("a+b","aab","abb");
        //Строка содержит несколько или ни одной буквы "a", а за ней одну букву "b"
        check("a*b","b","abb");
        //Слово состоит из двух букв, первая из которых "a"
        check("a.","ab","abb");
        //Последняя буква в строке "a"
        check(".*a","a","abb");
        //Третья буква - "а"
        check(".{2}a.*","cba","abb");
        //Первая и последняя буквы - "а"
        check("a.*a","cba","abb");
        //Первая и последняя буквы - одинаковые
        check("(.).*\\1","cbc","abb");
        //Первая и последняя буквы - разные
        check("(.).*\\1","cbc","abb");
        //Не должна начинаться с буквы "a" или "b"
        check("[^ab].*\\1","cbc","abb");
        //Четные символы - "a"
        check("(.a)+","caca","abb");
        //Строка не содержит "a"
        check("[^a]+","bcbc","babb");
        //Слово содержит "a"
        check("[a-zA-Z]*a[a-zA-Z]*","bcbc","babb");
        //В строке содержатся цифры
        check("[a-zA-Z]*\\d[a-zA-Z]*","bcbc","babb");
        //В строке содержатся только цифры
        check("\\d+","1","babb");
        //Строка является вещественным числом с фиксированной точкой
        check("[+-]?\\d[.]?\\d*?","1.11","b");
        //Проверить номер телефона 8(029)-123-45-67
        check("8\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}","8(029)-123-45-67","8(0129)-123-45-67");

        TextFileReader textFileReader = new TextFileReader("src/data/vocab.txt");
        ArrayList list = (ArrayList) textFileReader.getList();
        System.out.println(list.toString());
        String str;
        for (int i = 0; i < list.size(); i++) {
            str = (String) list.get(i);
            if(Pattern.compile("a.*").matcher(str).matches())
                System.out.println(str);
        }

    }

    public static void check(String pattern, String s1, String s2){
        boolean b1 = Pattern.compile(pattern).matcher(s1).matches();
        boolean b2 = Pattern.compile(pattern).matcher(s2).matches();

        System.out.println(b1 + " "+ b2);
    }

}

//Из текстового файла-словаря извлекаются слова в массив строк
class TextFileReader {
    String fileName;
    private List<String> list = new ArrayList<String>();

    TextFileReader(String fileName) throws IOException {
        this.fileName = fileName;
        StringBuilder sb;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if (!line.equals(""))
                    list.add(line);
                line = br.readLine();
            }
        }
    }

    public List<String> getList() {
        return list;
    }
}
