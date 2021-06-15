package com.javarush.task.task28.task2810.vo;

import java.util.Objects;

public class Vacancy {
    private String title = "default";
    private String salary = "default";
    private String city = "default";
    private String companyName = "default";
    private String siteName = "default";
    private String url = "default";

    public String getTitle() {
        return title;
    }

    public String getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(getTitle(), vacancy.getTitle()) &&
                Objects.equals(getSalary(), vacancy.getSalary()) &&
                Objects.equals(getCity(), vacancy.getCity()) &&
                Objects.equals(getCompanyName(), vacancy.getCompanyName()) &&
                Objects.equals(getSiteName(), vacancy.getSiteName()) &&
                Objects.equals(getUrl(), vacancy.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSalary(), getCity(), getCompanyName(), getSiteName(), getUrl());
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", siteName='" + siteName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
