package com.voting.votingapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    // creates a separate table poll_options with id as foreign key and column option
    // without the need to create entity classes using this annotation
    // if option is a list of other class types, they are also included as columns
    @ElementCollection
    private List<OptionVote> options=new ArrayList<>();
}
