package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.ProcessPattern;
import by.ceramogrand.processes.service.converter.ProcessPatternConverter;
import by.ceramogrand.processes.service.converter.TaskPatternConverter;
import by.ceramogrand.processes.service.converter.UserConverter;
import by.ceramogrand.processes.service.model.ProcessPatternDTO;
import by.ceramogrand.processes.service.model.TaskPatternDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProcessPatternConverterImpl implements ProcessPatternConverter {

    private final UserConverter userConverter;
    private final TaskPatternConverter taskPatternConverter;

    public ProcessPatternConverterImpl(
            UserConverter userConverter,
            TaskPatternConverter taskPatternConverter
    ) {
        this.userConverter = userConverter;
        this.taskPatternConverter = taskPatternConverter;
    }

    @Override
    public ProcessPatternDTO getDTO(ProcessPattern model) {
        ProcessPatternDTO processPatternDTO = new ProcessPatternDTO();
        processPatternDTO.setId(model.getId());
        processPatternDTO.setName(model.getName());
        processPatternDTO.setDescription(model.getDescription());

        processPatternDTO.setDeleted(model.getDeleted());

        List<TaskPatternDTO> tasks = taskPatternConverter.getDTOs(model.getTasks());
        processPatternDTO.setTasks(tasks);

        UserDTO createdBy = userConverter.getDTO(model.getCreatedBy());
        processPatternDTO.setCreatedBy(createdBy);
        processPatternDTO.setDateCreated(model.getDateCreated());
        UserDTO updatedBy = userConverter.getDTO(model.getUpdatedBy());
        processPatternDTO.setUpdatedBy(updatedBy);
        processPatternDTO.setDateUpdated(model.getDateUpdated());
        return processPatternDTO;
    }

    @Override
    public ProcessPattern getModel(ProcessPatternDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessPatternDTO> getDTOs(List<ProcessPattern> models) {
        List<ProcessPatternDTO> processPatternDTOs = new ArrayList<>();
        for (ProcessPattern model : models) {
            processPatternDTOs.add(getDTO(model));
        }
        return processPatternDTOs;
    }

    @Override
    public List<ProcessPattern> getModels(List<ProcessPatternDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
