package frameworks;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
//This class is specifically used for storing all the paths related to the project
public class PathUtils {

    @SneakyThrows//alternative to using throws <exception> at a method level
    public void applySleep(long time)  {
        Thread.sleep(time);
    }
}
