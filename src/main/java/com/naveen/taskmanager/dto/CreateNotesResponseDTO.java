package com.naveen.taskmanager.dto;

import com.naveen.taskmanager.entities.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateNotesResponseDTO {
    private Integer taskId;
    private NoteEntity note;
}
