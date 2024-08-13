package org.adem.hospitalmanagement.mapper;

import org.adem.hospitalmanagement.dto.request.BedRequest;
import org.adem.hospitalmanagement.dto.response.BedResponse;
import org.adem.hospitalmanagement.model.Bed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BedMapper {
    Bed toBedEntity(BedRequest bedRequest);
    BedResponse toBedResponse(Bed bed);
}
