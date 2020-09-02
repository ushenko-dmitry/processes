package by.ceramogrand.processes.service.converter;

import java.util.List;

public interface GenericConverter<DTO, MODEL> {

    DTO getDTO(MODEL model);

    MODEL getModel(DTO dto);

    List<DTO> getDTOs(List<MODEL> models);

    List<MODEL> getModels(List<DTO> dtos);

}
