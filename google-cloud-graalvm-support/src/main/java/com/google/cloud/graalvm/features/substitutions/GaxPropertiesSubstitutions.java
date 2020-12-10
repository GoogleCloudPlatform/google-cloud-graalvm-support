/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.graalvm.features.substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

/**
 * This file contains the GaxProperties substitution to correctly set the Java language string
 * in API call headers for GraalVM users.
 */
@TargetClass(className = "com.google.api.gax.core.GaxProperties")
final class GaxPropertiesSubstitutions {

  private GaxPropertiesSubstitutions() {
  }

  @Substitute
  private static String getRuntimeVersion() {
    return System.getProperty("java.version") + "-graalvm";
  }
}

