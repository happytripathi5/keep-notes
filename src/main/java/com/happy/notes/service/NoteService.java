package com.happy.notes.service;


import com.happy.notes.entity.Note;
import com.happy.notes.exception.NoteNotFoundException;
import com.happy.notes.repository.NoteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new NoteNotFoundException("not found");
        }
    }

    public List<Note> get(){

        return noteRepository.findAll();
    }

    public Note completed(Long id, boolean completed){
       Optional<Note> notee= noteRepository.findById(id);
       if(notee.isPresent()){
           Note note= notee.get();
           note.setCompleted(completed);
           return noteRepository.save(note);

       }
       else{
//          throw new RuntimeException("Note not there");
           throw new NoteNotFoundException("Note not there to mark completed/not");

       }

    }


    public List<Note> searchBytitle(String title){

        return noteRepository.findByTitle(title);

    }


    //a proper search for normal user no need to search keeping the cases
    public List<Note> searchbytitlecontaining(String title){

        return noteRepository.findByTitleContainingIgnoreCase(title);
    }

    //18aug created service to search list of notes with there status completed
  //http://localhost:8080/note/search/isCompleted?completed=false
    public List<Note> searchbycompleted(boolean completed){
        return noteRepository.findByCompleted(completed);

    }


    //18 aug night ,need a function to get all the notes with everything sorted in some order
    // Sort is a class.
// Sort.by("title") is a static method that returns a Sort object containing
// the instruction to sort by the "title" field.
// .ascending() makes that Sort object sort A → Z.
// .descending() makes that Sort object sort Z → A.


    //notes



// Search + Filter + Sort together
//
//Right now you have them separately:
//
//Search by title → contains
//Filter → completed=true/false
//Sort → asc/desc
//
//Now we'll combine them into one API.

    //  ;
    // GET /note/search?title=spring&completed=true&direction=asc like this we call

    public List<Note> searchBytitleSorted(String direction){

        Sort sort ;

        if(direction.equalsIgnoreCase("asc")){

                sort= Sort.by("title").ascending();
                }
        else if (direction.equalsIgnoreCase("desc")){
            sort=Sort.by("title").descending();
        }
        else{
            sort=Sort.by("title").ascending();
        }
        //else because if nothing in the direction so what to do



       return noteRepository.findAll(sort);

    }

    //make a service accepting title for search and completed for filter and then sort and return the list of notes

    public List<Note> searchFilterSort(String title , boolean completed){
        Sort sort= Sort.by("title").descending();
       return noteRepository.findByTitleContainingIgnoreCaseAndCompleted(title,completed,sort);

    }










}
