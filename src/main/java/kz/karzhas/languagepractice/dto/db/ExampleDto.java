package kz.karzhas.languagepractice.dto.db;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="example")
public class ExampleDto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    String text;

    @OneToMany
    @CollectionTable(name="example_translation", joinColumns = @JoinColumn(name = "example_id"))
    List<TranslationDto> translations;


}
