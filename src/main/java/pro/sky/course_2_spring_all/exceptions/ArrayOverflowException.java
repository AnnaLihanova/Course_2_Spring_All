package pro.sky.course_2_spring_all.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArrayOverflowException extends RuntimeException{
    public ArrayOverflowException(String massage) {
        super(massage);
    }
}
