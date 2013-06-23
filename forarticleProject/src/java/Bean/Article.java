/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;

/**
 *
 * @author Ian
 */
public class Article {

    public Article(String articleID, String resumo, String title) {
        this.articleID = articleID;
        this.title = title;
        this.resumo = resumo;
        this.flag = 0;
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

    public void setArticleDate(String articleString) {
        this.articleDate = articleString;
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

    public ArrayList<String> getMeshHeading() {
        return meshHeading;
    }

    public ArrayList<String> getPublicationType() {
        return publicationType;
    }

    public ArrayList<String> getChemical() {
        return chemical;
    }

    public ArrayList<String> getKeyWord() {
        return keyWord;
    }

    public void setMeshHeading(ArrayList<String> meshHeading) {
        this.meshHeading = meshHeading;
    }

    public void setPublicationType(ArrayList<String> publicationType) {
        this.publicationType = publicationType;
    }

    public void setChemical(ArrayList<String> chemical) {
        this.chemical = chemical;
    }

    public void setKeyWord(ArrayList<String> keyWord) {
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
    
    public void addKeyWord(String keyword){
        this.keyWord.add(keyword);
    }
    
    public void addMeshHeading(String mesh){
        this.meshHeading.add(mesh);
    }
    
    public void addPublicationType(String type){
        this.publicationType.add(type);
    }
    
    public void addAuthor(Author autor){
        this.autores.add(autor);
    }
    
    public void addChemical(String chemical){
        this.chemical.add(chemical);
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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
    private ArrayList <String> meshHeading;
    private ArrayList <String> publicationType;
    private ArrayList <String> chemical;
    private ArrayList <String> keyWord;
    private int flag;
}