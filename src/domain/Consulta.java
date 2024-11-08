package domain;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta {
    private Integer codigo;
    private LocalDate data;
    private String resumo;
    private Tratamento tratamento;
    private Veterinario veterinario;
    private List<Exame> exames;
    
    public Consulta(LocalDate data, String resumo, Tratamento tratamento, Veterinario veterinario) {
        this.data = data;
        this.resumo = resumo;
        this.tratamento = tratamento;
        this.veterinario = veterinario;
    }
    public Consulta(String string, LocalDateTime now, Tratamento tratamento2, Veterinario veterinario2) {
        //TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Consulta [codigo=" + codigo + ", data=" + data + ", resumo=" + resumo + ", tratamento=" + tratamento
                + ", veterinario=" + veterinario + "]";
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getResumo() {
        return resumo;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public Tratamento getTratamento() {
        return tratamento;
    }
    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    public List<Exame> getExames() {
        return exames;
    }
    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
    

}
