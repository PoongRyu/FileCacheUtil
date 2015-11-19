package dubu.github.com.filecacheutil;

public class FileCacheAleadyExistException extends Exception {
    private String msg;

    public FileCacheAleadyExistException(String msg) {
        this.msg = msg;
    }
    @Override
    public String getMessage() {
        return msg;
    }
}