package ru.labun.doublegisexercise.service.doublegis;

import ru.labun.doublegisexercise.service.Profile;

/**
 * Created by constantine on 06/02/16.
 */
class ProfileResponseWrapper implements Profile {
    private ProfileResponse response;

    private ProfileResponseWrapper(ProfileResponse response) {
        this.response = response;
    }

    public static Profile wrap(ProfileResponse response) {
        return new ProfileResponseWrapper(response);
    }

    @Override
    public String getRating() {
        return response.getRating();
    }

    @Override
    public String getName() {
        return response.getName();
    }

    @Override
    public String getAddress() {
        return response.getCity() + ", " + response.getAddress();
    }
}
