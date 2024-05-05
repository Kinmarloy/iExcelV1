package configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "src/test/resources/test.properties"
})
public interface Props extends Reloadable{

    Props props = ConfigFactory.create(Props.class);

    @Key("url")
    String URL();
}
