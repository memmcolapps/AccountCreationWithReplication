package com.memmcol.accountcreation.dto;

import java.math.BigDecimal;

public record CustomerNewDTO(
        String accountNo,
        String bookNumber,
        String surname,
        String firstName,
        String otherNames,
        String meterNo,
        String mobile,
        String email,
        String buid,
        Integer tariffId,
        BigDecimal arrearsBalance,
        String statusCode
) {
}
