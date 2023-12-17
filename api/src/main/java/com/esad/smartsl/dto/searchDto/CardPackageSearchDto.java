package com.esad.smartsl.dto.searchDto;

import java.io.Serializable;

public class CardPackageSearchDto extends BaseSearchDto implements Serializable {

    private static final long serialVersionUID = 3838595526250050144L;

    private int id;
    private String name;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
