package legoset;

import jaxb.JAXBHelper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        LegoSet legoset = new LegoSet();
        legoset.setName("Imperial TIE Fighter");
        legoset.setTheme("Star Wars");
        legoset.setSubtheme("Solo");
        legoset.setYear(Year.of(2018));
        legoset.setPieces(519);

        Set<String> tag = new LinkedHashSet<String>();
        tag.add("Starfighter");
        tag.add("Stormtrooper");
        tag.add("Star Wars");
        tag.add("Solo");
        legoset.setTags(tag);

        ArrayList<Weight> weight = new ArrayList<>();
        weight.add(new Weight("kg",0.89));
        legoset.setWeight(weight);

        ArrayList<Minifig> minifigs = new ArrayList<>();
        minifigs.add(new Minifig("Imperial Mudtrooper", 2));
        minifigs.add(new Minifig("Imperial Pilot", 1));
        minifigs.add(new Minifig("Mimban Stormtrooper", 1));
        legoset.setMinifigs(minifigs);
        legoset.setUrl(new URL("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter"));

        JAXBHelper.toXML(legoset, System.out);

        JAXBHelper.toXML(legoset, new FileOutputStream("legoset.xml"));
        //System.out.println(JAXBHelper.fromXML(LegoSet.class, new FileInputStream("legoset.xml")));
    }
}
