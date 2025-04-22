package com.onefanofficial.onefan_backend.configuration.annotations.CustomUser;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}