package me.dev;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.dev.dto.TransactionDto;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class JsonObjectMapper {

    @Test
    public void testWriteObject() throws Exception {
        // SpringApplication.run(PersonalAccountServer.class, args);
        String str = "{\n" +
                "  \"transactionDate\": \"2020-04-10T12:15:30\",\n" +
                "  \"transactionAmount\": 15000,\n" +
                "  \"description\": \"salary\",\n" +
                "  \"accountId\": 1,\n" +
                "  \"transactionTypeId\": 1\n" +
                "}";
        TransactionDto dto = new TransactionDto();
        dto.setTransactionDate(new Date());
        dto.setTransactionAmount(100222);
        ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.writeValue(System.out,dto);
        TransactionDto dto1 = objectMapper.readValue(str, TransactionDto.class);
        System.out.println(dto1.getTransactionDate());
    }

}

