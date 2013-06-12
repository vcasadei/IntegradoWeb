/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBanco;

import java.util.ArrayList;

/**
 *
 * @author Ian
 */
public class Article {

    public Article(String articleID, String title) {
        this.articleID = articleID;
        this.title = title;
    }

    public Article() {
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPagination() {
        return pagination;
    }

    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(String publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
    
    public ArrayList<Author> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Author> autores) {
        this.autores = autores;
    }

    public ArrayList<MeshHeading> getMeshHeading() {
        return meshHeading;
    }

    public void setMeshHeading(ArrayList<MeshHeading> meshHeading) {
        this.meshHeading = meshHeading;
    }

    public ArrayList<PublicationType> getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(ArrayList<PublicationType> publicationType) {
        this.publicationType = publicationType;
    }

    public ArrayList<Chemical> getChemical() {
        return chemical;
    }

    public void setChemical(ArrayList<Chemical> chemical) {
        this.chemical = chemical;
    }

    public ArrayList<KeyWord> getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(ArrayList<KeyWord> keyWord) {
        this.keyWord = keyWord;
    }
    
    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    } 
    
    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
    private String resumo;
    private String articleID;
    private String username;
    private String title;
    private String pagination;
    private String volume;
    private String issue;
    private String articleDate;
    private String publicationStatus;
    private String affiliation;
    private Journal journal;
    private ArrayList <Author> autores;
    private ArrayList <MeshHeading> meshHeading;
    private ArrayList <PublicationType> publicationType;
    private ArrayList <Chemical> chemical;
    private ArrayList <KeyWord> keyWord;
}
