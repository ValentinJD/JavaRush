package com.javarush.task.task40.task4002;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

/* 
Опять POST, а не GET
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost("https://enpfh0sze0hf.x.pipedream.net", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        HttpClient client = getHttpClient(); // создаем клиента

        HttpPost request = new HttpPost(url); // создаем запрос

        request.addHeader("User-Agent", "Mozilla/5.0"); // устанавливаем параметры запроса

        List<NameValuePair> params = URLEncodedUtils.parse(urlParameters, Charset.forName("UTF-8"));
        // Для работы с библиотекой апачи нужно для создания ентити распарсить в лист запрос
        HttpEntity httpEntity = new UrlEncodedFormEntity(params); // создаем ентити

        request.setEntity(httpEntity); // устанавливаем в запрос ентити

        HttpResponse response = client.execute(request); // получаем ответ от сервера

        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());// получаем код ответа от сервера

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        // записываем ответный контент от сервера из инпустрима
        StringBuffer result = new StringBuffer();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result.toString());
    }

    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
}
