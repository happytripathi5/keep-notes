package com.happy.notes.repository;

import com.happy.notes.entity.Note;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    Iterable<Long> id(Long id);

    List<Note> findByTitle(String title);


    List<Note> findByTitleContainingIgnoreCase(String title);

    //18aug need to make a method for searching using filted completed or not

    List<Note> findByCompleted(boolean completed);

    //18 aug nighr to make a memthod for search by title and sorted in some manner

    //18 aug night:  make a sevice reciver both search contianing /filter and sort by asc in one call
//   like this:- GET /note/search?title=spring&completed=true&direction=asc

    List<Note> findByTitleContainingIgnoreCaseAndCompleted(String title, boolean completed, Sort sort);
}

