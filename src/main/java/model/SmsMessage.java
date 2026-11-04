package model;

import lombok.*;

@Data
@AllArgsConstructor
public class SmsMessage {
    private String phoneNumber;
    private String message;
}
