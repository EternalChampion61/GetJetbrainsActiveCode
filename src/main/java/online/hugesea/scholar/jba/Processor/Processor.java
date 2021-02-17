package online.hugesea.scholar.jba.Processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Processor {

    /**
     * This function will return the content from API.
     * @return String: Content of API.
     */
    public String GetContentFromAPI() {
        URL API;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuffer = new StringBuilder();
        try {
            String urlOfAPI = "http://idea.medeming.com/jets/images/jihuoma.txt";
            API = new URL(urlOfAPI);
            bufferedReader = new BufferedReader(new InputStreamReader(API.openStream(), "GBK"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException ignored) { }
        }
        return stringBuffer.toString();
    }
}
