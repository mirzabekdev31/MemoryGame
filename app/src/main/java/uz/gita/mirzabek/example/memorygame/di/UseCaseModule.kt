package uz.gita.mirzabek.example.memorygame.di
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mirzabek.example.memorygame.domain.usecase.GameUseCase
import uz.gita.mirzabek.example.memorygame.domain.usecase.impl.GameUseCaseImpl


@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Binds
    fun bindGameUseCase(impl: GameUseCaseImpl): GameUseCase
}