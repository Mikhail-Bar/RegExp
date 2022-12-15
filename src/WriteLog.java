import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.*;

public class WriteLog {
    private final static Logger logger = Logger.getLogger(WriteLog.class.getClass().getName());
    public static void main(String[] args) throws FileNotFoundException {
//Получить праздничные дни из файла
        FileReader file = new FileReader("src/data/holidays.json");
        JSONTokener tokener = new JSONTokener(file);
        JSONArray holidays = new JSONArray(tokener);
        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("src/data/logFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.setLevel(Level.INFO);
        //Вывод в лог
        for (Object holiday:holidays){
            String s = ((JSONObject)holiday).getString("name").toString();

            logger.info(s);


        }
        LogManager.getLogManager().reset();
    }
}
