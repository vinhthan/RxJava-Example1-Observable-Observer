package com.example.example1observableobserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //observable
        Observable<String> footballPlayesObservable = getFootballPlayesObservable();

        //observer
        Observer<String> footbalPlayesObserver = getFootballPlayesObserver();

        //observer subcribing to observable
        footballPlayesObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(footbalPlayesObserver);
    }

    private Observer<String> getFootballPlayesObserver() {
        return  new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: "+s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
    }

    //tao Observable de phat dlieu
    private Observable<String> getFootballPlayesObservable(){
        return Observable.just("Ronaldo, Messi, Quang Hai, Tuan Anh, Cong Phuong, Tien Linh, Minh Vuong, Tien Dung, Van Lam, Van Quyet, Trong Hoang");
    }


}
