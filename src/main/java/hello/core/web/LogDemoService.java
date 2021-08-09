package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    //    private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;
    public void logic(String testID) {
//        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service ID = " + testID);
    }
}
