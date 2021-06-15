package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://career.habr.com/vacancies?q=java%20Самара&type=all";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36";
    private static final String referrer = "https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";
    private static final int timeout = 5 * 1000;
    private static final String URL_hash = "http://javarush.ru/testdata/big28data2.html";


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

            Elements elements = document.getElementsByAttributeValue("class", "vacancy-card__inner");
            if (elements.size() == 0) break;

            for (Element element : elements) {

                Vacancy vacancy = new Vacancy();

                vacancy.setCompanyName(
                        element.getElementsByAttributeValue("class", "vacancy-card__title").text()       );
                /*vacancy.setTitle(
                        element.getElementsByAttributeValueContaining(
                                "class", "title").text().trim());
                vacancy.setCity(
                        element.getElementsByAttributeValueContaining(
                                "class", "location").text().trim());
                vacancy.setSiteName("https://moikrug.ru/");*/
               // Elements el = element.getElementsByClass("title").first().getElementsByTag("a");
               /* //vacancy.setTitle(el.first().text());*/
                vacancy.setUrl(URL_FORMAT );
                /*//vacancy.setUrl(vacancy.getSiteName() + element.attr("href").substring(1));*/
                /*vacancy.setUrl(
                        element.getElementsByAttributeValueContaining(
                                "class", "url")
                                .attr("href").trim());*/

                /*vacancy.setSalary(
                        element.getElementsByAttributeValueContaining(
                                "class", "salary"
                        ).text().trim());*/
                listVacancy.add(vacancy);
                break;
            }
            break;

        }
        return listVacancy;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String city = searchString;
        return Jsoup.connect(URL_FORMAT)
                .userAgent(userAgent)
                .referrer(referrer).get();
    }
}
