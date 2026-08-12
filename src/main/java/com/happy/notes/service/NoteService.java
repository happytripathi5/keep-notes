package com.happy.notes.service;


import com.happy.notes.entity.Note;
import com.happy.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

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
        this.noteRepository= noteRepository;
    }
    Note save(Note note){
       return noteRepository.save(note);



    }
}
