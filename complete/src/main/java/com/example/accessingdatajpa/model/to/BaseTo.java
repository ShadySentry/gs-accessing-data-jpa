package com.example.accessingdatajpa.model.to;

import com.example.accessingdatajpa.util.HasId;

public class BaseTo implements HasId {
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}
