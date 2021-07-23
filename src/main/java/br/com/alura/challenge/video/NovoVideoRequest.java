package br.com.alura.challenge.video;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NovoVideoRequest {

    @NotBlank(message = "Título deve ser preenchido.")
    final String titulo;
    @NotBlank(message = "Descrição deve ser preenchida.")
    final String descricao;
    @NotBlank(message = "URL deve ser preenchida.")
//    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
//            message = "URL deve ser preenchida com formato válido")
    @URL
    final String url;

    public NovoVideoRequest(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }
}
