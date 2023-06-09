package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.tasks.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NotesEntity,Long> {
    public TaskEntity findByTaskTaskId(Long taskId);
}
