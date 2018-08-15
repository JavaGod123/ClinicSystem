/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.MedicoDAO;
import conexao.ConnectionFactory;
import modelo.Cidade;
import modelo.Especializacao;
import modelo.Medico;

/**
 *
 * @author Nicolas
 */
public class controlMedico {
    private Medico medicoAux;
    
    public void addMedico(Especializacao especializacao,Cidade cidade, String nomeCompleto, String nascimento, String sexo, String identidade, String CPF){
        MedicoDAO medicoDAO = new MedicoDAO(ConnectionFactory.obterConexao());
        Medico medicoNovo = new Medico(especializacao, cidade, nomeCompleto, nascimento, sexo, identidade, CPF);
    
        medicoDAO.insert(medicoNovo);
    }
    
    public void updateMedico(String nomeCompleto, String nascimento, String sexo, String identidade, String CPF, Especializacao especializacao, long medicoId){
        MedicoDAO mdao = new MedicoDAO(ConnectionFactory.obterConexao());
        Medico medicoNovo = new Medico( nomeCompleto, nascimento, sexo, identidade, CPF, especializacao, medicoId);
        

        mdao.update(medicoNovo);

    }
}
