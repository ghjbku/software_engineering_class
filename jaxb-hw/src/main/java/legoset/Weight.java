package legoset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Weight {
    @XmlValue
    private double value;
    @XmlAttribute
    private String unit;
    public Weight() {}

    public Weight(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }
}
