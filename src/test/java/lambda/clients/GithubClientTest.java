package lambda.clients;

import static org.junit.Assert.assertTrue;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.junit.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lambda.clients.GithubClient;
import lambda.clients.GetRepositoriesParams;
import static lambda.utils.DateHelper.*;

/**
 * Unit test for simple App.
 */
public class GithubClientTest 
{
    private GithubClient client;
    private Logger logger;
    /**
     * Test GithubClient
     */

    @Before
    public void initialize() {
        client = GithubClient.create(new OkHttpClient());
        logger = LoggerFactory.getLogger(GithubClientTest.class);
    }

    @Test
    public void shouldSearchRepositoriesByLanguage()
    {
        String yesterday = getYesterdayDateString();
        String[] languages = {"javascript", "java", "Go"};
        GetRepositoriesParams params = GetRepositoriesParams.create();
        //params.setQuery("created:2019-03-18 size:>0");
        for(String lang: languages) {
            String resp = client.getRepositoriesByLanguageAndDate(lang, yesterday);
            logger.info(resp);
            assert(resp.length() > 0);
        }
    }

    @Test
    public void shouldSearchRepositories()
    {
        GetRepositoriesParams params = GetRepositoriesParams.create();
        params.setQuery("created:2019-03-18 size:>0");
        String resp = client.getRepositories(params);
        //logger.info(resp);
        assert(resp.length() > 0);
    }
}
