package info.hyperreal.acid.stats.exceptions;

public class AcidStatsEntityException extends Exception {

    protected Object entity;

    public AcidStatsEntityException() {
    }

    public AcidStatsEntityException(String message) {
        super(message);
    }

    public AcidStatsEntityException(String message, Object entity) {
        super(message);
        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }
}
