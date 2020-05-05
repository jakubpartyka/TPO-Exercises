/**
 *
 *  @author Gut Paweł S18923
 *
 */

package PASSTIME1;


import org.yaml.snakeyaml.Yaml;

import java.beans.Customizer;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tools {

    static Options createOptionsFromYaml(String fileName) throws Exception
    {
        String data;
        Yaml yaml = new Yaml();
        FileInputStream in = new FileInputStream(fileName);
        Map<String, Object> clientsMap = (Map<String, Object>)yaml.load(in);

        return new Options((String)clientsMap.get("host"),
                (int)clientsMap.get("port"),
                (boolean)clientsMap.get("concurMode"),
                (boolean)clientsMap.get("showSendRes"),
                (Map)clientsMap.get("clientsMap"));
    }
}
