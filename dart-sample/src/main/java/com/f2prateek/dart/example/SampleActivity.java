/*
 * Copyright 2013 Jake Wharton
 * Copyright 2014 Prateek Srivastava (@f2prateek)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.f2prateek.dart.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;
import com.f2prateek.dart.Nullable;
import java.util.List;

public class SampleActivity extends Activity {
  public static final String DEFAULT_EXTRA_VALUE = "a default value";

  private static final String EXTRA_STRING = "extraString";
  private static final String EXTRA_INT = "extraInt";
  private static final String EXTRA_PARCELABLE = "extraParcelable";
  private static final String EXTRA_LIST_PARCELABLE = "extraListParcelable";
  private static final String EXTRA_SPARSE_ARRAY_PARCELABLE = "extraSparseArrayParcelable";
  private static final String EXTRA_OPTIONAL = "extraOptional";
  private static final String EXTRA_PARCEL = "extraParcel";
  private static final String EXTRA_WITH_DEFAULT = "extraWithDefault";

  @InjectExtra(EXTRA_STRING) String stringExtra;
  @InjectExtra(EXTRA_INT) int intExtra;
  @InjectExtra(EXTRA_PARCELABLE) ComplexParcelable parcelableExtra;
  @InjectExtra(EXTRA_PARCEL) ExampleParcel parcelExtra;
  @InjectExtra(EXTRA_LIST_PARCELABLE) List<ExampleParcel> listParcelExtra;
  @InjectExtra(EXTRA_SPARSE_ARRAY_PARCELABLE) SparseArray<ExampleParcel> sparseArrayParcelExtra;
  @Nullable @InjectExtra(EXTRA_OPTIONAL) String optionalExtra;
  @Nullable @InjectExtra(EXTRA_WITH_DEFAULT) String defaultExtra = DEFAULT_EXTRA_VALUE;
  @InjectExtra String defaultKeyExtra;

  @InjectView(R.id.default_key_extra) TextView defaultKeyExtraTextView;
  @InjectView(R.id.string_extra) TextView stringExtraTextView;
  @InjectView(R.id.int_extra) TextView intExtraTextView;
  @InjectView(R.id.parcelable_extra) TextView parcelableExtraTextView;
  @InjectView(R.id.optional_extra) TextView optionalExtraTextView;
  @InjectView(R.id.parcel_extra) TextView parcelExtraTextView;
  @InjectView(R.id.list_parcel_extra) TextView listParcelExtraTextView;
  @InjectView(R.id.sparse_array_parcel_extra) TextView sparseArrayParcelExtraTextView;
  @InjectView(R.id.default_extra) TextView defaultExtraTextView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);

    ButterKnife.inject(this);
    Dart.inject(this);

    // Contrived code to use the "injected" extras.
    stringExtraTextView.setText(stringExtra);
    intExtraTextView.setText(String.valueOf(intExtra));
    parcelableExtraTextView.setText(String.valueOf(parcelableExtra));
    optionalExtraTextView.setText(String.valueOf(optionalExtra));
    parcelExtraTextView.setText(String.valueOf(parcelExtra.getName()));
    listParcelExtraTextView.setText(String.valueOf(listParcelExtra.size()));
    sparseArrayParcelExtraTextView.setText(String.valueOf(sparseArrayParcelExtra.size()));
    defaultExtraTextView.setText(String.valueOf(defaultExtra));
    defaultKeyExtraTextView.setText(defaultKeyExtra);
  }
}
