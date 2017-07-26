package com.dumitruc.transformers;

/**
 * Created by dima on 25/07/2017.
 */
import com.mdimension.jchronic.Chronic;
import com.mdimension.jchronic.utils.Span;
import cucumber.api.Transformer;

import java.util.Calendar;
import java.util.Date;

public class HumanDate extends Transformer<Date> {
    @Override
    public Date transform(String s) {
        Date resultDate = null;
        Span parse = Chronic.parse(s);
        if (parse != null) {
            Calendar beginCalendar = parse.getBeginCalendar();
            resultDate = new Date(beginCalendar.getTimeInMillis());
        }
        return resultDate;
    }
}
