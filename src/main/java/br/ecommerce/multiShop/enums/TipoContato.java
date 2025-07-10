package br.ecommerce.multiShop.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoContato {
    PESSOAL,
    PROFISSIONAL;

    @JsonCreator
    public static TipoContato fromValue(String value) {
        return TipoContato.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }

}
