package com.ert.utils.check_threshold;

public class CheckThreshold 
{
    public Boolean mail_validate(String n)
    {
        n = n.substring(1);
        Double value = Double.parseDouble(n);
        System.out.println(value);
        if(value >= 81.5)
        {
            return true;
        }
        return false;
    }
    
}
