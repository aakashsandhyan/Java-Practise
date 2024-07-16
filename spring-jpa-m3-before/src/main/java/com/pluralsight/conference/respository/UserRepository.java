package com.pluralsight.conference.respository;

import com.pluralsight.conference.model.User;

public interface UserRepository {
    User save(User user);
}
