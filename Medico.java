/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import modelo.Especializacao;
public class Medico {
    private long medicoId;
    private String nomeCompleto;
    private Date nascimento;
    private String sexo;
    private String identidade;
    private String CPF;
    private Especializacao especializacao;
    private Cidade cidade;

    public Medico() {
    }

    public Medico(String nomeCompleto,Date nascimento, String sexo, String identidade, String CPF, Especializacao especializacao) {
        this.especializacao= especializacao;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.identidade = identidade;
        this.CPF= CPF;
    }
    
    
    public Medico(long medicoId, String nomeCompleto) {
        this.medicoId = medicoId;
        this.nomeCompleto = nomeCompleto;
    }

   public Medico(Especializacao especializacao,String nomeCompleto, Date nascimento, String sexo, String identidade, String CPF){
       this.especializacao= especializacao;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.identidade = identidade;
        this.CPF= CPF;
      
   }
    
    public Medico(long medicoId, String nomeCompleto, Date nascimento, String sexo, String identidade, String CPF, Especializacao especializacao) {
        this.medicoId = medicoId;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.identidade = identidade;
        this.CPF = CPF;
        this.especializacao = especializacao;
    }
    public Medico(String nomeCompleto, Date nascimento, String sexo, String identidade, String CPF, Especializacao especializacao, long medicoId) {
        this.medicoId = medicoId;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.identidade = identidade;
        this.CPF = CPF;
        this.especializacao = especializacao;
    }

    public Medico(Especializacao especializacao, Cidade cidade, String nomeCompleto, Date nascimento, String sexo, String identidade, String CPF) {
        this.especializacao= especializacao;
        this.cidade = cidade;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.identidade = identidade;
        this.CPF= CPF;
    }

    
    
    
    public long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(long medicoId) {
        this.medicoId = medicoId;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    
    
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.medicoId ^ (this.medicoId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (this.medicoId != other.medicoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return especializacao.getDesc();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Medico(long medicoId, String nomeCompleto, Date nascimento, String sexo, String identidade, String CPF, Especializacao especializacao, Cidade cidade) {
        this.medicoId = medicoId;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.identidade = identidade;
        this.CPF = CPF;
        this.especializacao = especializacao;
        this.cidade = cidade;
    }
    
    
    
}
