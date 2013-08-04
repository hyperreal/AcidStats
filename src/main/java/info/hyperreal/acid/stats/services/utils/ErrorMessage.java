package info.hyperreal.acid.stats.services.utils;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "error")
public class ErrorMessage {

    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String message) {
        this();
        this.message = message;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
