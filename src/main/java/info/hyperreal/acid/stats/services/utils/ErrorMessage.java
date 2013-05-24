package info.hyperreal.acid.stats.services.utils;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

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
