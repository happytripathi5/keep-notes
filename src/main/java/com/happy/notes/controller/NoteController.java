package com.happy.notes.controller;

import com.happy.notes.entity.Note;
import com.happy.notes.service.NoteService;
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




}
