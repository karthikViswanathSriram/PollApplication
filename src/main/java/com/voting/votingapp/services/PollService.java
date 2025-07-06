package com.voting.votingapp.services;

import com.voting.votingapp.models.OptionVote;
import com.voting.votingapp.models.Poll;
import com.voting.votingapp.repositories.PollRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        //  get poll object from db using pollid
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(()-> new RuntimeException("poll not found"));
        // get the list of options from poll
        List<OptionVote> options = poll.getOptions();
        if(optionIndex<0 || optionIndex>=options.size()){
            throw new IllegalArgumentException("option index out of bounds");
        }

        // increment particular option's voteCount by 1
        OptionVote selectedOption = options.get(optionIndex);
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);

        // update db
        pollRepository.save(poll);

    }
}
