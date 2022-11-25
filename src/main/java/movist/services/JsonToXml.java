package movist.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class JsonToXml {
    public void jsonToXml(String path) throws IOException {
        String json = new Scanner(new File(path))
                .useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(json);
        Object firstCar = jsonObject.getJSONObject("_embedded").getJSONArray("cars").get(0);

        //get custom data(get one car without links)
        String data = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
        String root = "<car1>";
        String endRoot = "</car1>";
        String str = XML.toString(firstCar);
        String normalize1 = str.substring(0, str.indexOf("<_links>"));
        String normalize2 = str.substring(str.indexOf("</_links>") + 1);
        String newData = data + root + normalize1 + normalize2 + endRoot;
        String folderToSave = "C:\\Users\\Shtigun\\Desktop\\5 сем\\Практика 5 сем\\projs\\FileConverterService\\src\\main\\java\\movist\\xml\\";
        String[] last = path.split("\\\\");
        String nameOfFile = last[last.length - 1].split("\\.")[0];
        Files.write(Paths.get(folderToSave + nameOfFile + ".xml"), newData.getBytes());
    }
}
