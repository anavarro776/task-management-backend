package com.anavarro776.taskmangment.model;


import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="task")

public class Task {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    long id;
    @Column(nullable = false)
    private String title;

    private String description;



    @Enumerated(EnumType.STRING)

    @Column(nullable = false)

    private Status status;

    private LocalDate dueDate;
    @Column(nullable = false, updatable = false)
    private LocalDate createdDate;
    private LocalDate updatedDate;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id" ,nullable=false)
    private Users user;
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
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public LocalDate getUpdatedDate() {
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
    public void setDueDate(LocalDate dueDate){
        this.dueDate=dueDate;
    }
    public void setCreatedDate(LocalDate createdDate){
        this.createdDate=createdDate;
    }
    public void setUpdatedDate(LocalDate updatedDate){
        this.updatedDate=updatedDate;
    }
    @PrePersist
    protected void onCreate(){
        createdDate=LocalDate.now();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedDate=LocalDate.now();
    }
    public enum Status{ PENDING,In_PROGRESS,COMPLETED}


}
