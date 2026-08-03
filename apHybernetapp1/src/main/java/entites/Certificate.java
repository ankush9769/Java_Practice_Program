package entites;

import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {
    public String getCousername() {
        return cousername;
    }

    public void setCousername(String cousername) {
        this.cousername = cousername;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Certificate(String cousername, String duration) {
        this.cousername = cousername;
        this.duration = duration;
    }
    public Certificate(){

    }

    private String cousername;
    private String duration;

}
