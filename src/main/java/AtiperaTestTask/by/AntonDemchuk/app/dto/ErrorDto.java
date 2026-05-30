package AtiperaTestTask.by.AntonDemchuk.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {

    private int status;

    private String message;

}
