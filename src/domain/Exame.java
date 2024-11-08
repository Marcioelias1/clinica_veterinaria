package domain;

import java.time.LocalDate;

public class Exame {

    private Integer codigo;

    private String tipo;

    private String resultado;

    private LocalDate data;

    private Consulta consulta;

    public Exame(String tipo, String resultado, LocalDate data, Consulta consulta) {
        this.tipo = tipo;
        this.resultado = resultado;
        this.data = data;
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Exame [codigo=" + codigo + ", tipo=" + tipo + ", resultado=" + resultado + ", data=" + data
                + ", consulta=" + consulta + "]";
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    
}
