package com.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Свойства URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) throws MalformedURLException {
        try {
            URL url = new URL(s);
            url.sameFile(url);
            String protocol = url.getProtocol();
            String authority = url.getAuthority();
            String file = url.getFile();
            String host = url.getHost();
            String path = url.getPath();
            int port = url.getPort();
            int defaultPort = url.getDefaultPort();
            String query = url.getQuery();
            String ref = url.getRef();
            System.out.println(protocol);
            System.out.println(authority);
            System.out.println(file);
            System.out.println(host);
            System.out.println(path);
            System.out.println(port);
            System.out.println(defaultPort);
            System.out.println(query);
            System.out.println(ref);
        } catch (MalformedURLException e) {
           System.out.format("Parameter %s is not a valid URL.", s);
        }

    }
}

