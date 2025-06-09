package com.naveen.taskmanager.controllers;

import com.naveen.taskmanager.dto.CreateNoteDTO;
import com.naveen.taskmanager.dto.CreateNotesResponseDTO;
import com.naveen.taskmanager.entities.NoteEntity;
import com.naveen.taskmanager.service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService){
        this.notesService = notesService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId){
       var notes = notesService.getNotesForTask(taskId);

       return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNotesResponseDTO> addNote(@PathVariable("taskId") Integer taskId, @RequestBody CreateNoteDTO body){
        var note = notesService.addNoteForTask(taskId, body.getBody(), body.getBody());

        return ResponseEntity.ok(new CreateNotesResponseDTO(taskId, note));
    }

}
