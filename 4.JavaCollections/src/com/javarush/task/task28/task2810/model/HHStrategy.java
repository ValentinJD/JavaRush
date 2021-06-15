package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36";
    private static final String referrer = "https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";
    private static final int timeout = 5 * 1000;
    private static final String URL_hash = "http://javarush.ru/testdata/big28data.html";

    public static String getUrlFormat() {
        return URL_FORMAT;
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> listVacancy = new ArrayList<>();
        Document document = null;
        for (int i = 0; ; i++) {
            try {
                document = getDocument(searchString, i);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (elements.size() == 0) break;

            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(
                        element.getElementsByAttributeValueContaining(
                                "data-qa", "vacancy-serp__vacancy-title").text().trim());
                vacancy.setCity(
                        element.getElementsByAttributeValueContaining(
                                "data-qa", "vacancy-serp__vacancy-address").text().trim());
                vacancy.setCompanyName(
                        element.getElementsByAttributeValueContaining(
                                "data-qa", "vacancy-serp__vacancy-employer").text().trim());
                vacancy.setUrl(
                        element.getElementsByAttributeValueContaining(
                                "data-qa", "vacancy-serp__vacancy-title")
                                .attr("href").trim());
                vacancy.setSiteName(URL_FORMAT);
                vacancy.setSalary(
                        element.getElementsByAttributeValueContaining(
                                "data-qa", "vacancy-serp__vacancy-compensation"
                        ).text().trim());
                listVacancy.add(vacancy);
            }
        }
        return listVacancy;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String city = searchString;
        return Jsoup.connect(String.format(URL_FORMAT, city, page))
                .userAgent(userAgent)
                .referrer(referrer).get();
    }
}

