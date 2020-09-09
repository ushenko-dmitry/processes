package by.ceramogrand.processes.service.model;

import java.time.LocalDate;

public class AddProcessDTO {

    private ProcessPatternDTO process;
    private UserDTO createdBy;
    private LocalDate dateCreated;

    public ProcessPatternDTO getProcess() {
        return process;
    }

    public void setProcess(ProcessPatternDTO process) {
        this.process = process;
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
}
