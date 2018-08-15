/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Estado {
    private int estadoId;
    private String nome;
    private String uf;

    public Estado(String nome) {
        this.nome = nome;
    }

    public Estado() {
        
    }
    
    

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return getUf();
    }

    public String getNome(String nome) {
        return nome;
    }

    public String getUf(String uf) {
        return uf;
    }

    public void getEstadoId(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
