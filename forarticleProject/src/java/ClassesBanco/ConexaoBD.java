/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBanco;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Ian
 */
public class ConexaoBD {
    
    Connection con;
    Statement stmt;
    
    //Realiza a conexão com o Banco de dados
    private void conectarBD(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;DatabaseName=LABBD;integratedSecurity=true;";
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
        }catch(java.sql.SQLException e){
            System.err.print("SQLException: " + e.getMessage());
        }catch(java.lang.ClassNotFoundException e){
            System.err.print("JavaSQLException: " + e.getMessage());
        }
    }
    
    //Fecha a conexão com o banco
    private void fecharBD(){
        try{
            con.close();
        }catch(java.sql.SQLException e){
            System.err.print("SQLException: " + e.getMessage());
        }
    }
    
    //Função auxiliar para verificar o login
    public boolean login(){
        conectarBD();
        fecharBD();
        return false;
    }
    
    //Função auxiliar para a pesquisa de journal
    public ArrayList<Journal> pesquisarJournal(String title){
        
        //realiza a conexão com o banco de dados
        conectarBD();
        
        //lista de journal resultantes
        ArrayList<Journal> resposta = new ArrayList();
        
        //auxiliar utilizado para popular a lista de journal
        Journal auxiliarJ = new Journal();
        
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        //string com a query a ser executada no banco de dados
        String sql;
        sql = "SELECT * FROM Journal WHERE title like '" + title + "%'";
        
        
        try{
            //resultado recebe o resultado da busca
            resultado = stmt.executeQuery(sql);
            
            //percorre a lista de tuplas encontradas
            while(resultado.next()){
                
                //altera cada campo do Journal auxiliar 
                auxiliarJ.setISSN(resultado.getString(1));
                auxiliarJ.setTitle(resultado.getString(2));
                auxiliarJ.setAbreviation(resultado.getString(3));
                auxiliarJ.setNlmUniqueID(resultado.getString(4));
                
                //adiciona o autor na lista de resposta
                resposta.add(auxiliarJ);
            }
           
        }catch (java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        //fecha a conexão com o banco
        fecharBD();
        
        //retorna a lista populada com os resultados
        return resposta;
    }
    
    //Função auxiliar para a pesquisa de publicationType
    public ArrayList<PublicationType> pesquisarPublicationType(String typeName){
        
        //realiza a conexão com o banco de dados
        conectarBD();
        
        //lista de publicationType resultantes
        ArrayList<PublicationType> resposta = new ArrayList();
        
        //auxiliar utilizado para popular a lista de publicationType
        PublicationType auxiliarP = new PublicationType();
        
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        //string com a query a ser executada no banco de dados
        String sql;
        sql = "SELECT * FROM PublicationType WHERE typeName like '" + typeName + "%'";
        
        try{
            //resultado recebe o resultado da busca
            resultado = stmt.executeQuery(sql);
            
            //percorre a lista de tuplas encontradas
            while(resultado.next()){
                
                //altera o typeName do PublicationType auxiliar 
                auxiliarP.setTypeName(resultado.getString(1));
                
                //adiciona o publicationType na lista de resposta
                resposta.add(auxiliarP);
            }
           
        }catch (java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        //fecha a conexão com o banco
        fecharBD();
        
        //retorna a lista populada com os resultados
        return resposta;
    }
    
    //Função auxiliar para a pesquisa de keyWord
    public ArrayList<KeyWord> pesquisarKeyWord(String keyWordName){
        
        //realiza a conexão com o banco de dados
        conectarBD();
        
        //lista de keyWord resultantes
        ArrayList<KeyWord> resposta = new ArrayList();
        
        //auxiliar utilizado para popular a lista de keyWord
        KeyWord auxiliarK = new KeyWord();
        
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        //string com a query a ser executada no banco de dados
        String sql = "SELECT * FROM Keyword WHERE keyWordName like '" + keyWordName + "%'";
        
        try{
            //resultado recebe o resultado da busca
            resultado = stmt.executeQuery(sql);
            
            //percorre a lista de tuplas encontradas
            while(resultado.next()){
                
                //altera o keyWordName do KeyWord auxiliar 
                auxiliarK.setKeyWord(resultado.getString(1));
                
                //adiciona o keyWord na lista de resposta
                resposta.add(auxiliarK);
            }
           
        }catch (java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        //fecha a conexão com o banco
        fecharBD();
        
        //retorna a lista populada com os resultados
        return resposta;
    }
    
    //Função auxiliar para a pesquisa de keyWord
    public ArrayList<Chemical> pesquisarChemical(String chemicalName){
        
        //realiza a conexão com o banco de dados
        conectarBD();
        
        //lista de chemical resultantes
        ArrayList<Chemical> resposta = new ArrayList();
        
        //auxiliar utilizado para popular a lista de chemical
        Chemical auxiliarC = new Chemical();
        
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        //string com a query a ser executada no banco de dados
        String sql = "SELECT * FROM Chemical WHERE chemicalName like '" + chemicalName + "%'";
        
        try{
            //resultado recebe o resultado da busca
            resultado = stmt.executeQuery(sql);
            
            //percorre a lista de tuplas encontradas
            while(resultado.next()){
                
                //altera o chemicalName do Chemical auxiliar 
                auxiliarC.setChemicalName(resultado.getString(1));
                
                //adiciona o chemical na lista de resposta
                resposta.add(auxiliarC);
            }
           
        }catch (java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        //fecha a conexão com o banco
        fecharBD();
        
        //retorna a lista populada com os resultados
        return resposta;
    }
    
    //Função auxiliar para a pesquisa de meshHeading
    public ArrayList<MeshHeading> pesquisarMeshHeading(String descriptionName){
        
        //realiza a conexão com o banco de dados
        conectarBD();
        
        //lista de meshHeading resultantes
        ArrayList<MeshHeading> resposta = new ArrayList();
        
        //auxiliar utilizado para popular a lista de meshHeading
        MeshHeading auxiliarM = new MeshHeading();
        
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        //string com a query a ser executada no banco de dados
        String sql = "SELECT * FROM MeshHeading WHERE descriptionName like '" + descriptionName + "%'";
        
        try{
            //resultado recebe o resultado da busca
            resultado = stmt.executeQuery(sql);
            
            //percorre a lista de tuplas encontradas
            while(resultado.next()){
                
                //altera o descriptionName do MeshHeading auxiliar 
                auxiliarM.setDescriptionName(resultado.getString(1));
                
                //adiciona o meshHeading na lista de resposta
                resposta.add(auxiliarM);
            }
           
        }catch (java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        //fecha a conexão com o banco
        fecharBD();
        
        //retorna a lista populada com os resultados
        return resposta;
    }
    
    //Função auxiliar para a pesquisa de autores
    public ArrayList<Author> pesquisarAuthor(String foreName, String lastName){
        
        //realiza a conexão com o banco de dados
        conectarBD();
        
        //lista de autores resultantes
        ArrayList<Author> resposta = new ArrayList();
        
        //auxiliar utilizado para popular a lista de autores
        Author auxiliarA = new Author();
        
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        //string com a query a ser executada no banco de dados
        String sql;
        
        //Verifica se algum dos campos está em branco e monta a query correspondente
        if(foreName.isEmpty()){
            sql = "SELECT * FROM Author WHERE lastName like '" + lastName +  "%'";
        }else if(lastName.isEmpty()){
            sql = "SELECT * FROM Author WHERE foreName like '" + foreName +  "%'";
        }else{
            sql = "SELECT * FROM Author WHERE foreName like '" + foreName +  "%' AND lastName like '" + lastName + "%'";
        }
        
        try{
            //resultado recebe o resultado da busca
            resultado = stmt.executeQuery(sql);
            
            //percorre a lista de tuplas encontradas
            while(resultado.next()){
                
                //altera cada campo do Author auxiliar 
                auxiliarA.setForeName(resultado.getString(1));
                auxiliarA.setLastName(resultado.getString(2));
                auxiliarA.setInitials(resultado.getString(3));
                
                //adiciona o autor na lista de resposta
                resposta.add(auxiliarA);
            }
           
        }catch (java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        //fecha a conexão com o banco
        fecharBD();
        
        //retorna a lista populada com os resultados
        return resposta;
    }
    
    //Função auxiliar para a pesquisa simples (titulo do artigo)
    public ArrayList<Article> pesquisarSimples(String valorBusca){
        
        //lista de artigos com o titulo buscado
        ArrayList <Article> resposta = new ArrayList();
                
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        //realiza a conexão com o banco de dados
        conectarBD();
     
        //string com a query a ser executada no banco de dados
        String sql = "SELECT articleID, title, resumo FROM ARTICLE WHERE title LIKE '%" + valorBusca + 
                "%' ORDER BY title";
        
        try{
            
            //executa a query e armazena em resultado
            resultado = stmt.executeQuery(sql);
            
            //resultado possui uma lista com as tuplas selecionadas no banco
            
            while(resultado.next()){
                //auxiliar utilizado para popular a lista de artigos
                Article auxiliarA = new Article();

                //monta um artigo na variavel auxiliarA a ser adiconado 
                //na lista de artigos encontrados
                auxiliarA.setArticleID(resultado.getString(1));            
                auxiliarA.setTitle(resultado.getString(2));
                auxiliarA.setResumo(resultado.getString(3));
                
                //adiciona o artigo na lista
                resposta.add(auxiliarA);
            }
            
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        //fecha a conexão com o banco
        fecharBD();
        
        //retorna a lista populada com os resultados
        return resposta;
    }
    
    //Função auxiliar para pesquisar todos os dados do artigo
    public Article pesquisarArtigo(String articleID){
        
        //auxiliar para armazenamento do artigo
        Article resposta = null;
        
        Journal auxiliarJ = new Journal();
     
        //Auxiliares para armazenar os autores
        ArrayList<Author> autores = new ArrayList();
        
        //Auxiliares para armazenar as keyWords
        ArrayList<KeyWord> keyWords = new ArrayList();
        
        //Auxiliares para armazenar os publicationType
        ArrayList<PublicationType> publicationType = new ArrayList();
        
        //Auxiliares para armazenar os meshHeading
        ArrayList<MeshHeading> meshHeading = new ArrayList();
        
        //Auxiliares para armazenar os chemical
        ArrayList<Chemical> chemical = new ArrayList();
        
        //estabelece uma conexão com o banco de dados
        conectarBD();
        
        //string com a query a ser executada no banco de dados
        String sql = "SELECT * FROM ARTICLE WHERE articleID = '" + articleID + "'";
        
        //variável para armazenar o resultado da pesquisa no banco
        ResultSet resultado;
        
        try{
            
            resposta = new Article();
            //realização da busca pelos dados do artigo
            resultado = stmt.executeQuery(sql);
            resultado.next();
            
            //inicialização da variavel article com os resultados da busca
            resposta.setArticleID(resultado.getString("articleID"));
            resposta.setUsername(resultado.getString("loginUser"));
            resposta.setTitle(resultado.getString("title"));
            resposta.setPagination(resultado.getString("pagination"));
            resposta.setVolume(resultado.getString("volume"));
            resposta.setIssue(resultado.getString("issue"));
            resposta.setArticleDate(resultado.getString("articleDate"));
            resposta.setPublicationStatus(resultado.getString("publicationStatus"));
            resposta.setAffiliation(resultado.getString("affiliation"));
            
            //Query para buscar o journal relacionado ao artigo
            sql = "SELECT * FROM Journal WHERE NlmUniqueID = '" + resultado.getString("journal") + "'";
            resultado = stmt.executeQuery(sql);
            resultado.next();
            
            //inicialização da variavel journal auxiliar com os resultados da busca
            auxiliarJ.setISSN(resultado.getString("ISSN"));
            auxiliarJ.setTitle(resultado.getString("title"));
            auxiliarJ.setAbreviation(resultado.getString("abreviation"));
            auxiliarJ.setNlmUniqueID(resultado.getString("NlmUniqueID"));
            
            //inserção do journal inicializado no artigo
            resposta.setJournal(auxiliarJ);
            
            //Query para buscar a lista de autores do artigo
            sql = "SELECT forename, lastname, initials FROM AuthorArticle WHERE articleID = '" + articleID + "' ";
            resultado = stmt.executeQuery(sql);
            
            //Percorre a lista com os resultados da busca de autores
            while(resultado.next()){
                //adiciona o elemento a lista de autores auxiliar
                autores.add( new Author(resultado.getString("foreName"), resultado.getString("lastName"), resultado.getString("initials")));
            }
            //adiciona a lista de autores ao artigo
            resposta.setAutores(autores);
            
            //Query para selecionar a lista de MeshHeading correspondente ao artigo
            sql = "SELECT meshHeading FROM ArticleMeshHeadingList WHERE articleID = '"+ articleID + "'";
            resultado = stmt.executeQuery(sql);
            
            //Percorre a lista com os resultados da busca
            while(resultado.next()){
                //adiciona o elemento na lista auxiliar de meshHeading
                meshHeading.add(new MeshHeading(resultado.getString("meshHeading")));
            }
            //adiciona a lista de meshHeading ao artigo
            resposta.setMeshHeading(meshHeading);
            
            //Query utilizada para buscar pelas keywords relacionadas ao artigo
            sql = "SELECT keyWord FROM ArticleKeywordList WHERE articleID = '" + articleID + "'";
            resultado = stmt.executeQuery(sql);            
            
            //Percorre a lista com os resultados da busca
            while(resultado.next()){
                //adiciona o elemento na lista auxiliar de keyWords
                keyWords.add( new KeyWord(resultado.getString("keyWordName")));
            }
            //adiciona a lista de keyWords ao artigo
            resposta.setKeyWord(keyWords);
            
            //Query utilizada para buscar pelos publicationType relacionados ao artigo
            sql = "SELECT publicationTypeName FROM ArticlePublicationType WHERE articleID = '" + articleID + "'";
            resultado = stmt.executeQuery(sql);
            
            //Percorre a lista com os resultados da busca
            while(resultado.next()){
                System.out.println("PT: " + resultado.getString("publicationTypeName"));
                
                //adiciona o elemento na lista auxiliar de publicationType
                publicationType.add( new PublicationType(resultado.getString("publicationTypeName")));
            }
            //adiciona a lista de publicationType ao artigo
            resposta.setPublicationType(publicationType);
            System.out.println("chegou\n");
            
            //Query utilizada para buscar pelos chemical relacionados ao artigo
            sql = "SELECT chemicalName FROM ArticleChemicalList WHERE articleID = '" + articleID + "'";
            resultado = stmt.executeQuery(sql);
            
            //Percorre a lista com os resultados da busca
            while(resultado.next()){
                //adiciona o elemento na lista auxiliar de chemical
                chemical.add(new Chemical(resultado.getString("chemicalName")));
            }
            //adiciona a lista de chemical ao artigo
            resposta.setChemical(chemical);
            
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
        }
        
        
        //finaliza a conexão com o banco
        fecharBD();
        return resposta;
    }
    
    //Função auxiliar para excluir o artigo escolhido    
    public boolean excluirArtigo(String articleID){
        conectarBD();
            
        //Query para excluir o artigo definido
        String sql;
        sql = "DELETE FROM Article WHERE Article.articleID = '" + articleID + "'";
        
        try{
            stmt.execute(sql);
            
            //Query para excluir a ligação dos autores com o artigo excluido
            sql = "DELETE FROM AuthorArticle WHERE articleID = '" + articleID + "'";
            stmt.execute(sql);
            
            //Query para excluir a ligação dos meshHeading com o artigo excluido
            sql = "DELETE FROM ArticleMeshHeadingList WHERE articleID = '" + articleID + "'";
            stmt.execute(sql);
            
            //Query para excluir a ligação dos publicationType com o artigo excluido
            sql = "DELETE FROM ArticlePublicationType WHERE articleID = '" + articleID + "'";
            stmt.execute(sql);
            
            //Query para excluir a ligação das keyWords com o artigo excluido
            sql = "DELETE FROM ArticleKeywordList WHERE articleID = '" + articleID + "'";
            stmt.execute(sql);
            
            //Query para excluir a ligação das chemical com o artigo excluido
            sql = "DELETE FROM ArticleChemicalList WHERE articleID = '" + articleID + "'";
            stmt.execute(sql);
            
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para excluir o journal escolhido    
    public boolean excluirJournal(String nlmUniqueID){
        conectarBD();
            
        //Query para excluir o journal definido
        String sql;
        sql = "DELETE FROM Journal WHERE Journal.NlmUniqueID = '" + nlmUniqueID + "'";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para excluir o meshHeading escolhido    
    public boolean excluirMeshHeading(String descriptionName){
        conectarBD();
            
        //Query para excluir o MeshHeading definido
        String sql;
        sql = "DELETE FROM MeshHeading WHERE MeshHeading.descriptionName = '" + descriptionName + "'";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para excluir o autor escolhido 
    public boolean excluirAuthor(String foreName, String lastName, String initials){
        conectarBD();
            
        //Query para excluir o Author definido
        String sql;
        sql = "DELETE FROM Author WHERE foreName = '" + foreName + "'"
                + " AND lastName = '" + lastName + "' AND initials = '" + initials + "'";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para excluir o publicationType escolhido 
    public boolean excluirPublicationType(String typeName){
        conectarBD();
            
        //Query para excluir o publicationType definido
        String sql;
        sql = "DELETE FROM PublicationType WHERE typeName = '" + typeName + "'";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para excluir a Keyword escolhida
    public boolean excluirKeyword(String keyWordName){
        conectarBD();
            
        //Query para excluir a Keyword definida
        String sql;
        sql = "DELETE FROM Keyword WHERE keyWordName = '" + keyWordName + "'";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para excluir o Chemical escolhido
    public boolean excluirChemical(String chemicalName){
        conectarBD();
            
        //Query para excluir a Chemical definida
        String sql;
        sql = "DELETE FROM Chemical WHERE chemicalName = '" + chemicalName + "'";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //função auxiliar para inserir um Chemical
    public boolean inserirChemical(String chemicalName){
        conectarBD();
            
        //Query para inserir a Chemical definida
        String sql;
        sql = "INSERT INTO Chemical VALUES ('" + chemicalName + "')";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //função auxiliar para inserir um Journal
    public boolean inserirJournal(String ISSN, String title, String abreviation, String nlmUniqueID){
        conectarBD();
            
        //Query para inserir a Journal definida
        String sql;
        sql = "INSERT INTO Journal VALUES ('" + ISSN + "', '" + title + "', '" + abreviation 
                + "', '" + nlmUniqueID +"' )";
        System.out.println(sql);
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para inserir o publicationType escolhido 
    public boolean inserirPublicationType(String typeName){
        conectarBD();
            
        //Query para inserir o publicationType definido
        String sql;
        sql = "INSERT INTO PublicationType VALUES ('" + typeName + "')";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para inserir o autor escolhido 
    public boolean inserirAuthor(String foreName, String lastName, String initials){
        conectarBD();
            
        //Query para inserir o Author definido
        String sql;
        sql = "INSERT INTO Author VALUES ('" + foreName + "', '"  + lastName + "', '" + initials + "')";
        System.out.println("inserir author "+sql);
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para inserir o meshHeading escolhido    
    public boolean inserirMeshHeading(String descriptionName){
        conectarBD();
            
        //Query para inserir o MeshHeading definido
        String sql;
        sql = "Insert INTO MeshHeading VALUES ('" + descriptionName + "')";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para inserir a Keyword escolhida
    public boolean inserirKeyword(String keyWordName){
        conectarBD();
            
        //Query para inserir a Keyword definida
        String sql;
        sql = "INSERT INTO Keyword VALUES ('" + keyWordName + "')";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.err.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para alterar um Journal pelo id do mesmo
    public boolean alterarJournal(String ISSN, String journalTitle, String abreviation, String pkey){
        conectarBD();
            
        //Query para alterar um Journal pelo NlmUniqueID (var pkey)
        String sql;
        sql = "UPDATE Journal SET "
                + "title = '" + journalTitle + "', "
                + " abreviation = '"+ abreviation + "' "
                + " WHERE NlmUniqueID = '"+ pkey + "';"; 
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para alterar um Article pelo id do mesmo
    public boolean alterarArticle(String articleID, String journal, String title, String pagination, 
            String volume, String issue, String articleData, String publicationStatus, String affiliation){
        conectarBD();
            
        //Query para alterar um Article pelo articleID
        String sql;
        sql = "UPDATE Article SET journal =  '"+ journal +"', "
                + "title = '" + title +"', "
                + "pagination = '"+ pagination +"', "
                + "volume = '"+ volume +"', "
                + "issue = '"+ issue +"', "
                + "articleData = '"+ articleData +"', "
                + "publicationStatus '= "+ publicationStatus +"', "
                + "affiliation = '"+ affiliation +"' "
                + "WHERE articleID = '"+ articleID + "';";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para inserir um Article
    public boolean inserirArticle(String articleID, String nlmuniqueid, String title, String pagination, String volume,
            String issue, String articleDate, String publicationStatus, String affiliation, String loginUser){
        conectarBD();
            
        //Query para inserir um artigo
        String sql;
        sql = "INSERT INTO Article VALUES ('"+ articleID +"',"
                + "'"+ nlmuniqueid +"',"
                + "'" + title +"', "
                + "'"+ pagination +"', "
                + "'"+ volume +"', "
                + "'"+ issue +"', "
                + "'"+ articleDate +"', "
                + "'"+ publicationStatus +"', "
                + "'"+ affiliation +"', "
                + "'"+ loginUser +"');";
        System.out.println(sql);
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um MeshHeading associado a um argigo
    public boolean removerArticleMeshHeading(String articleID, String meshHeading){
        conectarBD();
            
        //Query para remover um item da lista de Meshs do Artigo
        String sql;
        sql = "DELETE FROM ArticleMeshHeadingList WHERE articleID = '" + articleID + "' "
                + "AND meshHeading = '" + meshHeading +"';";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um MeshHeading associado a um argigo
    public boolean inserirArticleMeshHeading(String articleID, String meshHeading){
        conectarBD();
            
        //Query para adicionar um item na lista de Meshs do Artigo
        String sql;
        sql = "INSERT INTO ArticleMeshHeadingList VALUES ('" + articleID + "','"+ meshHeading +"');";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um Chemical associado a um argigo
    public boolean removerArticleChemical(String articleID, String chemicalName){
        conectarBD();
            
        //Query para remover um item da lista de Chemicals do Artigo
        String sql;
        sql = "DELETE FROM ArticleChemicalList WHERE articleID = '" + articleID + "'s"
                + "AND chemicalName = '" + chemicalName +"';";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um Chemical associado a um argigo
    public boolean inserirArticleChemical(String articleID, String chemicalName){
        conectarBD();
            
        //Query para adicionar um item na lista de Chemicals do Artigo
        String sql;
        sql = "INSERT INTO ArticleChemicalList VALUES ('" + articleID + "','"+ chemicalName +"');";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um PublicationType associado a um argigo
    public boolean removerArticlePublicationType(String articleID, String publicationTypeName){
        conectarBD();
            
        //Query para remover um publication type associado a um Article
        String sql;
        sql = "DELETE FROM ArticlePublicationType WHERE articleID = '" + articleID +"'"
                + "AND publicationTypeName = '" + publicationTypeName +"';";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um PublicationType associado a um argigo
    public boolean inserirArticlePublicationType(String articleID, String publicationTypeName){
        conectarBD();
            
        //Query para adicionar um item na lista de publication type do Artigo
        String sql;
        sql = "INSERT INTO ArticlePublicationType VALUES ('" + articleID + "','"+ publicationTypeName +"');";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um Keyword associado a um argigo
    public boolean removerArticleKeyword(String articleID, String keyword){
        conectarBD();
            
        //Query para remover uma keyword associada a um Article
        String sql;
        sql = "DELETE FROM ArticleKeywordList WHERE articleID = '" + articleID + "' "
                + "AND keyword = '" + keyword+ "';";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    //Função auxiliar para remover um Keyword associado a um argigo
    public boolean inserirArticleKeyword(String articleID, String keyword){
        conectarBD();
            
        //Query para inserir uma keyword na lista de keywors associadas a um Article 
        String sql;
        sql = "INSERT INTO ArticleKeywordList VALUES ('" + articleID + "','"+ keyword +"');";
        
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
    
    public boolean inserirArticleAuthor(String foreName, String lastName, String initials, String articleID){
        conectarBD();
            
        //Query para adicionar um item na lista de Meshs do Artigo
        String sql;
        sql = "INSERT INTO authorArticle VALUES ('" + articleID + "','"+ foreName +"', '"
                + lastName +"', '"+ initials +"');";
        System.out.println("ins author arti "+sql);
        try{
            stmt.execute(sql);
        }catch(java.sql.SQLException e){
            System.out.printf("SQLException: " + e.getMessage());
            return false;
        }  
        fecharBD();
        return true;
    }
} 