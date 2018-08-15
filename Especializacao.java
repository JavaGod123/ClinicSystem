package modelo;

public class Especializacao {
    private long especializacaoId;
    private String desc;

    public Especializacao(long especializacaoId, String desc) {
        this.especializacaoId = especializacaoId;
        this.desc = desc;
    }

    public Especializacao(long especializacaoId) {
        this.especializacaoId = especializacaoId;
    }

    public Especializacao() {
    }

    public Especializacao(String descricao) {
        this.setDesc(descricao);
    }

    
    
    
    public long getEspecializacaoId() {
        return especializacaoId;
    }

    public void setEspecializacaoId(long especializacaoId) {
        this.especializacaoId = especializacaoId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (int) (this.especializacaoId ^ (this.especializacaoId >>> 32));
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
        final Especializacao other = (Especializacao) obj;
        if (this.especializacaoId != other.especializacaoId) {
            return false;
        }
        return true;
    }

    public long getEspecializacaoId(long aLong) {
        return especializacaoId;
    }

    public String getDesc(String string) {
        return desc;
    }

    @Override
    public String toString() {
        return getDesc();
    }
    
    
}
