package com.example.accessingdatajpa.model.to;

import com.example.accessingdatajpa.util.HasId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseTo implements HasId {
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}
