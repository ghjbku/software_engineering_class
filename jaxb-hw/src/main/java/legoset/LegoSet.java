package legoset;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URL;
import java.time.Year;
import java.util.List;
import java.util.Set;
@XmlType(propOrder = {"name", "theme", "subtheme", "year", "pieces","tags","minifigs","weight","url"})
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class LegoSet {
    private String name,theme,subtheme;
    private int pieces;

    @XmlJavaTypeAdapter(YearAdapter.class)
    private Year year;
    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    private Set<String> tags;
    @XmlElementWrapper(name = "minifigs")
    @XmlElement(name = "minifig")
    private List<Minifig> minifigs;
    private URL url;

    private List<Weight> weight;
}
