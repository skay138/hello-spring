package com.study.hellospring.payment;

import java.util.Optional;
import java.util.function.Function;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.stream.*;

public class EnumMapper {

    private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();

    public EnumMapper() {
    }

    public void put(String key, Class<? extends EnumMapperType> e) {
        factory.put(key, toEnumValues(e));
    }

    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> e) {
        return Arrays.stream(e.getEnumConstants()).map(EnumMapperValue::new).collect(Collectors.toList());
    }

    public List<EnumMapperValue> get(String key) {
        return factory.get(key);
    }

    public Map<String, List<EnumMapperValue>> get(List<String> keys) {

        return Optional.ofNullable(keys)
                .filter(k -> !k.isEmpty())
                .map(k -> k.stream().collect(Collectors.toMap(Function.identity(), factory::get)))
                .orElseGet(LinkedHashMap::new);
    }

    public Map<String, List<EnumMapperValue>> getAll() {
        return factory;
    }
}
