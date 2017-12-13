package com.click.store.di.component;

import com.click.store.di.FragmentScope;
import com.click.store.di.moudle.RemmendModule;
import com.click.store.ui.fragment.RecommendFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by S on 2017/11/22.
 */

@FragmentScope
@Component(modules = RemmendModule.class,dependencies = AppComponent.class)
public interface RemmendComponent {

    void inject(RecommendFragment fragment);

}
