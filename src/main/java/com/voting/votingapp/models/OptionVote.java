package com.voting.votingapp.models;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
// options column in poll_options will be split into two columns as defined below
// need to use Embeddable annotation to use this class in the List<>
public class OptionVote {
    private String voteOption;
    private Long voteCount = 0L;
}
