package HtmlParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebParser {

    public StringBuilder parse(WebPage webpage){
        try {
            return this.getHtml(webpage.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private StringBuilder getHtml(String web_url) throws IOException {

        URL url = null;// 根据链接（字符串格式），生成一个URL对象
        try {
            url = new URL(web_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection urlConnection = null;// 打开URL
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream(), "utf8"));// 得到输入流，即获得了网页的内容

        StringBuilder bufr = new StringBuilder();

        String line = ""; // 读取输入流的数据，并显示
        while ((line = reader.readLine()) != null) {
            bufr.append(line);
        }
        return bufr;
    }
}
