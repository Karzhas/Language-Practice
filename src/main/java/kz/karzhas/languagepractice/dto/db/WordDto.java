package kz.karzhas.languagepractice.dto.db;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="word")
public class WordDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String text;

    @ManyToMany
    @JoinTable(
            name="word_translation",
            joinColumns = @JoinColumn(name = "word_id"),
            inverseJoinColumns = @JoinColumn(name="translation_id")
    )
    private List<TranslationDto> translations;

//    @Column(unique = true, nullable = false)
//    private String spelling;
//
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name="word_synonym",
//            joinColumns = @JoinColumn(name = "word_id"),
//            inverseJoinColumns = @JoinColumn(name="synonym_word_id")
//    )
//    private Set<WordDto> synonyms;
//
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name="word_sentence",
//            joinColumns = @JoinColumn(name="word_id"),
//            inverseJoinColumns = @JoinColumn(name="sentence_id")
//    )
//    private List<SentenceDto> sentences;
//
//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name="dictionary_id")
//    private DictionaryDto dictionary;



}
