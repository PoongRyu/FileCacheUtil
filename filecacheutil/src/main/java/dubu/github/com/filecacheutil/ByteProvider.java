package dubu.github.com.filecacheutil;

import java.io.IOException;
import java.io.OutputStream;

public interface ByteProvider {
    void writeTo(OutputStream os) throws IOException;
}
