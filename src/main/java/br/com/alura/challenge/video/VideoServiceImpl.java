package br.com.alura.challenge.video;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class VideoServiceImpl implements VideoService {

    public static final String DELETADO = "Vídeo deletado";

    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<VideoResponse> buscaTodos() {
        var videos = videoRepository.findAll();

        return videos.stream().map(VideoResponse::new).collect(Collectors.toList());
    }

    @Override
    public VideoResponse buscaPorId(Long idVideo) {
        var video = buscaVideoPorId(idVideo);

        return new VideoResponse(video);
    }


    @Override
    public VideoResponse salva(NovoVideoRequest request) {
        var novoVideo = videoRepository.save(this.toModel(request));

        return new VideoResponse(novoVideo);
    }

    @Override
    public VideoResponse atualizaPorId(Long idVideo, AtualizaVideoRequest request) {
        var video = this.buscaVideoPorId(idVideo);
        videoRepository.save(video.atualiza(request));
        return new VideoResponse(video);
    }

    @Override
    public String deletaPorId(Long idVideo) {
        var video = this.buscaVideoPorId(idVideo);

        videoRepository.delete(video);

        return DELETADO;
    }

    private Video toModel(NovoVideoRequest request) {
        return new Video(request.titulo, request.descricao, request.url);
    }

    private Video buscaVideoPorId(Long idVideo) {
        return videoRepository.findById(idVideo)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Vídeo não encontrado"));
    }
}
