package uz.gita.mirzabek.example.memorygame.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mirzabek.example.memorygame.navigation.AppNavigationManager
import uz.gita.mirzabek.example.memorygame.navigation.AppNavigator
import uz.gita.mirzabek.example.memorygame.navigation.NavigationHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun bindsAppNavigator(impl: AppNavigationManager): AppNavigator

    @Binds
    fun bindsNavigationHandler(impl: AppNavigationManager): NavigationHandler
}