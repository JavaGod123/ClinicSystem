/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.EspecializacaoDAO;
import conexao.ConnectionFactory;
import modelo.Especializacao;

/**
 *
 * @author Nicolas
 */
public class controlEspecializacao {
    public void addEspecializacao(String descricao){
        EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO(ConnectionFactory.obterConexao());
        Especializacao especializacaoNovo = new Especializacao(descricao);
        
        especializacaoDAO.insert(especializacaoNovo);
    }
}
