package org.springframework.extended.section08

import org.springframework.core.env.PropertySource

class CustomPropertySource extends PropertySource<Map<String, String>> {
    private final Map<String, String> myProperties = [propertyA: "valueA", "propertyB": "valueB"]

    CustomPropertySource() {
        super("my custom property source implementation")
    }

    @Override
    Object getProperty(String name) {
        return myProperties[(name)]
    }

}
