package sem5.homework.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Data
@Entity
@Table(name="tasks")
public class Task {
    public enum Status{
        IN_PROGRESS,
        COMPLETED,
        NOT_STARTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String discription;

    private Status status;

    @Column(name = "task_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date taskData;

    public Task(){

    }
}
