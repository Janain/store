package com.click.store.di.component;


import com.click.store.di.FragmentScope;
import com.click.store.di.module.RemmendModule;
import com.click.store.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * @Author Wangjj
 * @Create 2017/12/21.
 * @Content
 */

@FragmentScope
@Component(modules = RemmendModule.class,dependencies = AppComponent.class)
public interface RecommendComponent {



    void inject(RecommendFragment fragment);
}
