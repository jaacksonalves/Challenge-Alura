package br.com.alura.challenge.video;

import lombok.Getter;

@Getter
public class VideoResponse {

    private final Long id;
    private final String titulo;
    private final String descricao;
    private final String url;

    public VideoResponse(Video video) {
        this.id = video.getId();
        this.titulo = video.getTitulo();
        this.descricao = video.getDescricao();
        this.url = video.getUrl();
    }
}
