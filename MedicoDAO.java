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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import modelo.Cidade;
import modelo.Especializacao;
import modelo.Medico;

public class MedicoDAO implements IDAO<Medico> {
    java.util.Date date;
    java.sql.Date sqldate = new java.sql.Date(date.getTime());
    
    //Comandos SQLs
    private static final String INSERT_INTO = "INSERT INTO medico (nomeCompleto,nascimento,sexo,identidade,cpf,especializacaoId,cidadeId2) " + "VALUES (?,'"+sqldate+"',?,?,?,(SELECT especializacaoId FROM especializacao WHERE descricao = ?),(SELECT cidadeId FROM cidade WHERE nome_cidade = ?))";
    private static final String SELECT_ALL = "SELECT * FROM medico";
    private static final String SELECT_ID = "SELECT * FROM medico WHERE medicoId = ?;";
    private static final String UPDATE = "UPDATE medico SET nomeCompleto = ? ,nascimento = ?,sexo = ?, identidade = ?, cpf = ?, especializacaoId = ?, cidadeId2 = ?" + " WHERE medicoId = ? ";
    private static final String REMOVE = "DELETE FROM medico WHERE medicoId = ? ";
    private static final String REMOVE_ID = "DELETE FROM medico WHERE (medicoId = ?)";
    private static final String ORDER_BY = "SELECT * FROM medico ORDER BY nomeCompleto ;";
    private static final String ORDER_BY_FILTER = "SELECT * FROM medico WHERE especializacaoId BETWEEN ? and ? ";
    
    //Declaraçao das colunas, organizadas para editar mais facilmente
    private static final String COLUMN1 = "nomeCompleto";
    private static final String COLUMN2 = "nascimento";
    private static final String COLUMN3 = "sexo";
    private static final String COLUMN4 = "identidade";
    private static final String COLUMN5 = "cpf";
    private static final String FOREIGN_KEY = "especializacaoId";
    private static final String PRIMARY_KEY = "medicoId";
    private static final String FOREIGN_KEY2 = "cidadeId2";
    
