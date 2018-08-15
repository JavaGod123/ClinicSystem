/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Nicolas
 */
import conexao.ConnectionFactory;
import interfaces.IDAO;
    import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Estado;

public class EstadoDAO implements IDAO<Estado> {

    private Connection conexao;

    private static final String ADD_ESTADO = "insert into estado(nome,uf) values(?,?);";
    private static final String REMOVE_ESTADO = "delete from estado where estadoId= ?;";
    private static final String UPDATE_ESTADO = "update estado set nome=? , uf=? " +
            "where estadoId=?;";
    private static final String GETALL_ESTADO = "select * from estado;";
    private static final String GETBYID_ESTADO = "select * from estado where estadoId=?;";
    private static final String ORDER_BY = "SELECT * FROM estado ORDER BY uf;";

    
    private static final String PRIMARY_KEY = "estadoId";
    private static final String NOME_ESTADO = "nome";
    private static final String UF_ESTADO = "uf";


    public EstadoDAO(Connection connection) {
        this.conexao = connection;
    }

    public EstadoDAO() {
         
    }

    @Override
    public void insert(Estado estado) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(ADD_ESTADO);
            stmt.setString(1,estado.getNome().toUpperCase());
            stmt.setString(2,estado.getUf().toUpperCase());
            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: " + e);
            e.printStackTrace();
        }
        finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    @Override
    public void remove(Estado estado) {
        //esse método , para evitar codigo repitido , ira chamar o remove(int id)
        remove(estado.getEstadoId());
    }

    @Override
    public void remove(int id) {
        Connection con = ConnectionFactory.obterConexao();
        
        try {
            PreparedStatement stmt = con.prepareStatement(REMOVE_ESTADO);
            stmt.setInt(1,id);//transforma o valor do id para uma string
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e ) {
            e.printStackTrace();
            //SQLIntegrityConstraintViolationException já é pega pelo SQLException
        }
    }

    @Override
    public void update(Estado estado) {
        Connection con = ConnectionFactory.obterConexao();
        
        try{
            PreparedStatement stmt = con.prepareStatement(UPDATE_ESTADO);

            stmt.setString(1, estado.getNome().toUpperCase());
            stmt.setString(2, estado.getUf().toUpperCase());
            stmt.setInt(3, estado.getEstadoId());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Estado> getAll() {
        List<Estado> lista = new ArrayList<>();
        Connection con = ConnectionFactory.obterConexao();
        try {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(GETALL_ESTADO);
            while (resultSet.next()){
                Estado estadoAux = new Estado();

                estadoAux.setEstadoId(resultSet.getInt(PRIMARY_KEY));
                estadoAux.setNome(resultSet.getString(NOME_ESTADO));
                estadoAux.setUf(resultSet.getString(UF_ESTADO));
               

                lista.add(estadoAux);
            }
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Estado getById(int id) {
        Estado estadoAux = null;
        Connection con = ConnectionFactory.obterConexao();
        try {
            PreparedStatement stmt = con.prepareStatement(GETBYID_ESTADO);
            stmt.setString(1,String.valueOf(id));
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                estadoAux = new Estado();
                estadoAux.setEstadoId(resultSet.getInt(PRIMARY_KEY));
                estadoAux.setNome(resultSet.getString(NOME_ESTADO));
                estadoAux.setUf(resultSet.getString(UF_ESTADO));
               
            }
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estadoAux;
    }
    
    @Override
    public List<Estado> orderByName() {
        List<Estado> lista = new ArrayList<>();
        Connection con = ConnectionFactory.obterConexao();
        try {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(ORDER_BY);
            while (resultSet.next()){
                Estado estadoAux = new Estado();

                estadoAux.setEstadoId(resultSet.getInt(PRIMARY_KEY));
                estadoAux.setNome(resultSet.getString(NOME_ESTADO));
                estadoAux.setUf(resultSet.getString(UF_ESTADO));
               

                lista.add(estadoAux);
            }
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}

