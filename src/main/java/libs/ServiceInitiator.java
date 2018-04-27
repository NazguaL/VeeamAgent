package libs;

import org.apache.log4j.Logger;


/**
 * Created by sergii.ivashko on 03.04.2018.
 */
public class ServiceInitiator
{
    Logger log;

    public ServiceInitiator()
    {
        log = Logger.getLogger(getClass());
    }

    public void StartService ()
    {
        String[] cmdstart = {"C:\\WINDOWS\\system32\\cmd.exe", "/c", "sc", "start", "VeeamAgent"};

        try
        {
            Process proc = Runtime.getRuntime()
                    .exec(cmdstart);
            log.trace("VeeamAgent service started");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public void StopService ()
    {
        String[] cmd = {"C:\\WINDOWS\\system32\\cmd.exe", "/c", "sc", "stop", "VeeamAgent"};

        try
        {
            Process proc = Runtime.getRuntime()
                    .exec(cmd);
            log.trace("VeeamAgent service stoped");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
