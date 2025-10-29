package TrabalhoBackEnd.Loja_Roupas;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String cpf;
    private LocalDate dataNascimento;
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
