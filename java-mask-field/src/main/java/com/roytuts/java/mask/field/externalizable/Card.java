package com.roytuts.java.mask.field.externalizable;

public class Card {

    private Type type;
    private String name;

    //@MaskChar
    //@MaskChar('*')
    //@MaskString
    //@MaskString("****")
    private String identifier;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = CardUtil.maskStringField(Card.class, "identifier", identifier);
    }

    @Override
    public String toString() {
        return "Card [type=" + type + ", name=" + name + ", identifier=" + identifier + "]";
    }

}
