package kz.pavel.crm.builder;

import kz.pavel.crm.dto.CheckDTO;
import kz.pavel.crm.entity.Check;

public class CheckConverter {

    public static CheckDTO toCheckDTO(Check check) {

        CheckDTO checkDTO = new CheckDTO();

        checkDTO.setId(check.getId());
        checkDTO.setCustomerId(check.getCustomer().getId());
        checkDTO.setCafeTableId(check.getCafeTable().getId());
        checkDTO.setSum(check.getSum());
        checkDTO.setCreatedAt(check.getCreatedAt());

        return checkDTO;
    }

}
