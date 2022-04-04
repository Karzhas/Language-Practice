package kz.karzhas.languagepractice.vocabulary;

import kz.karzhas.languagepractice.dto.db.WordDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordDto, Integer> {
}
