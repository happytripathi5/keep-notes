package com.happy.notes.repository;

import com.happy.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    Iterable<Long> id(Long id);

    List<Note> findByTitle(String title);


    List<Note> findByTitleContainingIgnoreCase(String title);

}

