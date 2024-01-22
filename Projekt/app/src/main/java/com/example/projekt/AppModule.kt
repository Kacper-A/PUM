import com.example.projekt.data.ItemDao
import com.example.projekt.data.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideItemsRepository(itemDao: ItemDao): ItemsRepository {
        return ItemsRepository(itemDao)
    }
}