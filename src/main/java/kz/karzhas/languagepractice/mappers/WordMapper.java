package kz.karzhas.languagepractice.mappers;

import kz.karzhas.languagepractice.domain.Example;
import kz.karzhas.languagepractice.domain.Translation;
import kz.karzhas.languagepractice.domain.Word;
import kz.karzhas.languagepractice.dto.db.WordDto;
import kz.karzhas.languagepractice.dto.yandex_api.WordResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordMapper {

    public Word toEntityFromYandexApi(WordResponse response) {
        WordResponse.Word wordResponse = response.getWord().get(0);
        Word word = new Word();
        word.setText(wordResponse.text);
        word.setTranslations(parseResponseTranslates(wordResponse.translations));
        return word;
    }

    private List<Translation> parseResponseTranslates(List<WordResponse.Translation> translations) {
        return translations
                .stream()
                .map(this::toTranslationEntity)
                .collect(Collectors.toList());
    }

    private Translation toTranslationEntity(WordResponse.Translation translation) {
        Translation entityTranslation = new Translation();
        int             frequency = translation.frequency;
        String          text = translation.text;
        List<String>    synonyms = translation.synonyms == null ? null :
                translation.synonyms.stream().map(synonym -> synonym.text).collect(Collectors.toList());
        List<String>    meanings = translation.meanings == null ? null :
                translation.meanings.stream().map(meaning -> meaning.text).collect(Collectors.toList());
        List<Example>   examples = translation.examples == null ? null :
                translation.examples.stream().map(this::toEntityExample).collect(Collectors.toList());

        entityTranslation.setFrequency(frequency);
        entityTranslation.setText(text);
        entityTranslation.setSynonyms(synonyms);
        entityTranslation.setMeanings(meanings);
        entityTranslation.setExamples(examples);

        return entityTranslation;
    }

    private Example toEntityExample(WordResponse.Example example) {
        Example entityExample = new Example();
        entityExample.setText(example.text);
        entityExample.setTranslations(example.translations.stream().map(this::toTranslationEntity).collect(Collectors.toList()));
        return entityExample;
    }


}
