package DAO;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import interfaces.IDAO;
import modelo.Especializacao;


public class EspecializacaoDAO implements IDAO<Especializacao> {

    
    private static final String PRIMARY_KEY = "especializacaoId";
    private static final String COLUMN2 = "descricao";
    
    private static final String INSERT_INTO = "INSERT INTO especializacao (descricao) " + "VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM especializacao";
    private static final String SELECT_ID = "SELECT * FROM especializacao WHERE especializacaoId = ?";
    private static final String UPDATE = "UPDATE especializacao SET descricao = ? WHERE especializacaoId = ? ";
    private static final String REMOVE = "DELETE FROM especializacao WHERE especializacaoId = ? ";
    private static final String REMOVE_ID = "DELETE FROM especializacao WHERE especializacaoId = ?";
    private static final String ORDER_BY = "SELECT * FROM especializacao ORDER BY descricao;";
    private static final String SHOW_BETWEEN = "SELECT * FROM especializacao WHERE especializacaoId BETWEEN ? AND ?;";

    private Connection conexao;
    
    public EspecializacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public EspecializacaoDAO() {
         
    }


  
    
    @Override
    public void insert(Especializacao e) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(INSERT_INTO);
            stmt.setString(1, e.getDesc());
            

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso!!");

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
            Logger.getLogger(EspecializacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    @Override
    public List<Especializacao> getAll() {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Especializacao> especializacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Especializacao e = new Especializacao();

                e.setEspecializacaoId(rs.getInt(PRIMARY_KEY));
                e.setDesc(rs.getString(COLUMN2));               
                especializacoes.add(e);

            }

        } catch (SQLException ex) {
            System.out.println("Dados nao disponiveis: " + ex);
            Logger.getLogger(EspecializacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }

        return especializacoes;
    }

    @Override
    public Especializacao getById(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Especializacao e = null;
        try {
            stmt = con.prepareStatement(SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                e = new Especializacao(rs.getInt(PRIMARY_KEY), rs.getString(COLUMN2));
            }
            JOptionPane.showMessageDialog(null, "Encontrado por Id: " + e.getEspecializacaoId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Encontrar: " + ex);
            Logger.getLogger(EspecializacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }

        return e;
    }

    @Override
    public void update(Especializacao e) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(UPDATE);
            stmt.setString(1, e.getDesc());

            stmt.setLong(2, e.getEspecializacaoId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(EspecializacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    @Override
    public void remove(Especializacao e) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(REMOVE);

            stmt.setLong(1, e.getEspecializacaoId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(EspecializacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    @Override
    public void remove(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(REMOVE_ID);

            stmt.setInt(1, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(EspecializacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
    
    
    @Override
    public List<Especializacao> orderByName() {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Especializacao> especializacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(ORDER_BY);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Especializacao e = new Especializacao();

                e.setEspecializacaoId(rs.getInt(PRIMARY_KEY));
                e.setDesc(rs.getString(COLUMN2));               
                especializacoes.add(e);

            }

        } catch (SQLException ex) {
            System.out.println("Dados nao disponiveis: " + ex);
            Logger.getLogger(EspecializacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }

        return especializacoes;
    }
}
