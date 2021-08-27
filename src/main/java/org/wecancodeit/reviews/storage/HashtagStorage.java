package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.repos.HashtagRepository;

import java.util.Optional;

@Service
public class HashtagStorage {

    private HashtagRepository hashtagRepo;

    public HashtagStorage(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    public void saveHashtag(Hashtag hashtag) {
        hashtagRepo.save(hashtag);
    }

    public Iterable<Hashtag> getAllHashtags() {
        return hashtagRepo.findAll();
    }

    public Hashtag retrieveHashtagByName(String name) {
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByName(name);
        if (!hashtagOptional.isEmpty()) {
            return hashtagOptional.get();
        } else {
            return null;
        }
    }

    public boolean isThereAHashtag(String name) {
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByName(name);
        return !hashtagOptional.isEmpty();
    }

    public Hashtag createOrRetrieveHashtag(String name) {
        Hashtag isHashtag = this.retrieveHashtagByName(name);
        if (isHashtag != null) {
            return isHashtag;
        } else {
            Hashtag createdHashtag = new Hashtag(name);
            this.saveHashtag(createdHashtag);
            return this.retrieveHashtagByName(name);
        }
    }
}
