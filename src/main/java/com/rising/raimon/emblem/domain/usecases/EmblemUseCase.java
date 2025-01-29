package com.rising.raimon.emblem.domain.usecases;

import com.rising.raimon.emblem.domain.model.EmblemDTO;
import com.rising.raimon.emblem.domain.model.enums.EmblemEnum;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;

import java.util.List;

public interface EmblemUseCase {
    EmblemDTO createEmblem(EmblemEnum request, int emblemId) throws RisingRaimonException;
    void deleteEmblem(int emblemId) throws RisingRaimonException;
    EmblemDTO getEmblemById(int emblemId) throws RisingRaimonException;
    List<EmblemDTO> getEmblems() throws RisingRaimonException;
}
