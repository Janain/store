package com.click.store.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
