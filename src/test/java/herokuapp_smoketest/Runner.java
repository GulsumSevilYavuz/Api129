package herokuapp_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
          C01_PostRequest.class,
          C02_GetRequest.class,
          C03_PutRequest.class,
          C04_PatchRequest.class,
          C05_DeleteRequest.class
        }

)
//Olusturulan classlarin calisma sirasini belirtiyoruz
public class Runner {
}
