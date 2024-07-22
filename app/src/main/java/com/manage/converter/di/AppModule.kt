package com.manage.converter.di

import com.manage.converter.data.main_page.MainPageRepositoryImpl
import com.manage.converter.domain.api.ConverterApiFactory
import com.manage.converter.domain.main_page.MainPageRepository
import com.manage.converter.presentation.MainPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        ConverterApiFactory.create()
    }

    single<MainPageRepository> {
        MainPageRepositoryImpl(converterApi = get())
    }

    viewModel {
        MainPageViewModel(repository = get())
    }
}