package aop.s8.services;
import aop.s8.aspects.TrackUserAction;
import aop.s8.model.Note;
import aop.s8.repository.NoteRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class NoteSrvice {
    private final NoteRepo noteRepo;

    public Note createNote(Note note) {return noteRepo.save(note);}

    @TrackUserAction
    public List<Note> getAllNotes(){return noteRepo.findAll();}

    @TrackUserAction
    public Note getNoteById(Long id){return noteRepo.findById(id).orElseThrow(null);}

    public Note updateNote(Note note) {
        Note updatedNote = getNoteById(note.getId());

        updatedNote.setTitle(note.getTitle());
        updatedNote.setContent(note.getContent());
        note.setCreationDate(LocalDateTime.now());
        return updatedNote;
    }

    public void deleteNote(Long id) {
        noteRepo.delete(getNoteById(id));
    }
}
