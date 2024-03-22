package com.joshuatony.studentrepo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmailSearch {
    @NotEmpty
    private String email;

    @JsonCreator
    public EmailSearch(@JsonProperty("email") String email) {
        this.email = email;
    }
}
