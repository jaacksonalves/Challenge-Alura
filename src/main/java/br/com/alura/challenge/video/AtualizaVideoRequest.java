package br.com.alura.challenge.video;

import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
public class AtualizaVideoRequest {

    private String titulo;
    private String descricao;
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
            message = "URL deve ser preenchida com formato válido")
    private String url;

}
