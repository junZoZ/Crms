package xmu.crms.service.impl;

import org.springframework.context.annotation.Bean;
import xmu.crms.service.TimerService;

import java.util.Date;
import java.util.HashMap;

public class TimerImpl implements TimerService {

    @Override
    public void insertEvent(Date time, Bean beanName, HashMap<Integer, String> paramMap) {

    }

    @Override
    public void scheduled() {

    }
}
