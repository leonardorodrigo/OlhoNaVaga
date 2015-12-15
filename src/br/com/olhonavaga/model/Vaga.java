package br.com.olhonavaga.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 09:33
 */
public class Vaga implements Serializable {

    private String id;
    private String created_at;
    private String title;
    private String location;
    private String type;
    private String description;
    private String how_to_apply;
    private String company;
    private String company_url;
    private String company_logo;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowToApply() {
        return how_to_apply;
    }

    public void setHowToApply(String how_to_apply) {
        this.how_to_apply = how_to_apply;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyUrl() {
        return company_url;
    }

    public void setCompanyUrl(String company_url) {
        this.company_url = company_url;
    }

    public String getCompanyLogo() {
        return company_logo;
    }

    public void setCompanyLogo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
