package by.ceramogrand.processes.service.impl;

import by.ceramogrand.processes.repository.ProcessPatternRepository;
import by.ceramogrand.processes.repository.ProcessRepository;
import by.ceramogrand.processes.repository.TaskRepository;
import by.ceramogrand.processes.repository.UserRepository;
import by.ceramogrand.processes.repository.model.*;
import by.ceramogrand.processes.repository.model.Process;
import by.ceramogrand.processes.service.ProcessService;
import by.ceramogrand.processes.service.converter.ConverterFacade;
import by.ceramogrand.processes.service.model.AddProcessDTO;
import by.ceramogrand.processes.service.model.ProcessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessRepository processRepository;
    @Autowired
    private ProcessPatternRepository processPatternRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ConverterFacade converterFacade;

    @Override
    public ProcessDTO createProcess(AddProcessDTO addProcessDTO) {
        ProcessPattern processPattern = processPatternRepository.findById(addProcessDTO.getProcess().getId());
        Process process = new Process();
        process.setName(processPattern.getName());
        process.setDescription(processPattern.getDescription());

        process.setComplete(false);
        process.setDeleted(false);

        User createdBy = userRepository.findById(addProcessDTO.getCreatedBy().getId());
        process.setCreatedBy(createdBy);
        process.setDateCreated(addProcessDTO.getDateCreated());

        List<Task> tasks = new ArrayList<>();
        for (TaskPattern taskPattern : processPattern.getTasks()){
            Task task = new Task();
            task.setName(taskPattern.getName());
            task.setDescription(taskPattern.getDescription());
            task.setComplete(false);
            task.setDeleted(false);

            task.setCreatedBy(createdBy);
            task.setDateCreated(addProcessDTO.getDateCreated());



            task.setProcess(process);
            tasks.add(task);
        }
        process.setTasks(tasks);
        processRepository.persist(process);
        return converterFacade.getProcessConverter().getDTO(process);
    }

    @Override
    public List<ProcessDTO> getProcesses() {
        return converterFacade.getProcessConverter().getDTOs(processRepository.findAll());
    }
}
