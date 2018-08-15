/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Nicolas
 */
public class Cidade {
    private int cidadeId;
    private String nome;
    private String cep;
    private Estado estado;

    public Cidade(){
        
    }
    
    public Cidade(String nome, String cep, Estado estado){
        this.nome = nome;
        this.cep = cep;
        this.estado = estado;
    }
    
    
    public int getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(int cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
}
