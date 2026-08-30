package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserResponse {
    private String name;
    private String job;

    public UserResponse() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
}
