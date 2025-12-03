package TrabalhoBackEnd.Loja_Roupas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cliente extends Pessoa {
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
    @Column(nullable = false)
    private LocalDate dataNascimento;
    
    @Column(nullable = false)
    private Integer pontuacao = 0;

   
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nome, String email, String telefone, 
                  String cpf, LocalDate dataNascimento, Integer pontuacao) {
        super(id, nome, email, telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.pontuacao = pontuacao != null ? pontuacao : 0;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}