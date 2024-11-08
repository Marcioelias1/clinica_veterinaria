package domain;

import java.sql.Date;
import java.time.LocalDate;

public class Pet {

    private Integer codigo;
    
    private String nome;

    private Date dataNascimento;

    private GeneroEnum genero;

    private Cliente tutor;

    public Pet(String nome, Date dataNascimento, GeneroEnum genero, Cliente tutor) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.tutor = tutor;
    }

    public Pet(String string, LocalDate dataNascimento2, GeneroEnum femea, Cliente cliente, Especie cachorro) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Pet [codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", genero=" + genero
                + ", tutor=" + tutor + "]";
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public Cliente getTutor() {
        return tutor;
    }

    public void setTutor(Cliente tutor) {
        this.tutor = tutor;
    }

    public Cliente getEspecie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEspecie'");
    }

    
}
