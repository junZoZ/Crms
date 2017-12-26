package xmu.crms.hander;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.FixGroup;
import xmu.crms.entity.Seminar;
import xmu.crms.exception.*;

@ControllerAdvice(basePackages = "xmu.crms.view")
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ClassesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse ClassesNotFoundExceptionHandler()
    {
        ExceptionResponse response=new  ExceptionResponse("班级没有找到！");
        return response;
    }

    @ExceptionHandler(value = CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse CourseNotFoundException()
    {
        ExceptionResponse response=new  ExceptionResponse("课程没有找到！");
        return response;
    }

    @ExceptionHandler(value = FixGroupNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse FixGroupNotFoundExceptionHandler()
    {
        ExceptionResponse response=new  ExceptionResponse("固定分组没有找到！");
        return response;
    }

    @ExceptionHandler(value = GroupNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse GroupNotFoundExceptionHandler()
    {
        ExceptionResponse response=new  ExceptionResponse("讨论课分组没有找到！");
        return response;
    }
    @ExceptionHandler(value = SeminarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse SeminarNotFoundExceptionHandler()
    {
        ExceptionResponse response=new  ExceptionResponse("讨论课没有找到！");
        return response;
    }
    @ExceptionHandler(value = TopicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse TopicNotFoundExceptionHandler()
    {
        ExceptionResponse response=new  ExceptionResponse("话题没有找到！");
        return response;
    }
    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse UserNotFoundExceptionHandler()
    {
        ExceptionResponse response=new  ExceptionResponse("用户没有找到！");
        return response;
    }

    @ExceptionHandler(value = InvalidOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse InvalidOperationExceptionHandler(InvalidOperationException es)
    {
        String mes=es.getMessage();
        ExceptionResponse response=new  ExceptionResponse("非法的操作！",mes);
        return response;
    }

    @ExceptionHandler(value = InfoIllegalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse InfoIllegalExceptionHandler(InfoIllegalException es)
    {
        String mes=es.getMessage();
        ExceptionResponse response=new  ExceptionResponse("非法的操作！",mes);
        return response;
    }

}

