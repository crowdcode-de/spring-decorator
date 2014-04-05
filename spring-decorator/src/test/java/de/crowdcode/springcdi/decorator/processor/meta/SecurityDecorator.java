package de.crowdcode.springcdi.decorator.processor.meta;

import java.lang.annotation.Retention;

import de.crowdcode.springcdi.decorator.meta.DecoratorAnnotation;

@DecoratorAnnotation
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface SecurityDecorator {
}
