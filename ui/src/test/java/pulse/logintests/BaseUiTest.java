package pulse.logintests;

import com.codeborne.selenide.Selenide;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;
import properies.CommonConfig;

import java.util.TreeMap;

@Slf4j
public class BaseUiTest {

    public static final CommonConfig config = create(CommonConfig.class, getProperties());


    @BeforeAll
    public static void setUp(){

        TreeMap<String, String> map = new TreeMap<>();

        map.put("300px", "a");
        map.put("200px", "e");
        map.put("100px", "u");
        map.put("500px", "r");
        map.put("600px", "q");


        map.keySet().stream().forEach(System.out::println);
        open(config.baseUrl());

    }

}