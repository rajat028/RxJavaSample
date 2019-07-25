package com.rxjavasample.country;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

public interface CountriesService {

    Single<String> countryNameInCapitals(Country country);

    Single<Integer> countCountries(List<Country> countries);

    Observable<Long> listPopulationOfEachCountry(List<Country> countries);

    Observable<String> listNameOfEachCountry(List<Country> countries);

    Observable<Country> listOnly3rdAnd4thCountry(List<Country> countries);

    Single<Boolean> isAllCountriesPopulationMoreThanOneMillion(List<Country> countries);

    Single<List<Country>> listPopulationMoreThanOneMillion(List<Country> countries);

    /**
     * @param countriesFromNetwork an async task which is sometimes very very slow
     * @return the filtered values from the {@link FutureTask} or an {@link Observable#empty()} if there are no values within 1 second
     */
    Observable<Country> listPopulationMoreThanOneMillionWithTimeoutFallbackToEmpty(FutureTask<List<Country>> countriesFromNetwork);

    Observable<String> getCurrencyUsdIfNotFound(String countryName, List<Country> countries);

    Observable<Long> sumPopulationOfCountries(List<Country> countries);

    Observable<Long> sumPopulationOfCountries(Observable<Country> countryObservable1,
                                              Observable<Country> countryObservable2);

    Single<Map<String, Long>> mapCountriesToNamePopulation(List<Country> countries);

    Single<Boolean> areEmittingSameSequences(Observable<Country> countryObservable1,
                                             Observable<Country> countryObservable2);
}
