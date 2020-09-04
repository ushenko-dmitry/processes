package by.ceramogrand.processes.service.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class AddProcessPatternDTO {

    private String name;
    private String description;

    private List<TaskPatternDTO> taskPatternDTOs = Collections.emptyList();

    private Boolean deleted;

    private UserDTO createdBy;
    private LocalDate dateCreated;
    private UserDTO updatedBy;
    private LocalDate dateUpdated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskPatternDTO> getTasks() {
        return taskPatternDTOs;
    }

    public void setTasks(List<TaskPatternDTO> tasks) {
        this.taskPatternDTOs = tasks;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UserDTO getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserDTO updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
