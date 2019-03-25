package lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import static lambda.utils.DateHelper.*;

public class App implements RequestHandler<String, String>
{

    public String handleRequest(String request, Context context) {
        LambdaLogger logger = context.getLogger();
        String yesterday = getYesterdayDateString();
        logger.log(String.format("Start to pull up data from %s",yesterday));
        logger.log("log data from App:" + request);
        return request;
    }

}
