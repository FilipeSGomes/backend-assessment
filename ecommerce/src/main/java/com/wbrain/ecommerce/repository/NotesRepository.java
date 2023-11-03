package com.wbrain.ecommerce.repository;

import com.wbrain.ecommerce.domain.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Integer> {

    List<Notes> findAllNotesByClientId(Integer codeClient);
}
