package lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * Hello world!
 *
 */
public class App implements RequestHandler<String, String>
{

    public String handleRequest(String request, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("log data from App:" + request);
        return request;
    }

}
