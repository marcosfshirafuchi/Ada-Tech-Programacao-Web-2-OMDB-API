import com.adatech.IMDB.client.FilmeClientOMDBFeign;
import com.adatech.IMDB.converter.FilmeConverter;
import com.adatech.IMDB.dto.FilmeDTO;
import com.adatech.IMDB.model.Filme;
import com.adatech.IMDB.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.adatech.IMDB.vo.FilmeOMDB;

import java.util.Optional;

@Service
public class FilmeService {

    @Value("${imdb.apikey}")
    private String apiKey;

    private final FilmeClientOMDBFeign filmeClientFeign;
    private final FilmeRepository filmeRepository;
    private final FilmeConverter filmeConverter;

    public FilmeService(FilmeClientOMDBFeign filmeClientFeign, FilmeRepository filmeRepository, FilmeConverter filmeConverter) {
        this.filmeClientFeign = filmeClientFeign;
        this.filmeRepository = filmeRepository;
        this.filmeConverter = filmeConverter;
    }


    public FilmeOMDB getFilme(String tema) {
        if (tema == null || tema.isEmpty()) {
            throw new IllegalArgumentException("O título do filme (tema) não pode ser nulo ou vazio");
        }
        return filmeClientFeign.getFilme(tema, apiKey);
    }


    public Filme save(FilmeDTO filmeDTO) {
        if (filmeDTO == null) {
            throw new IllegalArgumentException("FilmeDTO não pode ser nulo");
        }

        Filme filme = filmeConverter.converteParaFilme(filmeDTO);
        return filmeRepository.save(filme);
    }


    public Filme getById(long id) {
        Optional<Filme> filme = filmeRepository.findById(id);
        return filme.orElseThrow(() -> new IllegalArgumentException("Filme não encontrado com o ID: " + id));
    }
}
