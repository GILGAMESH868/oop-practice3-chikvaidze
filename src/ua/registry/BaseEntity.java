package ua.registry;

public abstract class BaseEntity {
    protected String id;
    public String getId() { return id; }
    protected void setId(String id) { this.id = id; }
}
