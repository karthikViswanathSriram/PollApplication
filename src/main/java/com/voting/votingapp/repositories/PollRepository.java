package com.voting.votingapp.repositories;

import com.voting.votingapp.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll,Long> {
}
