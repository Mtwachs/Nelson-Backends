package TrabalhoBackEnd.Loja_Roupas;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cliente extends Pessoa {
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
    @Column(nullable = false)
    private LocalDate dataNascimento;
    
    @Column(nullable = false)
    private Integer pontuacao;

    public Cliente() {
        super();
        this.pontuacao = 0; // Initialize pontuacao with 0 for new clients
    }

    public Cliente(Long id, String nome, String email, String telefone, 
                  String cpf, LocalDate dataNascimento, Integer pontuacao) {
        super(id, nome, email, telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.pontuacao = pontuacao;
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
}
