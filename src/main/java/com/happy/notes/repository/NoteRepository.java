package com.happy.notes.repository;

import com.happy.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    Iterable<Long> id(Long id);

    List<Note> findByTitle(String title);


    List<Note> findByTitleContainingIgnoreCase(String title);

    //18aug need to make a method for searching using filted completed or not

    List<Note> findByCompleted(boolean completed);

    //18 aug nighr to make a method for search by title and sorted in some manner

    //18 aug night :_sorting does not need any method in the repo it already have it with sort class

}

