package com.dumitruc.training;

import com.mdimension.jchronic.Chronic;
import com.mdimension.jchronic.utils.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static java.lang.Thread.setDefaultUncaughtExceptionHandler;
import static java.lang.Thread.sleep;

/**
 * Created by dima on 25/07/2017.
 */
public class BigAndHeavy {

    public static final long HOW_SLOW = 1000l;
    private static final Logger LOGGER = LoggerFactory.getLogger(BigAndHeavy.class);


    private static void secretProcessing(){
        try {
            LOGGER.info("Started long processing...");
            sleep(HOW_SLOW);
            LOGGER.info("Completed long processing...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Long,Date> parseDate(HashMap<Long,String> rawDate){
        secretProcessing();

        HashMap<Long,Date> resultDates = new HashMap<Long,Date>();

        for (Map.Entry<Long, String> longStringEntry : rawDate.entrySet()) {
            Span parse = Chronic.parse(longStringEntry.getValue());
            Calendar beginCalendar = parse.getBeginCalendar();
            resultDates.put(longStringEntry.getKey(),new Date(beginCalendar.getTimeInMillis()));
        }
        return resultDates;
    }

}
