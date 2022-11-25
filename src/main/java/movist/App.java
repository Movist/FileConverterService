package movist;

import movist.services.JsonToXml;
import movist.services.XmlToJson;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        /*JsonToXml jsonToXml = new JsonToXml();
        jsonToXml.jsonToXml("C:\\Users\\Shtigun\\Desktop\\5 сем\\Практика 5 сем\\projs\\FileConverterService\\src\\main\\java\\movist\\json\\cars.json");*/

        XmlToJson xmlToJson = new XmlToJson();
        xmlToJson.xmlToJson("C:\\Users\\Shtigun\\Desktop\\5 сем\\Практика 5 сем\\projs\\FileConverterService\\src\\main\\java\\movist\\xml\\cars.xml");

    }
}
