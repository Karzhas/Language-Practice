package kz.karzhas.languagepractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.*;

@Data
@AllArgsConstructor
public class Word {
    private String text;
    private List<Translation> translations;

    public Word(){
        translations = new ArrayList<>();
    }


}
