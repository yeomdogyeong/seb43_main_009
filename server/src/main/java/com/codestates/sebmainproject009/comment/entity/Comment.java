package com.codestates.sebmainproject009.comment.entity;

import com.codestates.sebmainproject009.commu.entity.Commu;
import com.codestates.sebmainproject009.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String comment;

    @Column
    private String displayName;

    @Column
    private LocalDateTime createAt = LocalDateTime.now();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "commuId")
    @JsonIgnore
    private Commu commu;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;


}
