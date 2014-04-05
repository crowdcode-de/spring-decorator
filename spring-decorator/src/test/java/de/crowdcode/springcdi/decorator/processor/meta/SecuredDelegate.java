package de.crowdcode.springcdi.decorator.processor.meta;

import java.lang.annotation.Retention;

import de.crowdcode.springcdi.decorator.meta.DelegateAnnotation;

@DelegateAnnotation
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface SecuredDelegate {
}
