package br.edu.infnet.pedidos.entidades;

public class Cliente {

    private Long codigo;
    private String nome;


    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, long codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String s) { nome = s; }


    public void setCodigo(long l) {
        codigo = l;
    }

    public String toString() {
        return "Cliente: " + nome + " (" + codigo + ")";
    }
}
