package aop.s8.controllers;
import aop.s8.model.Note;
import aop.s8.services.NoteSrvice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteSrvice noteSrvice;

    @GetMapping
    public List<Note> getAllNotes(){return noteSrvice.getAllNotes();}

    @PostMapping
    public Note createNote(Note note){
        note.setCreationDate(LocalDateTime.now());
        return noteSrvice.createNote(note);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteSrvice.updateNote(note), HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") Long id){
        Note noteById = noteSrvice.getNoteById(id);
        if (noteById == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        } else {
            return new ResponseEntity<>(noteById, HttpStatus.OK);
        }
    }
}
