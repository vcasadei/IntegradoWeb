/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author andre
 */
public class ArticleResult {
    private String titulo;
    private String resumo;
    private String id;
    
    public ArticleResult(String titulo, String resumo, String id) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.id = id;
    }
    
    public ArticleResult() {
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
