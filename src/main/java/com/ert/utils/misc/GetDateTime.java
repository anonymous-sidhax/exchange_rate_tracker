package com.ert.utils.misc;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetDateTime {

    public String getDateTime()
    {
        String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;        
    }
}
