package frameworks;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
//This class is specifically used for storing all the paths related to the project
public class PathUtils {

    @SneakyThrows//alternative to using throws <exception> at a method level
    public void applySleep(long time)  {
        Thread.sleep(time);
    }

    public String resultsPath;

    public String generateResultsFolder()
    {
        File f1=new File(System.getProperty("user.dir")+"//Results//"+getCurrentDateTime("dd-MM-yyyy hh-mm-ss"));
        f1.mkdirs();

        resultsPath=f1.getPath();
        return resultsPath;
    }
    public String getCurrentDateTime(String format)
    {
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date d1=new Date();
        return sdf.format(d1);
    }
    public String getScreenSHotPath(String ...imgName)
    {
        File f1 = new File(System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + getCurrentDateTime("dd-MM-yyyy"));
        f1.mkdirs();
        if (imgName.length == 0) {
            return f1.getPath() + File.separator + getCurrentDateTime("hh-mm-ss-SSS") + ".png";
        }
        else {
            return f1.getPath() + File.separator + imgName[0] + "_" + getCurrentDateTime("hh-mm-ss-SSS") + ".png";
        }
    }
}
