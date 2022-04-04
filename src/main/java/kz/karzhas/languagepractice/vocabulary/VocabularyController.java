package kz.karzhas.languagepractice.vocabulary;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/vocabulary")
public class VocabularyController {

    final VocabularyService service;


    @PostMapping(value = "/word")
    void addWord(@RequestBody String word){
        System.out.println(word);
        service.addWord(word);
    }


}
