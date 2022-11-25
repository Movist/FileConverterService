package movist.services;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class XmlToJson {
    public void xmlToJson(String path) throws IOException {
        String xml = new Scanner(new File(path))
                .useDelimiter("\\Z").next();

        JSONObject xmlJsonObject = XML.toJSONObject(xml);

        Object firstCar = xmlJsonObject.getJSONObject("_embedded").getJSONArray("cars").get(0);

        //get custom data(get one car without links)
        String str = firstCar.toString();
        String normalize1 = str.substring(0, str.indexOf("\"_links\""));
        String normalize2 = str.substring(str.indexOf("\"price\""));
        String newData = normalize1 + normalize2;

        String folderToSave = "C:\\Users\\Shtigun\\Desktop\\5 сем\\Практика 5 сем\\projs\\FileConverterService\\src\\main\\java\\movist\\json\\";
        String[] last = path.split("\\\\");
        String nameOfFile = last[last.length - 1].split("\\.")[0];
        Files.write(Paths.get(folderToSave + nameOfFile + ".json"), newData.getBytes());
    }
}