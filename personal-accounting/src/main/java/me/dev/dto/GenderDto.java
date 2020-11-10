package me.dev.dto;

import me.dev.entity.Gender;

public class GenderDto {

    private Byte id;
    private String code;
    private String title;

    public GenderDto() {
    }

    public GenderDto(Gender gender) {
        this(gender.getId(),gender.getCode(),gender.getTitle());
    }

    public GenderDto(Byte id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
