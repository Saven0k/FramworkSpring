package org.example.notes;

import org.example.notes.model.Note;
import org.example.notes.repository.NoteRepo;
import org.example.notes.service.NoteSrvice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class NotesApplicationTests {

    @Mock
    public NoteRepo noteRepo;

    @Test
    void contextLoads() {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Shopping");
        note.setContent("Go buy new clothes");
        note.setCreationDate(LocalDateTime.now());
        given(noteRepo.findById(note.getId())).willReturn(Optional.of(note));
    }

}
