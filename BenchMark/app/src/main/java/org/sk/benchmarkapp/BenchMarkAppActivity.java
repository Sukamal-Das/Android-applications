package org.sk.benchmarkapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by sk on 21-01-2015.
 */
public class BenchMarkAppActivity extends Activity {

    TextView tvStatus;
    TextView tvIns;
    TextView tvBub;
    TextView tvSel;
    RadioGroup rgCase;
    EditText etArraySize;
    int [] array;



    public void generate(View view){
        try {
            switch (rgCase.getCheckedRadioButtonId()) {

                case R.id.rdAverage:
                    array = new ArrayMethods().generateRandomArray(Integer.parseInt(etArraySize.getText().toString()));
                    tvStatus.setText("Average case array generated");
                    break;

                case R.id.rdBest:
                    array = new ArrayMethods().generateBestArray(Integer.parseInt(etArraySize.getText().toString()));
                    tvStatus.setText("Best case array generated");
                    break;

                case R.id.rdWorst:
                    array = new ArrayMethods().generateWorstArray(Integer.parseInt(etArraySize.getText().toString()));
                    tvStatus.setText("Worst case array generated");
                    break;


            }

        }catch(Exception e){
            tvStatus.setText("Give a valid array size");
        }
    }


    public void sortIt(View view) {

        try {
            switch (view.getId()) {

                case R.id.btnIns:

                    long start = System.currentTimeMillis();
                    new ArrayMethods().insertionSort(new ArrayMethods().cloneArray(array));
                    long timeTaken = System.currentTimeMillis() - start;
                    tvIns.setText(timeTaken + " milli seconds");
                    break;


                case R.id.btnSel:

                    long start1 = System.currentTimeMillis();
                    new ArrayMethods().selectionSort(new ArrayMethods().cloneArray(array));
                    long timeTaken1 = System.currentTimeMillis() - start1;
                    tvSel.setText(timeTaken1 + " milli seconds");
                    break;

                case R.id.btnBub:

                    long start2 = System.currentTimeMillis();
                    new ArrayMethods().bubbleSort(new ArrayMethods().cloneArray(array));
                    long timeTaken2 = System.currentTimeMillis() - start2;
                    tvBub.setText(timeTaken2 + " milli seconds");
                    break;


                case R.id.btnAll:

                    long start3 = System.currentTimeMillis();
                    new ArrayMethods().insertionSort(new ArrayMethods().cloneArray(array));
                    long timeTaken3 = System.currentTimeMillis() - start3;
                    tvIns.setText(timeTaken3 + " milli seconds");

                    long start4 = System.currentTimeMillis();
                    new ArrayMethods().selectionSort(new ArrayMethods().cloneArray(array));
                    long timeTaken4 = System.currentTimeMillis() - start4;
                    tvSel.setText(timeTaken4 + " milli seconds");

                    long start5 = System.currentTimeMillis();
                    new ArrayMethods().bubbleSort(new ArrayMethods().cloneArray(array));
                    long timeTaken5 = System.currentTimeMillis() - start5;
                    tvBub.setText(timeTaken5 + " milli seconds");
                    break;


            }

        }catch(Exception e){
            tvStatus.setText("Generate the array first");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benchapp_layout);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvIns = (TextView) findViewById(R.id.tvIns);
        tvSel = (TextView) findViewById(R.id.tvSel);
        tvBub = (TextView) findViewById(R.id.tvBub);
        rgCase = (RadioGroup) findViewById(R.id.rgCase);
        etArraySize = (EditText) findViewById(R.id.etArraySize);

    }
}
