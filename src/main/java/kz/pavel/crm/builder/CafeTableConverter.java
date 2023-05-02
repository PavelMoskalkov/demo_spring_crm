package kz.pavel.crm.builder;

import kz.pavel.crm.dto.CafeTableDTO;
import kz.pavel.crm.entity.CafeTable;
public class CafeTableConverter {

    public static CafeTableDTO toCafeTableDTO(CafeTable cafeTable) {
        CafeTableDTO cafeTableDTO = new CafeTableDTO();

        cafeTableDTO.setId(cafeTable.getId());
        cafeTableDTO.setStatus(cafeTable.getStatus());
        cafeTableDTO.setNumber(cafeTable.getNumber());
        cafeTableDTO.setOpeningTime(cafeTable.getOpeningTime());
        return cafeTableDTO;
    }
}
