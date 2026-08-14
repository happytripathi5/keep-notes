package com.happy.notes.service;


import com.happy.notes.entity.Note;
import com.happy.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Receive a Note and tell the repository to save it.
//The controller will eventually say:
//
//        "Hey Service, the user wants to create this Note."
//
//The Service says:
//
//        "Okay, I'll send this Note to the Repository."
//
//The Repository says:
//
//
//        "I'll save it in the database."
@Service
public class NoteService {
    NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository= noteRepository ;
    }
    public Note save(Note note){
       return noteRepository.save(note);

    }

    public Note update(Long id, Note note){
       Optional<Note> notee= noteRepository.findById(id);
       if(notee.isPresent()){
          Note newnote=notee.get();
           newnote.setTitle(note.getTitle());
           newnote.setContent(note.getContent());

           return noteRepository.save(newnote);

       }
       else{
           throw new RuntimeException("Note not found");
       }

    }
    public void delete(Long id){
        noteRepository.deleteById(id);
    }

    //will make method to get though a id

    public Note getbyID(Long id){

        Optional<Note> note=noteRepository.findById(id);
        if(note.isPresent()){
            return note.get();
        }
        else{
            throw new RuntimeException("Note not there");
        }
    }

}
