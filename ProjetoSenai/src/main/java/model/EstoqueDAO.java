
package model;


import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    // metodo para salvar
    //eb = estoqueBean
    //usar list no medoto para listar na tabela
    
    public void cadastrar(EstoqueBean eb) {
        String sql = "INSERT INTO estoque (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";
        try {
           
            Connection conn = new Conexao().conexao(); 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, eb.getNome());
            pst.setString(2, eb.getDescricao());
            pst.setInt(3, eb.getQuantidade());
            pst.setDouble(4, eb.getPreco());
            
            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
        }
    }
  
    public void excluir(int id) {
    String sql = "DELETE FROM estoque WHERE id = ?";
    try {
        Connection conn = new Conexao().conexao();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id); //isso daq é para passar o id relacionado
        
        pst.execute();
        pst.close();
    } catch (Exception e) {
        System.out.println("Erro ao excluir: " + e);
    }
}
    
    public List<EstoqueBean> listarTudo() {
    String sql = "SELECT * FROM estoque";
    List<EstoqueBean> lista = new ArrayList<>();
    
    try {
       
        Connection conn = new Conexao().conexao();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery(); 
        
        while (rs.next()) {
            EstoqueBean eb = new EstoqueBean();
            
            eb.setId(rs.getInt("id"));
            eb.setNome(rs.getString("nome"));
            eb.setDescricao(rs.getString("descricao"));
            eb.setQuantidade(rs.getInt("quantidade"));
            eb.setPreco(rs.getDouble("preco"));
            lista.add(eb);
        }
        
        
        
        
        rs.close();
        pst.close();
    } catch (Exception e) {
        System.out.println("Erro ao listar dados: " + e);
    }
    
    return lista;
}
    
    public void atualizar(EstoqueBean eb) {
    String sql = "UPDATE estoque SET nome = ?, descricao = ?, quantidade = ?, preco = ? WHERE id = ?";
    try {
        Connection conn = new Conexao().conexao();
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, eb.getNome());
        pst.setString(2, eb.getDescricao());
        pst.setInt(3, eb.getQuantidade());
        pst.setDouble(4, eb.getPreco());
        pst.setInt(5, eb.getId()); 
        
        pst.execute();
        pst.close();
    } catch (Exception e) {
        System.out.println("Erro ao atualizar: " + e);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

