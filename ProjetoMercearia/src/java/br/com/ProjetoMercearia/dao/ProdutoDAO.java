
package br.com.ProjetoMercearia.dao;

import br.com.ProjetoMercearia.modelo.Produto;
import br.com.ProjetoMercearia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProdutoDAO implements GenericDAO{

    private ResultSet rs;
    private Connection conexao;
    private PreparedStatement stmt;
    
    public ProdutoDAO(){
        try{
            conexao = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao conectar ao BD: " + e.getMessage());
        }
    }
    
    
    @Override
    public Boolean cadastrar(Object object) throws Exception {
        
        Boolean retorno = true;
        
        try{
            String sql = " insert into produto (nome,qtdEstoque,valor)"
                + "values(?,?,?)";
            Produto produto = (Produto) object;
            
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQtdEstoque());
            stmt.setDouble(3, produto.getValor());
            
            stmt.execute();
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar produtoDAO" + e.getMessage());
            retorno = false;
        }finally{
            ConnectionFactory.fecharConexao(rs, stmt, conexao);
        }
        return retorno;
    }

    @Override
    public Boolean excluir(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean carregar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}