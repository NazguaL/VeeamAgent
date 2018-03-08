package libs;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

/**
 * Created by sergii.ivashko on 19.02.2018.
 */
public class ExceptionHelper
{
    Logger log;

    public ExceptionHelper ()
    {
        log = Logger.getLogger(getClass());
    }

    public void ExceptionLogger (String text, Exception e)
    {
        log.error(text);
        //String stackTrace = org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e);
        String stackTrace = ExceptionUtils.getStackTrace(e);
        log.error("Exception: " + stackTrace);
    }

}
