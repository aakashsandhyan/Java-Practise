package com.pluralsight.conference.respository;

import com.pluralsight.conference.model.Registration;

public interface RegistrationRepository {
    Registration save(Registration registration);
}
