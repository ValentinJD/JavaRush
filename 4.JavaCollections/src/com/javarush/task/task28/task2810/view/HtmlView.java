package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HtmlView implements View {

    private Controller controller;

    private final String filePath = "./4.JavaCollections/src/" +
            this.getClass().getPackage().getName().replace('.', '/') +
            "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies) {
        // System.out.println(filePath);
        updateFile(getUpdatedFileContent(vacancies));
        vacancies.forEach(vacancy -> System.out.println(vacancy));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList) {
        Document document = null;
        try {
            document = getDocument();

            Element templateOriginal = document.getElementsByClass("template").first();
            Element copyTemplate = templateOriginal.clone();
            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");
            document.select("tr[class=vacancy]").remove(); //.not("tr[class=vacancy template");


            for (Vacancy vacancy : vacancyList) {
                Element localClone = copyTemplate.clone();
                localClone.getElementsByClass("city").first()
                        .text(vacancy
                                .getCity());
                localClone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                localClone.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = localClone.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateOriginal.before(localClone.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }


        return document.html();
    }

    private void updateFile(String string) {
        try {
            BufferedWriter reader = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            reader.write(string);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        File in = new File(filePath);
        return Jsoup.parse(in, "UTF-8");
    }
}
