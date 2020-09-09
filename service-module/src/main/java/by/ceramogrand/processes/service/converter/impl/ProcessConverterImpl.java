package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.Process;
import by.ceramogrand.processes.service.converter.ProcessConverter;
import by.ceramogrand.processes.service.converter.TaskConverter;
import by.ceramogrand.processes.service.converter.UserConverter;
import by.ceramogrand.processes.service.model.ProcessDTO;
import by.ceramogrand.processes.service.model.TaskDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessConverterImpl implements ProcessConverter {

    @Autowired
    private UserConverter userConverter;
    @Autowired
    private TaskConverter taskConverter;

    @Override
    public ProcessDTO getDTO(Process process) {
        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setId(process.getId());
        processDTO.setName(process.getName());
        processDTO.setDescription(process.getDescription());

        processDTO.setCompleted(process.getComplete());
        processDTO.setDateCompleted(process.getDateCompleted());

        processDTO.setDeleted(process.getDeleted());

        UserDTO createdBy = userConverter.getDTO(process.getCreatedBy());
        processDTO.setCreatedBy(createdBy);
        processDTO.setDateCreated(process.getDateCreated());

        UserDTO updatedBy = userConverter.getDTO(process.getUpdatedBy());
        processDTO.setUpdatedBy(updatedBy);
        processDTO.setDateUpdated(process.getDateUpdated());

        List<TaskDTO> tasks = taskConverter.getDTOs(process.getTasks());
        processDTO.setTasks(tasks);
        return processDTO;
    }

    @Override
    public Process getModel(ProcessDTO processDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProcessDTO> getDTOs(List<Process> processes) {
        List<ProcessDTO> processDTOList = new ArrayList<>();
        for (Process process : processes) {
            processDTOList.add(getDTO(process));
        }
        return processDTOList;
    }

    @Override
    public List<Process> getModels(List<ProcessDTO> processDTOS) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
