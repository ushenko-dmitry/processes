package by.ceramogrand.processes.service.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AddProcessPatternDTO {

    private String name;
    private String description;

    private List<TaskPatternDTO> taskPatternDTOs = Collections.emptyList();

    private Boolean deleted;

    private Long createdBy;
    private LocalDate dateCreated;

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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.taskPatternDTOs);
        hash = 79 * hash + Objects.hashCode(this.deleted);
        hash = 79 * hash + Objects.hashCode(this.createdBy);
        hash = 79 * hash + Objects.hashCode(this.dateCreated);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddProcessPatternDTO other = (AddProcessPatternDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.taskPatternDTOs, other.taskPatternDTOs)) {
            return false;
        }
        if (!Objects.equals(this.deleted, other.deleted)) {
            return false;
        }
        if (!Objects.equals(this.createdBy, other.createdBy)) {
            return false;
        }
        if (!Objects.equals(this.dateCreated, other.dateCreated)) {
            return false;
        }
        return true;
    }

}
