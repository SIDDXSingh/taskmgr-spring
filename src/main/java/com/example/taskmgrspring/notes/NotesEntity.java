package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.tasks.TaskEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "notes")
@Table(name = "notes")
public class NotesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String description;

    @ManyToOne(targetEntity = TaskEntity.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "tasks_id")
    @JsonBackReference
    private TaskEntity tasks;
}