    private Connection conexao;
    
    
    
    
    public MedicoDAO(){
        
    }
    public MedicoDAO(Connection connection){
        this.conexao = connection;
    }
    
    
    @Override
    public void insert(Medico m){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        sqldate = new java.sql.Date(date.getTime());
        
        try {
            
            stmt = con.prepareStatement(INSERT_INTO);
            stmt.setString(1, m.getNomeCompleto().toUpperCase());
            
            stmt.setString(2, m.getNascimento().toUpperCase());
            
            stmt.setString(3, m.getSexo().toUpperCase());
            stmt.setString(4, m.getIdentidade().toUpperCase());
            stmt.setString(5, m.getCPF().toUpperCase());
            stmt.setString(6, m.getEspecializacao().getDesc());
            stmt.setString(7, m.getCidade().getNome());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao salvar: " + ex);
                Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
    
    @Override
    public List<Medico> getAll(){
        Connection con = ConnectionFactory.obterConexao();

        List<Medico> medicos = new ArrayList<>();
        EspecializacaoDAO edao = new EspecializacaoDAO(); 
        CidadeDAO cidao = new CidadeDAO();
        try {
            

            PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
            
                ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                    Medico me = new Medico();
                    Especializacao e = new Especializacao();
                    Cidade c = new Cidade();
                    e = (edao.getById(rs.getInt(FOREIGN_KEY)));
                    c = (cidao.getById(rs.getInt(FOREIGN_KEY2)));
                    
                
                    me.setMedicoId(rs.getLong(PRIMARY_KEY));
                    me.setNomeCompleto(rs.getString(COLUMN1));
                    me.setNascimento(rs.getString(COLUMN2));
                    me.setSexo(rs.getString(COLUMN3));
                    me.setIdentidade(rs.getString(COLUMN4));
                    me.setCPF(rs.getString(COLUMN5));
                    me.setEspecializacao(e);
                    me.setCidade(c);
                   
                    
                
                    medicos.add(me);
                
                
                
            }
            rs.close();
            stmt.close();
            con.close();
           
            
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Dados nao disponiveis: "+ex);
                Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return medicos;
    }
    
    @Override
    public Medico getById(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico m = null;
        try{
            stmt = con.prepareStatement(SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while(rs.next()){
                EspecializacaoDAO edao = new EspecializacaoDAO(con);
                CidadeDAO cidao = new CidadeDAO(con);
                Especializacao especializacaoAux = edao.getById(rs.getInt(FOREIGN_KEY));
                Cidade cidadeAux = cidao.getById(rs.getInt(FOREIGN_KEY2));
//                m = new Medico(rs.getLong(PRIMARY_KEY), rs.getString(COLUMN1), rs.getString(COLUMN2), rs.getString(COLUMN3), rs.getString(COLUMN4), rs.getString(COLUMN5), especializacaoAux);
                m = new Medico();
                m.setMedicoId(rs.getInt(PRIMARY_KEY));
                m.setNomeCompleto(rs.getString(COLUMN1));
                m.setNascimento(rs.getString(COLUMN2));
                m.setSexo(rs.getString(COLUMN3));
                m.setIdentidade(rs.getString(COLUMN4));
                m.setCPF(rs.getString(COLUMN5));
                m.setEspecializacao(especializacaoAux);
                m.setCidade(cidadeAux);
                
            }
            JOptionPane.showMessageDialog(null,"Encontrado por id: " + m.getMedicoId());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Encontrar: " + ex);
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
       
        return m;
    }
    
    @Override
    public void update(Medico m){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(UPDATE);
            
            stmt.setString(1, m.getNomeCompleto().toUpperCase());
            stmt.setString(2, m.getNascimento().toUpperCase());
            stmt.setString(3, m.getSexo().toUpperCase());
            stmt.setString(4, m.getIdentidade().toUpperCase());
            stmt.setString(5, m.getCPF().toUpperCase());
            stmt.setLong(6, m.getEspecializacao().getEspecializacaoId());
            stmt.setInt(7, m.getCidade().getCidadeId());
            stmt.setLong(8 , m.getMedicoId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao atualizar: " + ex);
                Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
    
    @Override
    public void remove(Medico m){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(REMOVE);

            stmt.setLong(1 , m.getMedicoId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluído com sucesso!!");
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir: " + ex);
                Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
    
    @Override
    public void remove(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(REMOVE_ID);
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Excluído com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: " + ex);
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    @Override
    public List<Medico> orderByName(){
    Connection con = ConnectionFactory.obterConexao();

        List<Medico> medicos = new ArrayList<>();
        EspecializacaoDAO edao = new EspecializacaoDAO(); 
        CidadeDAO cidao = new CidadeDAO();
        try {
            

            PreparedStatement stmt = con.prepareStatement(ORDER_BY);
            
                ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                    Medico me = new Medico();
                    Especializacao e = new Especializacao();
                    Cidade c = new Cidade();
                    e = (edao.getById(rs.getInt(FOREIGN_KEY)));
                    c = (cidao.getById(rs.getInt(FOREIGN_KEY2)));
                    
                
                    me.setMedicoId(rs.getLong(PRIMARY_KEY));
                    me.setNomeCompleto(rs.getString(COLUMN1));
                    me.setNascimento(rs.getString(COLUMN2));
                    me.setSexo(rs.getString(COLUMN3));
                    me.setIdentidade(rs.getString(COLUMN4));
                    me.setCPF(rs.getString(COLUMN5));
                    me.setEspecializacao(e);
                    me.setCidade(c);
                   
                    
                
                    medicos.add(me);
                
                
                
            }
            rs.close();
            stmt.close();
            con.close();
           
            
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Dados nao disponiveis: "+ex);
                Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return medicos;
}
}