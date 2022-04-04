package kz.karzhas.languagepractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Example {
    String text;
    List<Translation> translations;
    public Example(){
        translations = new ArrayList<>();
    }
}
