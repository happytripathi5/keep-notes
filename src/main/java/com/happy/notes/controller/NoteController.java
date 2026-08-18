package com.happy.notes.controller;

import com.happy.notes.entity.Note;
import com.happy.notes.service.NoteService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Expose an http endpoint such as POST /notes
//The client will send:
//
//title
//content
//
//to the controller.
//
//The controller passes the Note to the service.
@RestController
public class NoteController {
    NoteService noteservice;

    public NoteController(NoteService noteService){
        this.noteservice=noteService;
    }

    @PostMapping("/note")

    public Note save(@RequestBody Note note){
        return noteservice.save(note);

    }

    @PutMapping("/note/{id}")

    public Note update(@RequestBody Note note,@PathVariable Long id){
        return noteservice.update(id,note);
    }

    @DeleteMapping("/note/{id}")

    public void delete(@PathVariable Long id){
        noteservice.delete(id);
    }

    //controller to get a id
    @GetMapping("/note/{id}")
    public Note getting(@PathVariable Long id){
        return noteservice.getbyID(id);
    }

    @GetMapping("/note")
    public List<Note> get(){
        return noteservice.get();
    }


//PATCH → modify only part of the resource.
    @PatchMapping("note/{id}/completed")
    public Note checkcomplete(@PathVariable Long id,boolean completed){
        return noteservice.completed(id,completed);
    }


    //lets search a id using search of title

    @GetMapping("/note/search")
//    GET http://localhost:8080/note/search?title=My%20First%20Notessaasaas
//    try with it
    public List<Note> search(@RequestParam String title){
        return noteservice.searchBytitle(title);
    }



//important non case sensitive endpoint
    //test with this;- http://localhost:8080/note/search/contains?title=first
    @GetMapping("/note/search/contains")
    public List<Note> searchUsingTitlecontaining(@RequestParam String title){
        return noteservice.searchbytitlecontaining(title);



    }

    //18aug creating for searching list of notes with completed filter

    @GetMapping("/note/search/isCompleted")
    public List<Note> searchFilterIsCompleted(@RequestParam boolean completed){
        return noteservice.searchbycompleted(completed);
    }


    //18aug creating for returning all the list of notes in sorted order
//    GET http://localhost:8080/note/sort?direction=asc
//    GET http://localhost:8080/note/sort?direction=desc

    @GetMapping("/note/sort")
    public List<Note> searchBySortedTitle(@RequestParam String direction){
        return noteservice.searchBytitleSorted(direction);
    }

    //creating another controller for sort contiaing&filter&sort
    //http://localhost:8080/note/search/isCompleted/sort?title=spring&completed=true
    @GetMapping("/note/search/isCompleted/sort")
    public List<Note> searchFilterAndSort (@RequestParam String title, @RequestParam boolean completed){
        return noteservice.searchFilterSort(title,completed);
    }





}

