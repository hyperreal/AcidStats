package info.hyperreal.acid.stats.domain.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Document(collection = "stat_rows")
public class StatRow {

    private String id;
    private String name;
    private String bannerId;

    public StatRow() {

    }

    public StatRow(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }


}
