/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import conexao.ConnectionFactory;
import interfaces.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidade;
import modelo.Estado;

public class CidadeDAO implements IDAO<Cidade> {


    private static final String ADD_CIDADE = "insert into cidade(nome_cidade , cep_cidade, estadoId) VALUES(?,?,(select estadoId from estado where nome=?))";
    private static final String REMOVE_CIDADE = "delete from cidade where cidadeId= ?;";
    private static final String UPDATE_CIDADE = "update cidade set nome_cidade=? , cep_cidade=? where cidadeId=?;";
    private static final String GETALL_CIDADE_BY_ESTADO = "select * from cidade where estadoId = ?;";
    private static final String GETBYID_TIPO = "select * from cidade where cidadeId=?;";
    private static final String ORDER_BY = "SELECT * FROM cidade ORDER BY nome;";


    //////////////////////////////////////////////////////////////////////////////////////////////
    private static final String PRIMARY_KEY = "cidadeId";
    private static final String NOME_CIDADE = "nome";
    private static final String CEP_CIDADE = "cep";
    private static final String FOREIGN_KEY = "estadoId";

    private Connection conexao;

    public CidadeDAO(Connection connection) {
        this.conexao = connection;
    }
    
    public CidadeDAO(){
        
    }

    @Override
    public void insert(Cidade cidade) {
        Connection con = ConnectionFactory.obterConexao();
        try {
            PreparedStatement stmt = con.prepareStatement(ADD_CIDADE);
            
            stmt.setString(1, cidade.getNome().toUpperCase());
            stmt.setString(2, cidade.getCep());
            stmt.setString(3, cidade.getEstado().getNome().toUpperCase());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Cidade cidade) {
        remove(cidade.getCidadeId());
    }

    @Override
    public void remove(int id) {
        Connection con = ConnectionFactory.obterConexao();
        try {
            PreparedStatement stmt = con.prepareStatement(REMOVE_CIDADE);

            stmt.setInt(1, id);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cidade cidade) {
        Connection con = ConnectionFactory.obterConexao();
        try {
            PreparedStatement stmt = con.prepareStatement(UPDATE_CIDADE);

            stmt.setString(1, cidade.getNome().toUpperCase());
            stmt.setString(2, cidade.getCep());
            stmt.setInt(3,cidade.getCidadeId());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cidade> getAll() {
        List<Cidade> cidades = new ArrayList<>();
        Connection con = ConnectionFactory.obterConexao();
        try {

            EstadoDAO estadoDAO = new EstadoDAO(con);
            List<Estado> estados = estadoDAO.getAll();
            PreparedStatement stmt = con.prepareStatement(GETALL_CIDADE_BY_ESTADO);

            for (Estado e : estados) {
                stmt.setInt(1, e.getEstadoId());
                ResultSet resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    Cidade cidadeAux = new Cidade();

                    cidadeAux.setCidadeId(resultSet.getInt(PRIMARY_KEY));
                    cidadeAux.setNome(resultSet.getString(NOME_CIDADE));
                    cidadeAux.setCep(resultSet.getString(CEP_CIDADE));
                    cidadeAux.setEstado(e);

                    cidades.add(cidadeAux);
                }

                resultSet.close();
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }

    public List<Cidade> getByEstado(Estado estado) {
        List<Cidade> cidades = new ArrayList<>();
        Connection con = ConnectionFactory.obterConexao();
        try {
            PreparedStatement stmt = con.prepareStatement(GETALL_CIDADE_BY_ESTADO);
            stmt.setInt(1, estado.getEstadoId());
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Cidade cidadeAux = new Cidade();

                cidadeAux.setCidadeId(resultSet.getInt(PRIMARY_KEY));
                cidadeAux.setNome(resultSet.getString(NOME_CIDADE));
                cidadeAux.setCep(resultSet.getString(CEP_CIDADE));
                cidadeAux.setEstado(estado);

                cidades.add(cidadeAux);
            }

            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidades;
    }

    @Override
    public Cidade getById(int id) {
        Cidade cidadeBuscada = null;
        Connection con = ConnectionFactory.obterConexao();

        try {
            PreparedStatement stmt = con.prepareStatement(GETBYID_TIPO);

            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                EstadoDAO estadoDAO = new EstadoDAO(conexao);
                Estado estadoAux = estadoDAO.getById(resultSet.getInt(FOREIGN_KEY));

                cidadeBuscada = new Cidade();
                cidadeBuscada.setCidadeId(resultSet.getInt(PRIMARY_KEY));
                cidadeBuscada.setNome(resultSet.getString(NOME_CIDADE));
                cidadeBuscada.setCep(resultSet.getString(CEP_CIDADE));
                cidadeBuscada.setEstado(estadoAux);
            }

            resultSet.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidadeBuscada;
    }
    
    
     @Override
    public List<Cidade> orderByName() {
        List<Cidade> cidades = new ArrayList<>();
        Connection con = ConnectionFactory.obterConexao();
        try {

            EstadoDAO estadoDAO = new EstadoDAO(con);
            List<Estado> estados = estadoDAO.getAll();
            PreparedStatement stmt = con.prepareStatement(ORDER_BY);

            for (Estado e : estados) {
                stmt.setInt(1, e.getEstadoId());
                ResultSet resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    Cidade cidadeAux = new Cidade();

                    cidadeAux.setCidadeId(resultSet.getInt(PRIMARY_KEY));
                    cidadeAux.setNome(resultSet.getString(NOME_CIDADE));
                    cidadeAux.setCep(resultSet.getString(CEP_CIDADE));
                    cidadeAux.setEstado(e);

                    cidades.add(cidadeAux);
                }

                resultSet.close();
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cidades;
    }
}