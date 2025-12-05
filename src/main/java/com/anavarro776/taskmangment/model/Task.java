package com.anavarro776.taskmangment.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 3, max = 255)
    private String title;

    @Override
    public String toString() {
        return "Task{id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", dueDate=" + dueDate + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + '}';
    }

    @Column(nullable = false)
    @Size(max = 1000)
    private String description;




    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;



    private LocalDate dueDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id" ,nullable=false)
    private User user;
    //Getters
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;

    }

    public LocalDate getDueDate() {
        return dueDate;


    }
    public Status getStatus() {
        return status;
    }
    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
    //Setters
    public void setId(long id) {
        this.id=id;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setStatus(Status status){
        this.status=status;
    }
    public void setUser(User user){
        this.user=user;
    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate=dueDate;
    }
    public void setCreatedDate(LocalDateTime createdDate){
        this.createdDate=createdDate;
    }
    public void setUpdatedDate(LocalDateTime updatedDate){
        this.updatedDate=updatedDate;
    }
    @PrePersist
    protected void onCreate(){
        createdDate=LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedDate=LocalDateTime.now();
    }
    public enum Status{ PENDING,IN_PROGRESS,COMPLETED}

    @Override
    public boolean equals(Object o){
        if (this==o)return true;
        if(!(o instanceof Task))return false;
        Task task=(Task) o;
        return id != null && id.equals(task.id);

    }

    @Override
    public int hashCode(){
        return Long.hashCode(id);
    }


}
