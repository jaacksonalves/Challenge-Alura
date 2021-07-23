package br.com.alura.challenge.video;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<VideoResponse> mostraUm() {
        return videoService.buscaTodos();
    }

    @GetMapping("/{idVideo}")
    public VideoResponse listaTodos(@PathVariable Long idVideo) {
        return videoService.buscaPorId(idVideo);
    }

    @PostMapping
    public ResponseEntity<VideoResponse> cadastra(@Valid @RequestBody NovoVideoRequest request) {
        return ResponseEntity.status(CREATED).body(videoService.salva(request));
    }

    @PutMapping("/{idVideo}")
    public VideoResponse atualiza(@PathVariable Long idVideo,
                                  @Valid @RequestBody AtualizaVideoRequest request) {
        return videoService.atualizaPorId(idVideo, request);
    }

    @DeleteMapping("/{idVideo}")
    public String deleta(@PathVariable Long idVideo) {
        return videoService.deletaPorId(idVideo);
    }
}
