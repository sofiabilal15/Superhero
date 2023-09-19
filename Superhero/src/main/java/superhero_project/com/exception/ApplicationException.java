package superhero_project.com.exception;

public class ApplicationException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Hero does not exist!";
    }
}
