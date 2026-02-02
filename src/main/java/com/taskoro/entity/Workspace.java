package com.taskoro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "workspaces")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Project> projects=new ArrayList<>();

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column (name = "updated_at")
    private LocalDateTime updatedAt;



    @PrePersist
    private void setCreatedAt(){
        createdAt=LocalDateTime.now();
    }

    @PreUpdate
    private void setUpdatedAt(){
        updatedAt=LocalDateTime.now();
    }

}
