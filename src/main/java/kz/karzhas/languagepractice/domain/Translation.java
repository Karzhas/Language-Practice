package kz.karzhas.languagepractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Translation {
    private String text;
    private int frequency;
    private List<String> synonyms;
    private List<String> meanings;
    private List<Example> examples;
    public Translation(){
        synonyms = new ArrayList<>();
        meanings = new ArrayList<>();
        examples = new ArrayList<>();
    }

}
