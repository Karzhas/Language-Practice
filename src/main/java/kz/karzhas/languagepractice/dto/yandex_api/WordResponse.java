package kz.karzhas.languagepractice.dto.yandex_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordResponse {

    @JsonProperty("def")
    public List<Word> word;

    public static class Word {
        public String text;

        @JsonProperty("tr")
        public List<Translation> translations;
    }
    public static class Translation {
        public String text;
        @JsonProperty("fr")
        public int frequency;
        @JsonProperty("syn")
        public List<Synonym> synonyms;
        @JsonProperty("mean")
        public List<Meaning> meanings;
        @JsonProperty("ex")
        public List<Example> examples;
    }
    public static class Synonym {
        public String text;
        public int frequency;
    }
    public static class Meaning {
        public String text;
    }
    public static class Example {
        public String text;

        @JsonProperty("tr")
        public List<Translation> translations;
    }
}
