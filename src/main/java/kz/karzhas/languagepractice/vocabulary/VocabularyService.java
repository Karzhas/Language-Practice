package kz.karzhas.languagepractice.vocabulary;

import kz.karzhas.languagepractice.domain.Translation;
import kz.karzhas.languagepractice.domain.Word;
import kz.karzhas.languagepractice.dto.db.WordDto;
import kz.karzhas.languagepractice.dto.yandex_api.WordResponse;
import kz.karzhas.languagepractice.mappers.WordMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VocabularyService {

    private final WordRepository wordRepository;

    private final RestTemplate restTemplate;

    private final WordMapper wordMapper;

    @Value("${yandex.api.base}")
    private final String YANDEX_BASE_API;

    void addWord(String wordText) {
        WordResponse response = getResponseFromExternalApi(wordText);
        Word word = wordMapper.toEntityFromYandexApi(response);
    }

    private WordResponse getResponseFromExternalApi(String wordText) {
        String lang = "lang=ru-en";
        String text = "text=" + wordText;
        String endpoint = YANDEX_BASE_API + lang + "&" + text;
        WordResponse response = restTemplate.getForObject(endpoint, WordResponse.class);
        return response;
    }



}
