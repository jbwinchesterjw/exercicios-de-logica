package controle_vacina_covid;
public class DadosUsuarioVacina {
    private int condigo;
    private String nome;
    private String cpf;
    private String vacina;
    private String dataRegistro;
    private String lote;

    public int getCondigo() {
        return condigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getVacina() {
        return vacina;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public String getLote() {
        return lote;
    }

    public void setCondigo(int condigo) {
        this.condigo = condigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
        return dataRegistro;
    }

    public void setLote(String lote) {
        this.lote = lote;

    }

}
