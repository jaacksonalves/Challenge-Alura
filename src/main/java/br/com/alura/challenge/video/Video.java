package br.com.alura.challenge.video;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "videos")
@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated)
public class Video {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String titulo;
    @NonNull
    @Column(nullable = false)
    private String descricao;
    @NonNull
    @Column(nullable = false)
    private String url;


    public Video atualiza(AtualizaVideoRequest request) {
        if (!request.getTitulo().isBlank()) this.titulo = request.getTitulo();
        if (!request.getDescricao().isBlank()) this.descricao = request.getDescricao();
        if (!request.getUrl().isBlank()) this.url = request.getUrl();
        return this;
    }
}