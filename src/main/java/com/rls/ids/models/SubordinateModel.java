package com.rls.ids.models;

import com.rls.ids.entities.User;

public class SubordinateModel {
    private User user;

    SubordinateModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
