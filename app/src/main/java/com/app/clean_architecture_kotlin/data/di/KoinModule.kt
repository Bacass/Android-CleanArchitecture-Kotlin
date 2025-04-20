package com.app.clean_architecture_kotlin.data.di

import com.app.clean_architecture_kotlin.data.network.RemoteDataSource
import com.app.clean_architecture_kotlin.data.network.provideApi
import com.app.clean_architecture_kotlin.data.network.provideRetrofit
import com.app.clean_architecture_kotlin.data.repository.AllUserRepositoryImpl
import com.app.clean_architecture_kotlin.data.repository.LoginRepositoryImpl
import com.app.clean_architecture_kotlin.domain.repository.AllUserRepository
import com.app.clean_architecture_kotlin.domain.repository.LoginRepository
import com.app.clean_architecture_kotlin.domain.usecase.AllUserUseCase
import com.app.clean_architecture_kotlin.domain.usecase.LoginUseCase
import com.app.clean_architecture_kotlin.presentation.viewmodel.AllUserViewModel
import com.app.clean_architecture_kotlin.presentation.viewmodel.LoginViewModel
import com.app.clean_architecture_kotlin.utils.helper.PreferenceHelper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    // declaration of singleton instances
    single { provideRetrofit() }
    single { PreferenceHelper(get()) }

    /**
     * provideApi() 는 Retrofit 를 인자로 받는다.
     * 위에서 만들어준 single { provideRetrofit() } 가 있기 때문에 get()을 쓰면 된다.
     */
    factory { provideApi(get()) }

    /**
     * RemoteDataSource 는 ApiService 를 인자로 받는다.
     * 위에서 만들어준 factory { provideApi(get()) } 가 있기 때문에 get()을 쓰면 된다.
     */
    factory { RemoteDataSource(get()) }

    // repositories
    /**
     * LoginRepositoryImpl 은 RemoteDataSource 를 인자로 받고 LoginRepository 인터페이스를 구현한다.
     * 위에서 만들어준 factory { RemoteDataSource(get()) } 가 있기 때문에 get()을 쓰면 된다.
     */
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single<AllUserRepository> { AllUserRepositoryImpl(get()) }

    // Use cases
    /**
     * LoginUseCase 는 LoginRepository 를 인자로 받는다.
     * 실제로는 LoginRepository 인터페이스를 구현한 LoginRepositoryImpl가 전달된다.
     * 위에서 만들어준 single<LoginRepository> { LoginRepositoryImpl(get()) } 가 있기 때문에 get()을 쓰면 된다.
     */
    factory { LoginUseCase(get()) }
    factory { AllUserUseCase(get()) }

    // View models
    /**
     * LoginViewModel 은 LoginUseCase 를 인자로 받는다.
     * 위에서 만들어준 factory { LoginUseCase(get()) } 가 있기 때문에 get()을 쓰면 된다.
     */
    viewModel { LoginViewModel(get(), get()) }
    viewModel { AllUserViewModel(get(), get()) }
}