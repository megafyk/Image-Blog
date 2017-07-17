package com.megafyk.util;

import com.megafyk.model.FileBucket;
import com.megafyk.model.MultiFileBucket;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MultiFileValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return MultiFileBucket.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        MultiFileBucket multiBucket = (MultiFileBucket) o;

        int index = 0;

        for (FileBucket file : multiBucket.getFiles()) {
            if (file.getFile() != null) {
                if (file.getFile().getSize() == 0) {
                    errors.rejectValue("files[" + index + "].file", "missing.file");
                }
            }
            index++;
        }
    }
}
