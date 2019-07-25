package com.rxjavasample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rxjavasample.operators.*
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val timingOperators = TimingOperators()
    private val transformingOperator = TransformingOperator()
    private val filteringOperator = FilteringOperator()
    private val errorOperator = ErrorOperator()
    private val connectableOperator = ConnectableOperator()
    private val reducingOperator = ReducingOperator()
    private val createOperator = CreateOperator()

    val mArrayList = mutableListOf<ContactPojo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.adapter = MainAdapter(prepareData())
        rvMain.setItemViewCacheSize(5)
        rvMain.setHasFixedSize(true)

        // Create Operator
//        createOperator.create()
//        createOperator.defer()

        // Timings Operator Sample
//        timerOperator()
//        delayoperator()
//        intervalOperator()

        // Transforming Operator Sample
//        zipOperator()
//        mapOperator()
       flatMapOperator()
//        switchMapOperator()
//        concatMapOperator()
//        scanOperator()
//        groupByOperator()

        // Filtering Operator
//        takeOperator()
        takeWhileOperator()
        takeUntillOperator()
//        takeLastOperator()
//        firstOperator()
//        elementAtOperator()
//        typeOfOperator()
//        skipOperator()
//        skipWhileOperator()
//        skipLastOperator()
//        distinctOperator()
//        distinctUntilChangedOperator()
//        ignoreElements()
        sampleOperator()
//        throttleFirstOperator()
//        throttleLastOperator()
//        debounceOperator()
//        sortedOperator()

        // Error Operator
//        errorOperator.caughtException()
//        errorOperator.onExceptionResumeNext()
//        errorOperator.onErrorResumeNext()
//        errorOperator.onErrorReturnItem()
//        errorOperator.onErrorReturn()

        // Connectable Operator
//        connectableOperator.publishOperator()
//        connectableOperator.replayOperator()
//        connectableOperator.autoConnectOperator()
//        connectableOperator.refCount()

        // Reducing Operator
//        reducingOperator.reduce()

        publishWithTakeUntill()

    }

    private fun publishWithTakeUntill() {
        val observable1 = Observable.range(1, 10).delay(10000, TimeUnit.MILLISECONDS)
        val observable2 = Observable.range(10, 10)


        observable1.publish {
            Observable.merge(it, observable2).takeUntil(it)
        }.subscribe {
            println("The merge output $it")
        }
    }

    private fun groupByOperator() {
        transformingOperator.groupBy()
    }

    private fun sortedOperator() {
        filteringOperator.sorted()
    }

    private fun debounceOperator() {
        filteringOperator.debounce()
    }

    private fun throttleLastOperator() {
        filteringOperator.throttleLast()
    }

    private fun throttleFirstOperator() {
        filteringOperator.throttleFirst()
    }

    private fun sampleOperator() {
        filteringOperator.sample()
    }

    private fun ignoreElements() {
        filteringOperator.ignoreElements()
    }

    private fun distinctUntilChangedOperator() {
        filteringOperator.distinctUntilChanged()
    }

    private fun distinctOperator() {
        filteringOperator.distinct()
    }

    private fun skipLastOperator() {
        filteringOperator.skipLast()
    }

    private fun skipWhileOperator() {
        filteringOperator.skipWhile()
    }

    private fun skipOperator() {
        filteringOperator.skip()
    }

    private fun typeOfOperator() {
        filteringOperator.ofType()
    }

    private fun elementAtOperator() {
        filteringOperator.elementAt()
    }

    private fun firstOperator() {
        filteringOperator.first()
    }

    private fun takeLastOperator() {
        filteringOperator.takeLast()
    }

    private fun takeWhileOperator() {
        filteringOperator.takeWhile()
    }

    private fun takeUntillOperator() {
        filteringOperator.takeUntill()
    }

    private fun takeOperator() {
        filteringOperator.take()
    }

    private fun concatMapOperator() {
        transformingOperator.concatMap()
    }

    private fun switchMapOperator() {
        transformingOperator.switchMap()
    }

    private fun flatMapOperator() {
        transformingOperator.flatMap()
    }

    private fun mapOperator() {
        transformingOperator.map()
    }

    private fun scanOperator() {
        transformingOperator.scan()
    }

    private fun zipOperator() {
        transformingOperator.zip()
    }

    private fun intervalOperator() {
        timingOperators.intervalOperator()
    }

    private fun timerOperator() {
        timingOperators.timerOperator()
    }

    private fun delayoperator() {
        timingOperators.delayOperator()
    }


    private fun prepareData(): MutableList<ContactPojo> {
        var contact: ContactPojo? = null

        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)
        contact = ContactPojo("Dhruvam", "9467884671", "22/12/1995")
        mArrayList.add(contact)

        return mArrayList
    }
}
