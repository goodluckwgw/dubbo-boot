package com.github.bootapi.dto;

import java.io.Serializable;

/**
 * User
 * 
 */
public class UserDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String name;

    public UserDto() {
    }

    public UserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name == null ? -1 : name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserDto)) {
            return false;
        }
        UserDto other = (UserDto) obj;
        if (this == other) {
            return true;
        }
        if (name != null && other.name != null) {
            return name.equals(other.name);
        }
        return false;
    }

}
