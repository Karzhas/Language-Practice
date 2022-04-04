package kz.karzhas.languagepractice.dto.db;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="translation")
public class TranslationDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String text;

    private int freq;

    @ElementCollection
    @CollectionTable(name="translation_synonym", joinColumns = @JoinColumn(name = "synonym_id"))
    Set<String> syn;

    @ElementCollection
    @CollectionTable(name="translation_mean", joinColumns = @JoinColumn(name = "synonym_id"))
    Set<String> mean;

    @ManyToMany
    @CollectionTable(name="translation_example", joinColumns = @JoinColumn(name = "synonym_id"))
    List<ExampleDto> examples;

}
