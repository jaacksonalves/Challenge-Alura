package br.com.alura.challenge.video;

import java.util.List;

public interface VideoService {

    List<VideoResponse> buscaTodos();

    VideoResponse buscaPorId(Long idVideo);

    VideoResponse salva(NovoVideoRequest request);

    VideoResponse atualizaPorId(Long idVideo, AtualizaVideoRequest request);

    String deletaPorId(Long idVideo);
}
