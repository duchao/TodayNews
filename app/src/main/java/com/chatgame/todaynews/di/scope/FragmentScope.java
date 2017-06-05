package com.chatgame.todaynews.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by duchao on 2017/6/5.
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
